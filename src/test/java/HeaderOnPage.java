import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderOnPage {
    private WebDriver webdriver;

    @FindBy(xpath = "//button[@data-role='login-button']")
    private WebElement autorezationButton;
    @FindBy(xpath = "//input[@autocomplete='username']")
    private WebElement login;
    @FindBy(xpath = "//input[@autocomplete='current-password']")
    private WebElement password;
    @FindBy(xpath = "//div[@class='form-entry-with-password__main-button']//*[contains(text(),'Войти')]")
    private WebElement buttonIn;
    @FindBy(xpath = "//div[@class='header-profile__level']")
    private WebElement ProfileButton;
    @FindBy(xpath = "//input[@data-role='search-city']")
    private WebElement inputSearchForm;

    String CityVidget="//ul[@class='header-top-menu__common-list']//div[@class='city-select w-choose-city-widget']//p";

    public HeaderOnPage(WebDriver webdriver) {
        this.webdriver = webdriver;
        PageFactory.initElements(webdriver,this);
    }

    public  HeaderOnPage CallFormForLogin(){
        autorezationButton.sendKeys(Keys.ENTER);
        new WebDriverWait(webdriver,3).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Войти с паролем')]")));
        webdriver.findElement(By.xpath("//div[@class='block-other-login-methods__password-caption']")).click();
        return new HeaderOnPage(webdriver);
    }
    public HeaderOnPage InputDataInLoginForm(String testLogin,String testPassword){
        login.sendKeys(testLogin);
        password.sendKeys(testPassword);
        buttonIn.click();
    return new HeaderOnPage(webdriver);
    }
    public WebElement FindNikName(){
        ProfileButton.click();
        WebElement NickName = webdriver.findElement(By.xpath("//span[@class='header-profile__username'][contains(text(),'Пришелец-CY75848')]"));
        return NickName;
    }

    public HeaderOnPage CallFormForCity() {
        webdriver.findElement(By.xpath("//a[@class='w-choose-city-widget pseudo-link pull-right']")).click();
        return this;
    }

    public HeaderOnPage InputCityToForm(String location) {
        By searchForm= By.xpath("//div[@class='base-modal select-city-modal base-modal_full-on-mobile']//div[contains(text(),'Ваш город')]");
        new WebDriverWait(webdriver,3).until(ExpectedConditions.presenceOfElementLocated(searchForm));
        inputSearchForm.sendKeys(location);
        inputSearchForm.sendKeys(Keys.ENTER);
        return new HeaderOnPage(webdriver);
    }

    public String FindNewLocation() throws InterruptedException {
        //new WebDriverWait(webdriver,3).until(ExpectedConditions.attributeContains(By.xpath("//ul[@class='header-top-menu__common-list']//div[@class='city-select w-choose-city-widget']//p"),"text","Москва"));
        Thread.sleep(300);// элемент появляется на странице раньше, чем обновляется его содержимое. поэтому явная задержка. так как локатор может содержать не только ожидаемое значение, то делать как в строке выше некорректно.
        return webdriver.findElement(By.xpath(CityVidget)).getText();
    }

    public HeaderOnPage authorizationWithCoockies(){
        webdriver.manage().addCookie(new Cookie("auth_access_token","eyJhbGciOiJFUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NDM4ODU1MzUsInJuZCI6ImY3NjhhYmIyMDhkZDJhOTY5NDFhYWFjOTQ1YzU2NGQ0NWFkOWFmOTY5MjBhODYyZTI1NTEzYmVmY2U4YzMzYTAiLCJ1c2VySWQiOiI3MTYxZDJkZC00ZGM1LTMxNjktZmM5NC0xOTk4MDI4NDhiNTUiLCJ1c2VyTmFtZSI6IiJ9.MEUCIQC2HG5E0qLox6HLjhteRs5D7NkfUmu1bdTmIZquHy3XRAIgVicTQeaaIuF0hsPqEf6YdpgdpR1ibFyWQZOcJxF9M7s"));
        //webdriver.manage().addCookie(new Cookie("auth_public_uid","736ee8f3bfbb4c63eda86ac5f6593536"));
        webdriver.manage().addCookie(new Cookie("auth_refresh_token","36c6e10975aefc3bf000861019c18547dba5a9a3c9322e8ae9b2939b32d3d872"));
        webdriver.manage().addCookie(new Cookie("auth_ssid","01246141e67e47932a92a6989bdbd6a00f44823d996b55811fea90aa35e5f9a7"));
        autorezationButton.sendKeys(Keys.ENTER);
        new WebDriverWait(webdriver,3).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='header-profile__level']")));
        return new HeaderOnPage(webdriver);
}


    public HeaderOnPage InputSearchProduct(String product) {
        String Search="//div[@class='header-menu-wrapper']//input[@placeholder='Поиск по сайту']";
        webdriver.findElement(By.xpath(Search)).sendKeys(product);
        webdriver.findElement(By.xpath(Search)).sendKeys(Keys.ENTER);
        return new HeaderOnPage(webdriver);
    }
}


