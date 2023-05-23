package com.website.stepdefinitions;


import com.website.pages.CategoryPage;
import com.website.pages.CodefishLoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

import java.util.HashMap;
import java.util.Map;

public class StepDef {

    WebDriver driver= DriverHelper.getDriver();
    CodefishLoginPage loginPage=new CodefishLoginPage(driver);
    CategoryPage categoryPage= new CategoryPage(driver);

    //register new user
    @When("User provides username and password and click register button")
    public void user_provides_username_and_password_and_click_register_button() throws InterruptedException {
       loginPage.createAccount(ConfigReader.readProperty("username_OnlyForAccountCreation"),
        ConfigReader.readProperty("password_OnlyForAccountCreation"));
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
    public void user_provides_and_for_code_fish_qa(String username, String password) throws InterruptedException {
        loginPage.login(username,password);
    }
    @Then("User validate the,{string} error message")
    public void user_validate_the_error_message(String errorMessage) {
     Assert.assertEquals(errorMessage,loginPage.validateErrorMessage());

    }

    @When("User chooses {string}")
    public void user_chooses(String category) {
        categoryPage.selectCategory("machinery");

    }
    @Then("User validates if the correct product and price are displaced.")
    public void user_validates_if_the_correct_product_and_price_are_displaced() {

        Map<String, String> expectedVaccineCategory= new HashMap<>();
        expectedVaccineCategory.put("Pfizer Vaccine", "9.99$");
        expectedVaccineCategory.put("Sputnik Vaccine", "6.59$");

        Map<String, String> expectedDrugsCategory= new HashMap<>();
        expectedDrugsCategory.put("Paracetamol", "10.29$");
        expectedDrugsCategory.put("Tramadol", "10.39$");
        expectedDrugsCategory.put("Aspirine", "5.99$");

        Map<String, String> expectedToolsCategory= new HashMap<>();
        expectedToolsCategory.put("Advanced Dissection Kit", "59.99$");
        expectedToolsCategory.put("CALIBRA Sphygmomanometer", "34.99$");

        Map<String, String> expectedMachineryCategory= new HashMap<>();
        expectedMachineryCategory.put("LCD Digital Microscope", "253.79$");
        expectedMachineryCategory.put("NIKON DIAPHOT", "1845.59$");



        categoryPage.list(expectedMachineryCategory);



    }






}
