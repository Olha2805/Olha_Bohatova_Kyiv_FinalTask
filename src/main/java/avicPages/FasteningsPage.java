package avicPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FasteningsPage extends BasePage {

    @FindBy(xpath = "//div[@class='brand-box__title']//a[contains(text(), 'Крепления')]")
    private WebElement fasteningsForTV;

    @FindBy(xpath = "//a[@class= 'prod-cart__buy'][contains(@data-ecomm-cart, 'Кронштейн')]")
    private WebElement buyOneFasterning;

    public FasteningsPage(WebDriver driver) {
        super(driver);
    }

    public void clickToFasteningsForTVButton() { fasteningsForTV.click(); }

    public WebElement visibilityOfElement(){return buyOneFasterning;}

    public void clickToBuyOneFasterning(){ buyOneFasterning.click(); }
}
