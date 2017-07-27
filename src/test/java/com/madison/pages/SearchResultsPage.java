package com.madison.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import java.util.List;

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


    ViewProductPage viewProductPage ;
    Constants constants;



    public boolean checkWordInFirstResultedProductFromFirstPage(){

        productsList.get(0).click();
        return verifyProductIfContainsSpecificWord();
    }

    public boolean checkWordInLastResultedProductFromFirstPage(){

        productsList.get(productsList.size()-1).click();
        return verifyProductIfContainsSpecificWord();
    }

    public boolean checkWordInLastResultedProduct(){
        getDriver().navigate().back();
        if(productsList.size()> 1){
        try {
            if (resultPages.isDisplayed()) {

                noOfPagesList.get(noOfPagesList.size()-2).click();
                return checkWordInLastResultedProductFromFirstPage();


            }
        } catch (Exception e) {
            return checkWordInLastResultedProductFromFirstPage();
        }
        }
        return true;

    }

    //search specific word in title, description and short description
    public boolean verifyProductIfContainsSpecificWord(){

        viewProductPage.setProductTitleAndDescriptions();
        String productTitle = Serenity.sessionVariableCalled("productTitle").toString();
        String productDescription = Serenity.sessionVariableCalled("productDescription").toString();
        String productShortDescription = Serenity.sessionVariableCalled("productShortDescription").toString();

        if(productTitle.toLowerCase().contains(constants.SEARCHED_WORD)){
            return true;
        }
        else if(productDescription.toLowerCase().contains(constants.SEARCHED_WORD)){
            return true;
        }
        else if(productShortDescription.toLowerCase().contains(constants.SEARCHED_WORD)){
            return true;
        }
        else{
            return false;
        }

    }



}
