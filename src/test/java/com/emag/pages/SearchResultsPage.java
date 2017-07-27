package com.emag.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class SearchResultsPage extends PageObject {

    @FindBy(css = ".emg-pagination-no")
    private List<WebElement> pagesNumbers;

    @FindBy(css = ".js-change-page")
    private List<WebElement> pagesNumbers2;

    @FindBy(css = ".lazy")
    private List<WebElement> products;

    @FindBy(css = ".thumbnail.js-product-url")
    private List<WebElement> products2;


    public void redirectToRandomPageList(String searchedProduct) {
        //waitFor(pagesNumbers);
        int noOfPages;
        if (pagesNumbers.size() != 0) {
            noOfPages = Integer.parseInt(pagesNumbers.get(pagesNumbers.size() - 1).getText());
        } else {
            noOfPages = Integer.parseInt(pagesNumbers2.get(pagesNumbers2.size() - 2).getText());
        }
        System.out.println(noOfPages);
        int pageNumber = new Random().nextInt(noOfPages);
        System.out.println(pageNumber);
        getDriver().get("https://emag.ro/search/" + searchedProduct + "/p" + pageNumber);

    }

    public void redirectToRandomProductList() {
        System.out.println(products.size() + "--------------------");
        int product;
        if (products.size() != 0) {
            product = Math.abs(new Random().nextInt(products.size()));
            System.out.println(product);
            products.get(product).click();
        } else {
            product = Math.abs(new Random().nextInt(products2.size()));
            products2.get(product).click();
        }

    }


}
