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
        loginPage.clearBox();
        loginPage.login(ConfigReader.readProperty("username"),
                ConfigReader.readProperty("password"));

    }
    @Then("User validate the  message 'Codefish QA'from homepage")
    public void user_validate_the_message_codefish_qa_from_homepage(String expectedMessage) throws InterruptedException {
        loginPage.validateMessage(expectedMessage);
    }



}
