package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {
    private static final String name_of_folder = "Learning programming";
    public String article_title_second;
    private static final String
            login = "Negovora",
            password = "testnegovora";

    @Test
    public void testSaveFirstArticleToMyList() throws InterruptedException {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        if ((Platform.getInstance().isAndroid())||(Platform.getInstance().isIOS())){
            SearchPageObject.clickByArticleWithSubstring("ava (programming language))");
        }else{
            SearchPageObject.clickByArticleWithSubstring("ject-oriented programming language");
        }

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        // System.out.println(article_title) ;

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {

            ArticlePageObject.addArticlesToMySaved();


        }

        if (Platform.getInstance().isMW()) {
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();


            Auth.enterLoginData(login, password);
            Auth.submitForm();
            ArticlePageObject.waitForTitleElement();
            ArticlePageObject.addArticlesToMySaved();
           // String test = ArticlePageObject.getArticleTitle();
            assertEquals("We are not on the same page after login.",
                    article_title,
                    ArticlePageObject.getArticleTitle()
            );

            //  ArticlePageObject.addArticlesToMySaved();
        }


        ArticlePageObject.closeArticle();


        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.openNavigation();
        NavigationUI.clickMyLists();

        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()) {
            MyListsPageObject.openFolderByName(name_of_folder);
        }
        //System.out.println("Test");
        MyListsPageObject.swipeByArticleToDeleted(article_title);
    }

    //Ex5
    @Test
    public void testSaveTwoArticleToMyList() throws InterruptedException {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        if ((Platform.getInstance().isAndroid())||(Platform.getInstance().isIOS())){
            SearchPageObject.clickByArticleWithSubstring("ava (programming language)");
        }else{
            SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");
        }

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {

            ArticlePageObject.addArticlesToMySaved();
        }

        if (Platform.getInstance().isIOS()) {
            ArticlePageObject.closeSaveAuth();
        }

        if (Platform.getInstance().isMW()) {
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(login, password);
            Auth.submitForm();
            ArticlePageObject.waitForTitleElement();
            ArticlePageObject.addArticlesToMySaved();
        }else{
        ArticlePageObject.closeArticle();
        }

        ///////////////вторая статья
        SearchPageObject.initSearchInput();
        if (Platform.getInstance().isIOS()){
            SearchPageObject.clickClearSearch();
        }
        SearchPageObject.typeSearchLine("JavaScript");
        SearchPageObject.clickByArticleWithSubstring("rogramming language");
        ArticlePageObject.waitForTitleElement();

        if (Platform.getInstance().isAndroid()) {
            article_title_second = ArticlePageObject.getArticleTitle();
            ArticlePageObject.addSecondArticleToMyList(name_of_folder);
        } else if (Platform.getInstance().isIOS() ) {
            article_title_second = ArticlePageObject.getArticleSecondTitle();
            ArticlePageObject.addArticlesToMySaved();
        }else {
            article_title_second = ArticlePageObject.getArticleTitle();
            ArticlePageObject.addArticlesToMySaved();
        }

        if (Platform.getInstance().isMW()){
            NavigationUI NavigationUI = NavigationUIFactory.get(driver);
            NavigationUI.openNavigation();
            NavigationUI.clickMyLists();
        }

        MyListsPageObject MyListsPageObject=MyListsPageObjectFactory.get(driver) ;
        if ((Platform.getInstance().isIOS())||(Platform.getInstance().isAndroid())){
            {
                ArticlePageObject.closeArticle();
                NavigationUI NavigationUI=NavigationUIFactory.get(driver);
                NavigationUI.clickMyLists();
            }
        }

        if (Platform.getInstance().isAndroid())
        {
            MyListsPageObject.openFolderByName(name_of_folder);
        }
        MyListsPageObject.swipeByArticleToDeleted(article_title);
        MyListsPageObject.waitListsElementBySubstring(article_title_second);

        }


}

