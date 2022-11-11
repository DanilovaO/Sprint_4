package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Order {
    WebDriver driver;

    public Order(WebDriver driver) {
        this.driver = driver;
    }

    //  поле ИМЯ
    By nameField = By.xpath("//input[@placeholder='* Имя']");

    // найти и кликнуть на поле Имя
    public void clickNameField() {
        driver.findElement(nameField).click();
    }

    // Ввести имя
    public void addNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    //  поле ФАМИЛИЯ
    By surnameField = By.xpath("//input[@placeholder='* Фамилия']");

    // найти и кликнуть на поле Имя
    public void cliсkSurnameField() {
        driver.findElement(surnameField).click();
    }

    // Ввести Фамилию
    public void addSurnameField(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    //поле АДРЕС
    By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");

    // найти и кликнуть на поле Адресс
    public void clickAddressField() {
        driver.findElement(addressField).click();
    }

    // Ввести Адрес
    public void addAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    // поле МЕТРО
    By undergroundField = By.xpath("//input[@placeholder='* Станция метро']");

    public void clickUndergroundField() {
        driver.findElement(undergroundField).click();
    }

    // выбор первого в списке элемента(станции метро)
    By firstUndergroundField = By.className("Order_Text__2broi");

    public void choiseFirstUndergroundField() {
        driver.findElement(firstUndergroundField).click();
    }

    //поле ТЕЛЕФОН
    By phoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    // найти и кликнуть на поле номер телефона
    public void clickPhoneField() {
        driver.findElement(phoneField).click();
    }

    // Ввести номер телефона
    public void addPhoneField(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    // кнопка ДАЛЕЕ на странице заказа
    By nextButton = By.className("Button_Middle__1CSJM");

    // найти и кликнуть на поле номер телефона
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    // поле ДАТА ДОСТАВКИ
    By dateDeliveryField = By.xpath("//input[@placeholder='* Когда привезти самокат']");

    public void clickDateDeliveryField() {
        driver.findElement(dateDeliveryField).click();
    }

    // выбор определенного числа 20.11.2022
    By setDateDeliveryField = By.className("react-datepicker__day--020");

    public void clickSetDateDeliveryField() {
        driver.findElement(setDateDeliveryField).click();
    }

    // выбор СРОК АРЕНДЫ
    By periodField = By.className("Dropdown-root");

    public void clickPeriodField() {
        driver.findElement(periodField).click();
    }

    // первый вариант из списка предложенных периодов
    By getFirstPeriodField = By.className("Dropdown-option");

    public void clickGetFirstPeriodField() {
        driver.findElement(getFirstPeriodField).click();
    }

    // поле ВЫБОР ЦВЕТА
    // черный
    By blackCheckbox = By.id("black");

    public void clickBlackCheckbox() {
        driver.findElement(blackCheckbox).click();
    }

    // серый
    By greyCheckbox = By.id("grey");

    public void clickGreyCheckbox() {
        driver.findElement(greyCheckbox).click();
    }

    // поле КОММЕНТАРИЙ КУРЬЕРУ
    By commentField = By.xpath("//input[@placeholder='Комментарий для курьера']");

    public void clickCommentField() {
        driver.findElement(commentField).click();
    }

    public void addCommentField() {
        driver.findElement(commentField).sendKeys("тестовый комментарий");
    }

    // кнопка ЗАКАЗАТЬ в конце оформления
    By orderButton = By.className("Button_Middle__1CSJM");

    public void clickOrderButton() {
        driver.findElements(orderButton).get(1).click();
    }

    // кнопка НАЗАД в конце оформления

    public void clickBackButton() {
        driver.findElements(orderButton).get(0).click();
    }

    // модальное окно в завершении заказа
    // кнопка ДА
    public void clickYesButton() {
        driver.findElements(orderButton).get(3).click();
    }

    // Кнопка НЕТ
    public void clickNoButton() {
        driver.findElements(orderButton).get(2).click();
    }

    // поиск эелемента и получение его текста для сравнения его с текстом оформленного заказа
    public String orderSuccessText = "Заказ оформлен";

    public String shouldBeTwoStringsEqual() {
        return driver.findElement(By.className("Order_ModalHeader__3FDaJ")).getText();
    }

}


