package org.example.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverCreator {

    public static WebDriver createWebDriver() {
        String browser = System.getProperty("browser", "chrome"); // По умолчанию использовать Chrome
        switch (browser) {
            case "yandex":
                return createYandexDriver();
            case "chrome":
            default:
                return createChromeDriver();
        }
    }

    private static WebDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup(); // Установка драйвера
        return new ChromeDriver(options);
    }

    private static WebDriver createYandexDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary(System.getenv("YANDEX_BROWSER_PATH"));
        WebDriverManager.chromedriver().driverVersion("128").setup();  // Установка драйвера
        return new ChromeDriver(options);
    }
}