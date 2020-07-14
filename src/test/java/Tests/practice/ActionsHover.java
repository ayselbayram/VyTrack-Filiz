package Tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;
import utils.Driver;

public class ActionsHover {

    WebDriver deriver=new FirefoxDriver();
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/hovers");
    }
    @Test(description = "verify first image")
    public void test1(){
        WebElement image1=driver.findElement(By.cssSelector(".figure:nth-of-type(1)"));
        Assert.assertTrue(Driver.get().getPageSource().contains("Hovers"));

        Actions action=new Actions(driver);
        action.moveToElement(image1).perform();
        String actualText=driver.findElement(By.xpath("//h5[text()='name: user1']")).getText();
        String expected="name: user1";
        System.out.println(actualText);
        Assert.assertEquals(actualText,expected,"message is wrong");


    }
    @Test(description = "verify all images")
    public void test2(){
        Actions action=new Actions(driver);
        for(int i=1;i<=3;i++) {

//           action.moveToElement(driver.findElement(By.cssSelector(".figure:nth-of-type("+i+")"))).perform();
           action.moveToElement(driver.findElement(By.xpath("//div[@class='figure']["+i+"]"))).perform();//both works
        BrowserUtils.wait(2);
//            System.out.println(driver.findElement(By.cssSelector(".figure:nth-of-type("+i+")")).getText());
        }
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
