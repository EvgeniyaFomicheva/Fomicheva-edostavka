package by.edostavka.ui.pages;

import by.edostavka.ui.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected static final Logger logger = LogManager.getLogger();

    public BasePage() {
        this.driver = Driver.getDriver();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }
}
