package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject //методы для поиска
   {
       private static final String
       SEARCH_INIT_ELEMENT="xpath://*[contains(@text,'Search Wikipedia')]",
       SEARCH_INPUT="xpath://*[contains(@text,'Search…')]",
       SEARCH_CANCEL_BUTTON="id:org.wikipedia:id/search_close_btn",
       SEARCH_RESULT_BY_SUBSTRING_TPL ="xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']",
       SEARCH_RESULT_ELEMENT="xpath://*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']",
       SEARCH_EMPTY_RESULT_ELEMENT="xpath://*[@text='No results found']",
       SEARCH_RESULT_BY_SUBSTRING_TITLE_DESCRIPTION_TPL ="xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{DESCRIPTION}'][@resource-id='org.wikipedia:id/page_list_item_description']/..//*[@text='{TITLE}'][@resource-id='org.wikipedia:id/page_list_item_title']",
       SEARCH_RESULT="id:org.wikipedia:id/page_list_item_container";

       public SearchPageObject(AppiumDriver driver)
       {
           super(driver);
       }

       /*TEMPLATES METHODS*/
       private static String getResultSearchElement(String substring)
       {
           return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}",substring);
       }

       private static String getResultSearchElementSubstringByTitleAndDescription(String title, String description)
       {
           return SEARCH_RESULT_BY_SUBSTRING_TITLE_DESCRIPTION_TPL.replace ("{TITLE}",title).replace("{DESCRIPTION}",description) ;

       }

       /*TEMPLATES METHODS*/

       public void initSearchInput()
       {
           this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search init element",4) ;
           this.waitForElementPresent(SEARCH_INIT_ELEMENT,"Cannot find search input after clicking search init element");
       }

       public void waitForCancelButtonToAppear()
       {
           this.waitForElementPresent(SEARCH_CANCEL_BUTTON,"Cannot find search cancel button",5);
       }

       public void waitForCancelButtonToDisappear()
       {
           this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON,"Search cancel button is still present!",5);
       }

       public void clickCancelSearch()
       {
           this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find and click search cancel button.", 5);
       }

       public void typeSearchLine(String search_line)
       {
           this.waitForElementAndSendKeys(SEARCH_INPUT, search_line, "Cannot find and type into search input",5 );
       }

       public void waitForSearchResult(String substring)
       {
           String search_result_xpath=getResultSearchElement(substring);
           this.waitForElementPresent(search_result_xpath,"Cannot find search result with substring "+substring);
       }

       public void clickByArticleWithSubstring(String substring)
       {
           String search_result_xpath=getResultSearchElement(substring);
           this.waitForElementAndClick(search_result_xpath,"Cannot find and click search result with substring "+substring, 10);
       }

       public int getAmountOfFoundArticles()

       {
          //String search_result_locator="//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='Linkin Park discography']";
           //System.out.println(search_result_locator);
           this.waitForElementPresent(
                   SEARCH_RESULT_ELEMENT ,
                   "Cannot find anything by the request ",
                   15
           ) ;
           return this.getAmountOfElements(SEARCH_RESULT_ELEMENT ) ;

       }

        public void waitForEmptyForResultsLabel ()
       {
           this.waitForElementPresent(SEARCH_EMPTY_RESULT_ELEMENT,"Cannot find element result element.",15);
       }

       public void assertThereIsNoResultOfSearch()
       {
           this.assertElementNotPresent(SEARCH_RESULT_ELEMENT, "We supposed not to find any results" );
       }

       public void waitForElementByTitleAndDescription(String title, String description)
       {
           String search_result_xpath=getResultSearchElementSubstringByTitleAndDescription(title, description);
           //System.out.println(search_result_xpath);
           this.waitForElementPresent(search_result_xpath,"Cannot find search result with title '"+title+"' and description '"+description+"'");
       }

       public int getAmountOfFoundElementLists()
       {
           return this.testSizeListForElementFind(SEARCH_RESULT);

       }

       public void waitForSearchListsToDisappear()
       {
           this.waitForElementNotPresent(SEARCH_RESULT,"Search lists is still present!",15);
       }



   }

