package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landing {
    WebDriver driver;

    public Landing(WebDriver driver) {
        this.driver = driver;
    }
// переход на тестовую страницу
    String landingUrl = "https://qa-scooter.praktikum-services.ru";

    public void open() {
        driver.get(landingUrl);
    }
// кнопка верхняя ЗАКАЗАТЬ
    By topOrderButton = By.className("Button_Button__ra12g");

    public void clickTopOrderButton() {

        driver.findElement(topOrderButton).click();
    }
    // кнопка нижняя ЗАКАЗАТЬ
    By secondTopOrderButton = By.className("Button_Middle__1CSJM");


    public void clickSecondTopOrderButton() {

        driver.findElement(secondTopOrderButton).click();
    }
    // кнопка куки
    By cookieButton = By.className("App_CookieButton__3cvqF");


    public void clickCookieButton() {

        driver.findElement(cookieButton).click();
    }
}
