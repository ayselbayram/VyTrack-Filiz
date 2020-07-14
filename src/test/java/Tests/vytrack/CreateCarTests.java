package Tests.vytrack;

import Pages.CreateCarPage;

import Pages.LoginPage;
import Pages.VehiclesPage;
import Tests.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.ConfigurationReader;
import utils.Driver;
import utils.ExcelUtil;

import java.util.List;
import java.util.Map;


public class CreateCarTests extends TestBase {

    @Test()
   @Parameters({"username","password"})
    public void test1(String username,String password) {

        extentTest = extentReports.createTest("create a new car");
        LoginPage loginpPage = new LoginPage();
        VehiclesPage vehiclePage = new VehiclesPage();
        CreateCarPage createCarPage = new CreateCarPage();

//        loginpPage.login("storemanager85", "UserUser123");
        loginpPage.login(username,password);
        loginpPage.navigateTo("Fleet", "Vehicles");

        loginpPage.waitUntilLoaderMaskDisappear();
        vehiclePage.clickToCreateACar();

        loginpPage.waitUntilLoaderMaskDisappear();
        createCarPage.licensePlateElement.sendKeys("123");


        createCarPage.selectTags("Compact");
//        Driver.get().findElement(By.cssSelector("div[id*='FuelType']")).click();
        createCarPage.selectFuelType("Diesel");

        loginpPage.waitUntilLoaderMaskDisappear();

        createCarPage.saveAndCloseButtonElement.click();
//        Driver.get().findElement(By.cssSelector("[class='btn btn-success action-button']")).click();
        extentTest.pass("create a new car");


    }

    @Test(description = "create car by reading test data from excel file")
    @Factory
    public void createCarTest() {
        extentTest = extentReports.createTest("create car by reading test data from excel file");
        LoginPage loginPage = new LoginPage();
        VehiclesPage vehiclePage = new VehiclesPage();
        CreateCarPage createCarPage = new CreateCarPage();

        String userName = ConfigurationReader.getProperty("user_name");
        String password = ConfigurationReader.getProperty("password");

        loginPage.login(userName, password);

        loginPage.navigateTo("Fleet", "Vehicles");

        loginPage.waitUntilLoaderMaskDisappear();

        vehiclePage.clickToCreateACar();

        loginPage.waitUntilLoaderMaskDisappear();

        ExcelUtil excelUtil = new ExcelUtil("cars.xlsx", "cars");
        //read data from excel spreadsheet as list of map
        //testData it's just reference variable
        List<Map<String, String>> testData = excelUtil.getDataList();
        //0 means data from first row, License Plate it's a column name
        //so we are reading from first row and License Plate column
        createCarPage.licensePlateElement.sendKeys(testData.get(0).get("License Plate"));
        //enter driver info
        createCarPage.driverElement.sendKeys(testData.get(0).get("Driver"));
        //enter model year
        createCarPage.modelYearElement.sendKeys(testData.get(0).get("Model Year"));
        //enter color
        createCarPage.colorElement.sendKeys(testData.get(0).get("Color"));

        loginPage.waitUntilLoaderMaskDisappear();
        createCarPage.saveAndCloseButtonElement.click();//click to save and close

        BrowserUtils.wait(3);//for demo
        extentTest.info("Created a new car");




    }
}
