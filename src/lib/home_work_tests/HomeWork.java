package lib.home_work_tests;

import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class HomeWork extends CoreTestCase {
    private lib.ui.MainPageObject MainPageObject;

    protected void setUp() throws Exception{
        super.setUp();

        MainPageObject = new MainPageObject(driver);
    }


        @Test
        public void testEx3() {
            MainPageObject.waitForElementAndClick(
                    By.xpath("//*[contains(@text,'SKIP')]"),
                    "Cannot find SKIP button",
                    5
            );

            MainPageObject.waitForElementAndClick(
                    By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                    "Cannot find 'Search Wikipedia' input",
                    5
            );

            MainPageObject.waitForElementAndSendKeys(
                    By.xpath("//*[contains(@text,'Search…')]"),
                    "Java",
                    "Cannot find search input",
                    5
            );

            MainPageObject.waitForElementPresent(
                    By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='Object-oriented programming language']"),
                    "Cannot find 'Object-oriented programming language",
                    5
            );

            MainPageObject.waitForElementPresent(
                    By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='Island of Indonesia']"),
                    "Cannot find 'Island of Indonesia' input",
                    5

            );

            MainPageObject.waitForElementPresent(
                    By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='Austronesian language']"),
                    "Cannot find 'Austronesian language' input",
                    5
            );

            MainPageObject.waitForElementAndClick(
                    By.id("org.wikipedia:id/search_close_btn"),
                    "Cannot find X to cancel search",
                    5
            );

            WebElement title_element =  MainPageObject.waitForElementPresent(
                    By.id("org.wikipedia:id/search_empty_message"),
                    "Text 'Search and read the free encyclopedia in your language' is not present",
                    15

            );

            String article_title = title_element.getAttribute("text");
            Assert.assertEquals(
                    "We see unexpected title",
                    "Search and read the free encyclopedia in your language",
                    article_title
            );


    }

    @Test
    public void testEx5(){
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'SKIP')]"),
                "Cannot find SKIP button",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                5
        );

        String search_line = "Java";
        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                search_line,
                "Cannot find search input",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='Object-oriented programming language']"),
                "Cannot find 'Search Wikipedia' input",
                5
        );

        MainPageObject.waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot find article title",
                15
        );


        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "Cannot find button to open article options",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='Add to reading list']"),
                "Cannot find option to add article to reading list",
                15
        );

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/onboarding_button"),
                "Cannot fined 'Got it tip' overlay",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/create_button"),
                "Cannot find 'Create new' layout",
                5
        );

        MainPageObject.waitForElementAndCLear(
                By.id("org.wikipedia:id/text_input"),
                "Cannot find input to set name of articles folder",
                5
        );

        String name_of_folder = "My list";
        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                name_of_folder,
                "Cannot put text into article folder input",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='OK']"),
                "Cannot press OK button",
                5
        );

        driver.navigate().back();

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                5
        );

        String second_search_line = "Java";
        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                second_search_line,
                "Cannot find second search input",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='Island of Indonesia']"),
                "Cannot find 'Island of Indonesia' input",
                15
        );

        MainPageObject.waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot find second article title",
                15
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "Cannot find button to open article options",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='Add to reading list']"),
                "Cannot find option to add article to reading list",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.TextView[@text='My list']"),
                "Cannot find 'My list' folder",
                5
        );

        driver.navigate().back();

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/fragment_main_nav_tab_layout']/android.view.ViewGroup/android.widget.FrameLayout[2]"),
                "Cannot find 'My list' layout_button",
                5
        );

        MainPageObject.waitForElementPresent(
                By.xpath("//android.widget.TextView[@text='My lists']"),
                "Cannot find 'My lists' ",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.TextView[@text='My list']"),
                "Cannot find 'My list' folder in My lists",
                5
        );

        MainPageObject.swipeElementToLeft(
                By.xpath("//*[@text='Java (programming language)']"),
                "Cannot fined 'Java (programming language)'"
        );


        MainPageObject.waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/reading_list_contents']//*[@text='Island of Indonesia']"),
                "Cannot find 'Java Island of Indonesia' element",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/reading_list_contents']//*[@text='Island of Indonesia']"),
                "Cannot find 'Java Island of Indonesia' element for click",
                5
        );

        WebElement title_element =  MainPageObject.waitForElementPresent(
                By.id("org.wikipedia:id/view_page_subtitle_text"),
                "Cannot find article title",
                15

        );

        String article_title = title_element.getAttribute("text");
        Assert.assertEquals(
                "We see unexpected title",
                "Island of Indonesia",
                article_title
        );



    }




}


