package amazonPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.Keys.ENTER;


public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    Actions action = new Actions(driver);

    @FindBy(xpath = "//a[@id = 'nav-logo-sprites']")
    private WebElement homeButton;

    @FindBy(xpath = "//span[@id = 'nav-global-location-data-modal-action']")
    private WebElement selectCountryButton;

    @FindBy(xpath = "//input[@class='GLUX_Full_Width a-declarative']")
    private WebElement selectPostCodeArea;

    @FindBy(xpath = "//span[@class='a-button a-button-span12']//input[@type='submit']")
    private WebElement applyButton;

    @FindBy(xpath = "//button[@name='glowDoneButton']")
    private WebElement doneButton;

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchArea;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@id='nav-hamburger-menu']")
    private WebElement menuButton;

    @FindBy(xpath = "//a[@data-menu-id = '2']")
    private WebElement amazonMusicButton;

    @FindBy(xpath = "//a[contains(text(), 'Amazon Music Unlimited')]")
    private WebElement unlimitedAmazonMusicButton;

    @FindBy(xpath = "//div[contains(text(), 'Best') or contains(text(), 'Arts & Crafts') or contains(text(), 'Clothing)]")
    private WebElement menuElementButton;

    @FindBy(xpath = "//a[contains(text(), 'Appliances') or contains(text(), 'Crafting') or contains(text(), 'Amazon Fashion')]")
    private WebElement submenuButton;

    @FindBy(xpath = "//div[contains(text(), 'Arts & Crafts') or contains(text(), 'Best')]")
    private WebElement artsAndCraftsButton;

    @FindBy(xpath = "//a[contains(text(), 'Crafting') or contains(text(), 'Baby')]")
    private WebElement craftingButton;

    @FindBy(xpath = "//a[@data-menu-id = '5']")
    private WebElement electronicsButton;

    @FindBy(xpath = "//a[contains(text(), 'Accessories & Supplies')]")
    private WebElement accessoriesAndSuppliesButton;

    @FindBy(xpath = "//select[@aria-describedby='searchDropdownDescription']")
    private WebElement categoriesButtonInSearchArea;

    @FindBy(xpath = "//option[contains(text(), 'Baby')]")
    private WebElement selectBabyCategory;

    @FindBy(xpath = "//span[@class='icp-nav-flag icp-nav-flag-us']")
    private WebElement languageBar;

    @FindBy(xpath = "//a[@class='hmenu-item' and contains(text(), 'United States')]")
    private WebElement countryButton;

    @FindBy(xpath = "//span[@class='a-button-text a-declarative']//span[contains(text(), 'United States')]")
    private WebElement selectRegionButton;

    @FindBy(xpath = "//span[contains(text(), 'Australia')]")
    private WebElement selectAustraliaInTheList;

    @FindBy(xpath = "//span[contains(text(), 'Go to website')]")
    private WebElement goToWebsiteButton;

    @FindBy(xpath = "//div[@class='a-row a-spacing-small a-size-base a-color-secondary']//span[@class='a-color-base']")
    private WebElement amazonCertifiedArea;

    public void selectUSARegion(long time, String postCode) {
        selectCountryButton.click();
        waitVisibilityOfElement(time * 2, selectPostCodeArea);
        selectPostCodeArea.sendKeys(postCode);
        applyButton.click();
        doneButton.click();
        waitVisibilityOfElement(time * 2, selectCountryButton);
    }

    public void clickHomeButton() {
        homeButton.click();
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public boolean isSearchFieldVisible() {
        return searchArea.isDisplayed();
    }

    public void clickToSearchArea(final String keyword) {
        searchArea.click();
        searchArea.sendKeys(keyword, ENTER);
    }

    public void writeToSearchArea(final String keyword) {
        searchArea.click();
        searchArea.sendKeys(keyword);
    }

    public void clickSearchButton(long time) {
        waitVisibilityOfElement(time, searchButton);
        searchButton.click();
        waitVisibilityOfElement(time, homeButton);
    }

    public void clickMenuButton(long time) {
        waitVisibilityOfElement(time, menuButton);
        menuButton.click();
    }

    public void clickAmazonMusicButton(long time) {
        waitVisibilityOfElement(time, amazonMusicButton);
        amazonMusicButton.click();
    }

    public void clickAmazonMusicUnlimitedButton(long time) {
        waitVisibilityOfElement(time, unlimitedAmazonMusicButton);
        unlimitedAmazonMusicButton.click();
    }

    public void clickKindleButton(long time) {
        waitVisibilityOfElement(time, menuElementButton);
        menuElementButton.click();
    }

    public void clickKindleSubmenuButton(long time) {
        waitVisibilityOfElement(time, submenuButton);
        submenuButton.click();
    }


    public void clickArtsAndCraftsButton(long time) {
        waitVisibilityOfElement(time, artsAndCraftsButton);
        artsAndCraftsButton.click();
    }

    public void clickCraftingButton(long time) {
        waitVisibilityOfElement(time, craftingButton);
        craftingButton.click();
    }

    public void clickElectronicsButton(long time) {
        waitVisibilityOfElement(time, electronicsButton);
        electronicsButton.click();
    }

    public void clickAccessoriesAndSuppliesButton(long time) {
        waitVisibilityOfElement(time, accessoriesAndSuppliesButton);
        accessoriesAndSuppliesButton.click();
    }

    public void clickCategoriesButtonInSearchArea(long time) {
        waitVisibilityOfElement(time, categoriesButtonInSearchArea);
        categoriesButtonInSearchArea.click();
    }

    public void clickBabyCategory(long time) {
        waitVisibilityOfElement(time, selectBabyCategory);
        selectBabyCategory.click();
    }

    public void clickLanguageBar(long time) {
        waitVisibilityOfElement(time, languageBar);
        action.moveToElement(languageBar).build().perform();
        languageBar.click();
    }

    public void clickCountryButton() {
        countryButton.click();
    }

    public void clickSelectRegionButton() {
        selectRegionButton.click();
    }

    public void clickAustraliaInRegion() {
        selectAustraliaInTheList.click();
    }

    public boolean canClickGoToWebsiteButton(final String Name_of_button) {
        return goToWebsiteButton.getText().contains(Name_of_button);
    }

    public String getTextFromAmazonCertifiedArea() {
        return amazonCertifiedArea.getText();
    }

}