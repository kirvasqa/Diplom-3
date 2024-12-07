import org.assertj.core.api.SoftAssertions;
import io.qameta.allure.junit4.DisplayName;
import org.example.pageobjects.ConstructorPage;
import org.example.utils.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Point;


@RunWith(Parameterized.class)
public class SectionsNavigationTest  extends BaseTest {
    public SectionsNavigationTest(String browser) {
        super(browser);
        this.browser = browser;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"chrome"},
                {"yandex"}
        };
    }


    @Test
    @DisplayName("Проверка координат заголовка 'Булки' после переходов")
    public void testBunsHeaderCoordinatesAfterSwitchingSections() throws  InterruptedException { // Укажите правильное исключение
        ConstructorPage constructorPage = new ConstructorPage(driver);
        SoftAssertions softly = new SoftAssertions();


        Point expectedCoordinates = constructorPage.setInitialHeaderCoordinates(browser);



        constructorPage.clickOnSaucesSection();
        Thread.sleep(800);

        constructorPage.clickOnBunsSection();
        Thread.sleep(800);
        Point bunsCoordinatesAfterSauces = constructorPage.getBunsHeaderPosition();

        softly.assertThat(bunsCoordinatesAfterSauces.getX())
                .as("Координаты X заголовка 'Булки' после 'Соусы'")
                .isEqualTo(expectedCoordinates.getX());
        softly.assertThat(bunsCoordinatesAfterSauces.getY())
                .as("Координаты Y заголовка 'Булки' после 'Соусы'")
                .isEqualTo(expectedCoordinates.getY());


        constructorPage.clickOnFillingsSection();
        Thread.sleep(800);

        constructorPage.clickOnBunsSection();
        Thread.sleep(800);
        Point bunsCoordinatesAfterFillings = constructorPage.getBunsHeaderPosition();

        softly.assertThat(bunsCoordinatesAfterFillings.getX())
                .as("Координаты X заголовка 'Булки' после 'Начинки'")
                .isEqualTo(expectedCoordinates.getX());
        softly.assertThat(bunsCoordinatesAfterFillings.getY())
                .as("Координаты Y заголовка 'Булки' после 'Начинки'")
                .isEqualTo(expectedCoordinates.getY());

        softly.assertAll();
    }

    @Test
    @DisplayName("Проверка координат заголовка 'Соусы' после клика на вкладку")
    public void testSaucesHeaderCoordinates() throws InterruptedException {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        SoftAssertions softly = new SoftAssertions();

        Point expectedCoordinates = constructorPage.setInitialHeaderCoordinates(browser);

        constructorPage.clickOnSaucesSection();
        Thread.sleep(500);

        Point saucesHeaderCoordinates = constructorPage.getSaucesHeaderPosition();

        softly.assertThat(saucesHeaderCoordinates.getX())
                .as("Координаты X заголовка 'Соусы' не совпадают с координатами булки")
                .isEqualTo(expectedCoordinates.getX());
        softly.assertThat(saucesHeaderCoordinates.getY())
                .as("Координаты Y заголовка 'Соусы' не совпадают с координатами булки")
                .isEqualTo(expectedCoordinates.getY());


        softly.assertAll();
    }

    @Test
    @DisplayName("Проверка координат заголовков 'Начинки', 'Булки' и 'Соусы' после выбора ")
    public void testFillingsHeaderCoordinates() throws InterruptedException {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        SoftAssertions softly = new SoftAssertions();

        Point expectedCoordinates = constructorPage.setInitialHeaderCoordinates(browser);

        constructorPage.clickOnFillingsSection();
        Thread.sleep(1000);
        Point fillingHeadersCoordinates = constructorPage.getFillingsHeaderPosition();

        softly.assertThat(fillingHeadersCoordinates.getX())
                .as("Координаты X заголовка 'Соусы' не совпадают с координатами булки")
                .isEqualTo(expectedCoordinates.getX());
        softly.assertThat(fillingHeadersCoordinates.getY())
                .as("Координаты Y заголовка 'Соусы' не совпадают с координатами булки")
                .isEqualTo(expectedCoordinates.getY());

        softly.assertAll();
    }
}
