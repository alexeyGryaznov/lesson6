import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class ChangeCityTest extends BaseArrage{

    private  String location="Москва";
    protected static String URL="https://www.dns-shop.ru/";
    @Test
    @DisplayName("Смена локации")
    public void ChangeCityTest() throws InterruptedException {
        WebDriver webdriver=setUp();
        webdriver.get(URL);
        String changeLocation=new HeaderOnPage(webdriver)
                .CallFormForCity()
                .InputCityToForm(location)
                .FindNewLocation();
        Assertions.assertEquals(location,changeLocation);
    }
}
