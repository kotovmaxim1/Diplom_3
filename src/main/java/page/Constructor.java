package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Constructor extends BasePage {
    public Constructor(WebDriver driver) {
        super(driver);
    }

    //Локатор кнопки Булки
    private final By bunButton = By.xpath(".//main/section[1]/div[1]/div[1]");

    //Локатор кнопки Соусы
    private final By sauceButton = By.xpath(".//main/section[1]/div[1]/div[2]");

    //Локатор кнопки Начинки
    private final By fillingButton = By.xpath(".//main/section[1]/div[1]/div[3]");

    //Локатор заголовка Булки
    private final By bunTittle = By.xpath(".//main/section[1]/div[2]/h2[1]");

    //Локатор заголовка Соусы
    private final By sauceTittle = By.xpath(".//main/section[1]/div[2]/h2[2]");

    //Локатор заголовка Начинки
    private final By fillingTittle = By.xpath(".//main/section[1]/div[2]/h2[3]");

    @Step("Нажатие кнопки Булки")
    public void clickBunButton(){
        driver.findElement(bunButton).click();
    }

    @Step("Нажатие кнопки Соусы")
    public void clickSauceButton(){
        driver.findElement(sauceButton).click();
    }

    @Step("Нажатие кнопки Начинки")
    public void clickFillingButton(){
        driver.findElement(fillingButton).click();
    }

    @Step("Проверка видимости заголовка Булки")
    public boolean checkBunTittle(){
        driver.findElement(bunTittle).isDisplayed();
        return true;
    }

    @Step("Проверка видимости заголовка Соусы")
    public boolean checkSauceTittle(){
        driver.findElement(sauceTittle).isDisplayed();
        return true;
    }

    @Step("Проверка видимости заголовка Начинки")
    public boolean checkFillingTittle(){
        driver.findElement(fillingTittle).isDisplayed();
        return true;
    }
}
