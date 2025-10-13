package tests.auth;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.mainPage.CaptchaPage;
import pages.mainPage.MainPage;
import tests.base.BaseTest;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


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

        System.out.println("Проверяю наличие каптчи");
        CaptchaPage captchaPage = new CaptchaPage(driver);


        Assert.assertTrue(captchaPage.isCaptchaPresent(), "Captcha checkbox должен присутствовать на странице после попытки входа");
    }


    @Test
    public void checkLogin() {
        openPage(driver);
        MainPage mainPage = new MainPage(driver);
        mainPage.enterButton()
                .sendLogin("qwerty@gmail.com")
                .sendPassword(PASSWORD)
                .clickEnterBTN();
        System.out.println("Проверяю наличие каптчи");
        CaptchaPage captchaPage = new CaptchaPage(driver);


        Assert.assertFalse(captchaPage.isCaptchaPresent(), "Captcha checkbox должен отсутствовать на странице после попытки входа");
    }

    @Test
    public void checkPassword() {
        openPage(driver);
        MainPage mainPage = new MainPage(driver);
        mainPage.enterButton()
                .sendLogin(LOGIN)
                .sendPassword("123")
                .clickEnterBTN();
        System.out.println("Проверяю наличие каптчи");
        CaptchaPage captchaPage = new CaptchaPage(driver);


        Assert.assertTrue(captchaPage.isCaptchaPresent(), "Captcha checkbox должен отсутствовать на странице после попытки входа");
    }

    @DataProvider(name = "invalidLogins")
    public Object[][] invalidLoginsProvider() {
        return new Object[][]{
                {"!"},{"@"},{"$"},{"а"},{"Б"},{":"},{";"},{"%"},{"&"},{"("},{")"}
        };
    }

    @Test(dataProvider = "invalidLogins", description = "Проверка поля 'Логин' на невалидные символы")
    public void invalidSymbolsLoginTest(String arg) {
        openPage(driver);
        MainPage mainPage = new MainPage(driver);
        mainPage.enterButton();
        String actualText = loginPage.sendTextToLoginInputIdAndGetTextFromField(arg);
        Assert.assertFalse(actualText.isEmpty(),
                "Невалидный символ оказался в поле ввода логина: " + arg);
    }
    @DataProvider(name = "invalidPassword")
    public Object[][] invalidPasswordProvider() {
        return new Object[][]{
                {"!"},{"@"},{"$"},{"а"},{"Б"},{":"},{";"},{"%"},{"&"},{"("},{")"}
        };
    }
    @Test(dataProvider = "invalidPassword", description = "Проверка поля 'Пароль' на невалидные символы")
    public void invalidSymbolsPasswordTest(String arg) {
        openPage(driver);
        MainPage mainPage = new MainPage(driver);
        mainPage.enterButton();
        String actualText = loginPage.sendTextToPasswordInputAndGetTextFromField(arg);
        Assert.assertFalse(actualText.isEmpty(),
                "Невалидный символ оказался в поле ввода логина: " + arg);
    }


    @Test(description = "Проверка элементов страницы")
        public void firstPageTest() {
            openPage(driver);
            MainPage mainPage = new MainPage(driver);

            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(mainPage.getEnterButtonText(), "Вход", "Текст кнопки входа неверен");
            softAssert.assertEquals(mainPage.getEnterFaceBookButtonText(), "", "Текст кнопки входа через Facebook неверен");

            softAssert.assertAll();
        }

}

