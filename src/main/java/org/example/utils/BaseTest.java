package org.example.utils;

import io.qameta.allure.Allure;
import org.junit.After;
import org.junit.Before;

import org.openqa.selenium.WebDriver;
import org.example.driver.WebDriverCreator;


public abstract class BaseTest {
    protected WebDriver driver;
    final String URL = "https://stellarburgers.nomoreparties.site/";
    protected String browser; // Параметр браузера

    public BaseTest(String browser) {
        this.browser = browser;
    }

    @Before
    public void setUp() {
        // Установка параметра браузера
        System.setProperty("browser", browser);
        driver = WebDriverCreator.createWebDriver();
        driver.get(URL);
        Allure.addAttachment("Текущий браузер", browser);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
