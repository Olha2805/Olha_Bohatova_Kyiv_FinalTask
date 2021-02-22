package avic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.lang.*;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.Keys.ENTER;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FirstTest {

    private WebDriver driver;

    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();//создаем экзаемпляр хром драйвера
        driver.manage().window().maximize();//открыли браузер на весь экран
        driver.get("https://avic.ua/");//открыли сайт
        ExpectedConditions.visibilityOfAllElements();
    }

    @Test(priority = 1)
    public void checkAddingElementToTheCart() throws InterruptedException {
       driver.findElement(xpath("//input[@id='input_search']"))
               .sendKeys("iPad", ENTER); // search iPads
        ExpectedConditions.visibilityOfAllElements();
        List<WebElement> iPads = driver.findElements(By.xpath("//div[@class='prod-cart__descr']")); // create list of all iPads
        iPads.get(3).click(); // select 4th iPad from the List and click
        driver.findElement(xpath("//a[@class='config__color ' and contains(@style,'fecf9c')]"))
                .click(); // select rose color
        driver.findElement(xpath("//a[@class='config__memory ']"))
                .click(); // select 64GB
        String expectedName = driver
                .findElement(xpath("//div[@class='product-info__left']//h1[@class='page-title']"))
                .getText().toString();
        driver.findElement(xpath("//a[contains(@class, 'main-btn main-btn--orange main-btn--middle')]"))
                .click(); // select bye in one click
        Thread.sleep(5000);
        ExpectedConditions.elementToBeSelected(By.xpath("//div[@id='js_oneclickModal']"));
        String actualName = driver
                .findElement(xpath("//div[contains(@class, 'modal-g oneclick')]//div//div//div//div[@class='name']"))
                .getText().toString();
        assertEquals(actualName, expectedName);
    }

    @Test(priority = 2)
    public void checkMatchingNumberOfElements() {
        driver.findElement(xpath("//div[@class='partner-box height']//img[@alt='Xiaomi']")).click();//click to MI
        ExpectedConditions.visibilityOfAllElements();
        List<WebElement> listOfMi = driver.findElements(By.xpath("//a[@class='category-box-item']")); //select all categories in MI
        List<WebElement> factListOfMi = driver.findElements(xpath("//a[@class='brand__more']")); //select all categories for select
        assertEquals(listOfMi.size(), factListOfMi.size());
    }

    @Test(priority = 3)
    public void checkAnswerToIncorrectSearchingWord() {
        driver.findElement(xpath("//input[@id='input_search']"))
                .sendKeys("блаблабла", ENTER);  // enter incorrect searching word to search
        ExpectedConditions.visibilityOfAllElements();
        String expectedAnswer = "Ничего не найдено";
        String actualAnswer = driver.findElement(xpath("//p[@class='col-xs-12']")).getText();
        assertEquals(actualAnswer, expectedAnswer);
    }

    @Test(priority = 4)
    public void checkAddToCartSeveralDifferentProducts() throws InterruptedException {
       driver.findElement(xpath("//span[@class='sidebar-item']"))
               .click();  // click to catalog button
       ExpectedConditions.visibilityOfAllElements();
       driver.findElement(xpath("//span[contains(text(), 'Телевизоры')]"))
               .click();  // click to TV`s
       ExpectedConditions.visibilityOfAllElements();
       driver.findElement(xpath("//div[@class='brand-box__title']//a[contains(text(), 'Телевизоры')]"))
               .click();  // click to TV`s
       ExpectedConditions.visibilityOfAllElements();
       List<WebElement> listOfTV = driver.findElements(xpath("//a[@class='prod-cart__buy']"));  // make list of TV`s in first page
       listOfTV.get(5).click();  // click to buy 5th element

        Thread.sleep(5000);
        ExpectedConditions.elementToBeClickable(xpath("//div[@class='btns-cart-holder']//a[contains(@class,'btn--orange')]"));
        driver.findElement(xpath("//div[@class='btns-cart-holder']//a[contains(@class,'btn--orange')]")).click();//продолжить покупки

        Thread.sleep(5000);
        ExpectedConditions.elementToBeClickable(xpath("//span[@class='sidebar-item']"));
       driver.findElement(xpath("//span[@class='sidebar-item']"))
                .click();  // click to catalog button

        Thread.sleep(5000);
       driver.findElement(xpath("//span[contains(text(), 'Телевизоры')]"))
                .click();  // click to TV`s

       ExpectedConditions.visibilityOfAllElements();
       driver.findElement(xpath("//div[@class='brand-box__title']//a[contains(text(), 'Крепления')]"))
                .click();  // click to "Крепления для телевизоров"
         ExpectedConditions.visibilityOfAllElements();

        Thread.sleep(5000);
       List<WebElement> listOfProducts = driver.findElements(xpath("//a[@class='prod-cart__buy']"));  // create the list of elements
       listOfProducts.get(1).click(); // click to buy first product in the list
        Thread.sleep(5000);
       driver.findElement(xpath("//a[contains(text(), 'Оформить заказ')]"))
                .click();  // click to "Оформить заказ" button
        Thread.sleep(5000);
       assertEquals(driver.findElement(xpath("//button[@type = 'submit']")).getText().toString(),"Заказ подтверждаю");
    }

    @AfterMethod
    public void tearDown() {
       driver.close();//закрытие драйвера
    }
}