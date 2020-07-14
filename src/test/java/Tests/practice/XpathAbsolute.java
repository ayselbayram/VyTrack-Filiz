package Tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class XpathAbsolute {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/registration_form");
        driver.findElement(By.xpath("/html/body/div/div/div/div/div//form/div/div/input")).sendKeys("Filiz");
        driver.findElement(By.xpath("/html/body/div/div/div/div/div//form/div[3]/div/input")).sendKeys("Anne");
        driver.findElement(By.xpath("/html/body/div/div/div/div/div//form/div[6]/div/input")).sendKeys("1234567");

        //britix
        driver.get("https://login1.nextbasecrm.com/company/personal/user/527/disk/path/");
        WebElement warningMessage=driver.findElement(By.id("/html/body/table/tbody/tr[2]/td/div/div/div[2]"));
        System.out.println(warningMessage.getText());

        //vytrack
        driver.get("https://qa2.vytrack.com/user/login");


    }
}
