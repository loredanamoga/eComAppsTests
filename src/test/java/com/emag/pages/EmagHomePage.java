package com.emag.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class EmagHomePage extends PageObject{
	
	@FindBy(css="#emg-input-autosuggest")
    private WebElementFacade searchInput;
	
	public void navigateTo(String url){
		getDriver().get(url);
	}

    public void inputSearchTerm(String keyword) {
		searchInput.sendKeys(keyword);
		searchInput.submit();
    }

}
