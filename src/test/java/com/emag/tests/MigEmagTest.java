package com.emag.tests;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.emag.steps.EmagSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class MigEmagTest {
	

    @Managed(uniqueSession = true)
    public WebDriver driver;
    
	WebElement addToCart, search, cartDetails, dynamicElement, dynamicElement2, dynamicElement3;
	Random rand = new Random();
	String searchedProduct = "telefon";
	
	@Steps
	public EmagSteps emagSteps;
	
	@Test
    public void emagSearch() {
//		driver.get("https://emag.ro");
//		search = driver.findElement(By.cssSelector("#emg-input-autosuggest"));
//		search.sendKeys(searchedProduct);
//		search.submit();
		emagSteps.navigateTo("https://emag.ro");
		emagSteps.searchTerm(searchedProduct);
		
		
//		List<WebElement> pages = driver.findElements(By.cssSelector(".emg-pagination-no"));
//		// pageNo =
//		// driver.findElement(By.cssSelector("emg-pagination-no:last-child")).getText();
//		int noOfPages = Integer.parseInt(pages.get(pages.size() - 1).getText());
//		System.out.println(noOfPages);
//		int pageNumber = rand.nextInt(noOfPages) + 1;
//		System.out.println(pageNumber);
//		driver.get("https://emag.ro/search/" + searchedProduct + "/p" + pageNumber);
		
		emagSteps.navigateToRandomResultsPage(searchedProduct);
		
		dynamicElement = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".lazy")));
		List<WebElement> products = driver.findElements(By.cssSelector(".lazy"));
		int product = rand.nextInt(products.size()) + 1;
		System.out.println(product);
		products.get(product).click();
		String title = driver.findElement(By.cssSelector(".page-title")).getText();
		dynamicElement3 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(
				By.cssSelector(".btn.btn-primary.btn-emag.btn-block.yeahIWantThisProduct.gtm_680klw")));
		addToCart = driver
				.findElement(By.cssSelector(".btn.btn-primary.btn-emag.btn-block.yeahIWantThisProduct.gtm_680klw"));
		addToCart.click();
		dynamicElement2 = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".btn")));
		cartDetails = driver.findElement(By.cssSelector(".btn"));
		cartDetails.submit();
		String productTitle = driver.findElement(By.cssSelector(".line-item-title.main-product-title")).getText();
		Assert.assertEquals(title, productTitle);
	}

}
