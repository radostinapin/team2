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

    @FindBy(linkText = "test1")
    WebElement accountButton;

    @FindBy(xpath = "//div[contains(text(),'Authentication failed')]")
    WebElement errorMessage;

    @FindBy(linkText = "qatest1")
    WebElement qatest1Account;

    @FindBy(xpath = "//button[contains(text(),'Delete account')]")
    WebElement deleteQaAccount;

    @FindBy(linkText = "admin")
    WebElement admin;

    @FindBy(linkText = "Logout")
    WebElement logout;


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

    public void deleteAccount() throws InterruptedException {
        qatest1Account.click();
        Thread.sleep(100);
        deleteQaAccount.click();
        Thread.sleep(100);

    }


    public void login(String username, String password) throws InterruptedException {
        this.username.clear();
        Thread.sleep(300);
        this.username.sendKeys(username);
        Thread.sleep(300);
        this.password.clear();
        this.password.sendKeys(password);
        Thread.sleep(300);
        loginButton.click();

    }

    public void enterAccount(){
        accountButton.click();
    }

    public String validateErrorMessage(){
        return BrowserUtils.getText(errorMessage);
    }







}
