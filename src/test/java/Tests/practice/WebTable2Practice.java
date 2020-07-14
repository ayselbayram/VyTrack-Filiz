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

public class WebTable2Practice {
    private WebDriver driver;
    private WebDriverWait wait;
    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        wait=new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("table2")));
    }
    @Test(description = "print table1 data")
    public void test1(){//without header
        WebElement table1=driver.findElement(By.xpath("//table[@id='table2']//tbody"));
        System.out.println(table1.getText());
    }
    @Test(description = "verify that number of colouns in the first table is equals to 6")
    public void test2(){
     int actualColumnNumbers=driver.findElements(By.xpath("//table[@id='table2']//tr[1]//td")).size();
     int expectedColumnNumber=6;
        System.out.println(actualColumnNumbers);
        Assert.assertEquals(actualColumnNumbers,expectedColumnNumber);
    }
    @Test(description = "verify that number of rows is equals to 5")
    public void test3(){
     int actualRowNumbers=driver.findElements(By.xpath("//table[@id='table2']//tr")).size();
     int expectedRowNumber=5;
        System.out.println(actualRowNumbers);
        Assert.assertEquals(actualRowNumbers,expectedRowNumber);
    }
    @Test(description = "print all values from the 2.row (excluding table heder)")
    public void test4(){
       List<WebElement> cell=driver.findElements(By.xpath("//table[@id='table2']//tbody//tr[2]//td"));
       for(WebElement row2:cell){
           System.out.println(row2.getText());
       }
    }
    @Test(description = "print all values from the n-th row (excluding table heder)")
    public void test5(){
        int index=4;
        List<WebElement>cell=driver.findElements(By.xpath("//table[@id='table2']//tbody//tr["+index+"]//td"));
        for(WebElement rowData:cell){
            System.out.println(rowData.getText());
        }

    }
    @Test(description = "verify that e mail in the 3. row is equal to jdoe@hotmail.com")
    public void test6(){
        int row1=3;
        int column=3;
        List<WebElement> rows=driver.findElements(By.xpath("//table[@id='table2']//tbody//tr["+row1+"]//td["+column+"]"));
        for(WebElement row:rows){
            Assert.assertTrue(row.getText().equals("jdoe@hotmail.com"));
            System.out.println(row.getText());
        }

    }
    @Test(description = "verify that every email contains '@'")
    public void test7(){
      List<WebElement> emails=driver.findElements(By.xpath("//table[@id='table2']//tbody//tr//td[3]"));
      for(WebElement email:emails){
          Assert.assertTrue(email.getText().contains("@"));
          System.out.println(email.getText());
      }
    }
    @Test(description = "verify that author clicking on Last Name, values will be sorted in alphabetic order")
    public void test(){
    driver.findElement(By.xpath("//table[@id='table2']//*[text()='Last Name']")).click();
    List<WebElement> lastNames=driver.findElements(By.xpath("//table[@id='table2']//tbody//td[1]"));
    for(int i=0;i<lastNames.size()-1;i++){
        String lastName=lastNames.get(i).getText();
        String followinglastname=lastNames.get(i+1).getText();
        Assert.assertTrue(lastName.compareTo(followinglastname)<0);
        System.out.println("iteration: "+i);
        System.out.println("current last name is "+lastName);
        System.out.println("following last name is "+followinglastname);
    }
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
