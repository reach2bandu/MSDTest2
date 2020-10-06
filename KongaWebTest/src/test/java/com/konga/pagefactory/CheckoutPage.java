package com.konga.pagefactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
*
* @author Shashi
*/

public class CheckoutPage {
	
    public WebDriver driver;
    public CheckoutPage(WebDriver d){
        this.driver = d;
        PageFactory.initElements(driver,this);
    }
    
    @FindBys({
    	@FindBy(how = How.XPATH, using ="//div[h1[text()='Delivery / Pickup Options']]/following-sibling::div//button[@class='_0a08a_3czMG _7e22a_3zNWE']")
    })
    public  List<WebElement> addressButtonText;
    
    @FindBy(how = How.XPATH, using ="//div[h1[text()='Review Order']]/following-sibling::div//h3/a")
    @CacheLookup
    public  WebElement orderReviewNameText;
    
    @FindBy(how = How.XPATH, using ="//div[h1[text()='Review Order']]/following-sibling::div//form//div[@class='a03ba_1Zj-T']")
    @CacheLookup
    public  WebElement orderReviewQty;
    
    @FindBy(how = How.XPATH, using ="//div[h1[text()='Review Order']]/following-sibling::div//h3[@class='_5238f__ps1l']")
    @CacheLookup
    public  WebElement orderReviewItemPrice;
    
    @FindBy(how = How.XPATH, using ="//section[@class='_4b230_19Wk8 _651d7_qAjL2 b4565_PwzUY']//a")
    @CacheLookup
    public  WebElement paymentPayNowRadioBtn;
    
    @FindBy(how = How.XPATH, using ="//section[@class='_4b230_19Wk8 _651d7_qAjL2 b4565_PwzUY']//span[contains(text(),'Subtotal')]/following-sibling::span")
    @CacheLookup
    public  WebElement paymentSubtotal;
    
    @FindBy(how = How.XPATH, using ="//section[@class='_4b230_19Wk8 _651d7_qAjL2 b4565_PwzUY']//span[contains(text(),'Delivery Charges')]/following-sibling::span")
    @CacheLookup
    public  WebElement paymentDeliveryCharges;
    
    @FindBy(how = How.XPATH, using ="//section[@class='_4b230_19Wk8 _651d7_qAjL2 b4565_PwzUY']//h4[contains(text(),'Total')]/following-sibling::h4")
    @CacheLookup
    public  WebElement paymentTotal;
    
    //Before radio clicked _0a08a_3czMG _5b5d0_2a6td and after _0a08a_3czMG
    @FindBy(how = How.XPATH, using ="//section[@class='_4b230_19Wk8 _651d7_qAjL2 b4565_PwzUY']//button[text()='Continue to Payment']")
    @CacheLookup
    public  WebElement paymentContinueToPayBtn;
    
    public void checkout() {
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(paymentPayNowRadioBtn));
    	((JavascriptExecutor) driver).executeScript("arguments[0].click();", paymentPayNowRadioBtn);
    	paymentPayNowRadioBtn.click();
    	if(paymentContinueToPayBtn.getAttribute("Class").equals("_0a08a_3czMG"))
    		paymentContinueToPayBtn.click();
    }
    
    
}
