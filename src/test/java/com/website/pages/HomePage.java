package com.website.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);}


        @FindBy(xpath = "//div[@class='card-body']//button")
        List<WebElement> addToCartButton;

        @FindBy(xpath = " //div[@class='card-body']//i")
        WebElement checkMarkAddToCartButton;

        public void clickAddToCartButton (WebDriver driver) throws InterruptedException {

            for (int i = 0; i < addToCartButton.size(); i++) {
             BrowserUtils.scrollWithJS(driver,addToCartButton.get(i));
             Thread.sleep(1000);
                addToCartButton.get(i).click();

            }
        }
        public void validateAddToCartButtonFunctionality () throws InterruptedException {


           // Assert.assertTrue(checkMarkAddToCartButton.isDisplayed());
         //   return checkMarkAddToCartButton.isDisplayed();

            Thread.sleep(1000);
                checkMarkAddToCartButton.isEnabled();
                checkMarkAddToCartButton.isDisplayed();
            }

        }



