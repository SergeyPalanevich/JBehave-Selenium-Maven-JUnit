package com.epam.bdd.jbehave.steps;

import com.epam.bdd.jbehave.pages.CartPage;
import com.epam.bdd.jbehave.pages.HomePage;
import com.epam.bdd.jbehave.pages.ProductPage;
import com.epam.bdd.jbehave.pages.ResultPage;
import org.jbehave.core.annotations.*;
import org.springframework.stereotype.Component;

import static com.epam.bdd.core.drivers.DriverManager.closeDriver;
import static com.epam.bdd.core.drivers.DriverManager.getDriver;
import static org.junit.Assert.assertTrue;

@Component
public class EbayStepDef {
    private HomePage homepage;
    private ResultPage resultpage;
    private ProductPage productpage;
    private CartPage cartpage;

    @Given("User navigates to Ebay page")
    public void givenUserNavigatesToEbayPage() {
        homepage = new HomePage(getDriver());
        homepage.open();
    }

    @When("User enter search criteria as $query")
    public void whenUserEnterSearchCriteria(@Named("query") String query) {
        homepage.setCritetia(query);
    }

    @When("User click on the Search button")
    public void whenUserClickOnSearchButton() {
        resultpage = homepage.runSearch();
    }

    @When("User select first product")
    public void whenUserSelectFirstProduct() {
        productpage = resultpage.selectFirstProduct();
    }

    @When("User add the product to cart")
    public void whenUserAddToCartTheProduct() {
        cartpage = productpage.addToCart();
    }

    @Then("Product count in cart should be $count")
    public void whenProductCountInCartShouldBe(@Named("count")String count) {
        assertTrue(cartpage.getCartCount().contains(count));
    }

    @AfterScenario(uponType = ScenarioType.EXAMPLE)
    public void terrDown(){
        closeDriver();
    }
}
