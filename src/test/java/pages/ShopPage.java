package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitHelper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShopPage {
    private WebDriver driver;
    private WaitHelper wait;

    private final By addToCartBtn = By.xpath("//*[@id=\"content\"]/ul/li[1]/a[2]");
    private final By viewBasketLink = By.xpath("//*[@id=\"content\"]/ul/li[1]/a[3]");
    private final By addTwoCartBtn = By.xpath("//*[@id=\"content\"]/ul/li[2]/a[2]");
    private final By addThreeCartBtn = By.xpath("//*[@id=\"content\"]/ul/li[3]/a[2]");

    private final By cartCount = By.cssSelector(".cartcontents");

    public ShopPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitHelper(driver, 10);
    }
    public void addOneProductToCart() {
        wait.waitForElementVisible(addToCartBtn).click();
    }

    public String getViewBasket(){
        return wait.waitForElementVisible(viewBasketLink).getText();
    }
    public void addTwoProductToCart() {
        wait.waitForElementVisible(addTwoCartBtn).click();
    }
    public void addThreeProductToCart() {
        wait.waitForElementVisible(addThreeCartBtn).click();
    }
    public void waitForCartCountToBe(String expectedCount) {
        wait.wait.until(driver -> {
            String currentCount = driver.findElement(cartCount).getText().trim().toLowerCase();
            return currentCount.equals(expectedCount.toLowerCase());
        });
    }

    public String getCartCount(){

        return wait.waitForElementVisible(cartCount).getText();
    }
    public void navigateToShopMenu() {
        driver.findElement(By.cssSelector("#menu-item-40 > a")).click();
    }

    public void moveSliderRight(int offsetX) {
        WebElement slider = driver.findElement(By.cssSelector(".price_slider_wrapper .ui-slider-handle:nth-child(2)"));
        Actions action = new Actions(driver);
        action.dragAndDropBy(slider, offsetX, 0).perform();
    }

    public void applyPriceFilter() {
        driver.findElement(By.cssSelector(".price_slider_amount .button")).click();
    }

    public List<WebElement> getFilteredProducts() {
        return driver.findElements(By.cssSelector(".products .product"));
    }

    public String getFirstProductTitle() {
        return getFilteredProducts().get(0).findElement(By.cssSelector("h3")).getText();
    }

    public String getFirstProductPrice() {
        return getFilteredProducts().get(0).findElement(By.cssSelector(".price")).getText();
    }


}
