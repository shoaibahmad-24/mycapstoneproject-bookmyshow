package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;

public class GiftCardPage {

    WebDriver driver;
 // Constructor
    public GiftCardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators using PageFactory
//    @FindBy(xpath = "//a[@href='/giftcards' and @class='sc-1or3vea-21 gGtXEF']")
    @FindBy(xpath = "//div[@class='sc-1or3vea-19 bfNncl']//a[@href='/giftcards' and text()='Gift Cards']")
    private WebElement giftCardSectionLink;

    @FindBy(xpath = "//div[text()='Check Gift Card Balance']")
    private WebElement checkBalanceIcon;

    @FindBy(xpath = "//input[@id='gift-voucher']")
    private WebElement voucherCodeInput;

    @FindBy(xpath = "//div[@class='sc-zgl7vj-7 dMHyDB']")
    private WebElement checkBalanceButton;

    @FindBy(xpath = "//div[@id='error-gift-voucher']")
    private WebElement errorMessage;

    // Page Actions
    public void navigateToGiftCardSection() {
    	WaitUtils.waitForClickability(driver, giftCardSectionLink).click();
    }

    public boolean isCheckBalanceIconDisplayed() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", checkBalanceIcon);
        return checkBalanceIcon.isDisplayed();
    }

    public void clickCheckBalanceIcon() {
    	WaitUtils.waitForClickability(driver, checkBalanceIcon).click();;
    }

    public void enterVoucherCode(String code) {
    	WaitUtils.waitForVisibility(driver, voucherCodeInput).clear();
        voucherCodeInput.sendKeys(code);
    }

    public void clickCheckBalanceButton() {
    	WaitUtils.waitForClickability(driver, checkBalanceButton).click();
//        checkBalanceButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
