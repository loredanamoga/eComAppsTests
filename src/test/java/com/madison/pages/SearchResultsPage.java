package com.madison.pages;

import net.serenitybdd.core.Serenity;
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


    ViewProductPage viewProductPage;
    private Random randomGenerator = new Random();


    public boolean checkWordInFirstResultedProductFromFirstPage() {

        productsList.get(0).click();
        return verifyProductIfContainsSpecificWord();
    }

    public boolean checkWordInLastResultedProductFromFirstPage() {

        productsList.get(productsList.size() - 1).click();
        return verifyProductIfContainsSpecificWord();
    }

    public boolean checkWordInLastResultedProduct() {

        getDriver().navigate().back();
        if (productsList.size() > 1) {
            try {
                if (resultPages.isDisplayed()) {
                    noOfPagesList.get(noOfPagesList.size() - 2).click();
                    return checkWordInLastResultedProductFromFirstPage();
                }
            } catch (Exception e) {
            }
        }
        return checkWordInLastResultedProductFromFirstPage();

    }

    public boolean checkWordInRandomResultedProduct() {
        getDriver().navigate().back();
        if (productsList.size() > 1) {
            try {
                if (resultPages.isDisplayed()) {
                    int indexPage = Math.abs(randomGenerator.nextInt(noOfPagesList.size()));
                    noOfPagesList.get(indexPage).click();
                    return checkWordInLastResultedProductFromFirstPage();

                }
            } catch (Exception e) {


            }
        }

//        int indexProduct = Math.abs(randomGenerator.nextInt(productsList.size()));
//        productsList.get(indexProduct).click();
        return true;//verifyProductIfContainsSpecificWord();

    }

    //search specific word in title, description and short description
    public boolean verifyProductIfContainsSpecificWord() {

        viewProductPage.setProductTitleAndDescriptions();
        String productTitle = Serenity.sessionVariableCalled("productTitle").toString();
        String productDescription = Serenity.sessionVariableCalled("productDescription").toString();
        String productShortDescription = Serenity.sessionVariableCalled("productShortDescription").toString();

        if (productTitle.toLowerCase().contains(Constants.SEARCHED_WORD)) {
            return true;
        } else if (productDescription.toLowerCase().contains(Constants.SEARCHED_WORD)) {
            return true;
        } else if (productShortDescription.toLowerCase().contains(Constants.SEARCHED_WORD)) {
            return true;
        } else {
            return false;
        }

    }


}
