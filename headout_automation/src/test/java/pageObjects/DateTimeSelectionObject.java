package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DateTimeSelectionObject {

    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver,20);

    By dateTime = By.xpath("//section[@class='booking-calendar__month']/child::div[2] //div[5]/div/div/a/span/strong[contains(text(),'7.45pm')]");

    public DateTimeSelectionObject(WebDriver driver){
        this.driver = driver;
    }

    public void clickMonth(String monthName){
        WebElement monthSelection;
        By month = By.xpath("//span[contains(text(),'"+monthName+"')]");
        try {
            monthSelection = wait.until(ExpectedConditions.elementToBeClickable(month));
            monthSelection.click();
        }catch (ElementNotVisibleException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void selectDateTime(){
        WebElement dateTimeSelection;
        try{
            dateTimeSelection = wait.until(ExpectedConditions.elementToBeClickable(dateTime));
            dateTimeSelection.click();
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
