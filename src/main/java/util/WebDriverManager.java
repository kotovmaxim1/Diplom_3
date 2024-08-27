package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Locale;

public class WebDriverManager {

    public WebDriver getWebDrivers(String browserName){
        switch (browserName.toLowerCase(Locale.ROOT)){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "/Users/maxim/Diplom/Diplom_3/src/main/resources/chromedriver");
                return new ChromeDriver();
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "/Users/maxim/Diplom/Diplom_3/src/main/resources/yandexdriver");
                return new ChromeDriver();
            default:
                throw new IllegalArgumentException("wrong browser " + browserName);
        }
    }
}
