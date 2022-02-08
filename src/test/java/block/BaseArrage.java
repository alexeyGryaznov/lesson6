package block;

import io.github.bonigarcia.wdm.WebDriverManager;
import listener.ActionEventListener;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseArrage {
    protected EventFiringWebDriver webdriver;

    @BeforeEach
    void setUp() {
        webdriver = new EventFiringWebDriver(WebDriverManager.chromedriver().create());
        webdriver.register(new ActionEventListener());
        webdriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webdriver.manage().window().setSize(new Dimension(1500, 800));
    }

    @AfterEach
    void tearDown() {
        LogEntries browserLog=webdriver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> AllLog=browserLog.getAll();
       // if (AllLog.size()>0)
        webdriver.quit();
    }
}
