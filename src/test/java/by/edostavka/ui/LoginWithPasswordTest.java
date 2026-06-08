package by.edostavka.ui;

import by.edostavka.ui.pages.AuthFormPage;
import by.edostavka.ui.pages.LoginWithPasswordPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginWithPasswordTest extends BaseTest {
    private LoginWithPasswordPage loginWithPasswordPage;
    private AuthFormPage authFormPage;

    @BeforeEach
    public void setUpLoginWithPasswordPage(){
        homePage.clickCookies();
        homePage.clickButtonAuth();
        authFormPage = new AuthFormPage();
        authFormPage.clickButtonLogInWithPassword();
        loginWithPasswordPage = new LoginWithPasswordPage();
    }

    @Test
    public void loginWithIncorrectPhoneAndPassword(){
        loginWithPasswordPage.setInputPhoneNumber("11122233");
        loginWithPasswordPage.setInputPassword("123");
        loginWithPasswordPage.clickButtonSubmit();
        Assertions.assertEquals("Неверный логин или пароль", loginWithPasswordPage.getErrorMessage());
    }
}
