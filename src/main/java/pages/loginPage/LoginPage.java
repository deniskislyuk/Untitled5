package pages.loginPage;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;
import pages.startPage.StartPage;


public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@class=\"submit-button btn_action\"]")
    private WebElement loginButton;

    @FindBy (xpath = "//input[@placeholder=\"Username\"]")
    private WebElement userNameInput;

    @FindBy (xpath = "//input[@placeholder=\"Password\"]")

    private WebElement passwordInput;

    @FindBy (xpath = "//div[@class=\"login_logo\"]")
    private WebElement logo;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }




    @Step("Ввод логина в поле 'Логин'")
    public LoginPage sendLogin(String login) {
        userNameInput.sendKeys(login);
        return this;
    }

    @Step("Ввод пароля в поле 'Пароль'")
    public LoginPage sendPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Клик по кнопке 'Войти'")
    public StartPage clickEnterBTN() {
        System.out.println("Нажимаем кнопку 'Войти'");
        loginButton.click();
        return new StartPage(driver);
    }





//    @Step("Ввод текста в поле 'Логин' и получение текста из поля")
//    public String sendTextToLoginInputIdAndGetTextFromField(String text) {
//        System.out.println("Вводим текст в поле: " + text);
//        loginInput.clear();
//        loginInput.sendKeys(text);
//        return loginInput.getAttribute("value");
//    }
//
//    @Step("Ввод текста в поле 'Пароль' и получение текста из поля")
//    public String sendTextToPasswordInputAndGetTextFromField(String text) {
//        System.out.println("Вводим текст в поле: " + text);
//        passwordInput.clear();
//        passwordInput.sendKeys(text);
//        return passwordInput.getAttribute("value");
//    }
//
//
//
//    @Step("Ввод текста в поле 'Логин' и получение текста из поля")
//    public boolean isContecstMenuPresent() {return !contecstMenu.isDisplayed();}
//    public String getEnterButtonText() {
//        return enterButton.getText();
//    }
//
//    @Step("Ввод текста в поле 'Логин' и получение текста из поля")
//    public String getEnterFaceBookButtonText() {
//        return enterFaceBookButton.getText();
//    }
//
//    @Step("Ввод текста в поле 'Логин' и получение текста из поля")
//    public boolean isLoginInputPresent() {
//        return loginInput.isDisplayed();
//    }

}