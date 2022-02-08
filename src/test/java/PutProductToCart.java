import block.BaseArrage;
import block.BaseBodyPage;
import block.HeaderOnPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PutProductToCart extends BaseArrage {
    protected static String URL = "https://www.dns-shop.ru/";
    String product = "утюг";
    String pricebefore = "1000";

    @Test
    @DisplayName("добавление товара со стоимостью менее 1000 в корзину")
    @Severity(SeverityLevel.BLOCKER)
    public void PutProductToCart() {
        webdriver.get(URL);
        new HeaderOnPage(webdriver).InputSearchProduct(product);
        String costProductInCart = new BaseBodyPage(webdriver).
                FilterOnPrice(pricebefore).AddProductToCart().
                GoToCart().parcerPrice();
        Assertions.assertTrue(Integer.valueOf(costProductInCart) < Integer.valueOf(pricebefore));
    }
}
