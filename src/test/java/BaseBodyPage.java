import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseBodyPage {
    private WebDriver webdriver;

    @FindBy(xpath = "//input[@type='number'][contains(@placeholder, 'до')]")
    private WebElement UpToPrice ;

    String buttonWish ="//div[@class='product-buy product-buy_one-line']//button[@class='button-ui button-ui_white button-ui_icon wishlist-btn']";
    String loginButton="//button[@data-role='login-button']";
    String BuyButton="//button[contains(text(),'Купить')]";

    public BaseBodyPage(WebDriver webdriver) {
        this.webdriver = webdriver;
        PageFactory.initElements(webdriver,this);
    }

    public String CheckItemProduct(){
        return  webdriver.findElement(By.xpath("//div[@class='product-card-top__code']")).getText();
    }

    public BaseBodyPage AddProduktToWish(){
        new WebDriverWait(webdriver,3).until(ExpectedConditions.presenceOfElementLocated(By.xpath(buttonWish)));
        webdriver.findElement(By.xpath(buttonWish)).sendKeys(Keys.ENTER);
        return this;
    }
    public String CheckAddItemAndClear(){
        String addItem=webdriver.findElement(By.xpath("//div[@data-id='product']")).getAttribute("data-code");
        webdriver.findElement(By.xpath("//button[@data-role='clear-wishlist']")).click();
        new WebDriverWait(webdriver,3).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='profile-wishlist__remove-modal']")));
        webdriver.findElement(By.xpath("//div[@class='profile-wishlist__remove-modal']//div[contains(text(),'Удалить')]")).click();
        return addItem;
    }

    public BaseBodyPage GoToWishList(){
        webdriver.findElement(By.xpath("//a[@class='ui-link wishlist-link']")).sendKeys(Keys.ENTER);
        return new BaseBodyPage(webdriver);
    }

    public BaseBodyPage FilterOnPrice(String priceBefore) {
        WebDriverWait waiter=new WebDriverWait(webdriver,3);
        waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loginButton)));
        WebElement scroll= webdriver.findElement(By.xpath(loginButton));
        scroll.sendKeys(Keys.PAGE_DOWN);
        UpToPrice.sendKeys(priceBefore);
        UpToPrice.sendKeys(Keys.ENTER);
        waiter.until(ExpectedConditions.elementToBeSelected(By.xpath("//input[@data-max='1000']")));
        waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='picked-filter'][contains(text(),'Цена: до 1 000 ₽')]")));
        return new BaseBodyPage(webdriver);
    }

    public BaseBodyPage AddProductToCart() {
        new WebDriverWait(webdriver,3).until(ExpectedConditions.presenceOfElementLocated(By.xpath(BuyButton)));
        webdriver.findElement(By.xpath(BuyButton)).sendKeys(Keys.ENTER);
        return this;
    }

    public BaseBodyPage GoToCart() {
        webdriver.findElement(By.xpath("//a[@data-commerce-target='CART']")).sendKeys(Keys.ENTER);
        return new BaseBodyPage(webdriver);
    }

    public String parcerPrice(){
        String priceWithRUB=webdriver.findElement(By.xpath("//div[@class='cart-items__content-container']//span[@class='price__current']")).getText();
        String[] priceOnlycost = priceWithRUB.split(" ",2);
        webdriver.findElement(By.xpath("//div[@class='cart-items__wrapper']//preceding::button[@class='menu-control-button remove-button']")).sendKeys(Keys.ENTER);
        return priceOnlycost[0];
    }
}
