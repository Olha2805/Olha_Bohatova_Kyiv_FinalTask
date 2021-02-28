package avic;

import org.testng.annotations.Test;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.Keys.ENTER;
import static org.testng.Assert.assertEquals;

public class AddToCartTests extends BaseTest {

    private String SEARCH_KEYWORD_iPad = "iPad";
    private int TIME_FOR_WAIT = 300;
    private String EXPEXTED_WORDS_IN_DIFFERENT_PRODUCT_TEST = "Заказ подтверждаю";

    @Test
    public void checkAddingElementToTheCart()  {
        getHomePage().searchByKeyword(SEARCH_KEYWORD_iPad, ENTER);
        getIPadsResultsPage().waitForPageLoadComplete(TIME_FOR_WAIT);
        getIPadsResultsPage().clickToSomeIPad();
        getIPadsResultsPage().waitForPageLoadComplete(TIME_FOR_WAIT);
        String expectedName = getUniversalCommands().getGetNameOfProduct();
        getUniversalCommands().waitForPageLoadComplete(TIME_FOR_WAIT);
        getUniversalCommands().tapToBuyInOneClickButton();

        assertEquals(getDriver()
                .findElement(xpath("//div[@id='js_oneclickModal']//div[@class='col-sm-6 col-xs-12']//div[@class='name']"))
                .getText().toString(), expectedName);
    }


    @Test
    public void checkAddToCartSeveralDifferentProducts() throws InterruptedException {

        getHomePage().clickOnProductCatalogButton();  // open TV page
        getUniversalCommands().waitForPageLoadComplete(TIME_FOR_WAIT);
        getHomePage().clickToTVsButton();
        getUniversalCommands().waitForPageLoadComplete(TIME_FOR_WAIT);

        getTVPageResultsPage().clickTVs();  // buy one TV
        getUniversalCommands().waitForPageLoadComplete(TIME_FOR_WAIT);
        getTVPageResultsPage().buyOneTV();
        getUniversalCommands().waitVisibilityOfElement(30, getUniversalCommands().getAddToCartPopup());
        getUniversalCommands().clickOnContinueShoppingButton();
        getUniversalCommands().waitForPageLoadComplete(TIME_FOR_WAIT);

        getHomePage().clickOnProductCatalogButton();  // open TV page
        getIPadsResultsPage().waitForPageLoadComplete(TIME_FOR_WAIT);
        getHomePage().clickToTVsButton();
        getIPadsResultsPage().waitForPageLoadComplete(TIME_FOR_WAIT);

        getFasteningsPage().clickToFasteningsForTVButton();  // buy one fasterning
        getUniversalCommands().waitVisibilityOfElement(TIME_FOR_WAIT, getFasteningsPage().visibilityOfElement());
        getFasteningsPage().clickToBuyOneFasterning();
        getUniversalCommands().waitVisibilityOfElement(30, getUniversalCommands().getAddToCartPopup());
        getUniversalCommands().clickToCheckOut();  // click to "Оформить заказ" button

        getUniversalCommands().waitForPageLoadComplete(TIME_FOR_WAIT);
        assertEquals(getCheckOutPage().getSubmitButtonText(), EXPEXTED_WORDS_IN_DIFFERENT_PRODUCT_TEST);
    }

}
