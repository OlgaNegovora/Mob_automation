package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class SearchTests extends CoreTestCase
{
    @Test
    public void testSearch()
    {
        SearchPageObject SearchPageObject=SearchPageObjectFactory.get(driver);
//        System.out.println("test") ;
//        SearchPageObject.initTestSearchInput();
        SearchPageObject.initSearchInput();
       SearchPageObject.typeSearchLine("Java");
       SearchPageObject.waitForSearchResult("bject-oriented programming language");//Object-oriented programming language
    }

    @Test
    public void testCancelSearch()
    {
        SearchPageObject SearchPageObject=SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();

    }
    @Test
    public void testAmountOfNotEmptySearch()//работает
    {
        SearchPageObject SearchPageObject=SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line="Linkin Park Discography";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results=SearchPageObject.getAmountOfFoundArticles();

        //System.out.println(amount_of_search_results);
        assertTrue(
                "We found too few results!",
                amount_of_search_results>0
        );
    }

    @Test
    public void testAmountOfEmptySearch()//работает
    {
        SearchPageObject SearchPageObject=SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line="kjhkjh";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyForResultsLabel();
        SearchPageObject.assertThereIsNoResultOfSearch();
    }
//Ex9
    @Test
    public void testSearchFirstThree()
    {
        SearchPageObject SearchPageObject=SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForElementByTitleAndDescription ("Java (programming language)","Object-oriented programming language");
        SearchPageObject.waitForElementByTitleAndDescription ("Java","Indonesian island");
        SearchPageObject.waitForElementByTitleAndDescription ("JavaScript","High-level programming language");
    }

    //Ex3 отмена поиска
    @Test
    public void testSizeSearchListCancel()
    {
        SearchPageObject SearchPageObject= SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line="Java";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results_list=SearchPageObject.getAmountOfFoundArticles();
        //getAmountOfFoundElementLists();
                //.getAmountOfElements();
        //
        System.out.println(amount_of_search_results_list);
        assertTrue(
                "Search result less than or equal to 1!",
                amount_of_search_results_list>1
        );
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForSearchListsToDisappear();

    }



}
