package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitHelper;

public class BasketPage {
    private WebDriver driver;
    private WaitHelper wait;

    private final By quantityInput = By.cssSelector(".cart_item .quantity input");
    private final By updateCartBtn = By.name("update_cart");
    private final By subtotalText = By.cssSelector("tr.cart-subtotal td span.woocommerce-Price-amount");


    public BasketPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitHelper(driver, 10);
    }
    public void removeProductFromBasket() {
        wait.waitForElementVisible(By.cssSelector(".product-remove a")).click();
    }

    public String isBasketEmpty() {
        return wait.waitForElementVisible(By.cssSelector(".cart-empty")).getText();

    }
    public void updateQuantityTo(int quantity) {
        WebElement qtyInput = wait.waitForElementVisible(quantityInput);
        qtyInput.clear();
        qtyInput.sendKeys(String.valueOf(quantity));
        driver.findElement(updateCartBtn).click();
    }

    public int getQuantityValue() {
        WebElement qtyInput = wait.waitForElementVisible(quantityInput);
        return Integer.parseInt(qtyInput.getAttribute("value"));
    }
    public ChekoutPage goToCheckoutPage(){
        wait.waitForElementVisible(By.cssSelector("#page-34 > div > div.woocommerce > div > div > div > a")).click();
        return new ChekoutPage(driver);

    }



}
