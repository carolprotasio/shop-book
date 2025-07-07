package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.ShopPage;
import utils.WaitHelper;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopTest {

    private WebDriver driver;
    private WaitHelper wait;

    @BeforeEach
    void setupTest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1320,1080"); // define tamanho manualmente
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.get("https://practice.automationtesting.in/shop/");
    }

    @Test
    @DisplayName("CT-001 Adicionar o primeiro produto no carrinho")
    public void addFirstProductToCart(){
        ShopPage shop = new ShopPage(driver);

        shop.addOneProductToCart();
        String text = shop.getViewBasket();
        assertEquals("View Basket", text);
    }

    @Test
    @DisplayName("CT-002 Deve adicionar três produtos no carrinho")
    public void addThreeProductsToACart(){
        ShopPage shop = new ShopPage(driver);

        shop.addOneProductToCart();
        shop.waitForCartCountToBe("1 Item");
        shop.addTwoProductToCart();
        shop.waitForCartCountToBe("2 Items");
        shop.addThreeProductToCart();
        shop.waitForCartCountToBe("3 Items");

        String text = shop.getViewBasket();
        assertEquals("View Basket", text);

        String total = shop.getCartCount();
        assertEquals("3 Items", total);
    }



    @AfterEach
    public void tearDown() { driver.quit();  }


}
