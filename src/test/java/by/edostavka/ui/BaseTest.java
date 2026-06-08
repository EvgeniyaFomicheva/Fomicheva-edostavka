package by.edostavka.ui;

import by.edostavka.ui.driver.Driver;
import by.edostavka.ui.pages.AuthFormPage;
import by.edostavka.ui.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected AuthFormPage authFormPage;

   @BeforeEach
  public void beforeEach() {
      homePage = new HomePage();
       homePage.open();
   }

    @AfterEach
   public void afterEach() {
       Driver.quitDriver();
    }
}
