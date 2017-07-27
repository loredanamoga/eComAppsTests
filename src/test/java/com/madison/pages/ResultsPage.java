package com.madison.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by loredanamoga on 7/27/2017.
 */
public class ResultsPage extends PageObject {


    @FindBy(css = ".category-products > div:not(.toolbar-bottom) .pages>ol a")
    private List<WebElement> noOfPagesList;

    @FindBy(css = ".tab-content>.std")
    private WebElement searchedProdDescription;

    @FindBy(css = ".pages")
    private WebElement resultPages;

    @FindBy(css = ".products-grid>.item.last")
    private List<WebElement> productsList;

    MadisonHomePage madisonHomePage;
    RandomSearchPage randomSearchPage;


    public boolean checkByTitleIfProductIsInResultPage() {

        String productTitle = Serenity.sessionVariableCalled("productTitle").toString();
        madisonHomePage.searchInput(productTitle);
        try {
            if (resultPages.isDisplayed()) {
                System.out.println(productsList.size()+ "~~~~~~~~~~~");
                System.out.println(noOfPagesList.size()+ "----------");
                for (int i = 0; i < noOfPagesList.size(); i++) {
                    noOfPagesList.get(i).click();
                    for (WebElement product : productsList) {
                        if (product.getText().equals(productTitle)) {
                            return true;

                        }
                    }
                }
            }
        } catch (Exception e) {

            System.out.println(productsList.size()+ "~~~~~~~~~~~");

            for (WebElement product : productsList) {
                if (product.getText().equals(productTitle)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkByDescriptionIfProductIsInResultPage() {

        String productDescription = Serenity.sessionVariableCalled("productDescription").toString();
        madisonHomePage.searchInput(productDescription);
//        for (WebElement product : productsList) {
//            product.click();
//            if (searchedProdDescription.getText().contains(productDescription)) {
//                return true;
//            } else {
//                getDriver().navigate().back();
//            }
//        }
//        return false;
//    }

        for (int i = 0; i <= 2; i++) {
            randomSearchPage.redirectToRandomProduct();
            if (searchedProdDescription.getText().contains(productDescription)) {
                return true;

            }
        }

        return false;

    }
}
