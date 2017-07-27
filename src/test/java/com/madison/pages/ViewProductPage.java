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


    public void setProductTitle() {
        waitFor(productTitle);
        Serenity.setSessionVariable("productTitle").to(productTitle.getText());
        System.out.println(productTitle.getText());
    }

    public void setProductShortDescription() {
        waitFor(productShortDescription);
        Serenity.setSessionVariable("productShortDescription").to(productShortDescription.getText());
        System.out.println(productShortDescription.getText());
    }

    public void setProductDescription(){
        waitFor(productDescription);
        Serenity.setSessionVariable("productDescription").to(productDescription.getText());
        System.out.println(productDescription.getText());

    }

    @StepGroup
    public void setProductTitleAndDescriptions(){
        setProductTitle();
        setProductDescription();
        setProductShortDescription();
    }



}
