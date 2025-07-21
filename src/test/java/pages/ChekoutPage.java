package pages;

import org.openqa.selenium.WebDriver;
import utils.WaitHelper;

public class ChekoutPage {
    private WebDriver driver;
    private WaitHelper wait;

    public ChekoutPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WaitHelper(driver, 10);
    }
}
