package com.konga.test;


import com.konga.test.TestBase.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
*
* @author Shashi
*/
public class SearchTest extends BaseTest {

    public SearchTest() {
    }

    @BeforeTest
    public void setUp() {
        super.setUp();
    }

    @AfterTest
    public void tearDown() {
        super.tearDown();
    }

    @Test
    public void search() throws InterruptedException {
        Actions actionsObj = new Actions(driver);
        actionsObj.search();

       

    }

    public void clickListedItem(){


    }
}