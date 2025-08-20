package pages.mainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;



public class MainPage extends BasePage {
    public final By enterButton = By.xpath("//div[@class='auth-bar__item auth-bar__item--text']");
    private final By loginInput = By.xpath("//input[@placeholder='Ник или e-mail']");
    private final By passwordInput = By.xpath("//input[@placeholder='Пароль']");
    private final By enterSubmit = By.xpath("//button[@type='submit']");

    public MainPage(WebDriver driver) {
        super(driver);
    }


    public MainPage sendLogin(String login) {
        System.out.println("Вводим логин");
        waitElementToBeClickable(loginInput).sendKeys(login);
        return this;
    }

    public MainPage sendPassword(String password) {
        System.out.println("Вводим пароль");
        waitElementIsVisible(passwordInput).sendKeys(password);
        return this;
    }

    public MainPage clickEnterBTN() {
        System.out.println("Нажимаем кнопку 'Войти'");
        waitElementToBeClickable(enterSubmit).click();
        return this;
    }

    public MainPage enterButton() {
        System.out.println("Нажимаем кнопку 'Вход'");
        waitElementToBeClickable(enterButton).click();
        return this;
    }

}