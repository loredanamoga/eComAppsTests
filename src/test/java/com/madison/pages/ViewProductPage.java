package com.madison.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

/**
 * Created by loredanamoga on 7/26/2017.
 */
public class ViewProductPage extends PageObject {

    @FindBy(css=".h1")
    private WebElement productTitle;

    @FindBy(css=".short-description>.std")
    private WebElement productShortDescription;

    @FindBy (css = ".tab-content>.std")
    private WebElement productDescription;


    public void takeProductTitle() {
        waitFor(productTitle);
        Serenity.setSessionVariable("productTitle").to(productTitle.getText());
        System.out.println(productTitle.getText());
    }

    public void takeProductShortDescription() {
        waitFor(productShortDescription);
        Serenity.setSessionVariable("productShortDescription").to(productShortDescription.getText());
        System.out.println(productShortDescription.getText());
    }

    public void takeProductDescription(){
        waitFor(productDescription);
        Serenity.setSessionVariable("productDescription").to(productDescription.getText());
        System.out.println(productDescription.getText());
    }

    //search specific word in title, description and short description
    public boolean verifyProductIfContainsSpecificWord(String searchTerm) {
        return (checkIfContainsWord(productTitle.getText(),searchTerm) || checkIfContainsWord(productDescription.
                getText(),searchTerm) || checkIfContainsWord(productShortDescription.getText(),searchTerm));
    }

    public void navigateToPreviousPage() {
        getDriver().navigate().back();
    }

    public boolean verifyProductIfContainsSpecificWordAndGoBack(String searchTerm) {
        Boolean flag = verifyProductIfContainsSpecificWord(searchTerm);
        navigateToPreviousPage();
        return flag;
    }

    private boolean checkIfContainsWord(String productToSearchIn, String searchTerm) {
        return productToSearchIn.toLowerCase().contains(searchTerm);
    }


}
