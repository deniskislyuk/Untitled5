package common;

import constants.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

import static common.Config.PLATFORM_AND_BROWSER;
import static constants.Constant.IMPLICIT_WAIT;

public class CommonActions {

    public static WebDriver createDriver() {
        System.out.println("Creating WebDriver");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--incognito");
        //options.addArguments("--headless=new");
        options.addArguments("--disable-autofill");
        options.addArguments("--disable-save-password-brompt");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-password-encryption");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--window-size=1920,1200");

        WebDriver driver = null;

        try {
            switch (PLATFORM_AND_BROWSER.toLowerCase()) {
                case "win_chrome":
                    driver = new ChromeDriver(options);
                    break;
                default:
                    Assert.fail("Invalid Platform or Browser: " + PLATFORM_AND_BROWSER);

            }
        } catch (Exception e) {
            System.err.println("Failed to create WebDriver instance: " + e.getMessage());
            e.printStackTrace();
        }

        if (driver != null) {
            System.out.println("WebDriver created successfully.");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        } else {
            System.err.println("WebDriver creation failed. Returning null.");
        }
        return driver;
    }

    public static void openPage(WebDriver driver) {
        if (driver == null) {
            System.err.println("WebDriver instance is null in openPage(). Cannot open page.");
            throw new IllegalStateException("WebDriver instance is not initialized.");
        }
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
