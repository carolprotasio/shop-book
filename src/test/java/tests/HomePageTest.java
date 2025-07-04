package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.automationtesting.in/");
    }
    @Test
    public void searchIconTest() {
      HomePage home = new HomePage(driver);
      home.searchFor("java");

      String title = home.getSearchResultTitle();
      assertTrue(title.toLowerCase().contains("java"));
    }
    @Test
    public void shopLink() {
        driver.findElement(By.cssSelector("#menu-item-40 > a")).click();
        String text = driver.findElement(By.cssSelector("#woocommerce_price_filter-2 > h4")).getText();
        assertEquals("FILTER BY PRICE", text );
    }
    @Test
    public void myAccountLink() {
        driver.findElement(By.cssSelector("#menu-item-50 > a")).click();
        String text = driver.findElement(By.cssSelector("#customer_login > div.u-column1.col-1 > h2")).getText();
        assertEquals(text, "Login");
    }
    @Test
    public void testCasesLink() {
        driver.findElement(By.cssSelector("#menu-item-224 > a")).click();
        String text = driver.findElement(By.cssSelector("#accordion-222-sub_row_1-0-1-0-0 > h3")).getText();
        assertEquals(text, "HOME PAGE");
    }
    @Test
    public void atSiteLink() {
        driver.findElement(By.cssSelector("#menu-item-244 > a")).click();
        String text = driver.findElement(By.cssSelector("#site-description > span")).getText();
        assertEquals(text, "Automation Testing");
    }
    @Test
    public void demoSiteLink() {
        driver.findElement(By.cssSelector("#menu-item-251 > a")).click();
        String text = driver.findElement(By.cssSelector("#section > div > h2")).getText();
        assertEquals(text, "Register");
    }
    @Test
    public void addAProductToBasket() {
        HomePage home = new HomePage(driver);

        home.addAProductToCart();
        String buttonText = home.getTextViewBasket();
        assertEquals("View Basket", buttonText);
    }
    @Test
    public void addThreeProductToBasket() {
        HomePage home = new HomePage(driver);

        home.addThreeProductToCart();
        String buttonText = home.getTextViewBasket();
        assertEquals("View Basket", buttonText);
    }

    @Test
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
