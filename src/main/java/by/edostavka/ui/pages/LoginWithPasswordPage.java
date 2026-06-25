package by.edostavka.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginWithPasswordPage extends BasePage {
    final private String TITLE = "//h1[@class='wrapper_title__9r4Xa']";
    final private String INPUT_PHONE_NUMBER = "//input[@class='new-input-phone_input__XWAH5']";
    final private String INPUT_PASSWORD = "//input[@class='input_input___r0Z7 input_input_size_medium__00yqU']";
    final private String BUTTON_SUBMIT = "//button[@class='btn btn_size_medium btn_colour_black password_button__Pt0gU password_enter_button__8JmbR']";
    final private String BUTTON_LOGIN_WIHT_PHONE_NUMBER = "//button[@class='btn btn_size_medium btn_colour_black btn_type_secondary password_button__Pt0gU password_enter_phone_button__S9Fzj']";
    final private String BUTTON_REGISTRATION = "//button[@class='btn btn_size_medium btn_colour_white password_button__Pt0gU']";
    final private String BUTTON_FORGOT_PASSWORD = "//a[@class='password_forget_password__3_z8M']";
    final private String BUTTON_SHOW_PASSORD = "//div[@class='input_clickable__oKJEf']";
    final private String AUTH_LOGO = "//a[@class='auth_logo__i9lsb']";
    final private String ERROR_MESSAGE = "//div[@class='password_error_message__KRNDP']";


    public LoginWithPasswordPage() {
        super();
    }

    public String getTitleText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TITLE))).getText();
    }

    public void setInputPhoneNumber(String number) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_PHONE_NUMBER))).sendKeys(number);
    }

    public void setInputPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_PASSWORD))).sendKeys(password);
    }

    public void clickButtonSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_SUBMIT))).click();
    }

    public void clickButtonLoginWithPhoneNumber() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_LOGIN_WIHT_PHONE_NUMBER))).click();
    }

    public void clickButtonRegistration() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_REGISTRATION))).click();
    }

    public void clickButtonForgotPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_FORGOT_PASSWORD))).click();
    }

    public void clickButtonShowPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_SHOW_PASSORD))).click();
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ERROR_MESSAGE))).getText();
    }

    public void clickAuthLogo(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(AUTH_LOGO))).click();
    }
}
