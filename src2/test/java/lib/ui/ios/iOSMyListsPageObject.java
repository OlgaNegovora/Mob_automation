package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSMyListsPageObject extends MyListsPageObject
{
    static {
        ARTICLE_BY_TITLE_TPL="xpath://XCUIElementTypeLink[contains(@name,'{TITLE}')]";
        MY_LISTS_ELEMENT_TPL="xpath://XCUIElementTypeNavigationBar[@name='Saved']//..//..//XCUIElementTypeLink[contains(@name,'{SUBSTRING}')]";
    }
    public iOSMyListsPageObject (RemoteWebDriver driver)
    {
        super(driver);
    }
}
