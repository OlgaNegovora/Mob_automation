package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject //методы для поиска
   {
       private static final String
       SEARCH_INIT_ELEMENT="//*[contains(@text,'Search Wikipedia')]",
       SEARCH_INPUT="//*[contains(@text,'Search…')]",
       /*SEARCH_CANCEL_BUTTON="org.wikipedia:id/search_close_btn",
       SEARCH_RESULT_BY_SUBSTRING_TPL ="//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']",//org.wikipedia:id/page_list_item_description
       SEARCH_RESULT_ELEMENT="//*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']",
       SEARCH_EMPTY_RESULT_ELEMENT="//*[@text='No results found']",
       SEARCH_RESULT="org.wikipedia:id/page_list_item_container",*/
       SEARCH_RESULT_BY_SUBSTRING_TITLE_DESCRIPTION_TPL ="//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{DESCRIPTION}'][@resource-id='org.wikipedia:id/page_list_item_description']/..//*[@text='{TITLE}'][@resource-id='org.wikipedia:id/page_list_item_title']";

       public SearchPageObject(AppiumDriver driver)
       {
           super(driver);
       }

       /*TEMPLATES METHODS*/
       private static String getResultSearchElementSubstringByTitleAndDescription(String title, String description)
       {
           return SEARCH_RESULT_BY_SUBSTRING_TITLE_DESCRIPTION_TPL.replace ("{TITLE}",title).replace("{DESCRIPTION}",description) ;

       }
       /*TEMPLATES METHODS*/

       public void initSearchInput()
       {
           this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find and click search init element",4) ;
           this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT),"Cannot find search input after clicking search init element");
       }

       public void typeSearchLine(String search_line)
       {
           this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT), search_line, "Cannot find and type into search input",5 );
       }

       public void waitForElementByTitleAndDescription(String title, String description)
       {
           String search_result_xpath=getResultSearchElementSubstringByTitleAndDescription(title, description);
           //System.out.println(search_result_xpath);
           this.waitForElementPresent(By.xpath(search_result_xpath),"Cannot find search result with title '"+title+"' and description '"+description+"'");
       }

   }

