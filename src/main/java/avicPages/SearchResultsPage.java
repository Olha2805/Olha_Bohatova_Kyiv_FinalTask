package avicPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@class='prod-cart__descr']")
    private List<WebElement> searchResultsProductsListText;

    @FindBy(xpath = "//p[@class='col-xs-12']")
    private WebElement answerToIncorrectRequest;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String answerToIncorrectRequest(){return answerToIncorrectRequest.getText();}
}