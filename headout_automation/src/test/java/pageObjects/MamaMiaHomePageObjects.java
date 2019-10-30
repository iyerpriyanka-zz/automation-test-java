package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MamaMiaHomePageObjects {
    By bookTickets = By.xpath("//*[@class='submit ltd-cta event-booking-box__cta']");
    WebDriver driver;

    public MamaMiaHomePageObjects(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnBookTickets() {
        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement ticketsBookingHomePage ;
        try {
            ticketsBookingHomePage = wait.until(ExpectedConditions.elementToBeClickable(bookTickets));
            ticketsBookingHomePage.findElement(bookTickets).click();
        }catch (ElementNotVisibleException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public String getTitle(){
        return driver.getTitle();
    }
}
