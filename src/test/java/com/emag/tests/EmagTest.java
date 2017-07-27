package com.emag.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import com.emag.steps.EmagSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class EmagTest {
	


    @Managed(uniqueSession = true)
    public WebDriver driver;

	@Steps
	public EmagSteps emagSteps;

	@Before
	public void maximizeWindow(){
		driver.manage().window().maximize();
	}

	@Test
    public void emagSearch() {

		String searchedProduct = "telefon";
		emagSteps.navigateTo("https://emag.ro");
		emagSteps.searchTerm(searchedProduct);
		emagSteps.navigateToRandomResultsPage(searchedProduct);

		emagSteps.clickRandomProduct();

        emagSteps.setProductTitleAndClickAddToCartOnRandomProduct();


		emagSteps.submitViewCartDetailsButtonAndSetProductTitleFromCart();

		emagSteps.checkByTitleIfProductIsInCart();


	}

}
