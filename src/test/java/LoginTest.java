import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.pageobjects.ConstructorPage;
import org.example.pageobjects.LoginPage;
import org.example.pageobjects.PasswordRecoveryPage;
import org.example.pageobjects.RegistrationPage;
import org.example.utils.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.pageobjects.LoginPage.LOGIN_URL;
import static org.example.pageobjects.ConstructorPage.CONSTRUCTOR_URL;
import static org.example.pageobjects.PasswordRecoveryPage.PASSWORD_RECOVERY_URL;
import static org.example.pageobjects.RegistrationPage.REGISTRATION_URL;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LoginTest extends BaseTest {

    // Конструктор для передачи браузера
    public LoginTest(String browser) {
        super(browser);
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {"chrome"},
                {"yandex"}
        };
    }



    @Test
    @DisplayName("Логин через кнопку 'Войти в аккаунт'")
    @Description("Проверка возможности авторизации после нажатия на кнопку 'Войти в аккаунт'")
    public void checkLoginViaLoginButton() {
        ConstructorPage objConstructorPage = new ConstructorPage(driver);

        objConstructorPage.clickOnLoginButton();

        String currentUrl = driver.getCurrentUrl();
        assertEquals("URL страницы не совпадает с ожидаемым", LOGIN_URL, currentUrl);

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.setEmail();
        objLoginPage.setPassword();
        objLoginPage.clickOnLoginButton();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe(CONSTRUCTOR_URL));

        currentUrl = driver.getCurrentUrl();
        assertEquals("URL страницы не совпадает с ожидаемым", CONSTRUCTOR_URL, currentUrl);
    }




    @Test
    @DisplayName("Логин через ссылку в форме регистрации")
    @Description("Проверка возможности авторизации после нажатия на ссылку 'Зарегистрироваться'")
    public void checkLoginViaRegistrationLink() {
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.clickOnPersonalAccountButton();
        String currentUrl = driver.getCurrentUrl();
        assertEquals("URL страницы не совпадает с ожидаемым", LOGIN_URL, currentUrl);

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickOnRegistrationLink();
        currentUrl = driver.getCurrentUrl();
        assertEquals("URL страницы не совпадает с ожидаемым", REGISTRATION_URL, currentUrl);

        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.clickOnLoginLink();
        currentUrl = driver.getCurrentUrl();
        assertEquals("URL страницы не совпадает с ожидаемым", LOGIN_URL, currentUrl);

        objLoginPage.setEmail();
        objLoginPage.setPassword();
        objLoginPage.clickOnLoginButton();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe(CONSTRUCTOR_URL));

        currentUrl = driver.getCurrentUrl();
        assertEquals("URL страницы не совпадает с ожидаемым", CONSTRUCTOR_URL, currentUrl);
    }
    @Test
    @DisplayName("Логин через ссылку в форме восстановления пароля")
    @Description("Проверка возможности авторизации после нажатия на ссылку 'Восстановить пароль'")
    public void checkLoginViaPasswordRecoveryLink() {
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.clickOnPersonalAccountButton();
        String currentUrl = driver.getCurrentUrl();
        assertEquals("URL страницы не совпадает с ожидаемым", LOGIN_URL, currentUrl);

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickOnPasswordRecoveryLink();
        currentUrl = driver.getCurrentUrl();
        assertEquals("URL страницы не совпадает с ожидаемым", PASSWORD_RECOVERY_URL, currentUrl);


        PasswordRecoveryPage objPasswordRecoveryPage = new PasswordRecoveryPage(driver);
        objPasswordRecoveryPage.clickOnLoginLink();
        currentUrl = driver.getCurrentUrl();
        assertEquals("URL страницы не совпадает с ожидаемым", LOGIN_URL, currentUrl);

        objLoginPage.setEmail();
        objLoginPage.setPassword();
        objLoginPage.clickOnLoginButton();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe(CONSTRUCTOR_URL));

        currentUrl = driver.getCurrentUrl();
        assertEquals("URL страницы не совпадает с ожидаемым", CONSTRUCTOR_URL, currentUrl);
    }
}