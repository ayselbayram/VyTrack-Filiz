package Tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class CheckBoxes {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Checkboxes")).click();

    }
    @Test(description = "checkbox is selected or not")
    public void test1(){
        WebElement chechBox1=driver.findElement(By.xpath("//input[@type='checkbox'][1]"));

        Assert.assertFalse(chechBox1.isSelected());
    }
    @Test(description = "checkbox is selected or not")
    public void test2(){
        WebElement chechBox1=driver.findElement(By.id("//input[@type='checkbox'][2]"));
        Assert.assertTrue(chechBox1.isSelected());
    }



    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
