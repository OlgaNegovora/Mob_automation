import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;

public class Ex4SearchSubstring {
    private AppiumDriver driver;
    static String value="JAVA";//search by word
    @Before
    public void setUp() throws Exception
    {
        DesiredCapabilities capabilities =new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","and84");
        capabilities.setCapability("platformVersion","8.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","/Users/apple/Desktop/JavaAppiumAutomation/apks/org.wikipedia.apk");

        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }
    @After
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void searchForSubStringInString()
    {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find Search Wikipedia input",
                10
        );
        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                value,//global variable
                "Cannot find search input",
                5
        );
        waitForElementPresent(
                By.id("org.wikipedia:id/page_list_item_container"),
                "Search results 0",
                10
        );
        searchSubSting(
                By.id("org.wikipedia:id/page_list_item_title"),
                value//global variable

        );

    }

    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait=new WebDriverWait(driver,timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private WebElement waitForElementPresent(By by, String error_message)
    {
        return waitForElementPresent(by, error_message,5);
    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by,error_message,5);
        element.click();
        return element;
    }

    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by ,error_message,5);
        element.sendKeys(value);
        return element;
    }


    private void searchSubSting(By by, String valueSearch)
    {
        List<WebElement> testElement = driver.findElements(by);
        for (WebElement element:testElement)
        {
         //System.out.println(element.getText());
            String test = element.getText();
            int actual = test.toUpperCase().indexOf(valueSearch.toUpperCase());
            Assert.assertFalse("Substring '"+valueSearch+"' not found in string: "+test,actual<0);
        }
    }
}
