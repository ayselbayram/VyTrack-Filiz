package Tests.practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class PopUpPractice {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("JavaScript Alerts")).click();

    }
    @Test(description = "click on button then ok button on popup, then get the message")
    public void test1(){


        driver.findElement(By.xpath("//button[1]")).click();
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        BrowserUtils.wait(1);
        alert.accept();
        System.out.println(driver.findElement(By.cssSelector("#result")).getText());
    }
    @Test(description = "click on button2, and cancel it, then get the message")
    public void test2(){
        driver.findElement(By.xpath("//button[2]")).click();
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        BrowserUtils.wait(1);
        alert.dismiss();
        BrowserUtils.wait(1);
        System.out.println(driver.findElement(By.id("result")).getText());
    }
    @Test(description = "enter option3, enter text, then click ok")
    public void test3(){
        driver.findElement(By.xpath("//button[3]")).click();
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        BrowserUtils.wait(1);
        alert.sendKeys("Java is fun");
        BrowserUtils.wait(1);
        alert.accept();
        System.out.println(driver.findElement(By.cssSelector("#result")).getText());
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
