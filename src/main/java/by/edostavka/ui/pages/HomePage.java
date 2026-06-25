package by.edostavka.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    private final String URL = "https://edostavka.by/";
    private final String BUTTON_AUTH = "//button[@class='touchable_button__GJNQZ actions_action__button__OiPrx']";
    private final String INPUT_SEARCH = "//input[@class='search_search__input__G5mfm']";
    private final String BUTTON_SEARCH = "//button[@class='button button_size_large button_type_text button_icon search_search__button__4SRiK']";
    private final String COPY_RIGHTS = "//*[@id=\"footer\"]/div/div[3]/p[1]/span";
    private final String COOKIES = "//button[contains(@class, 'cookies_button')]";

    public HomePage() {
        super();
    }

    public void open() {
        driver.get(URL);
    }


    public void clickCookies() {
        WebElement cookies = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(COOKIES)));
        cookies.click();
    }

    public void clickButtonAuth() {
        WebElement buttonAuth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BUTTON_AUTH)));
        buttonAuth.click();
    }

    public void getCopyRights() {
        driver.findElement(By.xpath(COPY_RIGHTS)).getText();
    }

    public void fillInputSearch(String data) {
        driver.findElement(By.xpath(INPUT_SEARCH)).sendKeys(data);
    }

    public void clickButtonSearch() {
        driver.findElement(By.xpath(BUTTON_SEARCH)).click();
    }

}
