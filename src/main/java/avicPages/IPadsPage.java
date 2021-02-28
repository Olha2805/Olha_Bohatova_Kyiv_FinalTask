package avicPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IPadsPage extends BasePage {

    @FindBy(xpath = "//a[@class='prod-cart__buy'][contains(@data-ecomm-cart,' Gold (MPGW2)')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[@class='config__color ' and contains(@style,'fecf9c')]")
    private WebElement selectRoseColorCheckBox;

    @FindBy(xpath = "//a[@class='config__memory ']")
    private WebElement select64GB;


    @FindBy(xpath = "//div[@class ='prod-cart__descr']")
    private WebElement selectSomeIpad;

    public IPadsPage(WebDriver driver) {
        super(driver);
    }

    public void clickToSomeIPad(){
        selectSomeIpad.click();
    }
}
