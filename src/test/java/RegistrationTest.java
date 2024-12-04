import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.pageobjects.ConstructorPage;
import org.example.pageobjects.LoginPage;
import org.example.pageobjects.RegistrationPage;
import org.example.utils.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.pageobjects.LoginPage.LOGIN_URL;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RegistrationTest extends BaseTest {

    public RegistrationTest(String browser) {
        super(browser);
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"chrome"},
                {"yandex"}
        };
    }
    @Step("Генерация имени")
    private String generateRandomName() {
        return "User_" + RandomStringUtils.randomAlphabetic(5);
    }
    @Step("Генерация Email")
    private String generateRandomEmail() {
        return RandomStringUtils.randomAlphabetic(10) + "@example.com";
    }
    @Step("Генерация пароля")
    private String generateRandomPassword() {
        return RandomStringUtils.randomAlphanumeric(8); // Генерируем пароль из 8 символов
    }
    @Step("Генерация пароля длинной 1 символ")
    private String generateSingleCharacterPassword() {
        return RandomStringUtils.randomAlphanumeric(1); // Генерируем пароль из 8 символов
    }

    @Test
    @DisplayName("Регистрация пользователя")
    @Description("Регистрация пользователя с валидными значениями")
    public void checkTransitionToConstructor() {
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.clickOnLoginButton();

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickOnRegistrationLink();

        String name = generateRandomName();
        String email = generateRandomEmail();
        String password = generateRandomPassword();

        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.setNameField(name);
        objRegistrationPage.setEmailField(email);
        objRegistrationPage.setPasswordField(password);
        objRegistrationPage.clickOnRegistrationButton();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe(LOGIN_URL));
        String actualUrl = driver.getCurrentUrl();
        assertEquals("URL должен соответствовать ожидаемому",LOGIN_URL,actualUrl);
    }


    @Test
    @DisplayName("Регистрация пользователя с паролем в один символ")
    @Description("Проверка регистрации с недопустимым паролем")
    public void checkRegistrationWithSingleCharacterPassword() {
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.clickOnLoginButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickOnRegistrationLink();

        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        String name = generateRandomName();
        String email = generateRandomEmail();
        String password = generateSingleCharacterPassword();

        objRegistrationPage.setNameField(name);
        objRegistrationPage.setEmailField(email);
        objRegistrationPage.setPasswordField(password);

        objRegistrationPage.clickOnRegistrationButton();

         String actualMessage = objRegistrationPage.getErrorMessageText();
         assertEquals("Сообщение должно совпадать","Некорректный пароль",actualMessage);
    }
}

