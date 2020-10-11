package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class SearchTests extends CoreTestCase
{
    @Test
    public void testSearch()
    {
        SearchPageObject SearchPageObject=new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
    }

    @Test
    public void testCancelSearch()
    {
        SearchPageObject SearchPageObject=new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();

    }
    @Test
    public void testAmountOfNotEmptySearch()//работает
    {
        SearchPageObject SearchPageObject=new SearchPageObject(driver);
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
        SearchPageObject SearchPageObject=new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        String search_line="kjhkjh";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyForResultsLabel();
        SearchPageObject.assertThereIsNoResultOfSearch();
    }

    //Ex3 отмена поиска
    @Test
    public void testSizeSearchListCancel()
    {
        SearchPageObject SearchPageObject=new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        String search_line="Java";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results_list=SearchPageObject.getAmountOfFoundElementLists();
        assertTrue(
                "Search result less than or equal to 1!",
                amount_of_search_results_list>1
        );
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForSearchListsToDisappear();

    }

}
