package lib.home_work_tests;

import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Test;



public class HomeWork extends CoreTestCase {
    private lib.ui.MainPageObject MainPageObject;

    protected void setUp() throws Exception{
        super.setUp();

        MainPageObject = new MainPageObject(driver);
    }


    @Test
    public void testEx3()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSkipPage();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
        SearchPageObject.waitForSearchResult("Island of Indonesia");
        SearchPageObject.waitForSearchResult("Austronesian language");
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForSearchResultIsDisappearByEmptyMessage();

    }

    @Test
    public void testEx5()
    {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSkipPage();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        String name_of_folder = "My list";
        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Island of Indonesia");
        ArticlePageObject.addSecondArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyLists();

        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
        MyListsPageObject.openFolderByName(name_of_folder);
        MyListsPageObject.swipeByArticleToDelete(article_title);
        ArticlePageObject.waitForTitleElementByXpath();
        ArticlePageObject.waitForTitleElementAndClickByXpath();
        String title = ArticlePageObject.getArticleTitleByXpath();


        assertEquals(
                "We see unexpected title",
                "Island of Indonesia",
                title
        );



    }




}


