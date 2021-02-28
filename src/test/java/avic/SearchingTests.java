package avic;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.openqa.selenium.Keys.ENTER;
import static org.testng.Assert.assertEquals;

public class SearchingTests extends BaseTest {

    private String SEARCH_INCORRECT_KEYWORD = "блаблабла";
    private String ANSVER_TO_INCORRECT_KEYWORD = "Ничего не найдено";
    private int TIME_FOR_WAIT = 300;

    @Test
    public void checkAnswerToIncorrectSearchingWord() {
        getHomePage().searchByKeyword(SEARCH_INCORRECT_KEYWORD, ENTER);
        ExpectedConditions.visibilityOfAllElements();
        String expectedAnswer = ANSVER_TO_INCORRECT_KEYWORD;
        String actualAnswer = getSearchResultsPage().answerToIncorrectRequest();
        assertEquals(actualAnswer, expectedAnswer);
    }

    @Test
    public void checkMatchingNumberOfElements() {
        getHomePage().clickToMi();
        getUniversalCommands().waitForPageLoadComplete(TIME_FOR_WAIT);
        assertEquals(getHomePage().getListOfCategories(), getHomePage().getNumberOfElementsInPage());
    }
}
