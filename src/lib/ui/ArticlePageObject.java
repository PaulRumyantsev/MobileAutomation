package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject

{
    private static final String
    TITLE = "id:org.wikipedia:id/view_page_title_text",
    TITLE_ELEMENT_BY_XPATH = "xpath://*[@resource-id='org.wikipedia:id/reading_list_contents']//*[@text='Island of Indonesia']",
    FOOTER_ELEMENT = "xpath://*[@text='View page in browser']",
    OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']",
    OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://*[@text='Add to reading list']",
    ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button",
    MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input",
    MY_LIST_CREATE_NEW_BUTTON = "id:org.wikipedia:id/create_button",
    MY_LIST_OK_BUTTON = "xpath://*[@text='OK']",
    CLOSE_ARTICLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']",
    ADD_TO_MY_LIST_BUTTON = "xpath://android.widget.TextView[@text='My list']",
    CHECK_TITLE_ELEMENT_BY_XPATH = "xpath://*[@resource-id='org.wikipedia:id/view_page_subtitle_container']//*[@text='Island of Indonesia']";

    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(TITLE, "Can't find article title on page!",15);
    }

    public WebElement waitForTitleElementByXpath()
    {
       return this.waitForElementPresent(TITLE_ELEMENT_BY_XPATH, "Can't find article title on page by xpath!",15);
    }

    public WebElement waitForTitleElementAndClickByXpath()
    {
        return this.waitForElementAndClick(TITLE_ELEMENT_BY_XPATH, "Cannot find 'Java Island of Indonesia' element for click", 15);
    }

    public WebElement waitForLastTitleElementByXpath()
    {
        return this.waitForElementPresent(CHECK_TITLE_ELEMENT_BY_XPATH, "Can't find 'Island of Indonesia' article title on page by xpath!",15);
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
                FOOTER_ELEMENT,
                "Can't find the end of article",
                20
        );
    }

    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForElementAndClick(
               OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to add article to reading list",
                5
        );
        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot fined 'Got it tip' overlay",
                5
        );

        this.waitForElementAndClick(
                MY_LIST_CREATE_NEW_BUTTON,
                "Cannot find 'Create new' layout",
                5
        );

        this.waitForElementAndCLear(
                MY_LIST_NAME_INPUT,
                "Cannot find input to set name of articles folder",
                5
        );

        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot put text into article folder input",
                5
        );

        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot press OK button",
                5
        );
    }

        public void closeArticle()
        {

            this.waitForElementAndClick(
                    CLOSE_ARTICLE_BUTTON,
                    "Cannot close article, cannot find X link",
                    5
            );

        }

        public void addSecondArticleToMyList(String name_of_folder)
        {

            this.waitForElementPresent(
                TITLE,
                "Cannot find second article title",
                15
        );

       this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

       this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to add article to reading list",
                10
        );

        this.waitForElementAndClick(
                ADD_TO_MY_LIST_BUTTON,
                "Cannot find 'My list' folder",
                5
        );

        }
}
