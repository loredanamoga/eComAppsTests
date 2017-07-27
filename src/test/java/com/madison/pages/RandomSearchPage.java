package com.madison.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;


import java.util.List;

/**
 * Created by loredanamoga on 7/26/2017.
 */
public class RandomSearchPage extends PageObject {

    private Random randomGenerator = new Random();
    private Random randomCategGenerator = new Random();
    private Random randomSubcategGenerator = new Random();

    MadisonHomePage madisonHomePage;

    @FindBy(css = ".nav-primary>.level0")
    private List<WebElement> navigationCategories;

    @FindBy(css = ".catblocks>li a")
    private List<WebElement> navigationSubcategories;

    @FindBy(css = ".products-grid>.item.last")
    private List<WebElement> productsList;

    public void redirectToRandomCategAndSubcategPage() {

        int index = Math.abs(randomCategGenerator.nextInt(navigationCategories.size()));
        navigationCategories.get(index).click();
        try {
            Integer indexSubcategory = Math.abs(randomSubcategGenerator.nextInt(navigationSubcategories.size()));
            if (indexSubcategory != null) {
                navigationSubcategories.get(indexSubcategory).click();
            }
        } catch (Exception e) {
        }
    }


    public void redirectToRandomProduct() {
        int indexProduct = Math.abs(randomGenerator.nextInt(productsList.size()));
        productsList.get(indexProduct).click();

    }


}
