package com.emag.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.WebElement;

/**
 * Created by loredanamoga on 7/25/2017.
 */
public class ViewCartPage extends PageObject {

    @FindBy (css = "[href='/cart/products?ref=add-to-cart-module_go-to-cart_button']")
    private WebElement viewCart;

    @FindBy(css = ".line-item-title.main-product-title")
    private WebElement cartProductTitle;


    public void setProductTitleFromCart(){
        Serenity.setSessionVariable("cartProductTitle").to(cartProductTitle.getText());

    }
    public void submitViewCartDetailsButton(){
        viewCart.click();
    }

    @StepGroup
    public void submitViewCartDetailsButtonAndSetProductTitleFromCart(){
        submitViewCartDetailsButton();
        setProductTitleFromCart();
    }
}
