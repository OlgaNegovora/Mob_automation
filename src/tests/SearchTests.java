package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class SearchTests extends CoreTestCase
{

    @Test
    public void testSearchFirstThree()
    {
        SearchPageObject SearchPageObject=new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForElementByTitleAndDescription ("Java (programming language)","Object-oriented programming language");
        SearchPageObject.waitForElementByTitleAndDescription ("Java","Island of Indonesia");
        SearchPageObject.waitForElementByTitleAndDescription ("JavaScript","Programming language");
    }

}
