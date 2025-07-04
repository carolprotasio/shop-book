package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import utils.WaitHelper;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTest {

    private WebDriver driver;
    private WaitHelper wait;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--user-data-dir=/tmp/chrome-user-data-" + System.currentTimeMillis());


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.automationtesting.in/");
    }
    @Test
    @DisplayName("CT-001 - Buscar produtos ao digitar no campo de pesquisa")
    public void searchIconTest() {
      HomePage home = new HomePage(driver);
      home.searchFor("java");

      String title = home.getSearchResultTitle();
      assertTrue(title.toLowerCase().contains("java"));
    }
    @Test
    @DisplayName("CT-002 - Validar navegação para página 'Shop'")
    public void shopLink() {
        driver.findElement(By.cssSelector("#menu-item-40 > a")).click();
        String text = driver.findElement(By.cssSelector("#woocommerce_price_filter-2 > h4")).getText();
        assertEquals("FILTER BY PRICE", text );
    }
    @Test
    @DisplayName("CT-003 - Validar navegação para página 'My Account'")
    public void myAccountLink() {
        driver.findElement(By.cssSelector("#menu-item-50 > a")).click();
        String text = driver.findElement(By.cssSelector("#customer_login > div.u-column1.col-1 > h2")).getText();
        assertEquals(text, "Login");
    }
    @Test
    @DisplayName("CT-004 - Validar navegação para página 'Test Cases'")
    public void testCasesLink() {
        driver.findElement(By.cssSelector("#menu-item-224 > a")).click();
        String text = driver.findElement(By.cssSelector("#accordion-222-sub_row_1-0-1-0-0 > h3")).getText();
        assertEquals(text, "HOME PAGE");
    }
    @Test
    @DisplayName("CT-005 - Validar navegação para página 'AT Site'")
    public void atSiteLink() {
        driver.findElement(By.cssSelector("#menu-item-244 > a")).click();
        String text = driver.findElement(By.cssSelector("#site-description > span")).getText();
        assertEquals(text, "Automation Testing");
    }
    @Test
    @DisplayName("CT-006 - Validar navegação para página 'Demo Site'")
    public void demoSiteLink() {
        driver.findElement(By.cssSelector("#menu-item-251 > a")).click();
        String text = driver.findElement(By.cssSelector("#section > div > h2")).getText();
        assertEquals(text, "Register");
    }
    @Test
    @DisplayName("CT-007 - Adicionar um produto ao carrinho")
    public void addAProductToBasket() {
        HomePage home = new HomePage(driver);

        home.addAProductToCart();
        String buttonText = home.getTextViewBasket();
        assertEquals("View Basket", buttonText);
    }
    @Test
    @DisplayName("CT-008 - Adicionar três produtos ao carrinho")
    public void addThreeProductToBasket() {
        HomePage home = new HomePage(driver);

        home.addThreeProductToCart();
        String buttonText = home.getTextViewBasket();
        assertEquals("View Basket", buttonText);
    }

    @Test
    @DisplayName("CT-009 - Acessar o carrinho após adicionar produtos")
    public void addProductAndClickLinkCart() {
        HomePage home = new HomePage(driver);

        home.addThreeProductToCart();
        String buttonText = home.getTextViewBasket();
        assertEquals("View Basket", buttonText);

        home.menuBasketLink();
        String url = driver.getCurrentUrl();
        assertEquals("https://practice.automationtesting.in/basket/", url);
    }
    @Test
    @DisplayName("CT-010 - Enviar e-mail no formulário de newsletter")
    public void subscribeInputForm() {
        HomePage home = new HomePage(driver);

        String errorText = home.subscribeInputForm();

        assertEquals("Oops. Something went wrong. Please try again later.", errorText);
    }


    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
