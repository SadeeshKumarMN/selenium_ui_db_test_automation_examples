package scrollbar;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class InFiniteScrollBarTests extends BaseTests {

    @Test
    public void testInfiniteScrollBar() {
        var infiniteScrollBarPage = homePage.clickInfiniteScroll();
        infiniteScrollBarPage.scrollToInfinite(10);
        assertEquals(infiniteScrollBarPage.getSizeOftheParagraphs(), 10, "Incorrect scroll move");
    }
}
