package Tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class Dropdowns {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Dropdown")).click();
    }
    @Test(description = "select April from the months dropdown")
    public void test1(){
        WebElement months=driver.findElement(By.xpath("//select[@id='month']"));
        Select select=new Select(months);
        select.selectByVisibleText("April");
        BrowserUtils.wait(1);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"April");
    }
    @Test(description = "select the day from the day dropdown")
    public void test2(){
        WebElement day=driver.findElement(By.xpath("//select[@id='day']"));
        Select select=new Select(day);
        select.selectByValue("9");
        BrowserUtils.wait(1);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"8");

    }
    @Test(description = "select the year from the year dropdown")
    public void test3(){
        WebElement year=driver.findElement(By.xpath("//select[@id='year']"));
        Select select=new Select(year);
        select.selectByValue("1978");
        BrowserUtils.wait(1);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"1978");
    }
    @Test(description = "display the months")
    public void test(){
        WebElement element=driver.findElement(By.xpath("//select[@id='month']"));
        Select select=new Select(element);
        List<WebElement> states=select.getOptions();
        for(WebElement state:states){
            System.out.println(state.getText());
        }
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
