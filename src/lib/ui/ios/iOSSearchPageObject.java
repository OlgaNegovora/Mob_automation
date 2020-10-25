package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class iOSSearchPageObject extends SearchPageObject
{
    static {
        SEARCH_INIT_ELEMENT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
       // SEARCH_INPUT = "xpath://XCUIElementTypeSearchField[@label='Search Wikipedia']";
        SEARCH_INPUT = "xpath://XCUIElementTypeButton[@name='Close']/preceding-sibling::XCUIElementTypeSearchField";
        SEARCH_CANCEL_BUTTON = "id:Close";
        CLEAR_MINI="id:clear mini";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeLink[contains(@name,'{SUBSTRING}')]";

//XCUIElementTypeLink[@name="Java (programming language) Object-oriented programming language"]
        SEARCH_RESULT_ELEMENT = "xpath://XCUIElementTypeLink";
        SEARCH_EMPTY_RESULT_ELEMENT = "xpath://XCUIElementTypeStaticText[@name='No results found']";
//        SEARCH_RESULT_BY_SUBSTRING_TITLE_DESCRIPTION_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{DESCRIPTION}'][@resource-id='org.wikipedia:id/page_list_item_description']/..//*[@text='{TITLE}'][@resource-id='org.wikipedia:id/page_list_item_title']";
//        SEARCH_RESULT = "id:org.wikipedia:id/page_list_item_container";
     }
    public iOSSearchPageObject (AppiumDriver  driver)
    {
        super(driver);
    }
}
