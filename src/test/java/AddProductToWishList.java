import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class AddProductToWishList extends BaseArrage{
    private String Nik="Пришелец-CY75848";
    protected static String URL="https://www.dns-shop.ru/product/dbe0f59a93743330/hlebopec-midea-bm-220-q3-w-belyj/";

    @Test
    @DisplayName("проверка сохранения товара в избраном для залогиненого пользователя")
    public void AddProductToWishList(){
        WebDriver webdriver=setUp();
        webdriver.get(URL);
        String findNik=new HeaderOnPage(webdriver).authorizationWithCoockies().FindNikName().getText();
        Assumptions.assumeTrue(Nik.equals(findNik));
        String expextItem=new BaseBodyPage(webdriver).CheckItemProduct();// считываю код продукта со страницы товара и не вношу в блок arrange т.к. item может измениться
        String addItem=new BaseBodyPage(webdriver).AddProduktToWish().GoToWishList().CheckAddItemAndClear();
        Assertions.assertTrue(expextItem.contains(addItem));
    }
}
