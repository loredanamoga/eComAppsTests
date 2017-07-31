package com.madison.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

/**
 * Created by loredanamoga on 7/27/2017.
 */
public class SearchResultsPage extends PageObject {

    @FindBy(css = ".products-grid>.item.last")
    private List<WebElement> productsList;

    @FindBy(css = ".pages")
    private WebElement resultPages;

    @FindBy(css = ".category-products > div:not(.toolbar-bottom) .pages>ol a")
    private List<WebElement> noOfPagesList;

    @FindBy(css = ".amount--has-pages")
    private List<WebElement> amountOfProducts1;

    @FindBy(css = ".amount--no-pages strong")
    private List<WebElement> amountOfProducts2;

    @FindBy(css = ".limiter option[selected='selected']")
    private WebElement limitPerPage;

    public void clickOnProduct(int productIndex) {
        // TODO when there are not search results
        productsList.get(productIndex).findElement(By.cssSelector("a")).click();
    }

    public void clickOnFirstProduct() {
        clickOnProduct(0);
    }

    public void clickOnLastProduct() {
        clickOnProduct(productsList.size() - 1);
    }

    public void clickOnRandomProduct() {
        Random random = new Random();
        Integer productNr = Math.abs(random.nextInt(productsList.size()));
        //setProductTitleInSession(productsList.get(productNr).findElement(By.cssSelector(".product-name > a")).getAttribute("title"));
        clickOnProduct(productNr);
    }

    public void setAmountOfProductsInSession() {
        if(amountOfProducts1.size() > 0) {
            Serenity.setSessionVariable("amountOfProducts1").to(amountOfProducts1.get(0)
                    .getText().split(" ")[2]);
        } else {
            Serenity.setSessionVariable("amountOfProducts1").to(amountOfProducts2.get(0)
                    .getText().split(" ")[0]);
        }
    }

    public void setLimitPerPageInSession() {
        Serenity.setSessionVariable("limitPerPage").to(limitPerPage.getText()
                .replace(" ", ""));
    }

    public Integer getNumberOfResultPages() {
        setAmountOfProductsInSession();
        setLimitPerPageInSession();
        Integer productNumber = Integer.parseInt(Serenity.sessionVariableCalled("amountOfProducts1").toString());
        Integer limitNumber = Integer.parseInt(Serenity.sessionVariableCalled("limitPerPage").toString());
        if (productNumber % limitNumber != 0) {
            return productNumber / limitNumber + 1;
        }
        return productNumber / limitNumber;
    }

    public void navigateToLastResultPage(String searchedTerm) {
        if (getNumberOfResultPages() > 1) {
            navigateToResultPage(searchedTerm, getNumberOfResultPages());
        }
    }

    public void navigateToRandomResultPage(String searchedTerm) {
        navigateToResultPage(searchedTerm, Math.abs(new Random().nextInt(getNumberOfResultPages() + 1)));
    }

    public void navigateToResultPage(String searchedTerm, Integer pageNr) {
        getDriver().get("http://qa1.madison.com/catalogsearch/result/index/?p="
                + pageNr + "&q=" + searchedTerm);
    }

    public boolean checkIfProductsListIsEmpty() {
        return productsList.size() < 1;
    }


//    public boolean checkWordInLastResultedProduct() {
//        //remove navigate back .
//        getDriver().navigate().back();
//        if (checkIfAreMoreProductsInPage() && resultPages.isDisplayed()) {
//            noOfPagesList.get(noOfPagesList.size() - 2).click();
//            return checkWordInLastProduct();
//        }
//        return checkWordInLastProduct();
//
//    }
//
//    public boolean checkWordInRandomProduct() {
//        //remove navigate back ...
//        getDriver().navigate().back();
//        if (checkIfAreMoreProductsInPage() && resultPages.isDisplayed()) {
//
//            int indexPage = Math.abs(randomGenerator.nextInt(noOfPagesList.size()));
//            noOfPagesList.get(indexPage).click();
//            return checkWordInLastProduct();
//
//        }
//
//        return false;
//
//    }
}
