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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StepsDefinition_KostenBerechnen {


    private WebDriver driver;

    @Given("StarteWebApp")
    public void startewebapp() {
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();

    }

    @And("NavigiereZuTicketBuchung")
    public void navigierezuticketbuchung() {
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
        // Write code here that turns the phrase above into concrete actions
    }

}
