package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.ui.WelcomePageObject;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class CoreTestCase extends TestCase //наследуем метод TestCase в CoreTestCase
{
    protected RemoteWebDriver driver;
    @Override//перегружаем родительский метод setUp
    protected void setUp() throws Exception
    {
        super.setUp();//используем setUp из TestCase
        driver=Platform.getInstance().getDriver() ;
        this.rotateScreenPortrait();
        String testClass=getClass().getName();
        if (testClass.equalsIgnoreCase("tests.GetStartedTest")==false)
             {
                 this.skipWelcomePageForIOSApp();
             }
        this.openWikiWebPageForMobileWeb();
      //  System.out.println("test skip");
    }
    @Override
    protected void tearDown() throws Exception
    {
        driver.quit();
        super.tearDown(); //используем tearDown из TestCase
    }

    protected void rotateScreenPortrait()
    {
        if (driver instanceof AppiumDriver){
            AppiumDriver driver = (AppiumDriver) this.driver ;
            driver.rotate(ScreenOrientation.PORTRAIT);
        }else {
            System.out.println("Method rotateScreenPortrait() dose nothing for platform " + Platform.getInstance().getPlatformVar());
        }

    }

    protected void rotateScreenLandscape()
    {
        if (driver instanceof AppiumDriver){
            AppiumDriver driver = (AppiumDriver) this.driver ;
            driver.rotate(ScreenOrientation.LANDSCAPE);
        }else {
            System.out.println("Method rotateScreenPortrait() dose nothing for platform " + Platform.getInstance().getPlatformVar());
        }

    }

    protected void backgroundApp(int seconds)
    {
        if (driver instanceof AppiumDriver){
            AppiumDriver driver = (AppiumDriver) this.driver ;
            driver.runAppInBackground(Duration.ofSeconds(seconds));
        }else {
            System.out.println("Method rotateScreenPortrait() dose nothing for platform " + Platform.getInstance().getPlatformVar());
        }

    }

    protected void openWikiWebPageForMobileWeb()
    {
        if (Platform.getInstance().isMW()){
            driver.get("https://en.m.wikipedia.org");
        }else {
            System.out.println("Method openWikiWebPageForMobileWeb() dose nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    private void skipWelcomePageForIOSApp()
    {
        if(Platform.getInstance().isIOS()) {
            AppiumDriver driver = (AppiumDriver) this.driver ;
            WelcomePageObject WelcomePageObject=new WelcomePageObject(driver);
            WelcomePageObject.clickSkip();

        }
    }
}
