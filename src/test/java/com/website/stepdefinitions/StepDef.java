package com.website.stepdefinitions;


import com.website.pages.CodefishLoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class StepDef {

    WebDriver driver= DriverHelper.getDriver();
    CodefishLoginPage loginPage=new CodefishLoginPage(driver);

    //register new user
    @When("User provides username and password and click register button")
    public void user_provides_username_and_password_and_click_register_button() throws InterruptedException {
       loginPage.createAccount(ConfigReader.readProperty("username"),
        ConfigReader.readProperty("password"));

    }
    @Then("User validate the  message {string} from homepage")
    public void user_validate_the_message_from_homepage(String expectedMessage) throws InterruptedException {
    loginPage.validateMessage(expectedMessage);
    }

    //positive login
    @When("User provides username and password and click login")
    public void user_provides_username_and_password_and_click_login() throws InterruptedException {
        loginPage.login(ConfigReader.readProperty("username"),
                ConfigReader.readProperty("password"));
    }
    @Then("User navigate to his account dashboard")
    public void user_navigate_to_his_account_dashboard() {
        loginPage.enterAccount();
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(ConfigReader.readProperty("account_url"),driver.getCurrentUrl());
    }

    //negative login
    @When("User provides {string} and {string} for CodeFish QA")
    public void user_provides_and_for_code_fish_qa(String username, String password) {
        loginPage.login(username,password);
    }
    @Then("User validate the,{string} error message")
    public void user_validate_the_error_message(String errorMessage) {
     Assert.assertEquals(errorMessage,loginPage.validateErrorMessage());

    }







}
