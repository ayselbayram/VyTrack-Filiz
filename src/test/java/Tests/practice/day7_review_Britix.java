package Tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class day7_review_Britix {
    private WebDriver driver;
    @BeforeMethod
    public void logIn(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("https://login1.nextbasecrm.com/company/personal/user/527/disk/path/");
        driver.findElement(By.cssSelector(".login-inp")).sendKeys("helpdesk37@cybertekschool.com");
        driver.findElement(By.cssSelector("[type*='password']")).sendKeys("UserUser");
        driver.findElement(By.cssSelector("[value^='L']")).click();

    }
    @Test
    public void ActivityStream(){

        String expectedTitle="Activity Stream";
        driver.findElement(By.xpath("//span[@data-role='item-text']")).getText();
        driver.findElement(By.id("pagetitle"));
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Contact Center");
        driver.quit();
    }
}
