import block.BaseArrage;
import block.HelpPopUpWindow;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpeshialPriseTest extends BaseArrage {
    protected String URL = "https://www.dns-shop.ru/";
    private String expUrl = "https://www.dns-shop.ru/actions/";

    @Test
    @DisplayName("специальные акции открываются в отдельном окне при клике из виджета тех поддержки")
    @Severity(SeverityLevel.NORMAL)
    public void SpeshialPriseTest() {
        webdriver.get(URL);
        String currentUrl = new HelpPopUpWindow(webdriver)
                .clikOnHelp()
                .clikOnSpecPrice()
                .changeWindow();
        Assertions.assertEquals(expUrl, currentUrl);
    }
}
