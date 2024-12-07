package org.example.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


public class ConstructorPage {

    private final WebDriver driver;
    private String browser;

    public static final String CONSTRUCTOR_URL = "https://stellarburgers.nomoreparties.site/";

    private final By personalAccountButton = By.xpath(".//header/nav/a");

    private final By loginButton = By.xpath(".//section[2]/div/button[text()='Войти в аккаунт']");

    private final By createOrderButton = By.xpath(".//section[2]/div/button[text()='Оформить заказ']");

    private final By bunsSection = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[1]");
    private final By saucesSection = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[2]");
    private final By fillingsSection = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[3]");

    private final By bunsHeader = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[2]/h2[1]");
    private final By saucesHeader = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[2]/h2[2]");
    private final By fillingsHeader = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[2]/h2[3]");

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать на кнопку 'Личный кабинет'")
    public void clickOnPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Нажать на кнопку 'Войти в аккаунт'")
    public void clickOnLoginButton() {
        driver.findElement(loginButton).click();
    }
    @Step("Получить текст кнопки 'Войти в аккаунт'")
    public String getLoginButtonText() {
        WebElement loginBtnElement = driver.findElement(loginButton);
        return loginBtnElement.getText();
    }

    @Step("Получить текст кнопки 'Оформить заказ'")
    public String getCreateOrderButtonText() {
        WebElement createOrderBtnElement = driver.findElement(createOrderButton);
        return createOrderBtnElement.getText();
    }

    @Step("Нажать на раздел 'Булки'")
    public void clickOnBunsSection() {
        driver.findElement(bunsSection).click();
    }

    @Step("Нажать на раздел 'Соусы'")
    public void clickOnSaucesSection() {
        driver.findElement(saucesSection).click();
    }

    @Step("Нажать на раздел 'Начинки'")
    public void clickOnFillingsSection() {
        driver.findElement(fillingsSection).click();
    }
@Step("Инициализация ожидаемых координат заголовка 'Булки' для браузера {browser}")
    public Point setInitialHeaderCoordinates(String browser) {
        if (browser.equals("chrome")) {
            // Возвращаем координаты для Chrome
            return new Point(340, 243);
        } else if (browser.equals("yandex")) {
            // Возвращаем координаты для Yandex
            return new Point(316, 243);
        } else {
            // Обработка случая, если браузер не распознан (На случай если буду использовать такое в дальнейшем)
            throw new IllegalArgumentException("Неизвестный тип браузера: " + browser);
        }
    }

    @Step("Получить координаты заголовка 'Булки'")
    public Point getBunsHeaderPosition() {
        return getHeaderPosition(bunsHeader);
    }

    @Step("Получить координаты заголовка 'Соусы'")
    public Point getSaucesHeaderPosition() {
        return getHeaderPosition(saucesHeader);
    }

    @Step("Получить координаты заголовка 'Начинки'")
    public Point getFillingsHeaderPosition() {
        return getHeaderPosition(fillingsHeader);
    }

    private Point getHeaderPosition(By headerLocator) {
        try {
            WebElement headerElement = driver.findElement(headerLocator);
            return headerElement.getLocation();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}