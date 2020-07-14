package Tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class DragandDrop {
    @Test
    public void test1(){
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("button[class='optanon-allow-all accept-cookies-button']")).click();

        Actions action=new Actions(driver);
        WebElement earth=driver.findElement(By.id("droptarget"));
        WebElement moon=driver.findElement(By.id("draggable"));
        BrowserUtils.wait(2);
        action.dragAndDrop(moon,earth).perform();
        BrowserUtils.wait(2);



        driver.quit();


    }
}
