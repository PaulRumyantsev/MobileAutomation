package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject {

    private static final String
    MY_LISTS_LINK = "//*[@resource-id='org.wikipedia:id/fragment_main_nav_tab_layout']/android.view.ViewGroup/android.widget.FrameLayout[2]";


    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickMyLists()
    {
        this.waitForElementAndClick(
                By.xpath(MY_LISTS_LINK),
                "Cannot find navigation button to My list",
                5
        );
    }
}
