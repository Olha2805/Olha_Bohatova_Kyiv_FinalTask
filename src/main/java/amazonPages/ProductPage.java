package amazonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal' or @class='a-size-base-plus a-color-base a-text-normal' or contains(@class, 'featuringText')]")
    private WebElement openProductPage;

    @FindBy(xpath = "//input [@id='add-to-cart-button']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//input[@id='buy-now-button']")
    private WebElement buyNowButton;

    @FindBy(xpath = "//a[@id='nav-hamburger-menu']")
    private WebElement menuButton;

    public void clickAddToCartButton(long time) {
        waitVisibilityOfElement(time, openProductPage);
        if (openProductPage.isDisplayed()) {
            openProductPage.click();
        }
        waitForPageLoadComplete(time);
        addToCartButton.click();
        waitVisibilityOfElement(time, menuButton);
    }

    public void clickBuyNowButton() {
        openProductPage.click();
        buyNowButton.click();
    }
}
