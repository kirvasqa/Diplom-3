import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.pageobjects.LoginPage;
import org.example.utils.BaseTest;
import org.example.pageobjects.ConstructorPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.pageobjects.ConstructorPage.CONSTRUCTOR_URL;
import static org.example.pageobjects.PersonalAccountPage.PERSONAL_ACCOUNT_URL;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class TransitionToPersonalAccountTest extends BaseTest {

    public TransitionToPersonalAccountTest(String browser) {
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
    @DisplayName("Вход в личный кабинет")
    @Description("Проверка перехода в личный кабинет")
    public void checkPersonalAccount() {

        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.clickOnLoginButton();

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.setEmail();
        objLoginPage.setPassword();
        objLoginPage.clickOnLoginButton();

        objConstructorPage.clickOnPersonalAccountButton();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe(PERSONAL_ACCOUNT_URL));


        String actualURL = driver.getCurrentUrl();

        assertEquals("URL страницы не совпадает с ожидаемым",PERSONAL_ACCOUNT_URL,actualURL);
    }
}