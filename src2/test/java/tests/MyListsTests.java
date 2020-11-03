package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase
{
    private static final String name_of_folder="Learning programming";
    public String article_title_second;
    private static final String
            login="Olgan 85",
            password="Mila301215";
    @Test
    public void testSaveFirstArticleToMyList() throws InterruptedException {
        SearchPageObject SearchPageObject= SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");

        ArticlePageObject ArticlePageObject= ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title=ArticlePageObject.getArticleTitle();
       // System.out.println(article_title) ;

        if(Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        }else {
            ArticlePageObject.addArticlesToMySaved();
        }

        if (Platform.getInstance().isMW()) {
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton() ;}

            /*Auth.enterLoginData(login,password);
            Auth.submitForm();
            ArticlePageObject.waitForTitleElement() ;
            assertEquals("We are not on the same page after login.",
                    article_title,
                    ArticlePageObject.getArticleTitle()
            );

            ArticlePageObject.addArticlesToMySaved();
        }

        if(Platform.getInstance().isIOS()) {
            ArticlePageObject.closeSaveAuth();;
        }
        ArticlePageObject.closeArticle();


        NavigationUI NavigationUI=NavigationUIFactory.get(driver);
        NavigationUI.openNavigation();
        NavigationUI.clickMyLists();

        MyListsPageObject MyListsPageObject= MyListsPageObjectFactory.get(driver) ;
        if (Platform.getInstance().isAndroid())
        {
            MyListsPageObject.openFolderByName(name_of_folder);
        }
        //System.out.println("Test");
        MyListsPageObject.swipeByArticleToDeleted(article_title);*/
    }

    //Ex5
    @Test
    public void testSaveTwoArticleToMyList()
    {
        SearchPageObject SearchPageObject=SearchPageObjectFactory.get(driver);
        //первая статья
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");

        ArticlePageObject ArticlePageObject=ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title_first=ArticlePageObject.getArticleTitle();

        if(Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        }else {
            ArticlePageObject.addArticlesToMySaved();
        }

        if(Platform.getInstance().isIOS()) {
            ArticlePageObject.closeSaveAuth();;
        }
        ArticlePageObject.closeArticle();



        //вторрая статья
        SearchPageObject.initSearchInput();
        if (Platform.getInstance().isIOS()){
            SearchPageObject.clickClearSearch();
        }
        SearchPageObject.typeSearchLine("JavaScript");
        SearchPageObject.clickByArticleWithSubstring("JavaScript");
        ArticlePageObject.waitForTitleElement();
        if (Platform.getInstance().isAndroid()) {
            article_title_second = ArticlePageObject.getArticleTitle();
            ArticlePageObject.addSecondArticleToMyList(name_of_folder);

        }else {
            article_title_second = ArticlePageObject.getArticleSecondTitle();
            ArticlePageObject.addArticlesToMySaved();
        }
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI=NavigationUIFactory.get(driver);
        NavigationUI.clickMyLists();

        MyListsPageObject MyListsPageObject=MyListsPageObjectFactory.get(driver) ;
        if (Platform.getInstance().isAndroid())
        {
            MyListsPageObject.openFolderByName(name_of_folder);
        }
        MyListsPageObject.swipeByArticleToDeleted(article_title_second);
        MyListsPageObject.waitListsElementBySubstring(article_title_first);
    }


}
