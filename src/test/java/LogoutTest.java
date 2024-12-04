import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.pageobjects.ConstructorPage;
import org.example.pageobjects.LoginPage;
import org.example.pageobjects.PersonalAccountPage;
import org.example.utils.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.pageobjects.LoginPage.LOGIN_URL;
import static org.example.pageobjects.PersonalAccountPage.PERSONAL_ACCOUNT_URL;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LogoutTest extends BaseTest {

    public LogoutTest(String browser) {
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
    @DisplayName("Выход из аккаунта")
    @Description("Проверка выхода из аккаунта путём сравнения текста кнопки")
    public void checkLogout(){
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.clickOnLoginButton();

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.setEmail();
        objLoginPage.setPassword();
        objLoginPage.clickOnLoginButton();

        objConstructorPage.clickOnPersonalAccountButton();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe(PERSONAL_ACCOUNT_URL));

        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        objPersonalAccountPage.clickOnExitButton();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe(LOGIN_URL));

        String currentUrl = driver.getCurrentUrl();
        assertEquals("URL страницы не совпадает с ожидаемым", LOGIN_URL, currentUrl);

        objLoginPage.clickOnConstructorButton();

        String actualText = objConstructorPage.getLoginButtonText();
        assertEquals("Текст кнопки не соответствует ожидаемому", "Войти в аккаунт", actualText);


    }
}
