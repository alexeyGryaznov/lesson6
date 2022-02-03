import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseArrage {
    protected WebDriver webdriver;

    public WebDriver setUp () {
        WebDriver webdriver= WebDriverManager.chromedriver().create();
        webdriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webdriver.manage().window().setSize(new Dimension(1500,800));
        return webdriver;
    }

}
