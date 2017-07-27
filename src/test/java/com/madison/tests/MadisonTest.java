package com.madison.tests;

import com.madison.pages.Constants;
import com.madison.steps.MadisonSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by loredanamoga on 7/26/2017.
 */

@RunWith(SerenityRunner.class)
public class MadisonTest {

    Constants constants;

    @Managed(uniqueSession = true)
    public WebDriver driver;

    @Steps
    public MadisonSteps madisonSteps;

    @Before
    public void maximizeWindow(){
        driver.manage().window().maximize();
    }

    @Test
    public void madisonSearchSpecificProductInResultPages(){


        madisonSteps.navigateTo("http://qa1.madison.com/");

        //if we enter nothing
//        madisonSteps.searchInput("");
//        madisonSteps.verifyCurrentUrlWithHomePageUrl();
//
//        //if we enter a blank space
//        madisonSteps.searchInput(" ");
//        madisonSteps.verifyCurrentUrlWithHomePageUrl();


        //search random product
//        madisonSteps.redirectToRandomCategAndSubcateg();
//        madisonSteps.redirectToRandomProduct();

        //set random product's title
//        madisonSteps.setProductTitleAndDescriptions();

        madisonSteps.searchInput(constants.SEARCHED_WORD);

      //  madisonSteps.checkByTitleIfProductIsInResultPage();
//        madisonSteps.checkByDescriptionIfProductIsInResultPage();
        
        madisonSteps.checkWordInResultedProductsFromFirstPage();

    }




}
