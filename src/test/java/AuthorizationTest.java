import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.Authorization;
import util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class AuthorizationTest {

    Authorization authorization;
    WebDriver driver;
    String accessToken;

    @Before
    public void setUp(){

        WebDriverManager browserPage = new WebDriverManager();
        driver = browserPage.getWebDrivers("chrome");

        driver.get(URL.URL_STELLARBURGERS);
        authorization = new Authorization(driver);

        RegisterApi registerApi = new RegisterApi();
        Register register = new Register("kotovma_35@yandex.ru", "qwe1234", "Maxim");
        Response response = registerApi.postRegisterRequest(register);

        accessToken = response.then().extract().path("accessToken").toString().replace("Bearer ", "");
    }

    @Test
    public void authorizationByMainPageButtonTest(){
        authorization.goToAuthorizationByMainPageButton();
        authorization.filingFields("kotovma_35@yandex.ru", "qwe1234");
        authorization.waitForMakeOrderButton();
        assertTrue(authorization.findMakeOrdersButton());
    }

    @Test
    public void authorizationByHeaderButtonTest(){
        authorization.goToAuthorizationOrAccountByHeaderButton();
        authorization.filingFields("kotovma_35@yandex.ru", "qwe1234");
        authorization.waitForMakeOrderButton();
        assertTrue(authorization.findMakeOrdersButton());
    }

    @Test
    public void authorizationByRegistrationPageButtonTest(){
        authorization.goToAuthorizationByRegistrationPageButton();
        authorization.filingFields("kotovma_35@yandex.ru", "qwe1234");
        authorization.waitForMakeOrderButton();
        assertTrue(authorization.findMakeOrdersButton());
    }

    @Test
    public void authorizationByRecoveryPasswordPageButtonTest(){
        authorization.goToAuthorizationByPasswordRecoveryPagePageButton();
        authorization.filingFields("kotovma_35@yandex.ru", "qwe1234");
        authorization.waitForMakeOrderButton();
        assertTrue(authorization.findMakeOrdersButton());
    }

    @After
    public void tearDown() {
        UserApi userApi = new UserApi();
        userApi.deleteUserRequest(accessToken);

        driver.quit();
    }
}
