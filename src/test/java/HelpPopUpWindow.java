import org.junit.jupiter.api.Assumptions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HelpPopUpWindow {
    protected WebDriver webdriver;

    public HelpPopUpWindow(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public HelpPopUpWindow clikOnHelp() {
        webdriver.findElement(By.xpath("//div[@data-role='chat-button']")).click();
        return this;
    }

    public HelpPopUpWindow clikOnSpecPrice() {
        new WebDriverWait(webdriver,3).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-role='chat-container']")));
        webdriver.findElement(By.xpath("//div[@data-role='chat-container']//a[contains(text(),'Акции')]")).click();
        return new HelpPopUpWindow(webdriver);
    }

    public String changeWindow() {
        List<String> windowsHand=new ArrayList(webdriver.getWindowHandles());
        Assumptions.assumeFalse(windowsHand.isEmpty());
        webdriver.switchTo().window(windowsHand.get(1));
        return webdriver.getCurrentUrl();
    }


}
