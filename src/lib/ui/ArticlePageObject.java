package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject

{
    private static final String
    TITLE = "org.wikipedia:id/view_page_title_text",
    TITLE_ELEMENT_BY_XPATH = "//*[@resource-id='org.wikipedia:id/reading_list_contents']//*[@text='Island of Indonesia']",
    FOOTER_ELEMENT = "//*[@text='View page in browser']",
    OPTIONS_BUTTON = "//android.widget.ImageView[@content-desc='More options']",
    OPTIONS_ADD_TO_MY_LIST_BUTTON = "//*[@text='Add to reading list']",
    ADD_TO_MY_LIST_OVERLAY = "org.wikipedia:id/onboarding_button",
    MY_LIST_NAME_INPUT = "org.wikipedia:id/text_input",
    MY_LIST_CREATE_NEW_BUTTON = "org.wikipedia:id/create_button",
    MY_LIST_OK_BUTTON = "//*[@text='OK']",
    CLOSE_ARTICLE_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']",
    ADD_TO_MY_LIST_BUTTON = "//android.widget.TextView[@text='My list']",
    CHECK_TITLE_ELEMENT_BY_XPATH = "//*[@resource-id='org.wikipedia:id/view_page_subtitle_container']//*[@text='Island of Indonesia']";

    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(By.id(TITLE), "Can't find article title on page!",15);
    }

    public WebElement waitForTitleElementByXpath()
    {
       return this.waitForElementPresent(By.xpath(TITLE_ELEMENT_BY_XPATH), "Can't find article title on page by xpath!",15);
    }

    public WebElement waitForTitleElementAndClickByXpath()
    {
        return this.waitForElementAndClick(By.xpath(TITLE_ELEMENT_BY_XPATH), "Cannot find 'Java Island of Indonesia' element for click", 15);
    }

    public WebElement waitForLastTitleElementByXpath()
    {
        return this.waitForElementPresent(By.xpath(CHECK_TITLE_ELEMENT_BY_XPATH), "Can't find 'Island of Indonesia' article title on page by xpath!",15);
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return  title_element.getAttribute("text");
    }

    public String getArticleTitleByXpath()
    {
        WebElement title_element = waitForLastTitleElementByXpath();
        return  title_element.getAttribute("text");
    }

    public void swipeToFooter()
    {
        this.swipeUpToFindElement(
                By.xpath(FOOTER_ELEMENT),
                "Can't find the end of article",
                20
        );
    }

    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                By.xpath(OPTIONS_BUTTON),
                "Cannot find button to open article options",
                5
        );

        this.waitForElementAndClick(
                By.xpath(OPTIONS_ADD_TO_MY_LIST_BUTTON),
                "Cannot find option to add article to reading list",
                5
        );
        this.waitForElementAndClick(
                By.id(ADD_TO_MY_LIST_OVERLAY),
                "Cannot fined 'Got it tip' overlay",
                5
        );

        this.waitForElementAndClick(
                By.id(MY_LIST_CREATE_NEW_BUTTON),
                "Cannot find 'Create new' layout",
                5
        );

        this.waitForElementAndCLear(
                By.id(MY_LIST_NAME_INPUT),
                "Cannot find input to set name of articles folder",
                5
        );

        this.waitForElementAndSendKeys(
                By.id(MY_LIST_NAME_INPUT),
                name_of_folder,
                "Cannot put text into article folder input",
                5
        );

        this.waitForElementAndClick(
                By.xpath(MY_LIST_OK_BUTTON),
                "Cannot press OK button",
                5
        );
    }

        public void closeArticle()
        {

            this.waitForElementAndClick(
                    By.xpath(CLOSE_ARTICLE_BUTTON),
                    "Cannot close article, cannot find X link",
                    5
            );

        }

        public void addSecondArticleToMyList(String name_of_folder)
        {

            this.waitForElementPresent(
                By.id(TITLE),
                "Cannot find second article title",
                15
        );

       this.waitForElementAndClick(
                By.xpath(OPTIONS_BUTTON),
                "Cannot find button to open article options",
                5
        );

       this.waitForElementAndClick(
                By.xpath(OPTIONS_ADD_TO_MY_LIST_BUTTON),
                "Cannot find option to add article to reading list",
                10
        );

        this.waitForElementAndClick(
                By.xpath(ADD_TO_MY_LIST_BUTTON),
                "Cannot find 'My list' folder",
                5
        );

        }
}
