package com.website.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class Hook {

    WebDriver driver= DriverHelper.getDriver();
    @BeforeAll
    public void clearCaches(){
        driver.manage().deleteAllCookies();
    }

    @Before
    public void setup(){
        driver.get(ConfigReader.readProperty("url_qa"));
    }

    @After
    public void tearDown(Scenario scenario){
        BrowserUtils.getScreenShotForCucumber(driver,scenario);
       // driver.quit();
    }


}
