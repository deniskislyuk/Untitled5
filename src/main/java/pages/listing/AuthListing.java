package pages.listing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;

public class AuthListing extends BasePage {
    public AuthListing(WebDriver driver) {
        super(driver);
    }

    private final By title = By.xpath("//*[text()= \"Подтверждение входа\"]");

    public void checkTitle() {
        WebElement titleElement = waitElementIsVisible(title);
        String actualTitle = titleElement.getText();
        Assert.assertEquals(actualTitle, "Подтверждение входа");
    }
}