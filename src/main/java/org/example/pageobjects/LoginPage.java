package org.example.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage { // Добавим public модификатор доступа

    private final WebDriver driver;

    public static final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";

    private final By registrationLink = By.xpath(".//div/p[1]/a[text()='Зарегистрироваться']");

    private final By loginHeader = By.xpath(".//main/div/h2[text()='Вход']");

    private final By emailField = By.xpath(".//div/div/input[@type='text']");

    private final By passwordField = By.xpath(".//div/div/input[@name='Пароль']");

    private final By loginButton = By.xpath(".//div/form/button[text()='Войти']");

    private final By passwordRecoveryLink= By.xpath(".//div/p[2]/a[text()='Восстановить пароль']");

    private final By constructorButton = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a/p");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать на ссылку Регистрация")
    public void clickOnRegistrationLink() {
        driver.findElement(registrationLink).click();
    }
    @Step("Ввести тестовое значение в поле Email")
    public void setEmail() {
        driver.findElement(emailField).sendKeys("kirtest123@yandex.ru");
    }
    @Step("Ввести тестовое значение в поле Password")
    public void setPassword() {
        driver.findElement(passwordField).sendKeys("password");
    }
    @Step("Нажать на кнопку 'Войти'")
    public void clickOnLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Нажать на ссылку Восстановить пароль")
    public void clickOnPasswordRecoveryLink() {
        driver.findElement(passwordRecoveryLink).click();
    }
    @Step("Нажать на кнопку 'Конструктор'")
    public void clickOnConstructorButton() {
        driver.findElement(constructorButton).click();
    }
}