package rozetkaPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//rz-user //button[@class='header__button']")
    private WebElement userButton;

    @FindBy(xpath = "//a[contains (@class,'register-link')]")
    private WebElement registerButton;

    @FindBy(xpath = "//input[@formcontrolname='name']")
    private WebElement nameCell;

    @FindBy(xpath = "//input[@formcontrolname='surname']")
    private WebElement surnameCell;

    @FindBy(xpath = "//input[@formcontrolname='phone']")
    private WebElement phoneNumberCell;

    @FindBy(xpath = "//input[@formcontrolname='email']")
    private WebElement emailCell;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    private WebElement passwordCell;

    @FindBy(xpath = "//button[@class='button button_size_large button_color_green auth-modal__submit']")
    private WebElement ultimateRegistration;

    @FindBy(xpath = "//fieldset[@class='form__row js-name validation_type_error']//p[@class='validation-message']")
    private WebElement messageInRegistrationStageForName;

    @FindBy(xpath = "//fieldset[@class='form__row js-surname validation_type_error']//p[@class='validation-message']")
    private WebElement messageInRegistrationStageForSurname;

    @FindBy(xpath = "//fieldset[@class='form__row js-phone validation_type_error']//form-error[@class='validation-message']")
    private WebElement messageInRegistrationStageForPhoneNumber;

    @FindBy(xpath = "//fieldset[@class='form__row js-email validation_type_error']//form-error[@class='validation-message']")
    private WebElement messageInRegistrationStageForEmail;

    @FindBy(xpath = "//fieldset[@class='form__row js-new_password validation_type_error']//p[@class='form__caption']")
    private WebElement messageInRegistrationStageForPassword;

    @FindBy(xpath = "//button[contains(@class, 'auth-modal__submit')]")
    private WebElement agreeButton;

    public void clickToUserButton(){userButton.click();}

    public WebElement getRegistrationButton(){return registerButton;}

    public void clickToRegisterButton(){registerButton.click();}

    public void writeToNameCell(final String keyword) {nameCell.sendKeys(keyword);}

    public void tapToNameCell(){nameCell.click();}

    public void writeToSurnameCell (final String keyword) {surnameCell.sendKeys(keyword);}

    public void tapToSurnameCell(){surnameCell.click();}

    public void writePhoneNumber(final String keyword) {phoneNumberCell.sendKeys(keyword);}

    public void tapToPhoneNumberCell(){phoneNumberCell.click();}

    public void writeMail(final String keyword) {emailCell.sendKeys(keyword);}

    public void tapToMailCell(){emailCell.click();}

    public void writePassword(final String keyword) {passwordCell.sendKeys(keyword);}

    public void tapToPasswordSell(){passwordCell.click();}

    public void tapToUltimateRegistration(){ultimateRegistration.click();}

    public boolean ifMessageForNameInRegistrationStageContainsWords(final String keyword){
        return messageInRegistrationStageForName
                .getText()
                .contains(keyword);}

    public boolean ifMessageForSurnameInRegistrationStageContainsWords(final String keyword){
        return messageInRegistrationStageForSurname
                .getText()
                .contains(keyword);}

    public boolean ifMessageForPhoneNumberInRegistrationStageContainsWords(final String keyword){
        return messageInRegistrationStageForPhoneNumber
            .getText()
            .contains(keyword);}

    public boolean ifMessageForEmailInRegistrationStageContainsWords(final String keyword){
        return messageInRegistrationStageForEmail
                .getText()
                .contains(keyword);}

    public boolean ifMessageForPasswordInRegistrationStageContainsWords(final String keyword){
        return messageInRegistrationStageForPassword
                .getText()
                .contains(keyword);}

    public String agreeButtonIsHere(){return agreeButton.getText();}

}