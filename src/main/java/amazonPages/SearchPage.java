package amazonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='a-link-normal a-text-normal']")
    private WebElement oneProductsOnPage;

    @FindBy(xpath = "//li[@aria-label='Works with Alexa']//i[@class='a-icon a-icon-checkbox']")
    private WebElement worksWithAlexaCheckBox;

    @FindBy(xpath = "//span[contains(text(), 'No results for')]")
    private WebElement answerToIncorrectSearchWord;

    @FindBy(xpath = "//div[@class='a-row a-spacing-small a-size-base a-color-secondary']//span[@class='a-color-base']")
    private WebElement amazonCertifiedArea;

    public void clickToProduct(long time) {
        waitVisibilityOfElement(time, oneProductsOnPage);
        oneProductsOnPage.click();
    }

    public void clickWorksWithAlexaCheckBox(long time) {
        waitVisibilityOfElement(time, worksWithAlexaCheckBox);
        worksWithAlexaCheckBox.click();
        waitVisibilityOfElement(time, amazonCertifiedArea);
    }

    public String getAnswerToIncorrectSearchWord(long time) {
        waitVisibilityOfElement(time, answerToIncorrectSearchWord);
        return answerToIncorrectSearchWord.getText();
    }

    public boolean isOneElementContainsWord(String word) {
        waitVisibilityOfElement(500, oneProductsOnPage);
        return oneProductsOnPage.getText().contains(word);
    }
}
