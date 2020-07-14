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

public class MultipleButtons {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test(description = "click all the cehck boxes, isEnable,isSelected")
    public void test1() {

        driver.findElement(By.linkText("Checkboxes")).click();
        List<WebElement> checkbox = driver.findElements(By.cssSelector("[type='checkbox']"));

        int counter = 1;
        for (WebElement box : checkbox) {

            if (box.isEnabled() && !box.isSelected()) {
                BrowserUtils.wait(1);
                box.click();
                System.out.println(counter + " is clicked");
            } else {
                System.out.println(counter + " is not clicked ");
            }
            counter++;
        }


    }

    @Test(description = "select Option 2")
    public void test2() {
        driver.findElement(By.linkText("Dropdown")).click();
        WebElement dropDown = driver.findElement(By.cssSelector("#dropdown"));
        Select select = new Select(dropDown);
        select.selectByValue("2");
        BrowserUtils.wait(1);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 2");

    }

    @Test(description = "click all Radio buttons")
    public void test3() {
        driver.findElement(By.linkText("Radio Buttons")).click();
        List<WebElement> buttons = driver.findElements(By.xpath("//input[@type='radio']"));
        int count = 1;
        for (WebElement button : buttons) {
            if (button.isEnabled() && !button.isSelected()) {
                button.click();
                System.out.println(button.getAttribute("id") + " clickable");
            } else {
                System.out.println(button.getAttribute("id") + " not clickable");
            }
            count++;
        }

    }

    @Test(description = "verify that blue button is selected already")
    public void test4() {
        driver.findElement(By.linkText("Radio Buttons")).click();
        WebElement blueButton = driver.findElement(By.cssSelector("#blue"));
        BrowserUtils.wait(1);
        Assert.assertTrue(blueButton.isSelected());
    }
    @Test(description = "verify that red button is not selected")
     public void test5(){
        driver.findElement(By.linkText("Radio Buttons")).click();
        WebElement redButton=driver.findElement(By.id("red"));
        Assert.assertFalse(redButton.isSelected());
    }
    @Test(description = "verify that green button is not clickable")
    public void test6(){
        driver.findElement(By.linkText("Radio Buttons")).click();
        WebElement greenButton=driver.findElement(By.id("green"));
        Assert.assertFalse(greenButton.isEnabled());
    }
    @AfterMethod
    public void teardown() {
        driver.quit();

    }
}
