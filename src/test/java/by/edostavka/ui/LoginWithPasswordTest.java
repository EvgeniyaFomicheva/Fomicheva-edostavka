package by.edostavka.ui;

import by.edostavka.data.Utils;
import by.edostavka.ui.pages.AuthFormPage;
import by.edostavka.ui.pages.LoginWithPasswordPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginWithPasswordTest extends BaseTest {
    private WebDriverWait wait;
    private LoginWithPasswordPage loginWithPasswordPage;
    private AuthFormPage authFormPage;

    @BeforeEach
    public void setUpLoginWithPasswordPage() {
        homePage.clickCookies();
        homePage.clickButtonAuth();
        authFormPage = new AuthFormPage();
        authFormPage.clickButtonLogInWithPassword();
        loginWithPasswordPage = new LoginWithPasswordPage();
    }

    @Test
    public void loginWhenPhoneAndPasswordNotExist() {
        loginWithPasswordPage.setInputPhoneNumber(Utils.getPhoneNumber());
        loginWithPasswordPage.setInputPassword(Utils.getPassword());
        loginWithPasswordPage.clickButtonSubmit();
        Assertions.assertEquals("Неверный логин или пароль", loginWithPasswordPage.getErrorMessage());
    }

    @Test
    public void LoginWithSpacebarPhoneNumberAndPassword(){
        loginWithPasswordPage.setInputPhoneNumber(" ");
        loginWithPasswordPage.setInputPassword(" ");
        loginWithPasswordPage.clickButtonSubmit();
        Assertions.assertEquals("Неверный логин или пароль", loginWithPasswordPage.getErrorMessage());
    }

    @Test
    public void TitleText(){
        Assertions.assertEquals("Вход", loginWithPasswordPage.getTitleText());
    }
}
