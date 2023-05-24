package com.website.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class CartFunctPage {

    public CartFunctPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//div[@class='card-body']")
    List<WebElement> addToCartButton;

    @FindBy(xpath = "//li//a[.='Cart']")
    WebElement cartButton;

    @FindBy(xpath = "//div//table//td[2]")
   WebElement productName;

    @FindBy(xpath = "//div//table//td[3]")
   WebElement productPrice;

    @FindBy(xpath = "//div//table//td[4]")
    WebElement removeProdBtn;

    @FindBy(xpath = "//button[.='Remove']")
   List<WebElement >  removeAllBtn;

    @FindBy(xpath = "//div[@role='alert']")
    WebElement message;


    public void clickAddToCartButton (WebDriver driver) throws InterruptedException {

        for (int i = 0; i < addToCartButton.size()-5; i++) {
            BrowserUtils.scrollWithJS(driver,addToCartButton.get(i));
            Thread.sleep(1000);
            addToCartButton.get(i).click();

        }
    }
        public void clickToCartBtn(WebDriver driver) throws InterruptedException {

        Thread.sleep(1000);
        BrowserUtils.clickWithJS(driver, cartButton);
            Thread.sleep(1000);
    }
    public void checkProduct( ) throws InterruptedException {
      BrowserUtils.getText(productName);
        Thread.sleep(1000);
      BrowserUtils.getText(productPrice);
        Thread.sleep(1000);
      BrowserUtils.getText(removeProdBtn);

    }

    public void clickRemoveBtn(WebDriver driver) throws InterruptedException {

        for(int i=0; i<removeAllBtn.size(); i++) {
            Thread.sleep(3000);
            BrowserUtils.clickWithJS(driver, removeAllBtn.get(i));
            Thread.sleep(3000);
        }
    }

    public String validateMessage(String expectedMessage) throws InterruptedException {
        Thread.sleep(2000);
        return BrowserUtils.getText(message);


    }}


