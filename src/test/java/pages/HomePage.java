package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utils.WaitHelper;

public class HomePage {

    private WebDriver driver;
    private WaitHelper wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitHelper(driver, 10);
    }

    private By inputSearch = By.id("s");
    private By resultTitle = By.cssSelector("#content > h1");

    public void searchFor(String term) {
        wait.waitForElementVisible(inputSearch).sendKeys(term + Keys.ENTER);
    }

    public String getSearchResultTitle() {
        return wait.waitForElementVisible(resultTitle).getText();
    }

    private By addFirstCartButton = By.cssSelector(
            "#text-22-sub_row_1-0-2-0-0 > div > ul > li > a.button.product_type_simple.add_to_cart_button.ajax_add_to_cart"
    );
    private By addSecondCartButton = By.cssSelector(
            "#text-22-sub_row_1-0-2-1-0 > div > ul > li > a.button.product_type_simple.add_to_cart_button.ajax_add_to_cart"
    );
    private By addThirdCartButton = By.cssSelector(
            "#text-22-sub_row_1-0-2-2-0 > div > ul > li > a.button.product_type_simple.add_to_cart_button.ajax_add_to_cart"
    );

    private By viewBasketButton = By.xpath("//a[contains(@class, 'added_to_cart') and contains(text(), 'View Basket')]");



    public void addAProductToCart() {
        driver.findElement(addSecondCartButton).click();
    }
    public void addThreeProductToCart() {
        driver.findElement(addFirstCartButton).click();
        driver.findElement(addSecondCartButton).click();
        driver.findElement(addThirdCartButton).click();
    }

    public String getTextViewBasket() {
        return wait.waitForElementVisible(viewBasketButton).getText();
    }
    public String subscribeInputForm() {
        driver.findElement(By.cssSelector("input[type=email]"))
                .sendKeys("test@qa.com");
        driver.findElement(By.cssSelector("p:nth-child(2) > input[type=submit]"))
                .click();
        return driver.findElement(By.cssSelector("#mc4wp-form-1 > div.mc4wp-response > div > p"))
                .getText();
    }
    public BasketPage menuBasketLink() {
        By cartIcon = By.cssSelector("#wpmenucartli > a > span.cartcontents");
        driver.findElement(cartIcon).click();
        return new BasketPage(driver);
    }

}
