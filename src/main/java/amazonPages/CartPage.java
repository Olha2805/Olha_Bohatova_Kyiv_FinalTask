package amazonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@id='nav-cart-count']")
    private WebElement cartCount;

    @FindBy(xpath = "//div[@id='nav-cart-text-container']//span[@class='nav-line-2']")
    private WebElement nameOfCart;

    @FindBy(xpath = "//h1[@class='a-spacing-small']")
    private WebElement signInText;

    public String actualAmount(long time) {
        waitVisibilityOfElement(time, cartCount);
        return cartCount.getText();
    }

    public boolean isAmountOfProductsInCartIsCorrect(String amountOfProduct, long time) {
        waitVisibilityOfElement(time, cartCount);
        return cartCount.getText().contains(amountOfProduct);
    }

    public String getNameOfCart(long time) {
        waitVisibilityOfElement(time, nameOfCart);
        return nameOfCart.getText();
    }

    public boolean isSignTextTextVisible(long time) {
        waitVisibilityOfElement(time, signInText);
        return signInText.isDisplayed();
    }

}
