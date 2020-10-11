package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CoreTestCase extends TestCase //наследуем метод TestCase в CoreTestCase
{

    protected  AppiumDriver driver;
    private static String AppiumURL="http://127.0.0.1:4723/wd/hub";
    @Override//перегружаем родительский метод setUp
    protected void setUp() throws Exception
    {
        super.setUp();//используем setUp из TestCase

        DesiredCapabilities capabilities =new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","and84");
        capabilities.setCapability("platformVersion","8.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","/Users/apple/Desktop/JavaAppiumAutomation/apks/org.wikipedia.apk");
        //capabilities.setCapability("orientation","PORTRAIT");

        driver=new AndroidDriver(new URL(AppiumURL),capabilities);
        this.rotateScreenPortrait();
    }
    @Override
    protected void tearDown() throws Exception
    {
        driver.quit();
        super.tearDown(); //используем tearDown из TestCase
    }

    protected void rotateScreenPortrait()
    {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void rotateScreenLandscape()
    {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    protected void backgroundApp(int seconds)
    {
        driver.runAppInBackground(seconds);
    }
}