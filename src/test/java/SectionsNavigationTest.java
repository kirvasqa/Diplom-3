import io.qameta.allure.Description;
import org.assertj.core.api.SoftAssertions;
import io.qameta.allure.junit4.DisplayName;
import org.example.pageobjects.ConstructorPage;
import org.example.utils.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@RunWith(Parameterized.class)
public class SectionsNavigationTest  extends BaseTest {
    public SectionsNavigationTest (String browser) {
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
    @DisplayName("Проверка раздела БУЛКИ")
    @Description("Проверить, что заголовок 'Булки' и 'Соусы' виден, а 'Начинки' скрыты")
    public void checkBunsSection() {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        SoftAssertions softAssertions = new SoftAssertions();

        constructorPage.clickOnSaucesSection();
        new WebDriverWait(driver, Duration.ofSeconds(5));
        constructorPage.clickOnBunsSection();


        Point bunsHeaderPosition = constructorPage.getBunsHeaderPositionIfVisible();
        softAssertions.assertThat(bunsHeaderPosition)
                .as("Заголовок 'Булки' должен быть видим")
                .isNotNull();


        Point saucesHeaderPosition = constructorPage.getSaucesHeaderPositionIfVisible();
        softAssertions.assertThat(saucesHeaderPosition)
                .as("Заголовок 'Соусы' должен быть видим")
                .isNotNull();


        Point fillingsHeaderPosition = constructorPage.getFillingsHeaderPositionIfVisible();
        softAssertions.assertThat(fillingsHeaderPosition)
                .as("Заголовок 'Начинки' не должен быть видим")
                .isNull();

        softAssertions.assertAll();
    }

    @Test
    @DisplayName("Проверка раздела СОУСЫ")
    @Description("Проверить, что заголовок 'Соусы' и 'Начинки' виден, а 'Булки' скрыты")
    public void checkSaucesSection() {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        SoftAssertions softAssertions = new SoftAssertions();

        constructorPage.clickOnSaucesSection();


        Point saucesHeaderPosition = constructorPage.getSaucesHeaderPositionIfVisible();
        softAssertions.assertThat(saucesHeaderPosition)
                .as("Заголовок 'Соусы' должен быть видим и его координаты не должны быть равны null")
                .isNotNull();


        Point bunsHeaderPosition = constructorPage.getBunsHeaderPositionIfVisible();
        softAssertions.assertThat(bunsHeaderPosition)
                .as("Заголовок 'Булки' не должен быть видим") // здесь исправлено
                .isNull();


        Point fillingsHeaderPosition = constructorPage.getFillingsHeaderPositionIfVisible();
        softAssertions.assertThat(fillingsHeaderPosition)
                .as("Заголовок 'Начинки' должен быть видим и его координаты не должны быть равны null")
                .isNotNull();

        softAssertions.assertAll();
    }

    @Test
    @DisplayName("Проверка раздела НАЧИНКИ")
    @Description("Проверить, что заголовок 'Начинки' виден, а 'Булки' и 'Соусы' скрыты")
    public void checkFillingsSection() {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        SoftAssertions softAssertions = new SoftAssertions();

        constructorPage.clickOnFillingsSection();


        Point fillingsHeaderPosition = constructorPage.getFillingsHeaderPositionIfVisible();
        softAssertions.assertThat(fillingsHeaderPosition)
                .as("Заголовок 'Начинки' должен быть видим и его координаты не должны быть равны null")
                .isNotNull();


        Point bunsHeaderPosition = constructorPage.getBunsHeaderPositionIfVisible();
        softAssertions.assertThat(bunsHeaderPosition)
                .as("Заголовок 'Булки' не должен быть видим")
                .isNull();


        Point saucesHeaderPosition = constructorPage.getSaucesHeaderPositionIfVisible();
        softAssertions.assertThat(saucesHeaderPosition)
                .as("Заголовок 'Соусы' не должен быть видим")
                .isNull();

        softAssertions.assertAll();
    }
}
