package com.konga.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.konga.pagefactory.CartPage;
import com.konga.pagefactory.SearchResultPage;
import com.konga.test.TestBase.BaseTest;

import static org.testng.Assert.assertEquals;

/**
*
* @author Shashi
*/

public class CartValidationTest extends BaseTest {
	Actions actionObj;
	SearchResultPage seachPage;
	CartPage cartPage;
    @BeforeTest
    public void setUp() {
        super.setUp();
        actionObj = new Actions(driver);
        seachPage = new SearchResultPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterTest
    public void tearDown() {
        super.tearDown();
    }
    
    @Test
    public void cartValidationTest(){
    	actionObj.search();
    	String itemNameSearchPg= seachPage.addToCart();    	
    	cartPage.validateCartAndCheckout();    	
    	//assertEquals(itemNameSearchPg, CartPage.cartItemNameText.getText());
    }
	
}
