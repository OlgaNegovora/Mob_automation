package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class CoreTestCase extends TestCase //наследуем метод TestCase в CoreTestCase
{
    private static final String PLATFORM_IOS="ios";
    private static final String PLATFORM_ANDROID="android";
    protected  AppiumDriver driver;
    private static String AppiumURL="http://127.0.0.1:4723/wd/hub";
    @Override//перегружаем родительский метод setUp
    protected void setUp() throws Exception
    {
        super.setUp();//используем setUp из TestCase

        DesiredCapabilities capabilities =this.getCapabilitiesByPlatformEnv() ;
        driver=getDriverByPlatformEnv(capabilities);
        //System.out.println(driver);
                //new AndroidDriver(new URL(AppiumURL),capabilities);
      //  driver=new IOSDriver(new URL(AppiumURL),capabilities);
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
        driver.runAppInBackground(Duration.ofSeconds(seconds));
    }

    private DesiredCapabilities getCapabilitiesByPlatformEnv() throws Exception
    {
        String platform =System.getenv("PLATFORM");

        DesiredCapabilities capabilities =new DesiredCapabilities();
        if (platform.equals(PLATFORM_ANDROID) )
        {
            capabilities.setCapability("platformName","Android");
            capabilities.setCapability("deviceName","and84");
            capabilities.setCapability("platformVersion","8.0");
            capabilities.setCapability("automationName","Appium");
            capabilities.setCapability("appPackage","org.wikipedia");
            capabilities.setCapability("appActivity",".main.MainActivity");
            capabilities.setCapability("app","/Users/apple/Desktop/JavaAppiumAutomation/apks/org.wikipedia.apk");
            //capabilities.setCapability("orientation","PORTRAIT");
        }
        else if (platform.equals(PLATFORM_IOS) )
        {
            capabilities.setCapability("platformName","iOS");
            capabilities.setCapability("deviceName","iPhone SE");
            capabilities.setCapability("platformVersion","11.3");
            capabilities.setCapability("app","/Users/apple/Desktop/JavaAppiumAutomation/apks/org.wikipedia.apk");
        }
        else
            {
                throw new Exception("Cannot get run platform from env variable. Platform value "+platform);
            }
        return capabilities;

   }

    private AppiumDriver getDriverByPlatformEnv(DesiredCapabilities capabilities) throws Exception
    {
        String platform =System.getenv("PLATFORM");

        //DesiredCapabilities capabilities =new DesiredCapabilities();
        if (platform.equals(PLATFORM_ANDROID) )
        {
            return new AndroidDriver(new URL(AppiumURL),capabilities);
        }
        else if (platform.equals(PLATFORM_IOS) )
        {
            return new IOSDriver(new URL(AppiumURL),capabilities);
        }
        else
        {
            throw new Exception("Cannot get run platform from env variable. Platform value "+platform);
        }
    }
}
