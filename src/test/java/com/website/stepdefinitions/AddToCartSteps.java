package com.website.stepdefinitions;

import com.website.pages.CartFunctPage;
import com.website.pages.CategoryPage;
import com.website.pages.CodefishLoginPage;
import com.website.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class AddToCartSteps {
    WebDriver driver = DriverHelper.getDriver();
    CodefishLoginPage loginPage = new CodefishLoginPage(driver);
    CategoryPage categoryPage = new CategoryPage(driver);
    HomePage homePage = new HomePage(driver);
  //  CartFunctPage cartFunctPage = new CartFunctPage(driver);

    @Then("User scrolls down the homepage and clicks Add to cart button")
    public void user_scrolls_down_the_homepage_and_clicks_add_to_cart_button() throws InterruptedException {
        loginPage.login(ConfigReader.readProperty("username"),
                ConfigReader.readProperty("password"));
        homePage.clickAddToCartButton(driver);
    }

    @Then("User validate Add to cart button has the check mark on")
    public void user_validate_add_to_cart_button_has_the_check_mark_on() throws InterruptedException {
       // homePage.validateAddToCartButtonFunctionality();
   homePage.validateAddToCartButtonFunctionality();





}}
