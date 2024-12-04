package org.example.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage {

    private final WebDriver driver;

    public static final String PERSONAL_ACCOUNT_URL = "https://stellarburgers.nomoreparties.site/account/profile";

    private final By exitButton = By.xpath("//*[@id=\"root\"]/div/main/div/nav/ul/li[3]/button");

    private final By constructorButton = By.xpath(".//li[1]/a/p[text()='Конструктор']");

    public PersonalAccountPage (WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать на кнопку Выйти")
    public void clickOnExitButton() {
        driver.findElement(exitButton).click();
    }

    @Step("Нажать на кнопку 'Конструктор'")
    public void clickOnConstructorButton() {
        driver.findElement(constructorButton).click();
    }
}
