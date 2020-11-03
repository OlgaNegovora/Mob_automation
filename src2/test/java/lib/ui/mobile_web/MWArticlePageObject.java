package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject  {
    static {
        TITLE = "css:#content h1";
        //TITLE_TWO = "id:JavaScript";
        FOOTER_ELEMENT = "css:footer";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:#page-actions a#ca-watch.mw-ui-icon-wikimedia-star-base20";
                //"#page-actions a#ca-watch.mw-ui-icon-wikimedia-star-base20 before";
                //"css:#page-actions li#ca-watch.mw-ui-icon-wikimedia-star-base20 button";
        OPTION_REMOVE_FROM_MY_LIST_BUTTON="css:#page-actions a#ca-watch.mw-ui-icon-wikimedia-unStar-progressive";
        //CLOSE_ARTICLE_BUTTON = "id:Back";
       // CLOSE_AUTH ="id:places auth close";
    }

    public MWArticlePageObject (RemoteWebDriver driver)
    {
        super(driver);
    }
}
