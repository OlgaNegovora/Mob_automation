package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

abstract public class SearchPageObject extends MainPageObject //методы для поиска
   {
      protected  static String
       SEARCH_INIT_ELEMENT,
       SEARCH_INPUT,
       SEARCH_CANCEL_BUTTON,
       SEARCH_RESULT_BY_SUBSTRING_TPL,
       SEARCH_RESULT_ELEMENT,
       SEARCH_EMPTY_RESULT_ELEMENT,
       SEARCH_RESULT_BY_SUBSTRING_TITLE_DESCRIPTION_TPL ,
       SEARCH_RESULT,
       SKIP,
      CLEAR_MINI;

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
           this. waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search init element",10) ;
           this.waitForElementPresent(SEARCH_INPUT,"Cannot find search input after clicking search init element");
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
       public void clickClearSearch()
       {
           this.waitForElementAndClick(CLEAR_MINI, "Cannot find and click search clear button.", 5);
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

