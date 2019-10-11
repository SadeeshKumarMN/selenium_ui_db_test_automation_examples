package scrollbar;

import base.BaseTests;
import org.testng.annotations.Test;

public class FiniteScrollBarTests extends BaseTests {

    @Test
    public void testFiniteVerticalScrollBar() {
        homePage.clickLargeAndDeepDom().scrollToVerticalBarEnd();
    }

    @Test
    public void testFiniteHorizontalScrollBar() {
        homePage.clickLargeAndDeepDom().scrollToHorizontalBarEnd();
    }
}
