package com.emag.steps;

import com.emag.pages.EmagHomePage;
import com.emag.pages.SearchResultsList;

import net.thucydides.core.annotations.Step;

public class EmagSteps {
	
	EmagHomePage emagHomePage;
	SearchResultsList searchResultsList;
	
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
		searchResultsList.redirectToRandomProductsList(keyword);
	}
}
