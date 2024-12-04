package org.example.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.*;


public class ConstructorPage { // Указываем public для доступа из других пакетов

    private final WebDriver driver;

    public static final String CONSTRUCTOR_URL = "https://stellarburgers.nomoreparties.site/";

    private final By personalAccountButton = By.xpath(".//header/nav/a");

    private final By loginButton = By.xpath(".//section[2]/div/button[text()='Войти в аккаунт']");

    private final By createOrderButton = By.xpath(".//section[2]/div/button[text()='Оформить заказ']");

    private final By bunsSection = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]");
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


    @Step("Проверить, что заголовок 'Булки' виден и вернуть его координаты")
    public Point getBunsHeaderPositionIfVisible() {
        return getElementPositionIfVisible(bunsHeader);
    }

    @Step("Проверить, что заголовок 'Соусы' виден и вернуть его координаты")
    public Point getSaucesHeaderPositionIfVisible() {
        return getElementPositionIfVisible(saucesHeader);
    }

    @Step("Проверить, что заголовок 'Начинки' виден и вернуть его координаты")
    public Point getFillingsHeaderPositionIfVisible() {
        return getElementPositionIfVisible(fillingsHeader);
    }

    private Point getElementPositionIfVisible(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            if (element.isDisplayed()) {
                return element.getLocation();
            } else {
                return null; // Элемент не видим
            }
        } catch (NoSuchElementException e) {
            return null; // Элемент не найден
        }
    }
}