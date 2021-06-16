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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class StepsDefinition_KostenBerechnen {


    private WebDriver driver;

    @Given("StarteWebApp")
    public void startewebapp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.oebb.at/");

    }

    @And("NavigiereZuTicketBuchung")
    public void navigierezuticketbuchung() {
        driver.get("https://tickets.oebb.at/de/ticket");
        try {
            WebElement from;

            WebDriverWait wait = new WebDriverWait(driver, 10000);


            from = wait.until(ExpectedConditions.elementToBeClickable(By.name("stationFrom")));
            from.click();
            from.sendKeys("Wien");
            from.sendKeys(Keys.ENTER);


            WebElement to;
            to = wait.until(ExpectedConditions.elementToBeClickable(By.name("stationTo")));
            to.click();
            to.sendKeys("Linz");
            to.wait(100);
            to.sendKeys(Keys.ENTER);
            to = wait.until(ExpectedConditions.elementToBeClickable(By.className("wrapper")));

            to = wait.until(ExpectedConditions.elementToBeClickable(By.name("stationTo")));
            to.sendKeys(Keys.ENTER);

            //WebElement list = wait.until(ExpectedConditions.elementToBeClickable(By.id("autosuggest")));
            //list.findElements(By.className("wrapper"));

//            to = wait.until(ExpectedConditions.elementToBeClickable(By.name("stationTo")));
//            to.click();
//            to.sendKeys("Linz/Donau Hbf");
//            to.wait(100);
//            //to.click();
//            to.sendKeys(Keys.ENTER);



        } catch (Exception e) {

        }


    }

    @When("Wähle")
    public void wähle(io.cucumber.datatable.DataTable dataTable) {


        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        //throw new io.cucumber.java.PendingException();
    }

    @Then("Ticketkosten betragen {double}")
    public void ticketkosten_betragen(Double double1) {
        //driver.close();
        // Write code here that turns the phrase above into concrete actions
    }

}
