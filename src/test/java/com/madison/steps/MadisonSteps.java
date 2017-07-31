package com.madison.steps;

import com.madison.pages.*;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

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

//    @Step
//    public void verifyCurrentUrlWithHomePageUrl(){
//
//        madisonHomePage.getCurrentPageUrl();
//        String currentPageUrl = Serenity.sessionVariableCalled("currentPageUrl");
//        System.out.println(currentPageUrl);
//        assertEquals("http://qa1.madison.com/", currentPageUrl);
//    }
//
//    @Step
//    public void redirectToRandomCategAndSubcateg(){
//        randomSearchPage.redirectToRandomCategAndSubcategPage();
//    }
//
//    @Step
//    public void redirectToRandomProduct(){
//        randomSearchPage.redirectToRandomProduct();
//    }

    @Step
    public Boolean checkIfFirstProductIsRelevant(String inputToSearch){
        searchResultsPage.clickOnFirstProduct();
        return viewProductPage.verifyProductIfContainsSpecificWordAndGoBack(inputToSearch);
    }

    @Step
    public Boolean checkIfLastProductIsRelevant(String inputToSearch){
        searchResultsPage.navigateToLastResultPage(inputToSearch);
        searchResultsPage.clickOnLastProduct();
        return viewProductPage.verifyProductIfContainsSpecificWordAndGoBack(inputToSearch);
    }

    @Step
    public Boolean checkIfRandomProductIsRelevant(String inputToSearch){
        searchResultsPage.navigateToRandomResultPage(inputToSearch);
        searchResultsPage.clickOnRandomProduct();
        return viewProductPage.verifyProductIfContainsSpecificWordAndGoBack(inputToSearch);
    }

    @StepGroup
    public void ckeckFirstLastRandomIfRelevant(String inputToSearch){
        assertTrue("The searched word doesn't appear in the first, last and random product from result list",
                checkIfFirstProductIsRelevant(inputToSearch) &&
                checkIfLastProductIsRelevant(inputToSearch) &&
                checkIfRandomProductIsRelevant(inputToSearch));
    }

    @Step
    public void clickOnProductAndStoreItsInfo() {
        searchResultsPage.clickOnProduct(1);
        viewProductPage.takeProductTitle();
        viewProductPage.takeProductDescription();
        viewProductPage.takeProductShortDescription();
    }

    @Step
    public void checkIfResultsPageIsEmpty(){
        assertTrue(searchResultsPage.checkIfProductsListIsEmpty());
    }


}
