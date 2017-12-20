package com.epam.bdd.jbehave.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.bdd.core.drivers.DriverManager.getDriver;

public class HomePage extends BasePage{
    private static final String url = "https://www.ebay.com/";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gh-ac")
    public WebElement searchField;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement searchButton;

    public void open() {
        getDriver().get(url);
        waitForJSLoadComplete();
    }

    public void setCritetia(String query) {
        searchField.sendKeys(query);
    }

    public ResultPage runSearch() {
        searchButton.click();
        return new ResultPage(getDriver());
    }
}
