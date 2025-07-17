package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.ShopPage;
import utils.WaitHelper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    @Test
    @DisplayName("CT-003 - Filtrar produtos por preço")
    public void filterProductByPrice() {
        ShopPage shop = new ShopPage(driver);

        shop.navigateToShopMenu();
        shop.moveSliderRight(200);
        shop.applyPriceFilter();

        List<WebElement> produtos = shop.getFilteredProducts();

        assertEquals(1, produtos.size(), "Deveria retornar apenas 1 produto com esse filtro.");
        assertEquals("Selenium Ruby", shop.getFirstProductTitle(), "Produto esperado: Selenium Ruby");

        String preco = shop.getFirstProductPrice();
        assertTrue(preco.contains("500") || preco.contains("₹500"), "Preço deve refletir o filtro aplicado.");
    }
    @Test
    @DisplayName("CT-004 Verificar detalhes do produto Selenium Ruby")
    public void shouldDisplayProductDetails() {
        ShopPage shop = new ShopPage(driver);

        shop.openProductDetail("Selenium Ruby");

        assertEquals("Selenium Ruby", shop.getProductDetailTitle());
        assertTrue(shop.getProductPrice().contains("₹500.00"));
    }
    @Test
    @DisplayName("CT-005 Deve adicionar um produto no carrinho da pagina de detalhe do produto")
    public void shouldAddProductFromDetailPage(){
        ShopPage shop = new ShopPage(driver);
        String book = "Thinking in HTML";

        shop.openProductDetail(book);
        shop.addToCartFromDetailPage();

        String actualMessage = shop.confirmedProductBasketFromDetails();
        System.out.println("🔍 Mensagem da página: " + actualMessage);
        // Normaliza texto: remove quebras de linha e aspas tipográficas
        String normalized = actualMessage
                .toLowerCase()
                .replace("\n", " ")
                .replace("“", "\"")
                .replace("”", "\"")
                .trim();

        assertTrue(normalized.contains("\"thinking in html\" has been added to your basket."),
                "A mensagem esperada não foi encontrada: " + normalized);
    }
    @Test
    @DisplayName("CT-006 Deve adicionar no carrinho um produto e remover do carrinho na pagina - basket")
        public void shouldRemoveAProductFromBasketPage(){
            ShopPage shop = new ShopPage(driver);

            shop.addOneProductToCart();
            shop.goToBasketPage();
            shop.removeProductFromBasket();

        String actualMessage = shop.isBasketEmpty().trim();
        System.out.println("🔍 Mensagem da página: " + actualMessage);

            assertEquals("Your basket is currently empty.", actualMessage);
        }
    //@Test
    //@DisplayName("CT-007 Deve filtrar produto")

    @AfterEach
    public void tearDown() { driver.quit();  }


}
