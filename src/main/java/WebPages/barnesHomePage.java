package WebPages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utility.PropLoad;
import org.openqa.selenium.Keys;


public class barnesHomePage{

	static String SearchBox= "//input[@placeholder='Search by Title, Author, Keyword or ISBN']";

	static String SearchButton= "//button[@class='btn btn-outline-secondary rhf-search-btn']";
	static String AddToCartValue="//a[@id='navbarDropdown']/span[@class='rhf-cart-count']";
	static String FeaturedCategories="//span[@id='sc-subtotal-amount-activecart']/span";
	static String homePage="//a[@class='logo-img ']";


public void loadbarnesPage(WebDriver driver) {

	try {

		driver.get("https://www.barnesandnoble.com");
		
		Thread.sleep(2000);
		}
    catch (Exception e) {
		e.printStackTrace();
	}
}

public void SearchProduct(WebDriver driver) {
	
	try {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SearchBox))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SearchBox))).sendKeys(PropLoad.getProperties("SearchItem"));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SearchButton))).click();
		
	}
	 catch (Exception e) {
			e.printStackTrace();
		}
	
}
public int GetCartValue(WebDriver driver) throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(homePage))).click();
	String CartValue= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(AddToCartValue))).getText();
	System.out.println("No of Items in the cart "+ CartValue);
	int cartValue=Integer.parseInt(CartValue);
	return cartValue;
	
}
	
private String faeturesCategories(WebDriver driver) throws InterruptedException {
	String faetureCat="//section[contains(@class,'featuredCategories')][2]//h2";
	WebDriverWait wait = new WebDriverWait(driver, 30);
	String faeturesCategoriesValue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(faetureCat))).getText();

	
	return faeturesCategoriesValue;
		
}

public String FeaturedCatSecondValue(WebDriver driver) throws InterruptedException {
	
	String SecondValue = faeturesCategories(driver);
	
	System.out.println("Featured Categories second value is "+ SecondValue);
	return SecondValue;
	
	
}




}
