package com.konga.pagefactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
*
* @author Shashi
*/

public class SearchResultPage {
	
    public WebDriver driver;
    public SearchResultPage(WebDriver d){
        this.driver = d;
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH, using = "//section[@class='_588b5_3MtNs']//form//button")	
	public static List<WebElement> allAddToCardBtns;
	
    @FindBy(how = How.XPATH, using = "//section[@class='_588b5_3MtNs']//h3")
	public static List<WebElement> allItemNameText;
    
    @FindBy(how = How.XPATH, using = "//section[@class='_588b5_3MtNs']//h3/parent::div/following-sibling::div/span[1]")
	public static List<WebElement> allItemPrices;  
	
	@FindBy(how = How.XPATH, using = "//a[@class='_79484_1sLEt _7ad32_SD12Y _16536_xxIKG']")
	public static WebElement cartLink;
	
	@FindBy(how = How.XPATH, using = "//div[@class='_5de6f_5Wh-5 b2077_Ob65D e71b8_2h3ul']//a[1]")
	public static WebElement cartOverviewLink;
		
	static int getRandomInt(int range){
		Random objGenerator = new Random();
	    return objGenerator.nextInt(range);
	}
	
	static List<String> getAllPrice(){
		List<String> allPricesList = new ArrayList<String>(); 
		for(WebElement wb: allItemPrices) {
			allPricesList.add(wb.getText().replaceAll("[^0-9]", ""));
		}
        return allPricesList;
	}
	
	static int getFirstHighestPriceItem(){
		List<Integer> listInteger = getAllPrice().stream().map(Integer::parseInt).collect(Collectors.toList());
		List<Integer> sortedList = new ArrayList<Integer>(listInteger);
		Collections.sort(sortedList);
		System.out.println(listInteger.indexOf(sortedList.get(sortedList.size()-1))); 
		return listInteger.indexOf(sortedList.get(sortedList.size()-1));
	}
	
	static int getSecondHighestPriceItem(){
		List<Integer> listInteger = getAllPrice().stream().map(Integer::parseInt).collect(Collectors.toList());
		List<Integer> sortedList = new ArrayList<Integer>(listInteger);
		Collections.sort(sortedList);
		System.out.println(listInteger.indexOf(sortedList.get(sortedList.size()-1))); 
		return listInteger.indexOf(sortedList.get(sortedList.size()-2));
	}
	
	static void closeNotificationPopUp(WebDriver driver) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@name='preview-notification-frame']")));
		driver.findElement(By.xpath("//div[@id='NC_background_image']/a[2]")).click();			
	}
	
	public String addToCart() {
		//closeNotificationPopUp(driver);
		//driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		try {			Thread.sleep(10000);		} catch (InterruptedException e) {			e.printStackTrace();		}
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//section[@class='_588b5_3MtNs']//img")));
		int selectBtnNum = getFirstHighestPriceItem();//getRandomInt(20);		
		if(allAddToCardBtns.size()>0) {
			allAddToCardBtns.get(selectBtnNum).click();
			try {			Thread.sleep(20000);		} catch (InterruptedException e) {			e.printStackTrace();		}
		}
		selectBtnNum = getSecondHighestPriceItem();		
		if(allAddToCardBtns.size()>0) {
			allAddToCardBtns.get(selectBtnNum).click();
			try {			Thread.sleep(10000);		} catch (InterruptedException e) {			e.printStackTrace();		}
		}
		return allItemNameText.get(selectBtnNum).getText();
	}
	public void viewCart() {
		//new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='_5de6f_5Wh-5 b2077_Ob65D e71b8_2h3ul']//a[1]")));
		cartLink.click();
	}

}
