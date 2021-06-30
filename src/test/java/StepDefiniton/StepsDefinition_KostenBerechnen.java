package StepDefiniton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepsDefinition_KostenBerechnen {


    private WebDriver driver;
    private WebDriverWait wait;

    /*
    Treiber init
    Web app aufruf
     */
    @Given("StarteWebApp")
    public void startewebapp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10000);
        driver.get("https://tickets.oebb.at/de/ticket/relation");
        driver.manage().window().setSize(new Dimension(2542, 1382));
    }

    /*
    Von-Bis Ziele werden ausgewählt
     */
    @When("Wähle")
    public void wähle(io.cucumber.datatable.DataTable dataTable) {

        wait.until(ExpectedConditions.elementToBeClickable(By.name("stationFrom"))).click();
        // | type | name=stationFrom | Wien
        driver.findElement(By.name("stationFrom")).sendKeys("Wien");

        // | click | css=.entry:nth-child(1) .text |
        driver.findElement(By.xpath("//div[@id='autosuggest']/div[1]/button")).click();

        // | click | name=stationTo |
        wait.until(ExpectedConditions.elementToBeClickable(By.name("stationTo"))).click();

        // | type | name=stationTo | Linz
        driver.findElement(By.name("stationTo")).sendKeys("Linz");
        // | click | css=.entry:nth-child(1) span:nth-child(2) |
        driver.findElement(By.xpath("//div[@id='autosuggest']/div[4]/button")).click();

        // | click | css=.travelActionWrapper:nth-child(1) span:nth-child(1) |
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".travelActionWrapper:nth-child(1) span:nth-child(1)"))).click();

        // | click | travel |
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ui-view/root-content/router-outlet-wrapper/app-ticket-shop-main/div/div/div/div/timetable-container/div/div/timetable-connection[1]/div/div[1]"))).click();


    }

    /*
    Ticketpreise werden gelsen und verglichen
     */
    @Then("Ticketkosten betragen {double}")
    public void ticketkosten_betragen(Double expectedPrice) {
        String price = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ui-view/root-content/router-outlet-wrapper/app-ticket-shop-main/div/div/div/div/offer-state-wrapper/div/offers-container/offer-block/div/div[4]/offer-price/div[1]/p"))).getText();
        price = price.replace(" ", "").replace("€", "").replace(",", ".");
        assertEquals(expectedPrice, Double.valueOf(price));
        driver.close();
    }

}
