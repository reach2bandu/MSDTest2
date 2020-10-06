package com.konga.test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


/**
*
* @author Shashi
*/

public class Actions {

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Login / Signup')]")
    @CacheLookup
    public static WebElement loginPoint;

    @FindBy(how = How.XPATH, using = "//div[@class='_8486b_25fFV _16536_xxIKG']/following-sibling::div[1]//input")
    @CacheLookup
    public static WebElement searchElement;

    @FindBy(how = How.ID, using = "username")
    @CacheLookup
    public static WebElement username;

    @FindBy(how = How.ID, using = "password")
    @CacheLookup
    public static WebElement password;

    @FindBy(how = How.XPATH, using = "//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")
    @CacheLookup
    public static WebElement submitButton;

    @FindBy(how = How.XPATH, using ="//div[input[@id='username']]/div")
    @CacheLookup
    public static WebElement errorMessage;
    
    @FindBy(how = How.XPATH, using ="//input[@id='password']/following-sibling::div")
    @CacheLookup
    public static WebElement errorPassMessage;
    
    public WebDriver driver;
    public Actions(WebDriver d){
        this.driver = d;
        PageFactory.initElements(driver,this);
    }

    public void search(){

       //***** WebElement searchElement = webDriver.findElement(By.xpath("//form[@class='f6ed2_25oVd']//input[@id='jsSearchInput']"));
            searchElement.clear();
            searchElement.sendKeys("samsung");
            searchElement.sendKeys(Keys.ENTER);
            try {			Thread.sleep(10000);		} catch (InterruptedException e) {			e.printStackTrace();		}            
    }
    

        public void launchSite (WebDriver webDriver){

            String baseUrl = "https://www.konga.com";
            //test.resultList.add(new Result("Launch Site","", true));
            webDriver.get(baseUrl);
            String actualTitle = webDriver.getTitle();
            String expectedTitle = "Buy Phones,  Electronics in Nigeria | Konga Online Shopping";
            try {
                Assert.assertEquals(actualTitle, expectedTitle);
                //     test.resultList.add(new Result("Title Compare","", true));
            } catch (AssertionError ex) {
                //     test.resultList.add(new Result("Title Compare","", false));
            }

        }


    }
