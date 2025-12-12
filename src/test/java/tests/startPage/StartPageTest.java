package tests.startPage;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.loginPage.LoginPage;
import pages.startPage.StartPage;
import tests.base.BaseTest;

import static common.CommonActions.openPage;
import static constants.Constant.LOGIN;
import static constants.Constant.PASSWORD;


public class StartPageTest extends BaseTest {


@Test
    public void testStartPage() {
    openPage(getDriver());
    LoginPage loginPage = new LoginPage(getDriver());
    StartPage startPage = loginPage.sendLogin(LOGIN).sendPassword(PASSWORD).clickEnterBTN();
    int actualItemsCount = startPage.getItemsCount();
    Assert.assertEquals(actualItemsCount, 6,"Неверное количество итемов");
}
}
