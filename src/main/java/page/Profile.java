package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Profile extends BasePage {

    public Profile(WebDriver driver) {
        super(driver);
    }

    //Локатор кнопки на главном экране
    private final By LoginInAccountInMainPageButton = By.xpath("//button[text()='Войти в аккаунт']");

    //Локатор поля Email
    private final By emailField = By.xpath(".//fieldset[1]/div/div/input");

    //Локатор поля Пароль
    private final By passwordField = By.xpath(".//fieldset[2]/div/div/input");

    //Локатор кнопки Войти
    private final By authorizationButton = By.xpath(".//div/form/button");

    //Локатор кнопки Оформить заказ
    private final By makeOrdersButton = By.xpath(".//section[2]/div/button");

    //Локатор кнопки Профиль
    private final By profileButton = By.xpath(".//div/nav/ul/li[1]/a");

    //Локатор кнопки-лого в хедере
    private final By logoHeaderButton = By.xpath(".//header/nav/div");

    //Локатор кнопки Выход в профиле
    private final By exitButton = By.xpath("//ul/li[3]/button");

    //Локатор текст Вход после регистрации
    private final By enterTittleText = By.xpath(".//h2[text()='Вход']");

    //Локатор кнопки в хедере главного экрана
    private final By LoginInAccountOnHeaderButton = By.xpath(".//p[text()='Личный Кабинет']");


    @Step("Заполнение формы авторизации и нажатие кнопки Войти")
    public void filingFields(String email, String password){
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(authorizationButton).click();
    }

    @Step("Поиск кнопки оформить заказ после авторизации")
    public boolean findMakeOrdersButton(){
        driver.findElement(makeOrdersButton).isDisplayed();
        return true;
    }

    @Step("Ожидание появления кнопки Оформить заказ")
    public void waitForMakeOrderButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement anotherElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//section[2]/div/button")));
    }

    @Step("Поиск кнопки Профиль на экране личного кабинета")
    public boolean findProfileButton(){
        driver.findElement(profileButton).isDisplayed();
        return true;
    }

    @Step("Ожидание появления кнопки Профиль")
    public void waitForProfileButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement anotherElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div/nav/ul/li[1]/a")));
    }

    @Step("Переход к конструктору по кнопке-лого в хедере")
    public void clickHeaderLogoButton(){
        driver.findElement(logoHeaderButton).click();
    }

    @Step("Выход из аккаунта по кнопке Выход в профиле")
    public void exitFromAccount(){
        driver.findElement(exitButton).click();
    }

    //Метод поиска текста Вход
    @Step("Поиск текста Вход на странице авторизации")
    public boolean findTextAfterRegistration(){
        driver.findElement(enterTittleText).isDisplayed();
        return true;
    }

    //Метод ожидания загрузка страницы до экрана авторизации
    @Step("Ожидание загрузка страницы до экрана авторизации")
    public void waitRegistrationProcess(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement anotherElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h2[text()='Вход']")));
    }

    @Step("Переход к авторизации по кнопке на главном экране")
    public void goToAuthorizationByMainPageButton(){
        driver.findElement(LoginInAccountInMainPageButton).click();
    }

    @Step("Переход по кнопке Личный кабинет в хедере главного экрана")
    public void goToAuthorizationOrAccountByHeaderButton(){
        driver.findElement(LoginInAccountOnHeaderButton).click();
    }
}
