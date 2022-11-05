import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class QuestionImportantTest {
    public WebDriver driver;

    @Before
    public void before() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "./src/chromedriver");
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver();

        /* драйвер для браузера Firefox
        FirefoxOptions options = new FirefoxOptions();
        System.setProperty("webdriver.gecko.driver", "./src/geckodriver");
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new FirefoxDriver();*/

        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru");
        // поиск раздела "вопросы о важном" и скролл до вопросов из раздела
        WebElement element = driver.findElement(By.className("Home_FAQ__3uVm4"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    @Test
    public void test1(){
        //поиск первого элемента в вопросах о важном и клик по нему
        driver.findElement(By.id("accordion__heading-0")).click();
        // сравнение текста элемента
        assert driver.findElement(By.id("accordion__panel-0")).getText().contains("Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
    }
    @Test
    public void test2(){
        //поиск второго элемента в вопросах о важном и клик по нему
        driver.findElement(By.id("accordion__heading-1")).click();
        // сравнение текста элемента
        assert driver.findElement(By.id("accordion__panel-1")).getText().contains("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.");
    }
    @Test
    public void test3(){
        //поиск третьего элемента в вопросах о важном и клик по нему
        driver.findElement(By.id("accordion__heading-2")).click();
        // сравнение текста элемента
        assert driver.findElement(By.id("accordion__panel-2")).getText().contains("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.");
    }
    @Test
    public void test4(){
        //поиск четвертого элемента в вопросах о важном и клик по нему
        driver.findElement(By.id("accordion__heading-3")).click();
        // сравнение текста элемента
        assert driver.findElement(By.id("accordion__panel-3")).getText().contains("Только начиная с завтрашнего дня. Но скоро станем расторопнее.");
    }
    @Test
    public void test5(){
        //поиск четвертого элемента в вопросах о важном и клик по нему
        driver.findElement(By.id("accordion__heading-4")).click();
        // сравнение текста элемента
        assert driver.findElement(By.id("accordion__panel-4")).getText().contains("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.");
    }
    @Test
    public void test6(){
        //поиск четвертого элемента в вопросах о важном и клик по нему
        driver.findElement(By.id("accordion__heading-5")).click();
        // сравнение текста элемента
        assert driver.findElement(By.id("accordion__panel-5")).getText().contains("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.");
    }
    @Test
    public void test7(){
        //поиск четвертого элемента в вопросах о важном и клик по нему
        driver.findElement(By.id("accordion__heading-6")).click();
        // сравнение текста элемента
        assert driver.findElement(By.id("accordion__panel-6")).getText().contains("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.");
    }
    @Test
    public void test8(){
        //поиск четвертого элемента в вопросах о важном и клик по нему
        driver.findElement(By.id("accordion__heading-7")).click();
        // сравнение текста элемента
        assert driver.findElement(By.id("accordion__panel-7")).getText().contains("Да, обязательно. Всем самокатов! И Москве, и Московской области.");
    }

    @After
    public void teardown() {
        driver.quit(); // Закрыть браузер
    }
}