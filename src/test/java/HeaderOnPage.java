import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class HeaderOnPage {
    private WebDriver webdriver= WebDriverManager.chromedriver().create();

    public HeaderOnPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }
}
