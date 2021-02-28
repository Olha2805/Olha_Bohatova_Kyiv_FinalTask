package avicPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage {

    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement submitButton;

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public String getSubmitButtonText(){ return submitButton.getText().toString();}
}
