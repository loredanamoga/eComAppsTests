package com.emag.pages;

import java.util.Random;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class SearchResultsList extends PageObject {

	@FindBy(css = ".emg-fashion-view-dots + a")
	public WebElement pagesNumbers;

	public void redirectToRandomProductsList(String searchedProduct) {
		int noOfPages = Integer.parseInt(pagesNumbers.getText().trim());
		System.out.println(noOfPages);
		int pageNumber = new Random().nextInt(noOfPages);
		System.out.println(pageNumber);
		getDriver().get("https://emag.ro/search/" + searchedProduct + "/p" + pageNumber);
	
	}
}
