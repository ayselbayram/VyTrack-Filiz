package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;
import utils.Driver;

import java.util.List;

public class CalendarEventsPage extends BasePage{

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//tr[4]//td[@class='action-cell grid-cell grid-body-cell']")
    public WebElement dots;

    @FindBy(xpath = "//div[@class='actions-panel pull-right form-horizontal']//div//div/a")
    public WebElement gridButton;




   public void titleBoxIsChecked(){
       List<WebElement> boxes=Driver.get().findElements(By.xpath("//table[@class='grid table-hover table table-condensed']//tr//td[3]"));
       for(int i=2;i<boxes.size();i++){
           boxes.get(i).click();
           BrowserUtils.wait(1);

       }
       Assert.assertTrue(Driver.get().findElement(By.id("column-c93")).isDisplayed());
   }





    public void clickToCreateCalendarEvent(){
        BrowserUtils.waitForVisibility(createCalendarEvent, 5);
        BrowserUtils.waitForClickablility(createCalendarEvent, 5);
       createCalendarEvent.click();
    }

}
