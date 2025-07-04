package pages;

import org.openqa.selenium.WebDriver;
import utils.WaitHelper;

public class BasketPage {
    private WebDriver driver;
    private WaitHelper wait;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitHelper(driver, 10);
    }

}
