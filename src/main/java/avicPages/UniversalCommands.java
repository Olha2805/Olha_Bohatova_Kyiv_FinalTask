package avicPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UniversalCommands extends BasePage{
    @FindBy(xpath = "//div[@class='about-prod__center']//a[contains(@class,'btn--orange')]")
    private WebElement buyInOneClick;

    @FindBy(xpath = "//div[@class='prod-cart__descr']")
    private WebElement allProductsForList;

    @FindBy(id = "js_cart")
    private WebElement addToCartPopup;

    @FindBy(xpath = "//div[@class='btns-cart-holder']//a[contains(@class,'btn--orange')]")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//h1[@class='page-title']")
    private WebElement nameOfProduct;

    @FindBy(xpath = "//a[contains(text(), 'Оформить заказ')]")
    private WebElement checkout;

    public UniversalCommands(WebDriver driver) {
        super(driver);
    }

    public void tapToBuyInOneClickButton(){
        buyInOneClick.click();
    }

    public void clickOnContinueShoppingButton() {
        continueShoppingButton.click();
    }

    public WebElement getAddToCartPopup() {
        return addToCartPopup;
    }

    public String getGetNameOfProduct(){
        return nameOfProduct.getText().toString();
    }

    public void clickToCheckOut() { checkout.click(); }
}
