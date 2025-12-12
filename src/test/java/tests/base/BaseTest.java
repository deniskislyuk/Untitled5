package tests.base;

import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod; // Изменено
import org.testng.annotations.BeforeMethod; // Изменено
import org.testng.annotations.BeforeTest;
import pages.base.BasePage;
import pages.loginPage.LoginPage;
import pages.startPage.StartPage;


import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static constants.Constant.LOGIN;
import static constants.Constant.PASSWORD;

public class BaseTest {
    // Используем ThreadLocal для потокобезопасного хранения драйвера
    private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();
    protected BasePage basePage;
    protected LoginPage loginPage;
    protected StartPage startPage;

    @BeforeMethod // Создаём драйвер перед КАЖДЫМ тестом
    public void setUp() {
        WebDriver driver = CommonActions.createDriver();
        if (driver != null) {
            driverThread.set(driver);
        } else {
            throw new IllegalStateException("Failed to create WebDriver instance.");
        }
        basePage = new BasePage(getDriver());
        loginPage = new LoginPage(getDriver());
    }

    public WebDriver getDriver() {
        return driverThread.get();
    }

    @AfterMethod // Очищаем куки и хранилище после каждого теста
    public void clearCookiesAndLocalStorage() {
        if (CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
            getDriver().manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
        System.out.println("Почистил куки");
    }

    @AfterMethod // Закрываем браузер после КАЖДОГО теста
    public void close() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
            driverThread.remove();
        }
        System.out.println("Закрыл браузер");
    }
}
