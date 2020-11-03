package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.ui.factories.MyListsPageObjectFactory;
import org.openqa.selenium.WebElement;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject
{
    protected static String
        TITLE,
        TITLE_TWO,
        FOOTER_ELEMENT,
        OPTIONS_BUTTON,
        OPTIONS_ADD_TO_MY_LIST_BUTTON,
        OPTION_REMOVE_FROM_MY_LIST_BUTTON,
        ADD_TO_MY_LIST_OVERLAY,
        MY_LIST_NAME_INPUT,
        MY_LIST_OK_BUTTON,
        CLOSE_ARTICLE_BUTTON,
        CLOSE_AUTH;



    public ArticlePageObject (RemoteWebDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(TITLE,"Cannot find article title on page!", 15);
    }

    public WebElement waitForTitleSecondElement()
    {
        return this.waitForElementPresent(TITLE_TWO,"Cannot find article title on page!", 15);
    }

     public String getArticleTitle()
     {
         WebElement title_element = waitForTitleElement();
                if (Platform.getInstance().isAndroid())
                   {
                       return title_element.getAttribute("text");
                    }else if (Platform.getInstance().isIOS())
                    {
                       return title_element.getAttribute("name");
                    }else
                    {
                        return title_element.getText();
                    }

     }

    public String getArticleSecondTitle()
    {
        WebElement title_element = waitForTitleSecondElement();
        if (Platform.getInstance().isAndroid())
        {
            return title_element.getAttribute("text");
        }else
        {
            return title_element.getAttribute("name");
        }

    }

     public void swipeToFooter()
     {
         if (Platform.getInstance().isAndroid()){
             this.swipeUpToFindElement(
                     FOOTER_ELEMENT,
                     "Cannot find the and of article",
                     60
             );
         }else if (Platform.getInstance().isIOS()){
             this.swipeUpTillElementAppear(FOOTER_ELEMENT,
                     "Cannot find the end of article",
                     40) ;
         }else {
             this.scrollWebPageTillElementNotVisible(
                     FOOTER_ELEMENT,
                     "Cannot find the end of article",
                     40
             );
         }

     }

     public void addArticleToMyList(String name_of_folder)
     {
         this.waitForElementAndClick(
                 OPTIONS_BUTTON,
                 "Cannot find button to open article options",
                 5
         );

         this.waitForElementAndClick(
                 OPTIONS_ADD_TO_MY_LIST_BUTTON,
                 "Cannot find option to add article to reading list",
                 5
         );
         this.waitForElementAndClick(
                 ADD_TO_MY_LIST_OVERLAY,
                 "Cannot find 'Go it' tip overlay",
                 5
         );

         this.waitForElementAndClear(
                 MY_LIST_NAME_INPUT,
                 "Cannot find input to set name of articles folder",
                 5
         );

         this.waitForElementAndSendKeys(
                 MY_LIST_NAME_INPUT,
                 name_of_folder,
                 "Cannot put text into articles folder input",
                 5
         );

         this.waitForElementAndClick(
                 MY_LIST_OK_BUTTON ,
                 "Cannot press OK button",
                 5
         );
     }

     public void addArticlesToMySaved()
     {
         if (Platform.getInstance().isMW()){
             this.removeArticleFromSavedIfItAdded() ;
         }


         this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON,"Cannot find option to add article to reading list",5);
     }

     public void removeArticleFromSavedIfItAdded()
     {
         if (this.isElementPresent(OPTION_REMOVE_FROM_MY_LIST_BUTTON)){
             System.out.println("test OPTION_REMOVE_FROM_MY_LIST_BUTTON "  +OPTION_REMOVE_FROM_MY_LIST_BUTTON) ;
             this.waitForElementAndClick(
                     OPTION_REMOVE_FROM_MY_LIST_BUTTON,
                     "Cannot click button remove an article from saved",
                     1
                     );
             this.waitForElementPresent(
                     OPTIONS_ADD_TO_MY_LIST_BUTTON,
                     "Cannot find button to add an article to saved list after removing it from this list before"
             );
         }
     }

     public void closeArticle() {
        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()){
            this.waitForElementAndClick(
                    CLOSE_ARTICLE_BUTTON,
                    "Cannot close article, cannot find X link",
                    5
            );
        }else {
            System.out.println("Method closeArticle do nothing for platform "+Platform.getInstance().getPlatformVar());
        }

    }
    public void closeSaveAuth()
    {
        this.waitForElementAndClick(
                CLOSE_AUTH,
                "Cannot close article, cannot find X link on Save auth",
                5);
    }


    public void addSecondArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to add article to reading list",
                5
        );
        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver) ;
        MyListsPageObject.openFolderByName(name_of_folder);
    }
    //Ex6
    public void assertElementPresentTitle()
    {
        this.assertElementPresent(
                TITLE,
                "Title not found!"
        );
    }

}
