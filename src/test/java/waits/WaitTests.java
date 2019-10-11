package waits;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WaitTests extends BaseTests {

    @Test
    public void testDynamicLoadingLink1() {
        var dynamicLoadedPage = homePage.clickDynamicLoading().clickDynamicElement1();
        dynamicLoadedPage.clickDynamicLoadedExample1();
        assertEquals(dynamicLoadedPage.getMessageAfterLoaded(), "Hello World!", "Explicit Wait Fails");
    }

    @Test
    public void testDynamicLoadingLink2() {
        var dynamicLoadedPage = homePage.clickDynamicLoading().clickDynamicElement2();
        dynamicLoadedPage.clickDynamicLoadedExample2();
        assertEquals(dynamicLoadedPage.getMessageAfterLoaded(), "Hello World!", "Fluent Wait Fails");
    }

}
