package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.CookieManager;
import utils.EventReporter;
import utils.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import static com.google.common.io.Files.move;

public class BaseTests {

    protected HomePage homePage;
    //private WebDriver driver;
    private EventFiringWebDriver driver;
    private String baseUrl = "https://the-internet.herokuapp.com/";
    private String deleteCookie = "optimizelyBuckets";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
        //driver = new ChromeDriver();
        //Implicit Wait
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        // Asynchronus JS Execution
        //driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        openURL();
        //setCookie();
        //deleteCookie(deleteCookie);
        //System.out.println("Whether the deleted cookie is present? true or false"+ verifyCookie(deleteCookie));
        //Different ways of adjusting the browser window
        //driver.manage().window().fullscreen();
        //driver.manage().window().setSize(new Dimension(375,812));
       /* System.out.println(driver.getTitle());

        //Finding WebElement(s)
        WebElement linkTest= driver.findElement(By.linkText("Shifting Content"));
        linkTest.click();

        System.out.println(driver.getTitle());

        linkTest= driver.findElement(By.linkText("Example 1: Menu Element"));
        linkTest.click();

        System.out.println(driver.getTitle());

        List<WebElement> links = driver.findElements(By.xpath("//*[@id='content']/div/ul/li"));
        System.out.println("The size of the links in the Menu List "+ links.size());*/

    }

    @BeforeMethod
    public void openURL() {
        driver.get(baseUrl);
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            //System.out.println("Screenshot taken at "+screenshot.getAbsolutePath());
            try {
                move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    /*public static void main(String[] args) {
        BaseTests base = new BaseTests();
        base.setUp();
    }*/

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.addArguments("disable-infobars");
        //options.setHeadless(true);
        return options;
    }

    protected WebDriverManager getWindowManager() {
        return new WebDriverManager(driver);
    }

    protected CookieManager getCookieManager() {
        return new CookieManager(driver);
    }


}
