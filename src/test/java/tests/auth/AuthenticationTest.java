package tests.auth;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static common.CommonActions.openPage;
import static constants.Constant.LOGIN;
import static constants.Constant.PASSWORD;


public class AuthenticationTest extends BaseTest {

    @Test(description = "Логин")
    public void checkIsRedirectToOTP() {
        openPage(driver);
        loginPage
                .sendLogin(LOGIN)
                .sendPassword(PASSWORD)
                .clickEnterBTN();


        authListing.checkTitle();
    }
}
