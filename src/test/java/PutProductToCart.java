import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class PutProductToCart extends BaseArrage {
    protected static String URL="https://www.dns-shop.ru/";
    String product="утюг";
    String pricebefore="1000";

    @Test
    @DisplayName("добавление товара со стоимостью менее 1000 в корзину")
    public void PutProductToCart(){
        WebDriver webdriver=setUp();
        webdriver.get(URL);
        new HeaderOnPage(webdriver).InputSearchProduct(product);
        String costProductInCart =new BaseBodyPage(webdriver).
                FilterOnPrice(pricebefore).AddProductToCart().
                GoToCart().parcerPrice();
        Assertions.assertTrue(Integer.valueOf(costProductInCart) < Integer.valueOf(pricebefore));
    }
}
