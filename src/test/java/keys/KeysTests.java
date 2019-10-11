package keys;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class KeysTests extends BaseTests {
    @Test
    public void testKeysInput() {
        var keysPage = homePage.clickKeyPresses();
        keysPage.setkeyPressInputBox("A" + Keys.BACK_SPACE);
        var outputMessage = keysPage.getResultMessage();
        assertEquals(outputMessage, "You entered: BACK_SPACE", "Incorrect Key Press/Output Message");
    }

    @Test
    public void testPiInput() {

        var keysPage = homePage.clickKeyPresses();
        keysPage.setPiValue();
        var outputMessage = keysPage.getResultMessage();
        assertEquals(outputMessage, "You entered: 4", "Incorrect Key Press/Output Message");

    }
}
