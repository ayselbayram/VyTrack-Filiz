package Tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class StartsWith {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://login1.nextbasecrm.com/company/personal/user/527/disk/path/");
        driver.findElement(By.xpath("//input[starts-with(@placeholder,'Lo')]")).sendKeys("Filiz");
        driver.findElement(By.xpath("//input[starts-with(@type,'pas')]")).sendKeys("123");
        driver.findElement(By.xpath("//input[starts-with(@onclick,'BX')]")).click();
        WebElement wMessage=driver.findElement(By.xpath("//div[starts-with(@class,'er')]"));
        System.out.println(wMessage.getText());
        driver.quit();

    }
}
