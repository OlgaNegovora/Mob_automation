package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject  {
        static {
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        // SEARCH_INPUT = "xpath://XCUIElementTypeSearchField[@label='Search Wikipedia']";
        SEARCH_INPUT = "css:form>input[type='search']";
        SEARCH_CANCEL_BUTTON = "css:div>button.cancel";
      //  CLEAR_MINI="id:clear mini";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class,'wikidata-description')][contains(text(),'{SUBSTRING}')]";

//XCUIElementTypeLink[@name="Java (programming language) Object-oriented programming language"]
        SEARCH_RESULT_ELEMENT = "css:ul.page-list>li.page-summary";
        SEARCH_EMPTY_RESULT_ELEMENT = "css:p.without-results";
       // SEARCH_RESULT_BY_SUBSTRING_TITLE_DESCRIPTION_TPL="xpath://XCUIElementTypeLink[contains(@name,'{TITLE}')][contains(@name,'{DESCRIPTION}')]";
        // SEARCH_RESULT_BY_SUBSTRING_TITLE_DESCRIPTION_TPL="xpath://XCUIElementTypeLink[(@name=concat('{TITLE}',' ','{DESCRIPTION}')]";

//        SEARCH_RESULT_BY_SUBSTRING_TITLE_DESCRIPTION_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{DESCRIPTION}'][@resource-id='org.wikipedia:id/page_list_item_description']/..//*[@text='{TITLE}'][@resource-id='org.wikipedia:id/page_list_item_title']";
       // SEARCH_RESULT = "xpath://XCUIElementTypeLink";
    }
    public MWSearchPageObject (RemoteWebDriver driver)
        {
            super(driver);
        }
}
