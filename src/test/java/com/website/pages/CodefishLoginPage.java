package com.website.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class CodefishLoginPage {


    public  CodefishLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//button[contains(text(),'Register')]")
    WebElement registerButton;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement checkBox;

    @FindBy(linkText = "Codefish QA")
    WebElement message;


    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginButton;


    public void createAccount(String username,String password) throws InterruptedException {
        registerButton.click();
        Thread.sleep(200);
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        checkBox.click();
        registerButton.click();
        Thread.sleep(200);

    }

    public void validateMessage(String expectedMessage) throws InterruptedException {
        Assert.assertEquals(expectedMessage, BrowserUtils.getText(message));
    }

    public void clearBox() throws InterruptedException {
        username.clear();
        Thread.sleep(500);
        password.clear();
        Thread.sleep(500);
    }
    public void login(String username,String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }





}
