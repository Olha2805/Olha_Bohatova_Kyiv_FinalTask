package rozetka;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class RegistrationTest extends BaseTest {

    private int TIME_FOR_WAIT = 3000;
    private String NAME_FOR_REGISTRATION = "Ольга";
    private String SURNAME_FOR_REGISTRATION = "Петрівна";
    private String PHONE_NUMBER_FOR_REGISTRATION = "0901234567";
    private String MAIL_FOR_REGISTRATION = "abcdefj@gmail.com";
    private String PASSWORD_FOR_REGISTRATION = "abCdfj125896";
    private String MESSAGE_FOR_INVALID_PARAMS = "Введіть";
    private String MESSAGE_FOR_INVALID_PASSWORD = "Пароль повинен складатися";


    @Test
    public void registrationWithAnything() throws InterruptedException {
        getHomePage().waitForPageLoadComplete(TIME_FOR_WAIT);
        getHomePage().clickToUserButton();
        getHomePage().waitForPageLoadComplete(TIME_FOR_WAIT*2);
        getHomePage().waitVisibilityOfElement(TIME_FOR_WAIT*2, getHomePage().getRegistrationButton());
        getHomePage().clickToRegisterButton();
        getHomePage().waitForPageLoadComplete(TIME_FOR_WAIT);
        getHomePage().tapToNameCell();  // first test point
        getHomePage().tapToSurnameCell();  // second test point
        getHomePage().tapToPhoneNumberCell();  // tap to cell for phone number
        getHomePage().tapToMailCell();  // tap to cell for mail
        getHomePage().tapToPasswordSell();  // tap to cell for password
        getHomePage().tapToUltimateRegistration();  // tap to registration button
        getHomePage().waitForPageLoadComplete(TIME_FOR_WAIT);

        boolean expectedNameMessage = getHomePage()
                .ifMessageForNameInRegistrationStageContainsWords(MESSAGE_FOR_INVALID_PARAMS);
        boolean expectedSurNameMessage = getHomePage()
                .ifMessageForSurnameInRegistrationStageContainsWords(MESSAGE_FOR_INVALID_PARAMS);
        boolean expectedMailMessage = getHomePage()
                .ifMessageForEmailInRegistrationStageContainsWords(MESSAGE_FOR_INVALID_PARAMS);
        boolean expectedPasswordMessage = getHomePage()
                .ifMessageForPasswordInRegistrationStageContainsWords(MESSAGE_FOR_INVALID_PASSWORD);

        assertTrue(expectedNameMessage && expectedSurNameMessage && expectedMailMessage && expectedPasswordMessage,
                "Name or(and) surname or(and) email or(and) password were entered");
    }


    @Test
    public void registrationWithNameAndSurname() throws InterruptedException {
        getHomePage().waitForPageLoadComplete(TIME_FOR_WAIT);
        getHomePage().clickToUserButton();
        getHomePage().waitVisibilityOfElement(TIME_FOR_WAIT*2, getHomePage().getRegistrationButton());
        getHomePage().clickToRegisterButton();
        getHomePage().waitForPageLoadComplete(TIME_FOR_WAIT);
        getHomePage().writeToNameCell(NAME_FOR_REGISTRATION);  // write name
        getHomePage().writeToSurnameCell(SURNAME_FOR_REGISTRATION);  // write surname
        getHomePage().tapToPhoneNumberCell();  // tap to cell for phone number
        getHomePage().tapToMailCell();  // tap to cell for mail
        getHomePage().tapToPasswordSell();  // tap to cell for password
        getHomePage().tapToUltimateRegistration();  // tap to registration button
        getHomePage().waitForPageLoadComplete(TIME_FOR_WAIT);

        boolean expectedPhoneNumberMessage = getHomePage()
                .ifMessageForPhoneNumberInRegistrationStageContainsWords(MESSAGE_FOR_INVALID_PARAMS);
        boolean expectedMailMessage = getHomePage()
                .ifMessageForEmailInRegistrationStageContainsWords(MESSAGE_FOR_INVALID_PARAMS);
        boolean expectedPasswordMessage = getHomePage()
                .ifMessageForPasswordInRegistrationStageContainsWords(MESSAGE_FOR_INVALID_PASSWORD);

        assertTrue(expectedPhoneNumberMessage && expectedMailMessage && expectedPasswordMessage,
                "Name or(and) email or(and) password were entered");
    }

    @Test
    public void registrationWithAllCorrectParams() throws InterruptedException {
        getHomePage().waitForPageLoadComplete(TIME_FOR_WAIT);
        getHomePage().clickToUserButton();
        getHomePage().waitForPageLoadComplete(TIME_FOR_WAIT*2);
        getHomePage().waitVisibilityOfElement(TIME_FOR_WAIT*2, getHomePage().getRegistrationButton());
        getHomePage().clickToRegisterButton();
        getHomePage().waitForPageLoadComplete(TIME_FOR_WAIT);
        getHomePage().writeToNameCell(NAME_FOR_REGISTRATION);  // write name
        getHomePage().writeToSurnameCell(SURNAME_FOR_REGISTRATION);  // write surname
        getHomePage().writePhoneNumber(PHONE_NUMBER_FOR_REGISTRATION);  // write phone number
        getHomePage().writeMail(MAIL_FOR_REGISTRATION);  // write mail
        getHomePage().writePassword(PASSWORD_FOR_REGISTRATION);  // write password
        getHomePage().tapToUltimateRegistration();  // tap to registration button
        getHomePage().waitForPageLoadComplete(TIME_FOR_WAIT*2);

        String textOnAgreeButton = "Підтвердити";
        assertTrue(getHomePage().agreeButtonIsHere().toString().contains(textOnAgreeButton), "кнопка містить" + getHomePage().agreeButtonIsHere().toString());
    }
}
