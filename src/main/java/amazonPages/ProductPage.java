package amazonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(), 'No thanks')]")
    private WebElement noThanksButton;

    @FindBy(xpath = "//div[@class='a-section a-spacing-mini imageContainer aok-relative']")
    private WebElement bookCategory;

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal' or @class='a-size-base-plus a-color-base a-text-normal' or contains(@class, 'featuringText')]")
    private WebElement openProductPage;

    @FindBy(xpath = "//input [@id='add-to-cart-button']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//input[@id='buy-now-button']")
    private WebElement buyNowButton;

    public void clickAddToCartButton(long time){
        waitVisibilityOfElement(time, openProductPage);
        if (openProductPage.isDisplayed()){openProductPage.click();}
        waitForPageLoadComplete(time);
        addToCartButton.click();
        waitVisibilityOfElement(time, addToCartButton);
    }

    public void clickByuNowButton(){
        openProductPage.click();
        buyNowButton.click();}



}
