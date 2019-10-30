package testCases;

import configuration.ChromeDriverConfiguration;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.DateTimeSelectionObject;
import pageObjects.MamaMiaHomePageObjects;
import pageObjects.PaymentsPageObject;
import pageObjects.SeatSelectionObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TicketBookingTest {

    String path = System.getProperty("user.dir");

    WebDriver driver;
    Properties prop = new Properties();
    ChromeDriverConfiguration chromeDriver ;
    DateTimeSelectionObject dateTimeSelection;
    MamaMiaHomePageObjects homePage;
    SeatSelectionObject seatSelection;
    PaymentsPageObject paymentsPage;

    @BeforeClass
    public void setUp() throws IOException {
        chromeDriver = new ChromeDriverConfiguration(driver);
        driver = chromeDriver.startChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            prop.load(new FileInputStream(path+ "/src/test/java/objects/object.properties"));
        }catch (FileNotFoundException e){
            e.getStackTrace();
        }catch (IOException e) {
            e.getStackTrace();
        }
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
    }

    @Test
    public void ticketBooking() throws IOException {
        prop.load(new FileInputStream(path+ "/src/test/java/objects/object.properties"));
        homePage = new MamaMiaHomePageObjects(driver);
        homePage.clickOnBookTickets();

        dateTimeSelection = new DateTimeSelectionObject(driver);
        dateTimeSelection.clickMonth("November");
        dateTimeSelection.selectDateTime();
        seatSelection = new SeatSelectionObject(driver);
        seatSelection.seatSelection(840,283);
//        seatSelection.seatSelection(509, 206);
        paymentsPage.clickOnCreditCardOption();
        paymentsPage.enterCardDetails(prop.getProperty("name"),prop.getProperty("email"),prop.getProperty("telephone"),prop.getProperty("cardNumber")
                ,prop.getProperty("expiryDate"),prop.getProperty("cvv"));
    }
}
