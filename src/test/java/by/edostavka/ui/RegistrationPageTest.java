package by.edostavka.ui;

import by.edostavka.data.Utils;
import by.edostavka.ui.pages.AuthFormPage;
import by.edostavka.ui.pages.RegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.plaf.PanelUI;

public class RegistrationPageTest extends BaseTest {
    private WebDriverWait wait;
    private RegistrationPage registrationPage;
    private AuthFormPage authFormPage;

    @BeforeEach
    public void setupRegistrationPage(){
        homePage.clickCookies();
        homePage.clickButtonAuth();
        authFormPage = new AuthFormPage();
        authFormPage.clickButtonRegistration();
        registrationPage = new RegistrationPage();
    }

    @Test
    public void registrationWithoutName(){
        String userPassword = Utils.getPassword();
        registrationPage.clickName();
        registrationPage.setInputLastName(Utils.getLastName());
        registrationPage.setInputMiddleName(Utils.getMiddleName());
        registrationPage.setInputPhoneNumber(Utils.getPhoneNumber());
        registrationPage.setInputEmail(Utils.getEmail());
        registrationPage.setInputPassword(userPassword);
        registrationPage.setInputPasswordAgain(userPassword);
        registrationPage.clickButtonSubmit();
        registrationPage.clickCheckboxPrivacyAgreement();
        registrationPage.clickButtonScrollNext();
        registrationPage.clickCheckboxAcceptAll();
        registrationPage.clickButtonConfirmAgreement();
        Assertions.assertEquals("Поле имя обязательно для заполнения", registrationPage.getErrorMessageEmptyName());
    }

    @Test
    public void registrationWithoutSurname(){
        String userPassword = Utils.getPassword();
        registrationPage.setInputName(Utils.getName());
        registrationPage.clickLastName();
        registrationPage.setInputMiddleName(Utils.getMiddleName());
        registrationPage.setInputPhoneNumber(Utils.getPhoneNumber());
        registrationPage.setInputEmail(Utils.getEmail());
        registrationPage.setInputPassword(userPassword);
        registrationPage.setInputPasswordAgain(userPassword);
        registrationPage.clickButtonSubmit();
        registrationPage.clickCheckboxPrivacyAgreement();
        registrationPage.clickButtonScrollNext();
        registrationPage.clickCheckboxAcceptAll();
        registrationPage.clickButtonConfirmAgreement();
        Assertions.assertEquals("Поле фамилия обязательно для заполнения", registrationPage.getErrorMessageEmptyLastName());
    }

    @Test
    public void registrationWithoutSecondName(){
        String userPassword = Utils.getPassword();
        registrationPage.setInputName(Utils.getName());
        registrationPage.setInputLastName(Utils.getLastName());
        registrationPage.setInputPhoneNumber(Utils.getPhoneNumber());
        registrationPage.setInputEmail(Utils.getEmail());
        registrationPage.setInputPassword(userPassword);
        registrationPage.setInputPasswordAgain(userPassword);
        registrationPage.clickCheckboxPrivacyAgreement();
        registrationPage.clickButtonScrollNext();
        registrationPage.clickCheckboxAcceptAll();
        registrationPage.clickButtonConfirmAgreement();
        registrationPage.clickButtonSubmit();
        Assertions.assertTrue(registrationPage.isCodePageDisplayed(),
                "Переход на страницу ввода кода не произошел!");
    }

    @Test
    public void registrationWithoutPhone(){
        String userPassword = Utils.getPassword();
        registrationPage.setInputName(Utils.getName());
        registrationPage.setInputMiddleName(Utils.getMiddleName());
        registrationPage.setInputLastName(Utils.getLastName());
        registrationPage.clickPhoneNumber();
        registrationPage.setInputEmail(Utils.getEmail());
        registrationPage.setInputPassword(userPassword);
        registrationPage.setInputPasswordAgain(userPassword);
        registrationPage.clickButtonSubmit();
        registrationPage.clickCheckboxPrivacyAgreement();
        registrationPage.clickButtonScrollNext();
        registrationPage.clickCheckboxAcceptAll();
        registrationPage.clickButtonConfirmAgreement();
        Assertions.assertEquals("Поле номер телефона обязательно для заполнения", registrationPage.getErrorMessageEmptyPhonenumber());
    }

    @Test
    public void registrationWithoutPassword(){
        registrationPage.setInputName(Utils.getName());
        registrationPage.setInputMiddleName(Utils.getMiddleName());
        registrationPage.setInputLastName(Utils.getLastName());
        registrationPage.setInputPhoneNumber(Utils.getPhoneNumber());
        registrationPage.setInputEmail(Utils.getEmail());
        registrationPage.clickPassword();
        registrationPage.clickPasswordAgain();
        registrationPage.clickButtonSubmit();
        registrationPage.clickCheckboxPrivacyAgreement();
        registrationPage.clickButtonScrollNext();
        registrationPage.clickCheckboxAcceptAll();
        registrationPage.clickButtonConfirmAgreement();
        Assertions.assertEquals("Создание пароля обязательно", registrationPage.getErrorMessageWithoutPassword());
    }


    @Test
    public void registrationWithoutPasswordConfirm(){
        String userPassword = Utils.getPassword();
        registrationPage.setInputName(Utils.getName());
        registrationPage.setInputMiddleName(Utils.getMiddleName());
        registrationPage.setInputLastName(Utils.getLastName());
        registrationPage.setInputPhoneNumber(Utils.getPhoneNumber());
        registrationPage.setInputEmail(Utils.getEmail());
        registrationPage.setInputPassword(userPassword);
        registrationPage.clickPasswordAgain();
        registrationPage.clickButtonSubmit();
        registrationPage.clickCheckboxPrivacyAgreement();
        registrationPage.clickButtonScrollNext();
        registrationPage.clickCheckboxAcceptAll();
        registrationPage.clickButtonConfirmAgreement();
        registrationPage.clickButtonSubmit();
        Assertions.assertEquals("Пароли не совпадают", registrationPage.getErrorMessagePasswordNotMatch());
    }


    @Test
    public void registrationWithDifferentPassword(){
        registrationPage.setInputName(Utils.getName());
        registrationPage.setInputMiddleName(Utils.getMiddleName());
        registrationPage.setInputLastName(Utils.getLastName());
        registrationPage.setInputPhoneNumber(Utils.getPhoneNumber());
        registrationPage.setInputEmail(Utils.getEmail());
        registrationPage.setInputPassword("1qaz!QAZ");
        registrationPage.setInputPasswordAgain("2wsx@WSX");
        registrationPage.clickButtonSubmit();
        registrationPage.clickCheckboxPrivacyAgreement();
        registrationPage.clickButtonScrollNext();
        registrationPage.clickCheckboxAcceptAll();
        registrationPage.clickButtonConfirmAgreement();
        registrationPage.clickButtonSubmit();
        Assertions.assertEquals("Пароли не совпадают", registrationPage.getErrorMessagePasswordNotMatch());
    }


    @Test
    public void registrationWithoutEmail(){
        String userPassword = Utils.getPassword();
        registrationPage.setInputName(Utils.getName());
        registrationPage.setInputMiddleName(Utils.getMiddleName());
        registrationPage.setInputLastName(Utils.getLastName());
        registrationPage.setInputPhoneNumber(Utils.getPhoneNumber());
        registrationPage.setInputPassword(userPassword);
        registrationPage.setInputPasswordAgain(userPassword);
        registrationPage.clickCheckboxPrivacyAgreement();
        registrationPage.clickButtonScrollNext();
        registrationPage.clickCheckboxAcceptAll();
        registrationPage.clickButtonConfirmAgreement();
        registrationPage.clickButtonSubmit();
        Assertions.assertTrue(registrationPage.isCodePageDisplayed(),
                "Переход на страницу ввода кода не произошел!");
    }


    @Test
    public void registrationWithoutAgreement(){
        String userPassword = Utils.getPassword();
        registrationPage.setInputName(Utils.getName());
        registrationPage.setInputMiddleName(Utils.getMiddleName());
        registrationPage.setInputLastName(Utils.getLastName());
        registrationPage.setInputPhoneNumber(Utils.getPhoneNumber());
        registrationPage.setInputEmail(Utils.getEmail());
        registrationPage.setInputPassword(userPassword);
        registrationPage.setInputPasswordAgain(userPassword);
        registrationPage.clickButtonSubmit();
        Assertions.assertEquals("Необходимо согласие", registrationPage.getErrorMessageNeedConfirm());
    }


    @Test
    public void ButtonBecomesClickableAfterCheckboxCabinetCreation(){
        registrationPage.clickCheckboxPrivacyAgreement();
        registrationPage.clickButtonScrollNext();
        registrationPage.clickCheckboxAcceptCabinetCreation();
        boolean isClickable = registrationPage.isButtonConfirmAgreementClickable();
        Assertions.assertTrue(isClickable, "Кнопка согласия должна стать кликабельной!");
        registrationPage.clickButtonConfirmAgreement();
    }

    @Test
    public void ButtonConfirmNotClickableWithoutAnyCheckbox(){
        registrationPage.clickCheckboxPrivacyAgreement();
        registrationPage.clickButtonScrollNext();
        boolean isClickable = registrationPage.isButtonConfirmAgreementClickable();
        Assertions.assertFalse(isClickable, "Кнопка согласия НЕ должна быть кликабельной!");
    }

    @Test
    public void ButtonComfirmNotClickableWithoutCheckboxCreateCabinet(){
        registrationPage.clickCheckboxPrivacyAgreement();
        registrationPage.clickButtonScrollNext();
        registrationPage.clickCheckboxAcceptNewsletterEmail();
        registrationPage.clickCheckboxAcceptPromoGames();
        registrationPage.clickCheckboxAcceptNewsletterViberSms();
        boolean isClickable = registrationPage.isButtonConfirmAgreementClickable();
        Assertions.assertFalse(isClickable, "Кнопка согласия НЕ должна быть кликабельной без выбора чекбокса Создание кабинета!");
    }

    @Test
    public void ButtonConfirmClickableAfterCheckboxAcceptAll(){
        registrationPage.clickCheckboxPrivacyAgreement();
        registrationPage.clickButtonScrollNext();
        registrationPage.clickCheckboxAcceptAll();
        boolean isClickable = registrationPage.isButtonConfirmAgreementClickable();
        Assertions.assertTrue(isClickable, "Кнопка согласия должна стать кликабельной!");
        registrationPage.clickButtonConfirmAgreement();
    }
}

