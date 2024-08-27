package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Authorization extends BasePage {

    public Authorization(WebDriver driver) {
        super(driver);
    }

    //Локатор кнопки на главном экране
    private final By LoginInAccountInMainPageButton = By.xpath("//button[text()='Войти в аккаунт']");

    //Локатор кнопки в хедере главного экрана
    private final By LoginInAccountOnHeaderButton = By.xpath(".//p[text()='Личный Кабинет']");

    //Локатор кнопки на экране регистрации
    private final By LoginInAccountOnRegistrationPageButton = By.xpath(".//div/p/a[text()='Войти']");

    //Локатор кнопки на экране востановления пароля
    private final By LoginInAccountOnPasswordRecoveryPageButton = By.xpath(".//div/p/a[text()='Войти']");

    //Локатор поля Email
    private final By emailField = By.xpath(".//fieldset[1]/div/div/input");

    //Локатор поля Пароль
    private final By passwordField = By.xpath(".//fieldset[2]/div/div/input");

    //Локатор кнопки Войти
    private final By authorizationButton = By.xpath(".//div/form/button");

    //Локатор кнопки Оформить заказ
    private final By makeOrdersButton = By.xpath(".//section[2]/div/button");

    //Локатор кнопки Зарегестрироваться на экране авторизации
    private final By registrationButtonOnAuthorizationPage = By.xpath(".//a[text()='Зарегистрироваться']");

    //Локатор кнопки Восстановить пароль на экране авторизации
    private final By recoveryPasswordButtonOnAuthorizationPage = By.xpath(".//a[text()='Восстановить пароль']");


    @Step("Переход к авторизации по кнопке на главном экране")
    public void goToAuthorizationByMainPageButton(){
        driver.findElement(LoginInAccountInMainPageButton).click();
    }

    @Step("Переход по кнопке Личный кабинет в хедере главного экрана")
    public void goToAuthorizationOrAccountByHeaderButton(){
        driver.findElement(LoginInAccountOnHeaderButton).click();
    }

    @Step("Переход к авторизации по кнопке в форме регистрации")
    public void goToAuthorizationByRegistrationPageButton(){
        driver.findElement(LoginInAccountInMainPageButton).click();
        driver.findElement(registrationButtonOnAuthorizationPage).click();
        driver.findElement(LoginInAccountOnRegistrationPageButton).click();
    }

    @Step("Переход к авторизации по кнопке в форме востановления пароля")
    public void goToAuthorizationByPasswordRecoveryPagePageButton(){
        driver.findElement(LoginInAccountInMainPageButton).click();
        driver.findElement(recoveryPasswordButtonOnAuthorizationPage).click();
        driver.findElement(LoginInAccountOnPasswordRecoveryPageButton).click();
    }

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
}
