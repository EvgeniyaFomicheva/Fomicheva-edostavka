package by.edostavka.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage {
    private final String TITLE = "//h1[contains(text(), \"Регистрация\")]";
    private final String CHECKBOX_EDOSTAVKA = "//p[contains(@class, \"consent-form_service_name\") and contains(text(), \"edostavka.by\")]";
    private final String CHECKBOX_EMAIL_BY = "//li[@aria-label=\"emall.by\"]";
    private final String CHECKBOX_EVROPOCHTA_BY = "//li[@aria-label=\"evropochta.by\"]";
    private final String CHECKBOX_EVEZUNCHIKI = "//li[@aria-label=\"Е-везунчики\"]\n";
    private final String FIELD_NAME = "//input[@name=\"name\" and @autocomplete=\"given-name\"]\n";
    private final String FIELD_LASTNAME = "//input[@name=\"surname\" and @autocomplete=\"family-name\"]\n";
    private final String FIELD_MIDDLENAME = "//input[@class=\"input_input___r0Z7 input_input_size_medium__00yqU\" and @name=\"patronymic\"]\n";
    private final String FIELD_PHONE_NUMBER = "//input[contains(@class, \"new-input-phone_input\")]\n";
    private final String FIELD_EMAIL = "//input[@name=\"email\" and @autocomplete=\"email\"]\n";
    private final String FIELD_PASSWORD = "//input[@name=\"password\" and @type=\"password\"]";
    private final String FIELD_PASSWORD_AGAIN = "//input[@type=\"password\" and @name=\"passwordAgain\"]";
    private final String CHECKBOX_PRIVACY_AGREEMENT = "//*[@id=\"__next\"]/div[1]/div/div/div[1]/form/div[3]/div/label/span/i";
    private final String TEXT_PRIVECY_AGREEMENT = "//a[@href='https://api2.edostavka.by/files/personal_data_policy.pdf' and contains(text(), 'политикой обработки')]\n";
    private final String BUTTON_SUBMIT = "//button[@type='submit' and .//span[text()='Далее']]\n";
    private final String AGGREMENT_CONFIRM_PAGE = "https://edostavka.by/registration#modal-opened";
    private final String BUTTON_SCROLL_NEXT = "//button[contains(@class, 'policy-consent') and .//span[text()='Далее']]";
    private final String CHECKBOX_ACCEPT_CABINET_CREATION = "//span[contains(@class, 'policy-consent_target_name')]//p[normalize-space()='Создание и администрирование личного кабинета']";
    private final String CHECKBOX_ACCEPT_NEWSLETTER_VIBER_SMS = "//span[contains(@class, 'policy-consent_target_name')]//p[normalize-space()='Новостные и рекламные рассылки SMS/Viber']";
    private final String CHECKBOX_ACCEPT_NEWSLETTER_EMAIL = "//span[contains(@class, 'policy-consent_target_name')]//p[normalize-space()='Новостные и рекламные рассылки E-mail']";
    private final String CHECKBOX_ACCEPT_PROMO_GAMES = "//p[normalize-space()='Участие в рекламных играх Организации и ее партнеров']";
    private final String CHECKBOX_ACCEPT_ALL = "//label[contains(@class, 'policy-consent_checkbox') and following-sibling::text()[contains(., 'Выбрать все')]]";
    private final String BUTTON_CONFIRM_AGREEMENT = "//button[span[text()='Согласен']]";
    private final String BUTTON_DISSAGREEMENT = "//button[span[text()='Не согласен']]";
    private final String BUTTON_CLOSE = "//i[contains(@class, 'icon-close-24')]";
    private final String ERROR_MESSAGE_EMPTY_NAME = "//div[text()='Поле имя обязательно для заполнения']";
    private final String ERROR_MESSAGE_EMPTY_LASTNAME = "//div[text()='Поле фамилия обязательно для заполнения']";
    private final String ERROR_MESSAGE_EMPTY_PHONENUMBER = "//div[contains(@class, 'new-input-phone_message') and normalize-space()='Поле номер телефона обязательно для заполнения']";
    private final String ERROR_MESSAGE_WITHOUT_PASWORD = "//span[contains(@class, 'error_error_wrap_description') and normalize-space()='Создание пароля обязательно']";
    private final String ERROR_MESSAGE_PASSWORD_NOT_MATCH = "//span[contains(@class, 'error_error_wrap_description') and normalize-space()='Пароли не совпадают']";
    private final String ERROR_MESSAGE_NEED_CONFIRM = "//span[contains(@class, 'error_error_wrap_description') and normalize-space()='Необходимо согласие']";
    private final String FIELD_CODE = "//h1[text()='Введите код']";


   public RegistrationPage(){
       super();
   }

    public String getTitleText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TITLE))).getText();
    }

    public void setInputName(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FIELD_NAME))).sendKeys(name);
    }

    public void setInputLastName(String surname){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FIELD_LASTNAME))).sendKeys(surname);
    }

    public void setInputMiddleName(String secondname){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FIELD_MIDDLENAME))).sendKeys(secondname);
    }


    public void setInputPhoneNumber(String number) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FIELD_PHONE_NUMBER))).sendKeys(number);
    }

    public void setInputEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FIELD_EMAIL))).sendKeys(email);
    }

    public void setInputPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FIELD_PASSWORD))).sendKeys(password);
    }

    public void setInputPasswordAgain(String passwordAgain) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FIELD_PASSWORD_AGAIN))).sendKeys(passwordAgain);
    }

    public void clickCheckboxEdostavka(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHECKBOX_EDOSTAVKA))).click();
    }

    public void clickCheckboxEmailBy(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHECKBOX_EMAIL_BY))).click();
    }

    public void clickCheckboxEvropochtaBy(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHECKBOX_EVROPOCHTA_BY))).click();
    }

    public void clickCheckboxEvezunchiki(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHECKBOX_EVEZUNCHIKI))).click();
    }

    public void clickCheckboxPrivacyAgreement(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHECKBOX_PRIVACY_AGREEMENT))).click();
    }

    public void clickTextPrivacyAgreement(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TEXT_PRIVECY_AGREEMENT))).click();
    }

    public void clickButtonSubmit(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_SUBMIT))).click();
    }

    public void clickButtonScrollNext(){
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_SCROLL_NEXT))).click();
    }

    public void clickCheckboxAcceptCabinetCreation(){
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHECKBOX_ACCEPT_CABINET_CREATION))).click();
    }

    public void clickCheckboxAcceptNewsletterViberSms(){
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHECKBOX_ACCEPT_NEWSLETTER_VIBER_SMS))).click();
    }

    public void clickCheckboxAcceptNewsletterEmail(){
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHECKBOX_ACCEPT_NEWSLETTER_EMAIL))).click();
    }

    public void clickCheckboxAcceptPromoGames(){
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHECKBOX_ACCEPT_PROMO_GAMES))).click();
    }

    public void clickCheckboxAcceptAll(){
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHECKBOX_ACCEPT_ALL))).click();
    }

    public void clickButtonConfirmAgreement(){
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_CONFIRM_AGREEMENT))).click();
    }

    public void clickButtonDisagreement(){
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_DISSAGREEMENT))).click();
    }

    public void clickButtonClose(){
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_CLOSE))).click();
    }

    public String getErrorMessageEmptyName(){
      return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ERROR_MESSAGE_EMPTY_NAME))).getText();
    }

    public String getErrorMessageEmptyLastName(){
        By lastNameErrorLocator = By.xpath(ERROR_MESSAGE_EMPTY_LASTNAME);
        String expectedText = "Поле фамилия обязательно для заполнения";
        wait.until(ExpectedConditions.textToBePresentInElementLocated(lastNameErrorLocator, expectedText));
        return driver.findElement(lastNameErrorLocator).getText();
    }

    public String getErrorMessageEmptyPhonenumber(){
       return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ERROR_MESSAGE_EMPTY_PHONENUMBER))).getText();
    }

    public String getErrorMessageWithoutPassword(){
       return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ERROR_MESSAGE_WITHOUT_PASWORD))).getText();
    }

    public String getErrorMessagePasswordNotMatch(){
       return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ERROR_MESSAGE_PASSWORD_NOT_MATCH))).getText();
    }

    public String getErrorMessageNeedConfirm(){
       return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ERROR_MESSAGE_NEED_CONFIRM))).getText();
    }

    public void clickLastName(){
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FIELD_LASTNAME))).click();
    }

    public void clickPhoneNumber(){
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FIELD_PHONE_NUMBER))).click();
    }

    public void clickName(){
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FIELD_NAME))).click();
    }

    public void clickPassword(){
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FIELD_PASSWORD))).click();
    }

    public void clickPasswordAgain(){
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FIELD_PASSWORD_AGAIN))).click();
    }

    public boolean isButtonConfirmAgreementClickable() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_CONFIRM_AGREEMENT)));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }


    public boolean isCodePageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FIELD_CODE))).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
