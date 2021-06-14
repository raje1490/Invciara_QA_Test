package Invciara;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import WebPages.barnesHomePage;
import utility.PropLoad;



public class WebAppTest {
    Logger logger = Logger.getLogger(WebAppTest.class.getName());
    barnesHomePage barnesPage = new barnesHomePage();
    PropLoad scr = new PropLoad();


	 public static WebDriver driver;

	
	@BeforeMethod	
	public void setup() {
			

		    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		    ChromeOptions option = new ChromeOptions();
		    option.addArguments("incognito");
		    capabilities.setCapability(ChromeOptions.CAPABILITY,option);
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");  
		    driver= new ChromeDriver(capabilities);
		    driver.manage().window().maximize();
		}
@Test	
public void Scenario1() throws Exception {
	
	barnesPage.loadbarnesPage(driver);
	PropLoad.takeScreenshot(driver);

	barnesPage.SearchProduct(driver);
	PropLoad.takeScreenshot(driver);

	barnesPage.GetCartValue(driver);
	PropLoad.takeScreenshot(driver);

	barnesPage.FeaturedCatSecondValue(driver);
	PropLoad.takeScreenshot(driver);

	}


@AfterMethod
public void teardown() {
	
	driver.quit();
}
}
