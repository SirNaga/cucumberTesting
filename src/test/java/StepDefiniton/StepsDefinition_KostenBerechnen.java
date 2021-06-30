package StepDefiniton;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
        // 4 | type | name=stationFrom | Wien
        driver.findElement(By.name("stationFrom")).sendKeys("Wien");

        // 5 | click | css=.entry:nth-child(1) .text |
        driver.findElement(By.xpath("//div[@id='autosuggest']/div[1]/button")).click();

        // 6 | click | name=stationTo |
        wait.until(ExpectedConditions.elementToBeClickable(By.name("stationTo"))).click();

        // 7 | type | name=stationTo | Linz
        driver.findElement(By.name("stationTo")).sendKeys("Linz");
        // 8 | click | css=.entry:nth-child(1) span:nth-child(2) |
        driver.findElement(By.xpath("//div[@id='autosuggest']/div[4]/button")).click();

        // 9 | click | css=.travelActionWrapper:nth-child(1) span:nth-child(1) |
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".travelActionWrapper:nth-child(1) span:nth-child(1)"))).click();

        // 10 | click | css=#connection_7980412bc2f6711c7627f1ffdb617df8d0381a45a15572c67ac13583af1ea559 > .travel |
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ui-view/root-content/router-outlet-wrapper/app-ticket-shop-main/div/div/div/div/timetable-container/div/div/timetable-connection[1]/div/div[1]"))).click();


    }

    /*
    Lesen des Streckenpreises 
     */
    @Then("Ticketkosten betragen {double}")
    public void ticketkosten_betragen(Double expectedPrice) {
        String price = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ui-view/root-content/router-outlet-wrapper/app-ticket-shop-main/div/div/div/div/offer-state-wrapper/div/offers-container/offer-block/div/div[4]/offer-price/div[1]/p"))).getText();
        price = price.replace(" ", "").replace("€", "").replace(",", ".");
        assertEquals(expectedPrice, Double.valueOf(price));
        driver.close();
    }

}
