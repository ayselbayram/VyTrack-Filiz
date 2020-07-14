package Tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;

public class WebTable1Prcatice {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        wait = new WebDriverWait(driver, 15);
        //wait until the table1 is presence
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("table1")));
    }

    @Test(description = "print table1 data")
    public void test1() {
        //without header
        WebElement rows = driver.findElement(By.xpath("//table[@id='table1']//tbody"));
        //with header
        //By.id("table1")
        System.out.println(rows.getText());
    }

    @Test(description = "verify that number of colouns in the first table is equals to 6")
    public void test2() {
        int expectedNumbercoluns = 6;
        int actualNumberColuns = driver.findElements(By.xpath("//table[@id='table1']//tr/th")).size();
        System.out.println(actualNumberColuns);
        Assert.assertEquals(actualNumberColuns, expectedNumbercoluns);
    }

    @Test(description = "verify that number of raws is equals to 5")
    public void test3() {
        int actualRows = driver.findElements(By.xpath("//table[@id='table1']//tr")).size();
        System.out.println(actualRows);
        int expectedRows = 5;
        Assert.assertEquals(actualRows, expectedRows);
    }

    @Test(description = "print all values from the 2.row (excluding table heder)")
    public void test4() {
    List<WebElement> row2=driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[2]//td"));
    for(WebElement each:row2){
        System.out.println(each.getText());
    }
    }
    @Test(description = "print all values from the n-th row (excluding table header")
    public void test5(){
        int index=1;
        List<WebElement> row2=driver.findElements(By.xpath("//table[@id='table1']//tbody//tr["+index+"]//td"));
        for(WebElement each:row2){
            System.out.println(each.getText());
        }

    }
    @Test(description = "verify that e mail in the 3. row is equal to jdoe@hotmail.com")
    public void test6(){
        int row=3;
        int column=3;
        String actualEmail=driver.findElement(By.xpath("//table[@id='table1']//tbody//tr["+row+"]//td["+column+"]")).getText();
        String expectedEmail="jdoe@hotmail.com";
        System.out.println(actualEmail);
        Assert.assertEquals(actualEmail,expectedEmail);
    }
    @Test(description = "verify that every email contains '@'")
    public void test7(){
        int index=1;
        List<WebElement>cells=driver.findElements(By.xpath("//table[@id='table1']//tbody//td[3]"));
        for(WebElement each:cells) {
            Assert.assertTrue(each.getText().contains("@"),"email not contains @");
            System.out.println(each.getText());
        }
    }
    @Test(description = "verify that author clicking on Last Name, values will be sorted in alphabetic order")
    public void test8(){
     driver.findElement(By.xpath("//table[@id='table1']//*[text()='Last Name']")).click();
     List<WebElement> lastnames=driver.findElements(By.xpath("//table[@id='table1']//td[1]"));
     for(int i=0;i<lastnames.size()-1;i++){
         String lastname=lastnames.get(i).getText();
         String followinglastname=lastnames.get(i+1).getText();
         Assert.assertTrue(lastname.compareTo(followinglastname)<0);
         System.out.println("iteration "+i);
         System.out.println("current last name "+lastname);
         System.out.println("following last name "+followinglastname);
     }
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
