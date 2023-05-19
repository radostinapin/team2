package com.website.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryPage {
    public CategoryPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[.='All']")
    WebElement allCategory;

    @FindBy(xpath = "//button[.='Vaccines']")
    WebElement vaccines;

    @FindBy(xpath = "//button[.='Drugs']")
    WebElement drugs;

    @FindBy(xpath = "//button[.='Tools']")
    WebElement tools;

    @FindBy(xpath = "//button[.='Machinery']")
    WebElement machinery;

    @FindBy(css = ".card-title")
    List<WebElement> titles;

    @FindBy(xpath = "//div[@class='card-body']/p[2]")
    List<WebElement> prices;




    public void selectCategory(String category){
        category=category.toLowerCase();
        switch (category){

            case "all" :
                allCategory.click();
                break;
            case"vaccines" :
                vaccines.click();
                break;
            case "drugs" :
                drugs.click();
                break;
            case "tools" :
                tools.click();
                break;
            case "machinery" :
                machinery.click();
                break;
            default:
                System.out.println("Category is incorrect!");
        }
    }

    public void list(Map<String,String> expected){
        Map<String, String> mapOptions =new HashMap<>();
        for(int i=0; i<titles.size(); i++){
            mapOptions.put(titles.get(i).getText(), prices.get(i).getText());

        }
        Assert.assertEquals(expected,mapOptions);

    }


}
