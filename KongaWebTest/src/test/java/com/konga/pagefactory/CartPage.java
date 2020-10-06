package com.konga.pagefactory;

import static org.testng.Assert.assertTrue;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


/**
*
* @author Shashi
*/

public class CartPage {
	
    public WebDriver driver;
    public CartPage(WebDriver d){
        this.driver = d;
        PageFactory.initElements(driver,this);
    }
	

    String ORDER_SUMMARY_ROOT="//div[div[h4[text()='Order Summary']]]";
    String CART_ITEM_DETAIL_ROOT="//div[@class='_79480_w1pK7']";
    String CART_REVIEW_URL="https://www.konga.com/cart/overview";
    
    @FindBys({
    	@FindBy(how = How.XPATH, using ="//div[div[span[text()='Items Details']]]/following-sibling::div//h3/a")
    })
    public static List<WebElement> cartItemNamesText;
    
    @FindBy(how = How.XPATH, using ="//div[@class='_79480_w1pK7']//h3/a")
    @CacheLookup
    public static WebElement cartItemNameText;
    
    @FindBy(how = How.XPATH, using ="//div[@class='_79480_w1pK7']//h3[@class='_5238f__ps1l']")
    @CacheLookup
    public static WebElement cartItemPriceText;
    
    @FindBy(how = How.XPATH, using ="//form[@class='d4e80_37RCm']/div/div/div")
    @CacheLookup
    public static WebElement cartItemQuantityText;
    
    @FindBy(how = How.XPATH, using ="//div[span[contains(text(),'Subtotal')]]/span[@class='_3d254_IRXEX']")
    @CacheLookup
    public static WebElement cartSubtotalText;
    
    @FindBy(how = How.XPATH, using ="//div[div[h4[text()='Order Summary']]]//a")
    @CacheLookup
    public static WebElement checkoutBtn;
    
    @FindBy(how = How.XPATH, using ="//h3[text()='Your cart is empty.']")
    @CacheLookup
    public static WebElement cartEmptyText;
    
    public void validateCartAndCheckout() {    	        	
    	driver.navigate().to(CART_REVIEW_URL);
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    	
    	assertTrue(cartItemNameText.isDisplayed());
    	assertTrue(cartItemPriceText.isDisplayed());
    	assertTrue(cartItemQuantityText.isDisplayed());
    	assertTrue(cartSubtotalText.isDisplayed());
    	checkoutBtn.click();
    	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }
    
}
