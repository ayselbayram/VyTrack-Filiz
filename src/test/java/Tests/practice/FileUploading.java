package Tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FileUploading {

    @Test(description = "file uploading")
    public void test1(){
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.partialLinkText("Upload")).click();
        driver.findElement(By.cssSelector("#file-upload")).sendKeys("/Users/Filiz/Desktop/FlipgridQuestions.txt");

        BrowserUtils.wait(1);

        driver.findElement(By.cssSelector(".button")).click();
        String actualName=driver.findElement(By.cssSelector("#uploaded-files")).getText();
        String expected="FlipgridQuestions.txt";
        Assert.assertEquals(actualName,expected);



    driver.quit();
    }

}
