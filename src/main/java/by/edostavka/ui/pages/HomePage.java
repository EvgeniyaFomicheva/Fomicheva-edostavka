package by.edostavka.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    private final String URL = "https://edostavka.by/";
    private final String BUTTON_AUTH = "//button[@class='touchable_button__GJNQZ actions_action__button__OiPrx']";
    private final String INPUT_SEARCH = "//input[@placeholder='Поиск товаров']";
    private final String BUTTON_SEARCH = "//button[.//span[text()='Поиск']]";
    private final String FIRST_RESULT_ITEM = "(//a[@role='button' and contains(@class, 'vertical_title')])[1]";
    private final String SEARCH_RESULTS_HEADER = "//h1[contains(@class, 'heading_heading__text') and contains(text(), 'По запросу')]";
    private final String EMPTY_SEARCH_RESULT_MESSAGE = "//h3[contains(@class, 'heading_heading__text') and contains(text(), 'Ничего не нашлось')]";
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

    public String getCopyRights() {
        String copyrightsText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(COPY_RIGHTS))).getText();
        return copyrightsText;
    }

    public void searchForText(String textSearch) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(INPUT_SEARCH)));
        input.clear();
        input.sendKeys(textSearch);
    }


    public void clickButtonSearch() {
        driver.findElement(By.xpath(BUTTON_SEARCH)).click();
    }


    public String getFirstResultText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FIRST_RESULT_ITEM))).getText();
    }

    public String getSearchResultsHeaderText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SEARCH_RESULTS_HEADER))).getText();
    }

    public String getEmptyResultMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EMPTY_SEARCH_RESULT_MESSAGE))).getText();
    }

}