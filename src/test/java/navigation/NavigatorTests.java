package navigation;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NavigatorTests extends BaseTests {

    @Test
    public void testCommonNavigator() {
        homePage.clickDynamicLoading().clickDynamicElement1();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().to("https://google.com");
    }

    @Test
    public void testTabNavigator() {
        homePage.clickMultipleWindows().clickForNewWindow();
        getWindowManager().moveToRightTab("New Window");
        assertEquals(getWindowManager().getTitle(), "New Window", "Incorrect Tab Movement");
        getWindowManager().moveToRightTab("The Internet");
        assertEquals(getWindowManager().getTitle(), "The Internet", "Incorrect Tab Movement");
    }

    @Test
    public void testContextClickAndNavigation() {
        var dynamicLoadingPage = homePage.clickDynamicLoading();
        var dynamicLoadedPage = dynamicLoadingPage.contextClickDynamicElement2();
        getWindowManager().moveToNewTab();
        assertTrue(dynamicLoadedPage.isStartButtonEnabled(), "Start Button is not present");
        getWindowManager().moveToFirstTab();
    }
}
