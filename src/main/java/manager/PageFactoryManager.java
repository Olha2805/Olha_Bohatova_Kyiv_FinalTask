package manager;

import amazonPages.*;
import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public CartPage getCartPage(){return new CartPage(driver);}

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public ProductPage getProductPage(){return new ProductPage(driver);}

    public SearchPage getSearchPage(){return new SearchPage(driver);}

    public AmazonMusicUnlimitedPage getAmazonMusicUnlimitedPage(){return new AmazonMusicUnlimitedPage(driver);}

    public LanguagePage getLanguagePage(){return new LanguagePage(driver);}

}
