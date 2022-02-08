package listener;


import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

import static io.qameta.allure.Allure.step;


public class ActionEventListener extends AbstractWebDriverEventListener {
    private static final Logger logger = LoggerFactory.getLogger(ActionEventListener.class);


    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        String actionName = "Нажать на элемент " + element.getText();
        logger.info(actionName);
        step(actionName);
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        String actionName = "Нажать на элемент = Успешно!";
        logger.info(actionName);
        step(actionName);
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        String actionName = "ввести текст '" + Arrays.toString(keysToSend) + "' в поле" + element.getClass();
        logger.info(actionName);
        step(actionName);
        Allure.addAttachment("ScreeenShot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        String actionName = "Успешно!";
        logger.info(actionName);
        step(actionName);
    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        String actionName = "переключение на окно " + windowName;
        logger.info(actionName);
        step(actionName);
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        Allure.addAttachment("ScreeenShot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
}
