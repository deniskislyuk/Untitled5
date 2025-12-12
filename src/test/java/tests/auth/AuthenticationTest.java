package tests.auth;


import org.testng.annotations.Test;
import pages.loginPage.LoginPage;
import tests.base.BaseTest;
import org.testng.Assert;


import static common.CommonActions.openPage;
import static constants.Constant.*;


public class AuthenticationTest extends BaseTest {

    @Test(description = "Логин")
    public void checkIsRedirect() {
        openPage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .sendLogin(LOGIN)
                .sendPassword(PASSWORD)
                .clickEnterBTN();

        String actualUrl = getDriver().getCurrentUrl();
        System.out.println(actualUrl);

        Assert.assertEquals(actualUrl,
                START_URL,
                "Страница соответствует");

    }


//    @Test
//    @Tag("Smoke")
//    public void checkLogin() {
//        openPage(getDriver());
//        LoginPage loginPage = new LoginPage(getDriver());
//        loginPage.enterButton()
//                .sendLogin("qwerty@gmail.com")
//                .sendPassword(PASSWORD)
//                .clickEnterBTN();
//        System.out.println("Проверяю наличие каптчи");
//        CaptchaPage captchaPage = new CaptchaPage(getDriver());
//
//
//        Assert.assertFalse(captchaPage.isCaptchaPresent(), "Captcha checkbox должен отсутствовать на странице после попытки входа");
//    }
//
//    @Test
//    public void checkPassword() {
//        openPage(getDriver());
//        LoginPage loginPage = new LoginPage(getDriver());
//        loginPage.enterButton()
//                .sendLogin(LOGIN)
//                .sendPassword("123")
//                .clickEnterBTN();
//        System.out.println("Проверяю наличие каптчи");
//        CaptchaPage captchaPage = new CaptchaPage(getDriver());
//
//
//        Assert.assertTrue(captchaPage.isCaptchaPresent(), "Captcha checkbox должен отсутствовать на странице после попытки входа");
//    }
//
//    @DataProvider(name = "invalidLogins")
//    public Object[][] invalidLoginsProvider() {
//        return new Object[][]{
//                {"!"},{"@"},{"$"},{"а"},{"Б"},{":"},{";"},{"%"},{"&"},{"("},{")"}
//        };
//    }
//
//    @Test(dataProvider = "invalidLogins", description = "Проверка поля 'Логин' на невалидные символы")
//    public void invalidSymbolsLoginTest(String arg) {
//        openPage(getDriver());
//        LoginPage loginPage = new LoginPage(getDriver());
//        loginPage.enterButton();
//        String actualText = this.loginPage.sendTextToLoginInputIdAndGetTextFromField(arg);
//        Assert.assertFalse(actualText.isEmpty(),
//                "Невалидный символ оказался в поле ввода логина: " + arg);
//    }
//    @DataProvider(name = "invalidPassword")
//    public Object[][] invalidPasswordProvider() {
//        return new Object[][]{
//                {"!"},{"@"},{"$"},{"а"},{"Б"},{":"},{";"},{"%"},{"&"},{"("},{")"}
//        };
//    }
//    @Test(dataProvider = "invalidPassword", description = "Проверка поля 'Пароль' на невалидные символы")
//    public void invalidSymbolsPasswordTest(String arg) {
//        openPage(getDriver());
//        LoginPage loginPage = new LoginPage(getDriver());
//        loginPage.enterButton();
//        String actualText = this.loginPage.sendTextToPasswordInputAndGetTextFromField(arg);
//        Assert.assertFalse(actualText.isEmpty(),
//                "Невалидный символ оказался в поле ввода логина: " + arg);
//    }
//
//
//    @Test(description = "Проверка элементов страницы")
//        public void firstPageTest() {
//            openPage(getDriver());
//            LoginPage loginPage = new LoginPage(getDriver());
//
//            SoftAssert softAssert = new SoftAssert();
//            softAssert.assertEquals(loginPage.getEnterButtonText(), "Вход", "Текст кнопки входа неверен");
//            softAssert.assertEquals(loginPage.getEnterFaceBookButtonText(), "", "Текст кнопки входа через Facebook неверен");
//
//            softAssert.assertAll();
//        }

}