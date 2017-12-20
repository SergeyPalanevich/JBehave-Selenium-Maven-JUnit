package com.epam.bdd.jbehave.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.bdd.core.drivers.DriverManager.getDriver;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[@role='button' and @vib='vib' and @id='isCartBtn_btn']")
    public WebElement addToCartButton;


    public CartPage addToCart() {
        addToCartButton.click();
        return new CartPage(getDriver());
    }
}
