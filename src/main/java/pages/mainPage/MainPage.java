package pages.mainPage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;



public class MainPage extends BasePage {
    private final By enterButton = By.xpath("//div[@class='auth-bar__item auth-bar__item--text']");
    private final By enterFaceBookButton = By.xpath("//div[@title='Facebook']");
    private final By loginInput = By.xpath("//input[@placeholder='Ник или e-mail']");
    private final By passwordInput = By.xpath("//input[@placeholder='Пароль']");
    private final By enterSubmit = By.xpath("//button[@type='submit']");
    private final By profileIcon = By.xpath("//div[@class='b-top-profile__image js-header-user-avatar ym-hide-content']");
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

    public String sendTextToLoginInputIdAndGetTextFromField(String text) {
        System.out.println("Вводим текст в поле: " + text);
        waitElementToBeClickable(loginInput).clear();
        waitElementToBeClickable(loginInput).sendKeys(text);
        return waitElementIsVisible(loginInput).getAttribute("value");
    }

    public String sendTextToPasswordInputAndGetTextFromField(String text) {
        System.out.println("Вводим текст в поле: " + text);
        waitElementToBeClickable(passwordInput).clear();
        waitElementToBeClickable(passwordInput).sendKeys(text);
        return waitElementIsVisible(passwordInput).getAttribute("value");
    }




    public String getEnterButtonText() {
        return driver.findElement(enterButton).getText();
    }

    public String getEnterFaceBookButtonText() {
        return driver.findElement(enterFaceBookButton).getText();
    }


    public boolean isLoginInputPresent() {
        return !waitElementIsVisible(loginInput).isDisplayed();
    }

}
