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


    //tr.cart-subtotal > td > span
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

    public String getSubtotal() {
        WebElement element = wait.waitForElementVisible(subtotalText);
        return element.getText().trim();
    }
    public int getQuantityValue() {
        WebElement qtyInput = wait.waitForElementVisible(quantityInput);
        return Integer.parseInt(qtyInput.getAttribute("value"));
    }



}
