package Tests.practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.BrowserFactory;
import utils.Driver;

public class xpathRelative {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://login1.nextbasecrm.com/company/personal/user/527/disk/path/");
        driver.findElement(By.xpath("//input[@class='login-inp']")).sendKeys("filiz");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        WebElement warninMessage=driver.findElement(By.xpath("//div[@class='errortext']"));
        System.out.println(warninMessage.getText());

        String s =Float.toString(3.4f);
        String s1=Integer.toString(7);

        int a=Integer.parseInt("123");



    }
}
