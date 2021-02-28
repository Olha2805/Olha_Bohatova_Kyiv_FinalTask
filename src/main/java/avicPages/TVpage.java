package avicPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TVpage extends BasePage{

    @FindBy(xpath = "//div[@class='brand-box__title']//a[contains(text(), 'Телевизоры')]")
    private WebElement tapToTVs;

    @FindBy(xpath = "//a[@class= 'prod-cart__buy'][contains(@data-ecomm-cart, 'Телевизор LG 49NANO806NA')]")
    private WebElement selectTV;



    public TVpage(WebDriver driver) {
        super(driver);
    }

    public void clickTVs(){ tapToTVs.click(); }

    public void buyOneTV(){ selectTV.click();}



}
