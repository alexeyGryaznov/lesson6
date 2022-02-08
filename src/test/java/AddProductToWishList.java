import block.BaseArrage;
import block.BaseBodyPage;
import block.HeaderOnPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddProductToWishList extends BaseArrage {
    private String Nik = "Пришелец-CY75848";
    protected static String URL = "https://www.dns-shop.ru/product/dbe0f59a93743330/hlebopec-midea-bm-220-q3-w-belyj/";

    @Test
    @DisplayName("проверка сохранения товара в избраном для залогиненого пользователя")
    @Severity(SeverityLevel.NORMAL)
    @Description("В тесте используется предварительная авторизация через cookie")
    public void AddProductToWishList() {
        webdriver.get(URL);
        String findNik = new HeaderOnPage(webdriver).authorizationWithCoockies().FindNikName().getText();
        Assumptions.assumeTrue(Nik.equals(findNik));
        String expextItem = new BaseBodyPage(webdriver).CheckItemProduct();// считываю код продукта со страницы товара и не вношу в блок arrange т.к. item может измениться
        String addItem = new BaseBodyPage(webdriver).AddProduktToWish().GoToWishList().CheckAddItemAndClear();
        Assertions.assertTrue(expextItem.contains(addItem));
    }
}
