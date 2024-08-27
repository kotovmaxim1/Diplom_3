import io.restassured.response.Response;
import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import page.RegisterUser;
import util.*;

import static org.hamcrest.CoreMatchers.equalTo;

public class RegisterUserTest {

    RegisterUser registerUser;
    WebDriver driver;

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp(){
        WebDriverManager browserPage = new WebDriverManager();
        driver = browserPage.getWebDrivers("chrome");

        driver.get(URL.URL_STELLARBURGERS);
        registerUser = new RegisterUser(driver);
    }

    @Test
    public void registrationTest(){
        registerUser.goToRegistration();
        registerUser.registration("Maxim", "kotovma_35@yandex.ru", "qwe1234");
        registerUser.waitRegistrationProcess();
        String expected = "Вход";
        Assert.assertThat("Текст после регистрации не найден", registerUser.findTextAfterRegistration(), equalTo(expected));
    }

    @Test
    public void registrationWithShortPasswordTest(){
        registerUser.goToRegistration();
        registerUser.registration("Maxim", "kotovma_35@yandex.ru", "qwe12");
        String expected = "Некорректный пароль";
        Assert.assertThat("Текст Некорректный пароль не найден", registerUser.findWrongPasswordText(), equalTo(expected));
    }

    @After
    public void tearDown(){
        if(testName.getMethodName().equals("registrationTest")) {
            LoginApi loginApi = new LoginApi();
            Login login = new Login("kotovma_35@yandex.ru", "qwe1234");
            Response response = loginApi.postLoginRequest(login);

            String accessToken = response.then().extract().path("accessToken").toString().replace("Bearer ", "");
            UserApi userApi = new UserApi();
            userApi.deleteUserRequest(accessToken);
        }

        driver.quit();
    }
}
