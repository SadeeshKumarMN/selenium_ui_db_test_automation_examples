package contextmenu;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {

    @Test
    public void testContextClickAndAlertPopUp() {
        var contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.clickHotSpotBox();
        assertEquals(contextMenuPage.getAlertPopUpText(), "You selected a context menu", "Incorrect Alert Message");
    }
}
