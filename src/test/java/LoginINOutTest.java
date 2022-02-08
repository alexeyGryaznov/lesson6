import block.BaseArrage;
import block.HeaderOnPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginINOutTest extends BaseArrage {
    private String Nik = "Пришелец-CY75848";
    private String testLogin = "lightsteach@yandex.ru";
    private String testPassword = "test123456";
    protected static String URL = "https://www.dns-shop.ru/";

    @Test
    @DisplayName("Авторизация пользователя")
    @Severity(SeverityLevel.BLOCKER)
    public void LoginINOutTest() {
        webdriver.get(URL);
        String findNik = new HeaderOnPage(webdriver).
                CallFormForLogin().
                InputDataInLoginForm(testLogin, testPassword).
                FindNikName().getText();
        Assertions.assertEquals(Nik, findNik);
    }
}
