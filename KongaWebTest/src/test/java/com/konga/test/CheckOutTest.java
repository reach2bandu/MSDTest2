package com.konga.test;

import com.konga.pagefactory.CartPage;
import com.konga.pagefactory.CheckoutPage;
import com.konga.pagefactory.SearchResultPage;
import com.konga.test.TestBase.BaseTest;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.*;
/**
*
* @author Shashi
*/

public class CheckOutTest extends BaseTest {
	CheckoutPage checkoutPage;
	Actions actionObj;
	SearchResultPage seachPage;
	CartPage cartPage;
    @BeforeTest
    public void setUp() {
        super.setUp();
        checkoutPage = new CheckoutPage(driver);
        actionObj = new Actions(driver);
        seachPage = new SearchResultPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterTest
    public void tearDown() {
        //super.tearDown();
    }
    
    @Test
    public void checkoutTest() {
    	
    	actionObj.search();
    	seachPage.addToCart();
    	cartPage.validateCartAndCheckout();
    	assertTrue(checkoutPage.orderReviewNameText.isDisplayed());
    	assertTrue(checkoutPage.paymentSubtotal.isDisplayed());
    	assertTrue(checkoutPage.paymentTotal.isDisplayed());
    	checkoutPage.checkout();
    	
    }
}
