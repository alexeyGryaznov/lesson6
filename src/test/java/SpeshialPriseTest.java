import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class SpeshialPriseTest extends BaseArrage{
    protected static String URL="https://www.dns-shop.ru/";
    private String expUrl="https://www.dns-shop.ru/actions/";

    @Test
    @DisplayName("специальные акции открываются в отдельном окне при клике из виджета тех поддержки")
    public void SpeshialPriseTest(){
        WebDriver webdriver=setUp();
        webdriver.get(URL);
        String currentUrl= new HelpPopUpWindow(webdriver)
                .clikOnHelp()
                .clikOnSpecPrice()
                .changeWindow();
        Assertions.assertEquals(expUrl,currentUrl);
    }
}
