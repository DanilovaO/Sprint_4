import objects.Landing;
import objects.Order;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString; // импорт матчера containsString

import org.hamcrest.MatcherAssert; // импорт класса MatcherAssert
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class OrderTest {
    private final String name;
    private final String surname;
    private final String address;
    private final String phone;


    public OrderTest(String name, String surname, String address, String phone) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;

    }

    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"Ольга", "Данилова", "Москва", "88888888888"},
                {"Анна", "Краснова", "Чебоксары", "+70088888888"},
                {"Илья", "Данилов", "Анталия", "89259999999"},
        };
    }


    public WebDriver driver;
    //оюъявление стриницы
    public Landing landingPage;
    public Order orderPage;


    @Before
    public void before() {
        /*
        драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "./src/chromedriver");
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver();
        */

        // драйвер для браузера Firefox
        FirefoxOptions options = new FirefoxOptions();
        System.setProperty("webdriver.gecko.driver", "./src/geckodriver");
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new FirefoxDriver();

        // инициализировали страницу Landing
        landingPage = new Landing(driver);
        orderPage = new Order(driver);
    }


    @Test
    // тест проверяет успешный заказ при заполнении всех полей через верхнюю кнопку ЗАКАЗАТЬ
    public void testOrder1() throws InterruptedException {
        // переход на страницу тестового приложения
        landingPage.open();
        //убрать сообщение о куки
        landingPage.clickCookieButton();
        // поиск кнопки "заказать" и клик по ней
        landingPage.clickTopOrderButton();
        // заполнение строк
        orderPage.clickNameField();
        orderPage.addNameField(name);
        orderPage.cliсkSurnameField();
        orderPage.addSurnameField(surname);
        orderPage.clickAddressField();
        orderPage.addAddressField(address);
        orderPage.clickUndergroundField();
        orderPage.choiseFirstUndergroundField();
        orderPage.clickPhoneField();
        orderPage.addPhoneField(phone);
        // поиск и клик по кнопке Далее
        orderPage.clickNextButton();
        // заполнение полей про аренду
        orderPage.clickDateDeliveryField();
        orderPage.clickSetDateDeliveryField();
        orderPage.clickPeriodField();
        orderPage.clickGetFirstPeriodField();
        orderPage.clickGreyCheckbox();
        orderPage.clickCommentField();
        orderPage.addCommentField();
        // кликнуть на кнопку заказать
        orderPage.clickOrderButton();
        // подтвердить заказ
        orderPage.clickYesButton();
        // Проверка, что появилось всплывающее окно с сообщением об успешном создании заказа.
        MatcherAssert.assertThat(orderPage.shouldBeTwoStringsEqual(), containsString(orderPage.orderSuccessText));
    }

    @Test
    // тест проверяет успешный заказ при заполнении только обязательных полей через нижнюю кнопку ЗАКАЗАТЬ
    public void testOrder2() throws InterruptedException {
        // переход на страницу тестового приложения
        landingPage.open();
        // поиск с помощью скролла до второй кнопки "заказать" и клик по ней
        WebElement element = driver.findElement(By.className("Button_Middle__1CSJM"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        landingPage.clickSecondTopOrderButton();
        // заполнение строк
        orderPage.clickNameField();
        orderPage.addNameField(name);
        orderPage.cliсkSurnameField();
        orderPage.addSurnameField(surname);
        orderPage.clickAddressField();
        orderPage.addAddressField(address);
        orderPage.clickUndergroundField();
        orderPage.choiseFirstUndergroundField();
        orderPage.clickPhoneField();
        orderPage.addPhoneField(phone);
        // поиск и клик по кнопке Далее
        orderPage.clickNextButton();
        // заполнение полей про аренду
        orderPage.clickDateDeliveryField();
        orderPage.clickSetDateDeliveryField();
        orderPage.clickPeriodField();
        orderPage.clickGetFirstPeriodField();
        // кликнуть на кнопку заказать
        orderPage.clickOrderButton();
        // подтвердить заказ
        orderPage.clickYesButton();
        // Проверка, что появилось всплывающее окно с сообщением об успешном создании заказа.
        MatcherAssert.assertThat(orderPage.shouldBeTwoStringsEqual(), containsString(orderPage.orderSuccessText));
    }


    @After
    public void teardown() {
        driver.quit(); // Закрыть браузер
    }
}

