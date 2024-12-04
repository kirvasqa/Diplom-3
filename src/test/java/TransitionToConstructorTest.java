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

import static org.example.pageobjects.PersonalAccountPage.PERSONAL_ACCOUNT_URL;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TransitionToConstructorTest extends BaseTest {

    public TransitionToConstructorTest (String browser) {
        super(browser);
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"chrome"},
                {"yandex"}
        };
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    @Description("Проверка перехода в конструктор путём проверки текста кнопки 'Оформить заказ' ")
    public void checkTransitionToConstructor(){
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
        objPersonalAccountPage.clickOnConstructorButton();

        String actualText = objConstructorPage.getCreateOrderButtonText();

        assertEquals("Текст не совпадает с ожидаемым","Оформить заказ", actualText);

    }
}
