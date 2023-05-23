package com.website.stepdefinitions;

import com.website.pages.CartFunctPage;
import com.website.pages.CategoryPage;
import com.website.pages.CodefishLoginPage;
import com.website.pages.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class CartStepDef {
    WebDriver driver = DriverHelper.getDriver();
    CodefishLoginPage loginPage = new CodefishLoginPage(driver);
    CartFunctPage cartFunctPage = new CartFunctPage(driver);
    HomePage homePage = new HomePage(driver);


        @When("User navigates to addcart and cart button and clicks")
        public void user_navigates_to_addcart_and_cart_button_and_clicks() throws InterruptedException {
            loginPage.login(ConfigReader.readProperty("username"),
                    ConfigReader.readProperty("password"));
            cartFunctPage.clickAddToCartButton(driver);
            cartFunctPage.clickToCartBtn(driver);

        }
        @When("User navigates  {string}, {string},  {string}")
        public void user_navigates(String productName, String productPrice, String removeProdBtn ) throws InterruptedException {
            cartFunctPage.checkProduct();

        }
        @When("User navigates and click to remove button")
        public void user_navigates_and_click_to_remove_button() throws InterruptedException {
            cartFunctPage.clickRemoveBtn();
        }
    @Then("User validates {string}")
    public void user_validates_message(String expectedMessage) throws InterruptedException {
        Assert.assertEquals(expectedMessage,cartFunctPage.validateMessage(expectedMessage) );
    }
}


