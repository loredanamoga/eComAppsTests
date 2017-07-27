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


    //check first product from first page
    public boolean checkWordInFirstProduct() {

        productsList.get(0).click();
        return verifyProductIfContainsSpecificWord();
    }

    //check last product from first page
    public boolean checkWordInLastProduct() {

        productsList.get(productsList.size() - 1).click();
        return verifyProductIfContainsSpecificWord();
    }

    public boolean checkIfAreMoreProductsInPage(){
        if (productsList.size() > 1)return true;
        return false;
    }

    

    public boolean checkWordInLastResultedProduct() {
        getDriver().navigate().back();
        if (checkIfAreMoreProductsInPage()) {
            try {
                if (resultPages.isDisplayed()) {
                    noOfPagesList.get(noOfPagesList.size() - 2).click();
                    return checkWordInLastProduct();
                }
            } catch (Exception e) {
            }
        }
        return checkWordInLastProduct();

    }

    public boolean checkWordInRandomResultedProduct() {
        getDriver().navigate().back();
        if (checkIfAreMoreProductsInPage()) {
            try {
                if (resultPages.isDisplayed()) {
                    int indexPage = Math.abs(randomGenerator.nextInt(noOfPagesList.size()));
                    noOfPagesList.get(indexPage).click();
                    return checkWordInLastProduct();

                }
            } catch (Exception e) {


            }
        }
        return true;

    }

    //search specific word in title, description and short description
    public boolean verifyProductIfContainsSpecificWord() {

        viewProductPage.setProductTitleAndDescriptions();
        String productTitle = Serenity.sessionVariableCalled("productTitle").toString();
        String productDescription = Serenity.sessionVariableCalled("productDescription").toString();
        String productShortDescription = Serenity.sessionVariableCalled("productShortDescription").toString();
        if(checkWordInTitle(productTitle)|| checkWordInDescription(productDescription)||checkWordInShortDescription(productShortDescription)){
            return true;
        }
       return false;

    }

    public boolean checkWordInTitle(String productTitle){
        if (productTitle.toLowerCase().contains(Constants.SEARCHED_WORD)) {
            return true;}
            else return false;

    }

    public boolean checkWordInDescription(String productDescription){
        if (productDescription.toLowerCase().contains(Constants.SEARCHED_WORD)) {
            return true;}
            else return false;

    }

    public boolean checkWordInShortDescription(String productShortDescription){
        if (productShortDescription.toLowerCase().contains(Constants.SEARCHED_WORD)) {
        return true;}
        else return false;
    }


}
