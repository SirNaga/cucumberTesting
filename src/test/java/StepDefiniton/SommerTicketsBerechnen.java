package StepDefiniton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SommerTicketsBerechnen {


    private WebDriver driver;
    private WebDriverWait wait;

    @Given("StarteWebApp2")
    public void starteWebapp() {

        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, 10000);
        driver.get("https://tickets.oebb.at/de/ticket/relation");
        driver.manage().window().setSize(new Dimension(2542, 1382));


    }

    @When("User bestellt {int} Sommertickets")
    public void wähle(Integer ticketNumber) {

        // Sommertickets button anklicken
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/app-start-container/section/div[2]/travel-action-listing/div/div[2]/travel-action[2]/button"))).click();

        // Menge der Tickets erhöhen zu 2
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content-wrapper\"]/div/div/div/offer-state-wrapper/div/offers-container/offer-block[1]/div/div[2]/div/amount-counter/div/div[2]"))).click();


    }

    @Then("Sommerticketkosten betragen {double}")
    public void sommerticketsKostenBeantragen(Double expectedPrice) {
        String price = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content-wrapper\"]/div/div/div/offer-state-wrapper/div/offers-container/offer-block[1]/div/div[4]/offer-price/div[1]/p"))).getText();
        price = price.replace(" ", "").replace("€", "").replace(",", ".");
        assertEquals(expectedPrice, Double.valueOf(price));
        driver.close();
    }

}
