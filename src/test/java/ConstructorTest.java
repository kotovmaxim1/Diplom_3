import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.Constructor;
import util.URL;
import util.WebDriverManager;

import static org.junit.Assert.assertTrue;

public class ConstructorTest {

    Constructor constructor;
    WebDriver driver;


    @Before
    public void setUp() {

        WebDriverManager browserPage = new WebDriverManager();
        driver = browserPage.getWebDrivers("chrome");

        driver.get(URL.URL_STELLARBURGERS);
        constructor = new Constructor(driver);
    }

    @Test
    public void bunTransitionTest(){
        constructor.clickFillingButton();
        constructor.clickBunButton();
        assertTrue(constructor.checkBunTittle());
    }

    @Test
    public void sauceTransitionTest(){
        constructor.clickFillingButton();
        constructor.clickSauceButton();
        assertTrue(constructor.checkSauceTittle());
    }

    @Test
    public void fillingTransitionTest(){
        constructor.clickFillingButton();
        constructor.checkFillingTittle();
        assertTrue(constructor.checkFillingTittle());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
