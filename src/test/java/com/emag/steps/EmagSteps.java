package com.emag.steps;

import com.emag.pages.ViewCartPage;
import com.emag.pages.EmagHomePage;
import com.emag.pages.SearchResultsPage;
import com.emag.pages.ViewProductPage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

public class EmagSteps {
	
	EmagHomePage emagHomePage;
	SearchResultsPage searchResultsPage;
	ViewProductPage viewProductPage;
	ViewCartPage cartPage;
	
	@Step
	public void navigateTo(String url){
		emagHomePage.navigateTo(url);
	}

	@Step 
	public void searchTerm(String keyword){
		emagHomePage.inputSearchTerm(keyword);
	}
	
	@Step
	public void navigateToRandomResultsPage(String keyword){
		searchResultsPage.redirectToRandomPageList(keyword);
	}

	@Step
	public void clickRandomProduct(){
		searchResultsPage.redirectToRandomProductList();
	}

	@Step
	public void setProductTitleAndClickAddToCartOnRandomProduct(){
		viewProductPage.setProductTitleAndClickAddToCartOnRandomProduct();
	}

	@Step
	public void submitViewCartDetailsButtonAndSetProductTitleFromCart(){
		cartPage.submitViewCartDetailsButtonAndSetProductTitleFromCart();
	}

	@Step
	public void checkByTitleIfProductIsInCart() {
		String productTitle = Serenity.sessionVariableCalled("title").toString();
		String cartProductTitle = Serenity.sessionVariableCalled("cartProductTitle").toString();
		assertEquals(productTitle, cartProductTitle);
	}
}
