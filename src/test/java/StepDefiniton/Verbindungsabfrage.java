package StepDefiniton;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


public class Verbindungsabfrage {

    //accessKey of seetest-cloud-API
    private String accessKey = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjoxMjAwMTkxMCwieHAucCI6MTIwMDE5MDksInhwLm0iOjE2MjQzOTU5OTI3MTcsImV4cCI6MTkzOTc1NjA3NiwiaXNzIjoiY29tLmV4cGVyaXRlc3QifQ.ik_81ytHImv1NKRUxzqMAu0POTU9mvLgnFLX28ng-Qo";
    //define android driver element
    protected AndroidDriver<AndroidElement> driver = null;
    //define new Driver capabilities element
    DesiredCapabilities dc = new DesiredCapabilities();

    private WebDriverWait wait;

    @Given("StarteApp")
    public void starte_app() throws MalformedURLException {
        //set driver-capabilities for appium android driver

        //testName
        dc.setCapability("testName", "Verbindungsabfrage Test");
        //assign accessKey of Seetest-Cloud-API to capability parameters
        dc.setCapability("accessKey", accessKey);
        //device parameters
        dc.setCapability("deviceQuery", "@os='android' and @category='PHONE'");
        //app full path (name + activity)
        dc.setCapability(MobileCapabilityType.APP, "cloud:at.oebb.ts/.SplashActivity");
        //appName
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "at.oebb.ts");
        //activityName
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".SplashActivity");
        //initializes new driver session with given capability-parameters
        driver = new AndroidDriver<>(new URL("https://cloud.seetest.io/wd/hub"), dc);
        wait = new WebDriverWait(driver, 15);
    }
    @When("Auswahl")
    public void auswahl() {
        //step1: confirm welcome hint
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='OK']"))).click();
        //step2: select "Tickets and Services" by "tapping" on it
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Tickets and\nServices']"))).click();
        //step3: enter edit mode of "from" input field
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='header_station_from']"))).click();
        //step4: Type "Wien Hbf (U)" into input field "from"
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='header_station_from']"))).sendKeys("Wien Hbf (U)");
        //step5: Select and confirm autosuggestion
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='relation_image_arrow' and (./preceding-sibling::* | ./following-sibling::*)[@text='Wien Hbf (U)']]"))).click();
        //step6: enter edit mode of "to" input field
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='header_station_to']"))).click();
        //step7: Type "Linz/Donau Hbf" into input field "to"
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='header_station_to']"))).sendKeys("Linz/Donau Hbf");
        //step8: Select and confirm autosuggestion
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='relation_image_arrow' and (./preceding-sibling::* | ./following-sibling::*)[@text='Linz/Donau Hbf']]"))).click();
        //step9: press "ENTER" key on device
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        //step10: tap on departure time button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='header_time_from']"))).click();
        //step11: tap on date selection button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dateButton']"))).click();
        //step12: select 30.6.2021 by tapping on it
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@contentDescription='03 July 2021']"))).click();
        //step13: tap on confirm button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='CONFIRM']"))).click();
        //step14: tap on connections button to get to connections overview
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='android.widget.RelativeLayout' and ./*[@id='travelActions_icon'] and ./*[./*[@text='One-way tickets and day tickets']]]"))).click();
    }

    @Then("connection from Wien Hbf exists true")
    public void connectionFromWienHbfExistsTrue() {
        //get connection list into variable
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='connection_list']/*")));
        List<AndroidElement> elements = driver.findElements(By.xpath("//*[@id='connection_list']/*"));
        //check if connection list is empty or not
        assertTrue(!elements.isEmpty());
        //dispose driver session
        driver.quit();
    }
}