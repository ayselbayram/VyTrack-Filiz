package Tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class deneme {
    WebDriver driver= BrowserFactory.getDriver("chrome");
    @Test
    public void findBrokenLinks(){

        String url="http://practice.cybertekschool.com/";

        driver.get(url);
        BrowserUtils.wait(5);
        List<WebElement> links=driver.findElements(By.tagName("a"));

        for(WebElement each:links){
            Assert.assertTrue(each.isEnabled());

        }

    }
    @Test
    public void brokenImages(){
        driver.get("http://the-internet.herokuapp.com/broken_images");
        for (WebElement image : driver.findElements(By.cssSelector("img")))
        {
            isImageBroken(image);
        }
    }

    public void isImageBroken(WebElement image)
    {
        if (image.getAttribute("naturalWidth").equals("0"))
        {
            System.out.println(image.getAttribute("outerHTML") + " is broken.");
        }
    }
}
