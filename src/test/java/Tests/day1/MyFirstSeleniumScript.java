package Tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript {

    public static void main(String[] args) {


        String str="fsgd749&fhc";
        String result="";
        for(int i=0;i<str.length();i++){
            if(!Character.isDigit(str.charAt(i)) && !Character.isAlphabetic(str.charAt(i))){
                result+=str.charAt(i);

            }

        }
        System.out.println(result);

        //we have to setup webdriver based on the driver that we gonna use
        WebDriverManager.chromedriver().setup();
        //we need to create an object of appropriate class
        ChromeDriver driver=new ChromeDriver();
        //lets open gooegle.com
        //.get() method allows you open some website

        driver.get("http://google.com");
        //to read page titile , method  .getTitle();
        //teat1. verify that title of the page is "Google"
        String actualResult=driver.getTitle();
        String expectedResult ="Google";
        if(actualResult.equals(expectedResult)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }
        //to close browser at the end of test execution
        //if we open gate we need to close it.

        driver.close();
    }


}
