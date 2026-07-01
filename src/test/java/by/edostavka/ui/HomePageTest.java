package by.edostavka.ui;

import by.edostavka.ui.driver.Driver;
import by.edostavka.ui.pages.AuthFormPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTest extends BaseTest {
    private WebDriverWait wait;

    @BeforeEach
    public void setUpAuthFormPage() {
        homePage.clickCookies();
    }

    @Test
    @DisplayName("Успешный поиск сока Добрый и проверка заголовка выдачи")
    public void testSuccessfulSearchAndHeader() {
        String searchQuery = "Сок добрый";
        homePage.searchForText(searchQuery);
        homePage.clickButtonSearch();
        String headerText = homePage.getSearchResultsHeaderText();
        assertTrue(headerText.toLowerCase().contains("по запросу"),
                "Заголовок не содержит текст 'По запросу'. Получено: " + headerText);
        assertTrue(headerText.toLowerCase().contains(searchQuery.toLowerCase()),
                "Заголовок не содержит поисковый запрос. Получено: " + headerText);
    }


    @Test
    @DisplayName("Проверка соответствия первого товара поисковому запросу")
    public void testFirstResultContainsSearchQuery() {
        String searchQuery = "Coca-Cola";
        homePage.searchForText(searchQuery);
        homePage.clickButtonSearch();
        String firstItemText = homePage.getFirstResultText();
        assertTrue(firstItemText.toLowerCase().contains(searchQuery.toLowerCase()),
                "Первый товар в результатах поиска должен быть связан с " + searchQuery + ". Найдено: " + firstItemText);
    }


    @Test
    @DisplayName("Негативный тест: Поиск несуществующего товара")
    public void testSearchForNonExistentProduct() {
        String invalidQuery = "xyz123abcnonexistent";
        homePage.searchForText(invalidQuery);
        homePage.clickButtonSearch();
        String emptyMessage = homePage.getEmptyResultMessage();
        assertTrue(emptyMessage.toLowerCase().contains("ничего не нашлось"),
                "Ожидался текст 'Ничего не нашлось', но на странице отобразилось: " + emptyMessage);
    }

    @Test
    @DisplayName("Негативный тест: Поиск по пустому запросу")
    public void testSearchWithEmptyInput() {
        String urlBeforeSearch = Driver.getDriver().getCurrentUrl();
        homePage.searchForText("");
        homePage.clickButtonSearch();
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
        String urlAfterSearch = Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(urlBeforeSearch, urlAfterSearch,
                "Форма отправилась! Произошел переход или перезагрузка страницы при пустом поиске.");
    }


    @Test
    @DisplayName("Check footer displays expected copyright text")
    public void testCopyrightTextIsDisplayed() {
        String expectedCopyrightText = "© 2014-2026 Закрытое акционерное общество «Интернет-магазин Евроопт». Все права защищены. Дата государственной регистрации: 05.02.2013. Регистрационный номер в ЕГР: 691536217, место нахождения: 220019, Республика Беларусь, Минская область, Минский район, Щомыслицкий с/с, Западный промузел ТЭЦ-4, кабинет 229. Почтовый адрес ЗАО «Интернет-магазин Евроопт»: 220019, г. Минск, а/я 19. Онлайн-супермаркет edostavka.by. Режим работы: круглосуточно. Дата регистрации и регистрационный номер в Торговом реестре: 23.06.2022 | 536329. Адрес электронной почты: info@e-dostavka.by";
        assertEquals(expectedCopyrightText, homePage.getCopyRights());
    }


}
