package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentsPageObject {

    WebDriver driver ;

    By creditCardPaymentOption = By.xpath("//label[@data-method='methodCard']");
    By name = By.xpath("//input[@name='name']");
    By email = By.xpath("//input[@name='email']");
    By telephone = By.xpath("//input[@name='tel']");
    By cardNumber = By.xpath("//input[@name='card']");
    By expiryDate = By.xpath("//input[@name='expiry']");
    By cvv = By.xpath("//input[@name='csv']");
    By completeBooking = By.xpath("//strong[text()='Complete booking']");

    public void clickOnCreditCardOption() {
        driver.findElement(creditCardPaymentOption).click();
    }

    public void enterCardDetails(String name, String email, String telephone, String cardNumber,
                                 String expiry, String cvv){

        driver.findElement(this.name).sendKeys(name);
        driver.findElement(this.email).sendKeys(email);
        driver.findElement(this.telephone).sendKeys(telephone);
        driver.findElement(this.cardNumber).sendKeys(cardNumber);
        driver.findElement(this.expiryDate).sendKeys(expiry);
        driver.findElement(this.cvv).sendKeys(cvv);
    }

    public void clickCompleteBooking(){
        driver.findElement(completeBooking).click();
    }

    public String getTitle(){
        return driver.getTitle();
    }

}
