package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;


abstract public class MyListsPageObject extends MainPageObject
{
    protected static String
        FOLDER_BY_NAME_TPL,
        ARTICLE_BY_TITLE_TPL,
        MY_LISTS_ELEMENT_TPL;
    /*TEMPLATES METHODS*/
    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}",name_of_folder);
    }

    private static String getSavedArticleXpathByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}",article_title);
    }
    private static String getListXpathElement(String substring)
    {
        return MY_LISTS_ELEMENT_TPL.replace("{SUBSTRING}",substring);
    }

    /*TEMPLATES METHODS*/


    public MyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void openFolderByName(String name_of_folder)
    {
        String folder_name_xpath=getSavedArticleXpathByTitle(name_of_folder);
        this.waitForElementAndClick(
                folder_name_xpath,
                "Cannot find folder by name "+name_of_folder,
                5
        );
    }

    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_xpath=getSavedArticleXpathByTitle(article_title);
        this.waitForElementPresent(article_xpath,"Cannot find saved article by title  "+article_title,15);
    }

    public void waitListsElementBySubstring(String  article_title_first)
    {
        String name_element_xpath;

        if(Platform.getInstance().isAndroid()){
            name_element_xpath = getSavedArticleXpathByTitle(article_title_first);
        }
        else {
            name_element_xpath = getListXpathElement(article_title_first);
        }
        this.waitForElementPresent(name_element_xpath,"Expect to see another article, not "+article_title_first,5);
    }

    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_xpath=getSavedArticleXpathByTitle(article_title);
        this.waitForElementNotPresent(article_xpath,"Saved article still present with title "+article_title,15);
    }

    public void swipeByArticleToDeleted(String article_title)
    {
        this.waitForArticleToAppearByTitle(article_title);
        System.out.println(article_title) ;
        String article_xpath=getSavedArticleXpathByTitle(article_title) ;
        this.swipeElementToLeft(
                article_xpath,
                "Cannot find saved article"

        );
        if (Platform.getInstance().isIOS()){
            this.clickElementToTheRightUpperCorner(article_xpath,"Cannot find saved article") ;
        }
        this.waitForArticleToDisappearByTitle(article_title);
    }
}
