package com.madison.steps;

import com.madison.pages.*;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by loredanamoga on 7/26/2017.
 */
public class MadisonSteps {

    MadisonHomePage madisonHomePage;
    RandomSearchPage randomSearchPage;
    ViewProductPage viewProductPage;
    SearchResultsPage searchResultsPage;


    @Step
    public void navigateTo(String url){
        madisonHomePage.navigateTo(url);
    }

    @Step
    public void searchInput(String inputToSearch){
        madisonHomePage.searchInput(inputToSearch);
    }

    @Step
    public void verifyCurrentUrlWithHomePageUrl(){

        madisonHomePage.getCurrentPageUrl();
        String currentPageUrl = Serenity.sessionVariableCalled("currentPageUrl");
        System.out.println(currentPageUrl);
        assertEquals("http://qa1.madison.com/", currentPageUrl);
    }

    @Step
    public void redirectToRandomCategAndSubcateg(){
        randomSearchPage.redirectToRandomCategAndSubcategPage();
    }

    @Step
    public void redirectToRandomProduct(){
        randomSearchPage.redirectToRandomProduct();
    }

    @Step
    public void setProductTitleAndDescriptions(){
        viewProductPage.setProductTitleAndDescriptions();
    }


    @Step
    public void checkWordInFirstAndLastResultedProduct(){
        assertTrue("The searched word doesn't appear in the first product from result list",searchResultsPage.checkWordInFirstResultedProductFromFirstPage());
        assertTrue("The searched word doesn't appear in the last product from result list ",searchResultsPage.checkWordInLastResultedProduct());
    }


}
