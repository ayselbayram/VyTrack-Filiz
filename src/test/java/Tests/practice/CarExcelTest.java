package Tests.practice;

import Pages.CreateCarPage;
import Pages.LoginPage;
import Pages.VehiclesPage;
import Tests.TestBase;
import org.testng.annotations.Test;
import utils.ConfigurationReader;
import utils.ExcelUtil;

public class CarExcelTest extends TestBase {
    @Test(description = "create car with excel data")
    public void createTest(){

        LoginPage loginPage=new LoginPage();
        CreateCarPage createCarPage=new CreateCarPage();
        VehiclesPage vehiclesPage=new VehiclesPage();
        ExcelUtil excelUtil=new ExcelUtil("cars.xlsx","Cars");

        String userName= ConfigurationReader.getProperty("user_name");
        String password=ConfigurationReader.getProperty("password");

        loginPage.login(userName,password);
        createCarPage.navigateTo("Fleet","Vehicles");

        vehiclesPage.clickToCreateACar();

        loginPage.waitUntilLoaderMaskDisappear();

        createCarPage.licensePlateElement.sendKeys(excelUtil.getDataList().get(0).get("License Plate"));
        createCarPage.driverElement.sendKeys(excelUtil.getDataList().get(0).get("Driver"));
        createCarPage.locationElement.sendKeys(excelUtil.getDataList().get(0).get("Location"));
        createCarPage.modelYearElement.sendKeys(excelUtil.getDataList().get(0).get("Model Year"));
        createCarPage.colorElement.sendKeys(excelUtil.getDataList().get(0).get("Color"));
        createCarPage.saveAndCloseButtonElement.click();





    }



}
