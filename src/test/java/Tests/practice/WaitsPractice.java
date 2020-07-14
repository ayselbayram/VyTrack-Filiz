package Tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.concurrent.TimeUnit;

public class WaitsPractice {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }
    @Test
    public void test1(){
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 1")).click();
        driver.findElement(By.tagName("Button")).click();

        WebElement usernamebox=driver.findElement(By.id("username"));
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(usernamebox));
        usernamebox.sendKeys("tomsmith");

        //password
        WebElement passwordBox=driver.findElement(By.id("pwd"));
//        wait.until(ExpectedConditions.invisibilityOf(passwordBox));
        passwordBox.sendKeys("SuperSecretPassword");

       //submit button
        WebElement submitButton=driver.findElement(By.xpath("//button[text()='Submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();

        //message
        WebElement message=driver.findElement(By.cssSelector("#flash"));
        wait.until(ExpectedConditions.visibilityOf(message));
        System.out.println(message.getText());
    }
    @Test(description = "overlay")
    public void test2(){
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 5")).click();
        WebDriverWait wait=new WebDriverWait(driver,15);
        WebElement overlay=driver.findElement(By.cssSelector("[class='fa fa-cog fa-spin']"));
        wait.until(ExpectedConditions.visibilityOf(overlay));
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //enter password
        driver.findElement(By.id("pwd")).sendKeys("SuperSecretPassword");
        //click on submit key
        driver.findElement(By.tagName("button")).click();

    }



    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
