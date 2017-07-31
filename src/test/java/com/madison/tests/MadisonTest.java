package com.madison.tests;

import com.madison.pages.Constants;
import com.madison.steps.MadisonSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by loredanamoga on 7/26/2017.
 */

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = Constants.CSV_FILES_PATH + "searchTest.csv")
public class MadisonTest {


    @Managed(uniqueSession = false)
    public WebDriver driver;

    @Steps
    public MadisonSteps madisonSteps;
    String keyword;

    @Before
    public void maximizeWindow(){
        driver.manage().window().maximize();
        Constants.SEARCHED_WORD = keyword;
    }

    @Pending
    @Test
    public void searchSpecificProductInResultPages(){


        madisonSteps.navigateTo("http://qa1.madison.com/");
        madisonSteps.searchInput(Constants.SEARCHED_WORD);
        madisonSteps.ckeckFirstLastRandomIfRelevant(Constants.SEARCHED_WORD);

    }

//    @Test
//    public void madisonSearchByBlankSpace(){
//
//        madisonSteps.searchInput(" ");
//        madisonSteps.verifyCurrentUrlWithHomePageUrl();
//    }

//    @Test
//    public void madisonSearchByAddingNoWord(){
//        madisonSteps.searchInput("");
//        madisonSteps.verifyCurrentUrlWithHomePageUrl();
//    }

    @Test
    public void testIfThereAreNoResults(){
        madisonSteps.navigateTo("http://qa1.madison.com/");
        madisonSteps.searchInput("hfkjushfkjudhasfkjhds");
        madisonSteps.checkIfResultsPageIsEmpty();
    }

}
