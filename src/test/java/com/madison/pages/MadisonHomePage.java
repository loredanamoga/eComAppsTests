package com.madison.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

/**
 * Created by loredanamoga on 7/26/2017.
 */
public class MadisonHomePage extends PageObject{

    @FindBy(css="#search")
    private WebElementFacade searchInput;

    public void navigateTo(String url){
        getDriver().get(url);
    }

    public void searchInput(String inputToSearch){
        searchInput.sendKeys(inputToSearch);
        searchInput.submit();
    }

    public void getCurrentPageUrl(){
        Serenity.setSessionVariable("currentPageUrl").to(getDriver().getCurrentUrl());

    }
}
