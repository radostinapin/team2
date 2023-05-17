package utils;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

public class BrowserUtils {
    public static void selectBy(WebElement location, String value, String methodName){

        Select select=new Select(location);
        switch (methodName){
            case "text":
                select.selectByVisibleText(value);
                break;
            case  "value":
                select.selectByValue(value);
                break;
            case  "index":
                select.selectByIndex(Integer.parseInt(value));
            default:
                System.out.println("Method name is not available, use text value or index");

        }
    }

    //===getText method====
    public static String getText(WebElement element){
        return element.getText().trim();
    }


    //======JavaScript Methods=================
    public static String getTitleWithJS(WebDriver driver){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        return js.executeScript("return document.title").toString().trim();
    }

    public  static void  clickWithJS(WebDriver driver,WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",element);
    }

    public static void scrollWithJS(WebDriver driver,WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",element);
    }//==============================

    //how to switch btw 2 windows
    public static void switchByID(WebDriver driver){
        String mainPageID= driver.getWindowHandle();
        Set<String> allPagesID=driver.getWindowHandles();
        for(String id:allPagesID){
            if(!id.equals(mainPageID)){
                driver.switchTo().window(id);
                break;
            }
        }
    }

    public static void switchByTitle(WebDriver driver,String title){
        Set<String> allPagesID=driver.getWindowHandles();
        for(String id:allPagesID){
            driver.switchTo().window(id);
            if(driver.getTitle().contains(title)){
                break;
            }

        }
    }

    public  static void getScreenShot(WebDriver driver,String packageName){

        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //String location=System.getProperty("user.dir")+"/src/java/screenshot"+packageName;
        String location=System.getProperty("src/test/java/"+ packageName+"/");

        try{
            FileUtils.copyFile(file,new File(location+System.currentTimeMillis()));
        }catch(IOException e){
            throw new RuntimeException();
        }finally{
            throw new RuntimeException();
        }
    }

    public static void getScreenShotForCucumber(WebDriver driver, Scenario scenario){
        Date currentDate=new Date();
        String screenShotFileName=currentDate.toString().replace(" ","-").replace(":","-");
        if(scenario.isFailed()){
            File screenShotFile=((TakesScreenshot)driver).getScreenshotAs((OutputType.FILE));
            try {
                FileUtils.copyFile(screenShotFile,new File("src/test/java/screenshot/"+screenShotFileName+".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }







}
