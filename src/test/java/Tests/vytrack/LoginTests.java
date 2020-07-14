package Tests.vytrack;

import Pages.LoginPage;
import Tests.TestBase;
import com.beust.jcommander.Parameter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Driver;

//to inherit before and after methods
//this class will dedicated to tests related login page only
//we dont have to find elements here
//we should find elements in page classes only
@Listeners
public class LoginTests extends TestBase {

//    @Test(description = "Verify that page title is a 'Dashboard'")
    @Test()
    @Parameters({"username","password"})
    public void test1(String username, String password){
        //create a page object
        LoginPage loginpage=new LoginPage();
        //call login method
        //provide username and password
//        loginpage.login("storemanager85","UserUser123");
        loginpage.login(username, password);
        //verification stage
        //Driver.get()=driver
        //Driver.get() returns webdriver object
        WebDriverWait wait=new WebDriverWait(Driver.get(),10);
        //this is an explicit wait, it waits until title is "Dashoard"
        wait.until(ExpectedConditions.titleIs("Dashboard"));

        Assert.assertEquals(Driver.get().getTitle(),"Dashboard");
        //Driver.get() means Driver open chrome then get the title


    }
    @Test
    @Parameters({"username","password"})
    public void test2(@Optional("Abc") String username, String password){
        LoginPage loginpage=new LoginPage();
        loginpage.login(username,password);

    }
}
