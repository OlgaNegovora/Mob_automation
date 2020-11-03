package lib.ui.mobile_web;

import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyListsPageObject extends MyListsPageObject {
    static {
        ARTICLE_BY_TITLE_TPL="xpath://ul[contains (@class,'watchlist')]//h3[contains(text(),'{TITLE}')]";
        MY_LISTS_ELEMENT_TPL="xpath://ul[contains (@class,'watchlist')]//h3[contains(text(),'{TITLE}')]/../../div[contains(@class,'watched')]";
    }
    public MWMyListsPageObject  (RemoteWebDriver driver)
        {
            super(driver);
        }

}
