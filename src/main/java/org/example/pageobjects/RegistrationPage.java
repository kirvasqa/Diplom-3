package org.example.pageobjects;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage  {

    private final WebDriver driver;

    public static final String REGISTRATION_URL = "https://stellarburgers.nomoreparties.site/register";

    private final By loginLink = By.xpath(".//div/p/a[text()='Войти']");

    private final By nameField = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    private final By emailField = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    private final By passwordField = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input");
    private final By registrationButton = By.xpath(".//div/form/button[text()='Зарегистрироваться']");
    private final By errorMessage = By.xpath(".//fieldset[3]/div/p[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Нажать на ссылку 'Войти'")
    public void clickOnLoginLink() {
        driver.findElement(loginLink).click();
    }

    @Step("Ввести значение в поле 'Имя'")
    public void setNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    @Step("Ввести значение в поле 'Email'")
    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    @Step("Ввести значение в поле 'Пароль'")
    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    @Step("Нажать на ссылку 'Зарегистрироваться'")
    public void clickOnRegistrationButton() {
        driver.findElement(registrationButton).click();
    }
    @Step ("Получить текст 'Сообщения об ошибке' ")
    public String getErrorMessageText() {
        WebElement errorMsg = driver.findElement(errorMessage);
        return errorMsg.getText();
    }
}
