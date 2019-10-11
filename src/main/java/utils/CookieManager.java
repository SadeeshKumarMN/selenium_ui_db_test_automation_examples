package utils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class CookieManager {

    private WebDriver driver;

    public CookieManager(WebDriver driver) {
        this.driver = driver;
    }

    public Cookie setCookie(String name, String value) {
        return new Cookie.Builder(name, value).domain("the-internet.herokuapp.com").build();
    }

    public void addCookie(Cookie cookie) {
        driver.manage().addCookie(cookie);
    }

    public void deleteCookie(Cookie cookie) {
        driver.manage().deleteCookie(cookie);
    }

    /*private void deleteCookie (String nameOfTheCookie){
        Set<Cookie> cookies= driver.manage().getCookies();
        System.out.println("The number of Cookies in the browser "+ cookies.size());
        System.out.println("The Cookies are");
        cookies.forEach(System.out::println);
        for(Cookie cookie: cookies){
            if(cookie.getName().equals(nameOfTheCookie)) {
                driver.manage().deleteCookieNamed(nameOfTheCookie);
                System.out.println("The cookie named "+cookie.getName()+ "is deleted" );
            }
        }
        System.out.println("The current number of Cookies in the browser "+ driver.manage().getCookies().size());
    }*/


    public boolean isCookiePresent(Cookie cookie) {
        return driver.manage().getCookieNamed(cookie.getName()) != null;
    }

    /*private boolean verifyCookie(String nameOfTheCookie){

        return driver.manage().getCookies().contains(nameOfTheCookie);
    }*/
}
