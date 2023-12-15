package pages.telecomunications;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class MobilePhoneReplenishmentPage extends BasePage {
    public MobilePhoneReplenishmentPage(WebDriver driver) {
        super(driver);
    }

    private final By buttonWallet = By.xpath("//div[contains(text(), 'My wallet')]");
    private final By inputCardFrom = By.xpath("//input[@data-qa-node='numberdebitSource']");
    private final By inputCardExpDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
    private final By inputCardCvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
    private final By inputPhoneNumber = By.xpath("//input[@data-qa-node='phone-number']");
    private final By inputAmount = By.xpath("//input[@data-qa-node='amount']");
    private final By buttonSubmitToTheCart = By.xpath("//button[@data-qa-node='submit']");
    private final By paymentDetails = By.xpath("//div[@data-qa-node='details']");

    /**
     * Choose a card from the wallet
     */
    public MobilePhoneReplenishmentPage selectCardFromWallet(){
        driver.findElement(buttonWallet).click();
        return this;
    }

    /**
     * Enter phone number exluding country code
     * @param number phone number
     */
    public MobilePhoneReplenishmentPage enterPhoneNumber(String number){
        driver.findElement(inputPhoneNumber).sendKeys(number);
        return this;
    }

    /**
     * Clean input field and enter minimum amount
     * @param amount amount for replenishment
     */
    public MobilePhoneReplenishmentPage enterAmount(String amount){
        WebElement inputAmountElement = driver.findElement(inputAmount);
        inputAmountElement.sendKeys(Keys.CONTROL + "a");
        inputAmountElement.sendKeys(Keys.BACK_SPACE);
        inputAmountElement.sendKeys(amount);
        return this;
    }

    /**
     * Enter card number
     * @param card card number
     */
    public MobilePhoneReplenishmentPage enterCardFrom(String card){
        driver.findElement(inputCardFrom).sendKeys(card);
        return this;
    }

    /**
     * Enter card expiration date
     * @param expDate expiration date of card
     */
    public MobilePhoneReplenishmentPage enterCardExpDate(String expDate){
        driver.findElement(inputCardExpDate).sendKeys(expDate);
        return this;
    }

    /**
     * Enter card cvv
     * @param cvv card cvv
     */
    public MobilePhoneReplenishmentPage enterCvv(String cvv){
        driver.findElement(inputCardCvv).sendKeys(cvv);
        return this;
    }

    /**
     * Click "Add to cart" button to submit phone replenishment
     */
    public MobilePhoneReplenishmentPage submitToTheCart(){
        driver.findElement(buttonSubmitToTheCart).click();
        return this;
    }

    public MobilePhoneReplenishmentPage checkPaymentDetailsIsPresentInTheCart(String text){
        waitElementIsVisible(driver.findElement(paymentDetails));
        WebElement details = driver.findElement(paymentDetails);
        Assertions.assertEquals(text, details.getText());
        return this;
    }
}
