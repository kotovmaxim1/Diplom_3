import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.Profile;
import util.Register;
import util.RegisterApi;
import util.URL;
import util.UserApi;

import static org.junit.Assert.assertTrue;

public class ProfileTest {

    Profile profile;
    WebDriver driver;
    String accessToken;

    @Before
    public void setUp(){

        util.WebDriverManager browserPage = new util.WebDriverManager();
        driver = browserPage.getWebDrivers("chrome");

        driver.get(URL.URL_STELLARBURGERS);
        profile = new Profile(driver);

        RegisterApi registerApi = new RegisterApi();
        Register register = new Register("kotovma_35@yandex.ru", "qwe1234", "Maxim");
        Response response = registerApi.postRegisterRequest(register);

        accessToken = response.then().extract().path("accessToken").toString().replace("Bearer ", "");
    }

    @Test
    public void goToAccountTest(){
        profile.goToAuthorizationByMainPageButton();
        profile.filingFields("kotovma_35@yandex.ru", "qwe1234");
        profile.waitForMakeOrderButton();
        profile.goToAuthorizationOrAccountByHeaderButton();
        profile.waitForProfileButton();
        assertTrue(profile.findProfileButton());
    }

    @Test
    public void goToConstructorTest(){
        profile.goToAuthorizationByMainPageButton();
        profile.filingFields("kotovma_35@yandex.ru", "qwe1234");
        profile.waitForMakeOrderButton();
        profile.goToAuthorizationOrAccountByHeaderButton();
        profile.waitForProfileButton();
        profile.clickHeaderLogoButton();
        profile.waitForMakeOrderButton();
        assertTrue(profile.findMakeOrdersButton());
    }

    @Test
    public void exitFromAccountTest(){
        profile.goToAuthorizationByMainPageButton();
        profile.filingFields("kotovma_35@yandex.ru", "qwe1234");
        profile.waitForMakeOrderButton();
        profile.goToAuthorizationOrAccountByHeaderButton();
        profile.waitForProfileButton();
        profile.exitFromAccount();
        profile.waitRegistrationProcess();
        assertTrue(profile.findTextAfterRegistration());
    }

    @After
    public void tearDown() {
        UserApi userApi = new UserApi();
        userApi.deleteUserRequest(accessToken);

        driver.quit();
    }
}
