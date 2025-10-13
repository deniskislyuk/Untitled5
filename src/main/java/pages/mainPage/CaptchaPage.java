package pages.mainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CaptchaPage extends MainPage {
    private final By titleAuthForm = By.xpath("//div[@class='auth-form__title auth-form__title_base auth-form__title_condensed-other']");
    private final By closeButton = By.xpath("//div[@class=\"auth-form__close\"]");
    public CaptchaPage(WebDriver driver) {
        super(driver);
    }



    public void clickCloseButton() {
        System.out.println("Нажимаю на кнопку 'Х-Закрыть каптчу'");
        waitElementToBeClickable(closeButton).click();
    }
    public boolean isCaptchaPresent() {
        return !driver.findElements(titleAuthForm).isEmpty();
    }
}

