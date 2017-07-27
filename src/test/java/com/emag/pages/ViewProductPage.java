package com.emag.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.StepGroup;
import org.jruby.ext.socket.SocketUtils;
import org.openqa.selenium.WebElement;

/**
 * Created by loredanamoga on 7/25/2017.
 */
public class ViewProductPage extends PageObject {

    @FindBy(css = ".btn.btn-primary.btn-emag.btn-block.yeahIWantThisProduct.gtm_680klw")
    private WebElement addToCart;

    @FindBy(css=".page-title")
    private WebElement title;

    public void setProductTitle() {
        Serenity.setSessionVariable("title").to(title.getText());
        System.out.println(title);
    }

    public void clickAddToCartOnRandomProduct(){
        addToCart.click();
    }

    @StepGroup
    public void setProductTitleAndClickAddToCartOnRandomProduct() {
        setProductTitle();
        clickAddToCartOnRandomProduct();
    }

}
