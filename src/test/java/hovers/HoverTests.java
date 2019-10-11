package hovers;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoverTests extends BaseTests {

    @Test
    public void testHovers() {
        var hoverPage = homePage.clickHovers();
        var hoverElement = hoverPage.mouseHoverOverElement(3);
        assertTrue(hoverElement.isHoveredContentDisplayed(), "Not Hovered/Content not displayed");
        assertEquals(hoverElement.getHoveredHeaderText(), "name: user3", "Incorrect Header");
        assertTrue(hoverElement.getHoveredLink().endsWith("/users/3"), "Incorrect link in the hovered content");
        assertEquals(hoverElement.getHoveredLinkText(), "View profile", "Incorrect link in the hovered content");
    }

}
