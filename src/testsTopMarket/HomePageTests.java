package testsTopMarket;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import bsh.Console;
import pagesTopMarket.HomePage;

public class HomePageTests extends BaseTest{

	
	@Test
	public void tc01_searchForItem() {
		navigationpage.searchForItem("computer");
		WebElement pageTitle=driver.findElement(By.cssSelector("span.ty-mainbox-title__left"));
		assert pageTitle.getText().equalsIgnoreCase("search results");
		WebElement logoButton=driver.findElement(By.cssSelector(".top-logo"));
		logoButton.click();
	}
	
	@Test
	public void tc02_goHome() {
		navigationpage.searchForItem("computer");
		navigationpage.getHome();
		WebElement categoriesMenu=driver.findElement(By.cssSelector(".cm-popup-box>.ty-menu__items"));
		assert categoriesMenu.isDisplayed();
	}
	
	@Test
	public void tc03_searchDepartement() {
		navigationpage.searchDepartment("Laptops");
		WebElement pageTitle=driver.findElement(By.cssSelector(".searched-categories>li"));
		assert pageTitle.getText().contains("Laptops");
		navigationpage.getHome();
	}
	
	@Test
	public void tc04_chooseCategoryFromProductCategoriesMenu() {
		homepage.chooseCategoryFromMenu("CCTV & Alarm");
		WebElement pageTitle=driver.findElement(By.cssSelector("h1.ty-mainbox-title>span"));
		assert pageTitle.getText().equalsIgnoreCase("CCTV & Alarm");
		navigationpage.getHome();
	}

	@Test
	public void tc05_hoverCategoryAndChooseFromProductCategoriesMenu() {
		homepage.hoverCategoryAndChoose("Accessories","Memory Cards");
		WebElement pageTitle=driver.findElement(By.cssSelector("h1.ty-mainbox-title>span"));
		assert pageTitle.getText().equalsIgnoreCase("Memory Cards");
		navigationpage.getHome();
	}
	
	@Test
	public void tc06_chooseCategoryFromBelow() {
		homepage.chooseCategoryBelow("ALL IN ONE");
		WebElement pageTitle=driver.findElement(By.cssSelector("h1.ty-mainbox-title>span"));
		assert pageTitle.getText().equalsIgnoreCase("All-In-One Computers");
		navigationpage.getHome();
	}
}
