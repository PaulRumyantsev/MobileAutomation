package lib.tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class SearchTests extends CoreTestCase {

    @Test
    public void testSearch()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSkipPage();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
    }

    @Test
    public void testCancelSearch()
    {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSkipPage();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("J");
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();

    }

    @Test
    public void testAmountOfNotEmptySearch(){

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSkipPage();
        SearchPageObject.initSearchInput();
        String search_line = "Linkin Park discography";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmmountOfFoundArticles();


        assertTrue(
                "We found too few results",
                amount_of_search_results > 0
        );


    }

    @Test
    public void testAmountOfEmptySearch(){

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSkipPage();
        SearchPageObject.initSearchInput();
        String search_line = "wejldsfjls";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultsLabel();
        SearchPageObject.assertThereIsNoResultOfSearch();
    }
}
