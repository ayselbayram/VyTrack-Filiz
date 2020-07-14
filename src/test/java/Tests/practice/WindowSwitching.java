package Tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.Set;

public class WindowSwitching {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }
    @Test(description = "Verify that title is practice")
    public void test1(){
     driver.findElement(By.linkText("New tab")).click();
        BrowserUtils.wait(4);
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Practice");
    }
    @Test(description = "verify that user is able to see new window, switch between the windows")
    public void test2(){
        driver.findElement(By.linkText("New tab")).click();
        BrowserUtils.wait(4);
        String OriginalWindowHandle=driver.getWindowHandle();
        Set<String> windowHandles=driver.getWindowHandles();
        for(String windowHandle: windowHandles){
            if(!windowHandle.equals(OriginalWindowHandle)){
                driver.switchTo().window(windowHandle);
            }
        }
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Fresh tab");

        //going back original page, by title
        String originalTitle="Practice";
        for(String windowHandle:windowHandles){
            driver.switchTo().window(windowHandle);
            if(driver.getTitle().equals(originalTitle)){
                break;
            }
        }
        System.out.println(driver.getTitle());
    }






    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
