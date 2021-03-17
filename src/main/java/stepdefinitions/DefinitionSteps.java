package stepdefinitions;

import amazonPages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {
    private static final long DEFAULT_TIMEOUT = 500;
    private static final long TIMEOUT_FOR_FIRST_PAGE_LOAD = 1000;
    private static final String POST_CODE_OF_USA = "99501";

    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    HomePage homePage;
    SearchPage searchPage;
    ProductPage productPage;
    CartPage cartPage;
    AmazonMusicUnlimitedPage amazonMusicUnlimitedPage;
    LanguagePage languagePage;


    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }


    @Given("User opens {string} page")
    public void openHomePage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
        homePage.waitForPageLoadComplete(TIMEOUT_FOR_FIRST_PAGE_LOAD);
        homePage.selectUSARegion(DEFAULT_TIMEOUT, POST_CODE_OF_USA);

    }

    @And("User checks search field visibility")
    public void checksSearchFieldVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isSearchFieldVisible();
    }

    @When("User makes search by keyword {string}")
    public void userMakesSearchByKeywordKeyword(final String keyword) {
        homePage = pageFactoryManager.getHomePage();
        homePage.clickToSearchArea(keyword);
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT * 2);
    }

    @When("User writes keyword {string} in search area")
    public void userWritesKeywordInSearchArea(final String keyword) {
        homePage = pageFactoryManager.getHomePage();
        homePage.writeToSearchArea(keyword);
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT * 2);
    }

    @When("User click to Menu button")
    public void userClickToMenuButton() {
        homePage.clickMenuButton(DEFAULT_TIMEOUT);
    }

    @When("User click to language bar")
    public void userClickToLanguageBar() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickLanguageBar(DEFAULT_TIMEOUT);
    }

    @And("User clicks search button")
    public void clickSearchButton() {
        homePage.clickSearchButton(DEFAULT_TIMEOUT);
    }

    @And("User click add to cart on product")
    public void clickAddToCartOnProductForSearchingResult() {
        productPage = pageFactoryManager.getProductPage();
        productPage.clickAddToCartButton(DEFAULT_TIMEOUT);
    }

    @And("User click Can works with Alexa filter button")
    public void userClickCanWorksWithAlexaFilterButton() {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.clickWorksWithAlexaCheckBox(DEFAULT_TIMEOUT);
        searchPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User click Amazon Music button")
    public void userClickAmazonMusicButton() {
        homePage = pageFactoryManager.getHomePage();
        homePage.clickAmazonMusicButton(DEFAULT_TIMEOUT);
    }

    @And("User click Amazon Music Unlimited button")
    public void userClickAmazonMusicUnlimitedButton() {
        homePage = pageFactoryManager.getHomePage();
        homePage.clickAmazonMusicUnlimitedButton(DEFAULT_TIMEOUT * 2);
    }

    @And("User click Open Web Player button")
    public void userClickOpenWebPlayerButton() {
        amazonMusicUnlimitedPage = pageFactoryManager.getAmazonMusicUnlimitedPage();
        amazonMusicUnlimitedPage.clickOpenWebPlayerButton(DEFAULT_TIMEOUT);
    }

    @And("User clicks Kindle button")
    public void userClickKindleButton() {
        homePage = pageFactoryManager.getHomePage();
        homePage.clickKindleButton(DEFAULT_TIMEOUT);
        homePage.clickKindleSubmenuButton(DEFAULT_TIMEOUT);
    }

    @And("User click Arts and Crafts button")
    public void userClickArtsAndCraftsButton() {
        homePage = pageFactoryManager.getHomePage();
        homePage.clickArtsAndCraftsButton(DEFAULT_TIMEOUT);
    }

    @And("User click Crafting button")
    public void userClickCraftingButton() {
        homePage = pageFactoryManager.getHomePage();
        homePage.clickCraftingButton(DEFAULT_TIMEOUT);
    }

    @And("User click Electronics button")
    public void userClickElectronicsButton() {
        homePage = pageFactoryManager.getHomePage();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickElectronicsButton(DEFAULT_TIMEOUT);
    }

    @And("User click Accessories and Supplies button")
    public void userClickAccessoriesAndSuppliesButton() {
        homePage = pageFactoryManager.getHomePage();
        homePage.clickAccessoriesAndSuppliesButton(DEFAULT_TIMEOUT);
    }

    @And("User click navigation icon")
    public void userClickNavigationIcon() {
        homePage = pageFactoryManager.getHomePage();
        homePage.clickCategoriesButtonInSearchArea(DEFAULT_TIMEOUT);
    }

    @And("User select another language")
    public void userSelectAnotherLanguage() {
        languagePage = pageFactoryManager.getLanguagePage();
        languagePage.selectAnotherLanguage(DEFAULT_TIMEOUT);
    }

    @And("User click Save Changes button")
    public void userClickSaveChangesButton() {
        languagePage = pageFactoryManager.getLanguagePage();
        languagePage.clickSaveSelectedLanguage(DEFAULT_TIMEOUT);
    }

    @And("User select CategoriesName category")
    public void userSelectCategoriesNameCategory() {
        homePage = pageFactoryManager.getHomePage();
        homePage.clickBabyCategory(DEFAULT_TIMEOUT);
    }

    @And("User click Home button")
    public void userClickHomeButton() {
        homePage.clickHomeButton();
    }

    @And("User select another country")
    public void userSelectAnotherCountry() {
        homePage.clickCountryButton();
        homePage.clickSelectRegionButton();
        homePage.clickAustraliaInRegion();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User click buy now button")
    public void userClickBuyNowButton() {
        productPage = pageFactoryManager.getProductPage();
        productPage.clickBuyNowButton();
    }

    @And("User can click {string} button")
    public void userClickGoToWebsiteButton(final String Name_of_button) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(homePage.canClickGoToWebsiteButton(Name_of_button));
    }

    @Then("User checks that amount of products in cart are {string}")
    public void checksThatAmountOfProductsInCartIsCorrect(final String amountOfProduct) {
        cartPage = pageFactoryManager.getCartPage();
        cartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(cartPage.actualAmount(DEFAULT_TIMEOUT), cartPage.isAmountOfProductsInCartIsCorrect(amountOfProduct, DEFAULT_TIMEOUT));
    }

    @Then("User check that at least one element on page contains search word {string}")
    public void userCheckThatOneElementOnePageContainsSearchWordKeyword(final String searchWord) {
        searchPage = pageFactoryManager.getSearchPage();
        assertTrue(searchPage.isOneElementContainsWord(searchWord));
    }

    @Then("User checks that see word {string} on product area")
    public void userChecksThatSeeKeywordInURL(final String word) {
        assertTrue(homePage.getTextFromAmazonCertifiedArea().contains(word));
    }

    @Then("User check that see {string} period")
    public void userCheckThatSeeDaysPeriod(final String period) {
        amazonMusicUnlimitedPage = pageFactoryManager.getAmazonMusicUnlimitedPage();
        assertTrue(amazonMusicUnlimitedPage.isVisibleThirtyDaysText(DEFAULT_TIMEOUT, period));
    }

    @Then("User check that url contains {string}")
    public void userCheckThatUrlContainsString(final String wordForCheck) {
        amazonMusicUnlimitedPage = pageFactoryManager.getAmazonMusicUnlimitedPage();
        assertTrue(driver.getCurrentUrl().contains(wordForCheck));
    }

    @Then("User checks answer to invalid search word {string}")
    public void userChecksAnswerToInvalidSearchWord(String answerWords) {
        searchPage = pageFactoryManager.getSearchPage();
        assertTrue(searchPage.getAnswerToIncorrectSearchWord(DEFAULT_TIMEOUT).contains(answerWords));
    }

    @Then("User checks that cart have name {string}")
    public void userChecksThatCartHaveNameNewNameOfCart(String expectedNameOfCart) {
        cartPage = pageFactoryManager.getCartPage();
        assertTrue(cartPage.getNameOfCart(DEFAULT_TIMEOUT).contains(expectedNameOfCart));
    }

    @Then("User checks that see Sign-in text")
    public void userChecksThatSeeSignInText() {
        cartPage = pageFactoryManager.getCartPage();
        assertTrue(cartPage.isSignTextTextVisible(DEFAULT_TIMEOUT));
    }

    @Then("User checks new URL contains {string}")
    public void userChecksNewURLContainsDomain(final String domainName) {
        assertTrue(driver.getCurrentUrl().contains(domainName));
    }


    @After
    public void tearDown() {
        driver.close();
    }
}
