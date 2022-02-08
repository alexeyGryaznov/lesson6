import block.BaseArrage;
import block.HeaderOnPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChangeCityTest extends BaseArrage {

    private String location = "Москва";
    protected static String URL = "https://www.dns-shop.ru/";

    @Test
    @DisplayName("Смена локации")
    @Severity(SeverityLevel.CRITICAL)
    public void ChangeCityTest() throws InterruptedException {
        webdriver.get(URL);
        String changeLocation = new HeaderOnPage(webdriver)
                .CallFormForCity()
                .InputCityToForm(location)
                .FindNewLocation();
        Assertions.assertEquals(location, changeLocation);
    }
}
