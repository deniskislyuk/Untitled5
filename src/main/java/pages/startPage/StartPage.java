package pages.startPage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

import java.util.List;

public class StartPage extends BasePage {
    public StartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

@FindBy (id = "react-burger-menu-btn")
    private WebElement BurgerMenu;

@FindBy (xpath = "//div[@class=\"app_logo\"]")
    private WebElement Logo;

@FindBy (id = "shopping_cart_container")
    private WebElement ShoppingCart;

@FindBy (xpath = "//span[@class='title']")
    private WebElement Title;

@FindBy (xpath = "//span[@class='select_container]")
    private WebElement Filter;

@FindBy (xpath = "//div[@class=\"inventory_item\"]")
    private List<WebElement> InventoryList;

@Step ("Получение количества Items из itemList")
public int getItemsCount() {
    return InventoryList.size();
}

@Step ("Получение текущей URL")
    public String startPageURL (){
        return driver.getCurrentUrl();
}


}
