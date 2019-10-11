package cookie;

import base.BaseTests;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class CookieTests extends BaseTests {

    @Test
    public void testDeleteCookie() {
        var cookieManager = getCookieManager();
        Cookie cookie = cookieManager.setCookie("optimizelyBuckets", "%7B%TD");
        cookieManager.deleteCookie(cookie);
        assertFalse(cookieManager.isCookiePresent(cookie), "Cookie was not deleted");
    }
}
