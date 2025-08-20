package tests.auth;
import org.testng.annotations.Test;
import pages.mainPage.MainPage;
import tests.base.BaseTest;

import static common.CommonActions.openPage;
import static constants.Constant.LOGIN;
import static constants.Constant.PASSWORD;


public class AuthenticationTest extends BaseTest {

    @Test(description = "Логин")
    public void checkIsRedirect() {
        openPage(driver);
        MainPage mainPage = new MainPage(driver);
        mainPage
                .enterButton()
                .sendLogin(LOGIN)
                .sendPassword(PASSWORD)
                .clickEnterBTN();


    }
}