package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterUser extends BasePage {

    public RegisterUser(WebDriver driver){
        super(driver);
    }

    //Локатор кнопки Личный кабинет вверху страницы
    private final By userAccountTopButton = By.xpath(".//nav/a/p");

    //Локатор кнопки Зарегистрироваться внизу страницы на экране авторизации
    private final By goToRegistrationButton = By.xpath(".//p[1]/a");

    //Локатор поля Имя
    private  final By nameField = By.xpath(".//fieldset[1]/div/div/input");

    //Локатор поля Email
    private final By emailField = By.xpath(".//fieldset[2]/div/div/input");

    //Локатор поля пароль
    private final By passwordField = By.xpath(".//fieldset[3]/div/div/input");

    //Локатор кнопки Зарегестрироваться на экране регистрации
    private final By registrationButton = By.xpath(".//form/button");

    //Локатор текст Вход после регистрации
    private final By enterTittleText = By.xpath(".//h2[text()='Вход']");

    //Локатор текста Неккоректный пароль при вводе неподходящего пароля
    private final By wrongPasswordText = By.xpath(".//div/p[text()='Некорректный пароль']");


    //Метод перехода к регестрации
    @Step("Переход к экрану регестрации, через экран авторизации")
    public void goToRegistration(){
        driver.findElement(userAccountTopButton).click();
        driver.findElement(goToRegistrationButton).click();
    }

    //Метод регистрации
    @Step("Ввод данных и нажатие кнопки регистрации")
    public void registration(String name, String email, String password){
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(registrationButton).click();
    }

    //Метод поиска текста Вход
    @Step("Поиск текста Вход на странице авторизации")
    public String findTextAfterRegistration(){
        return driver.findElement(enterTittleText).getText();
    }

    //Метод ожидания загрузка страницы до экрана авторизации
    @Step("Ожидание загрузка страницы до экрана авторизации")
    public void waitRegistrationProcess(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement anotherElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h2[text()='Вход']")));
    }

    //Метод поиска текста Некорректный пароль
    @Step("Поиск текста Некорректный пароль на странице регеистрации")
    public String findWrongPasswordText(){
        return driver.findElement(wrongPasswordText).getText();
    }

}
