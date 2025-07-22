package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitHelper;

import java.time.Duration;

public class ChekoutPage {
    private WebDriver driver;
    private WaitHelper wait;

    public ChekoutPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WaitHelper(driver, 10);
    }
    public void fillFirstName(String name) {
        driver.findElement(By.id("billing_first_name")).clear();
        driver.findElement(By.id("billing_first_name")).sendKeys(name);
    }

    public void fillLastName(String name) {
        driver.findElement(By.id("billing_last_name")).clear();
        driver.findElement(By.id("billing_last_name")).sendKeys(name);
    }

    public void fillAddress(String address) {
        driver.findElement(By.id("billing_address_1")).clear();
        driver.findElement(By.id("billing_address_1")).sendKeys(address);
    }

    public void fillCity(String city) {
        driver.findElement(By.id("billing_city")).clear();
        driver.findElement(By.id("billing_city")).sendKeys(city);
    }

    public void fillPostcode(String postcode) {
        driver.findElement(By.id("billing_postcode")).clear();
        driver.findElement(By.id("billing_postcode")).sendKeys(postcode);
    }

    public void fillPhone(String phone) {
        driver.findElement(By.id("billing_phone")).clear();
        driver.findElement(By.id("billing_phone")).sendKeys(phone);
    }

    public void fillEmail(String email) {
        driver.findElement(By.id("billing_email")).clear();
        driver.findElement(By.id("billing_email")).sendKeys(email);
    }


    public void placeOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement placeOrderBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("place_order")));
        placeOrderBtn.click();

    }

    public String getOrderConfirmation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement confirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-thankyou-order-received")));
        return confirmation.getText();
    }
}
