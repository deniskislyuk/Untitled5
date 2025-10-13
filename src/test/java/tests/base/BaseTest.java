package tests.base;

import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import pages.base.BasePage;
import pages.mainPage.MainPage;
import pages.mainPage.CaptchaPage;


import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.HOLD_BROWSER_OPEN;

public class BaseTest {
    protected WebDriver driver;
    protected BasePage basePage;
    protected MainPage loginPage;
    protected CaptchaPage captchaPage;

    @BeforeSuite
    public void setUp() {
        driver = CommonActions.createDriver();
        basePage = new BasePage(driver);
        loginPage = new MainPage(driver);
    }


    @AfterTest
    public void clearCookiesAndLocalStorage() {
        if (CLEAR_COOKIES_AND_STORAGE){
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript ("window.sessionStorage.clear()");
        }
        System.out.println("Почистил куки");
    }

    @AfterSuite (alwaysRun = true)
    public void close() {
        if (HOLD_BROWSER_OPEN) {
            driver.quit();
        }
        System.out.println("Закрыл браузер");
    }


}
