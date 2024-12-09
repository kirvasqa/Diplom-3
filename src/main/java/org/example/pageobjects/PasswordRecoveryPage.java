package org.example.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {
    private final WebDriver driver;

    public static final String PASSWORD_RECOVERY_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    private final By loginLink = By.xpath(".//div/p/a[text()='Войти']");

    public PasswordRecoveryPage (WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать на ссылку Войти")
    public void clickOnLoginLink() {
        driver.findElement(loginLink).click();
    }

}
