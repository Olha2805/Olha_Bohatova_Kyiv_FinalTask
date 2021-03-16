package amazonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonMusicUnlimitedPage extends BasePage {
    public AmazonMusicUnlimitedPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='a-size-medium']")
    private WebElement tryForFreeButton;

    @FindBy(xpath = "//h1[@class='font_Amazon_Ember_Regular color_font_trueWhite copy']")
    private WebElement thirtyDaysText;

    @FindBy(xpath = "//span[@class='nav-a-content']//img[@class='nav-image']")
    private WebElement openWebPlayerButton;


    public boolean isVisibleTryForFreeButton(long time) {
        waitVisibilityOfElement(time, tryForFreeButton);
        return tryForFreeButton.isDisplayed();}  //.getText().contains("Try it free")

    public boolean isVisibleThirtyDaysText(long time, String number) {
        waitVisibilityOfElement(time, thirtyDaysText);
        return thirtyDaysText.getText().contains(number);}

    public void clickOpenWebPlayerButton(long time) {
        waitVisibilityOfElement(time, openWebPlayerButton);
        openWebPlayerButton.click();}
}
