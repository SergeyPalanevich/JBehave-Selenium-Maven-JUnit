package com.epam.bdd.jbehave.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='pb15']")
    public WebElement cart;


    public String getCartCount() {
        waitForJSLoadComplete();
        return cart.getText();
    }
}
