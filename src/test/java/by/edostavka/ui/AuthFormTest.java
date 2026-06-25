package by.edostavka.ui;

import by.edostavka.data.Utils;
import by.edostavka.ui.pages.AuthFormPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthFormTest extends BaseTest {
    private WebDriverWait wait;
    private AuthFormPage authFormPage;
    static final Logger logger = LogManager.getLogger();


    @BeforeEach
    public void setUpAuthFormPage() {
        homePage.clickCookies();
        homePage.clickButtonAuth();
        authFormPage = new AuthFormPage();
    }

    @Test
    public void test1() {
        authFormPage.setInputPhoneNumber(" ");
        authFormPage.clickButtonGetCode();
        Assertions.assertEquals("Номер введен некорректно", authFormPage.getErrorMessageIncorrectNumber());
    }


    @Test
    public void test2() {
        authFormPage.setInputPhoneNumber(Utils.getPhoneNumber());
        authFormPage.clickButtonGetCode();
        Assertions.assertEquals("Пожалуйста, убедитесь, что правильно ввели телефон", authFormPage.getErrorMessageCheckCorrectMessage());
    }


    @Test
    public void test3() {
        Assertions.assertEquals("Вход", authFormPage.getTitleText());

    }


}


