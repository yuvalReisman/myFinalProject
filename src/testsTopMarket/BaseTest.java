package testsTopMarket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pagesTopMarket.CartPage;
import pagesTopMarket.CheckoutPage;
import pagesTopMarket.HomePage;
import pagesTopMarket.ItemPage;
import pagesTopMarket.ItemsPage;
import pagesTopMarket.NavigationPage;


public class BaseTest {

	WebDriver driver;
	HomePage homepage;
	ItemPage itempage;
	NavigationPage navigationpage;
	CartPage cartpage;
	ItemsPage itemspage;
	CheckoutPage checkoutpage;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.topmarket.co.il/en/");
	}
	
	@BeforeClass
	public void setUpForPages() {
		homepage=new HomePage(driver);
		itempage=new ItemPage(driver);
		navigationpage=new NavigationPage(driver);
		cartpage=new CartPage(driver);
		itemspage=new ItemsPage(driver);
		checkoutpage=new CheckoutPage(driver);
	}
	
//	@AfterClass
//	public void tearDown() {
//		driver.quit(); 121212112
//	}
}
