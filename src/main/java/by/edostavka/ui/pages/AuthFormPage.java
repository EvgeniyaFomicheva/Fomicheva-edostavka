package by.edostavka.ui.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthFormPage extends BasePage {
    private final String TITLE = "//h1[@class='wrapper_title__9r4Xa']";
    private final String INPUT_PHONE_NUMBER = "//input[@class='new-input-phone_input__XWAH5']";
    private final String BUTTON_GET_CODE = "//button[@class='btn btn_size_medium btn_colour_black login_button__zjbHA']";
    private final String BUTTON_LOG_IN_WITH_PASSWORD = "//button[contains(., 'Войти по паролю')]";
    private final String BUTTON_REGISTRATION = "//button[@class='btn btn_size_medium btn_colour_white login_button__zjbHA']";
    private final String AUTH_LOGO = "//a[@class='auth_logo__i9lsb']";
    private final String ERROR_MESSAGE_INCORRECT_NUMER = "//div[@class='new-input-phone_message__H_yAc']";
    private final String ERROR_MESSAGE_CHECK_CORRECT_NUMBER = "//div[@class='new-input-phone_message__H_yAc']";

    public AuthFormPage() {
        super();
    }

    public String getTitleText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TITLE))).getText();
    }

    public void setInputPhoneNumber(String number) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_PHONE_NUMBER))).sendKeys(number);
    }

    public void clickButtonGetCode() {
        driver.findElement(By.xpath(BUTTON_GET_CODE)).click();
    }

    public void clickButtonLogInWithPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_LOG_IN_WITH_PASSWORD))).click();
    }

    public void clickButtonRegistration() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_REGISTRATION))).click();
    }

    public String getErrorMessageIncorrectNumber() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ERROR_MESSAGE_INCORRECT_NUMER)));
        return error.getText();
    }

    public String getErrorMessageCheckCorrectMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ERROR_MESSAGE_CHECK_CORRECT_NUMBER))).getText();
    }

    public void clickAuthLogo(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(AUTH_LOGO))).click();
    }

}
