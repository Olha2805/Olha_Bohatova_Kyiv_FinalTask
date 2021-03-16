package amazonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LanguagePage extends BasePage{
    public LanguagePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span [@class='a-label a-radio-label' and contains(text(), 'ES')]")
    private WebElement selectSpanishLangauge;

    @FindBy(xpath = "//input[@class='a-button-input']")
    private WebElement saveLanguageButton;

    public void selectAnotherLanguage(long time) {
        waitVisibilityOfElement(time, selectSpanishLangauge);
        selectSpanishLangauge.click();}

    public void clickSaveSelectedLanguage(long time) {
        waitVisibilityOfElement(time, saveLanguageButton);
        saveLanguageButton.click();}
}
