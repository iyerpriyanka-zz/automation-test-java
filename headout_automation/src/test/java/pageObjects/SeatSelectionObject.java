package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeatSelectionObject {

    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver,20);

    By seatSelectionCanvas = By.xpath("//canvas[@class='ltd-seatplan__canvas']");
    By addToBasket = By.xpath("//a[@class='seat-plan__submit__button ltd-cta']");

    public SeatSelectionObject(WebDriver driver){
        this.driver = driver;
    }

    public void seatSelection(int xOffset, int yOffset){
        Actions actionBuilder=new Actions(driver);
        driver.findElement(seatSelectionCanvas);
        WebElement seatSelectionElement;
        try {
            seatSelectionElement= wait.until(ExpectedConditions.presenceOfElementLocated(seatSelectionCanvas));
            actionBuilder.moveToElement(seatSelectionElement, xOffset, yOffset).click().build().perform();
        }catch (ElementNotVisibleException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void clickAddToBasket(){
        WebElement addBasket;
            driver.findElement(addToBasket).click();
    }

    public String getTitle(){
        return driver.getTitle();
    }
}
