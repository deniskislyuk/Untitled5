package common;

import constants.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static common.Config.PLATFORM_AND_BROWSER;
import static constants.Constant.IMPLICIT_WAIT;


public class CommonActions {

    public static WebDriver createDriver() {
        System.out.println("Creating WebDriver");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-autofill");
        options.addArguments("--disable-save-password-brompt");
        options.addArguments("--disable-password-encryption");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver;

        switch (PLATFORM_AND_BROWSER.toLowerCase()) {
            case "win_chrome":
                driver = new ChromeDriver(options);
                break;
            default:
                Assert.fail("Invalid Platform or Browser: " + PLATFORM_AND_BROWSER);
                return null;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        return driver;
    }

    public static void openPage(WebDriver driver) {
        String url = PageSwitcher.getPageUrl(Config.TEST_URL);
        driver.get(url);
    }

    public static class PageSwitcher {
        public static String getPageUrl(String pageName) {
            switch (pageName.toLowerCase()) {
                case "regres":
                    return Constant.REGRES_PAGE;
                case "test":
                    return Constant.TEST_PAGE;
                default:
                    throw new IllegalArgumentException("Unknown page: " + pageName);
            }
        }
    }
}