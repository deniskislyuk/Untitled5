package pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;



public class LoginPage extends BasePage {
    private final By loginInput = By.xpath("//input[@id='mat-input-0']");
    private final By passwordInput = By.xpath("//input[@id='mat-input-1']");
    private final By enter = By.xpath("//*[text()= \"Войти\"]");
    private final By forgotPassword = By.xpath("//*[text()= \"Забыли пароль?\"]");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage sendPassword(String password) {
        System.out.println("Вводим пароль");
        waitElementIsVisible(passwordInput).sendKeys(password);
        return this;
    }


    public void clickEnterBTN() {
        System.out.println("Нажимаем Enter");
        waitElementToBeClickable(enter).click();
    }
    public LoginPage clickforgotPasswordBTN() {
        waitElementToBeClickable(forgotPassword).click();
        return this;
    }

    public LoginPage sendLogin(String login) {
        System.out.println("Вводим логин");
        waitElementToBeClickable(loginInput).sendKeys(login);
        return this;
    }




}