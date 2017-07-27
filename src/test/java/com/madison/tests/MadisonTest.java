package com.madison.tests;

import com.madison.pages.Constants;
import com.madison.steps.MadisonSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
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
        madisonSteps.searchInput(constants.SEARCHED_WORD);
        madisonSteps.checkWordInFirstAndLastResultedProduct();

    }


    @Pending
    @Test
    public void madisonSearchByBlankSpace(){

        madisonSteps.searchInput(" ");
        madisonSteps.verifyCurrentUrlWithHomePageUrl();
    }


    @Pending
    @Test
    public void madisonSearchByAddingNoWord(){
        madisonSteps.searchInput("");
        madisonSteps.verifyCurrentUrlWithHomePageUrl();
    }

}
