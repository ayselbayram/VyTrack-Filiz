package Tests.practice;


import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;

public class day7_review_VyTrack {
    private WebDriver driver;
    @BeforeMethod
    public void setDriver(){
        driver=BrowserFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("user153");
        driver.findElement(By.cssSelector("#prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.cssSelector(".btn.btn-uppercase.btn-primary.pull-right")).click();

    }
    @Test
    public void links(){
        List<WebElement> list= driver.findElements(By.xpath("//a"));
        System.out.println("Number of links: "+list.size());
        driver.quit();
    }
    @Test
    public void printLinks(){
        List<WebElement> list= driver.findElements(By.xpath("//a"));
        for(WebElement WebElement:list){
            if(WebElement.getText().isEmpty()){
                continue;
            }
            System.out.println(WebElement.getText()+" ");

        }
        driver.quit();
    }




}
