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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import bsh.Console;
import pagesTopMarket.HomePage;

public class HomePageTests extends BaseTest {

	@AfterMethod
	public void afterEachTest() {
		navigationpage.getHome();
		Assert.assertTrue(homepage.isOnHomePage());
	}

	@Test
	public void tc01_searchForItem() {
		navigationpage.searchForItem("computer");
		String expectedPageTitle = "SEARCH RESULTS";
		String actualPageTitle = homepage.getsearchResultsPageTitle();
		Assert.assertEquals(expectedPageTitle, actualPageTitle);
	}

	@Test
	public void tc02_searchDepartement() {
		String chosenDepartement="Laptops";
		navigationpage.searchDepartment(chosenDepartement);
		String expectedChosenDEpartmentTitle = chosenDepartement;
		String actualChosenDEpartmentTitle = homepage.getDepartmentPageTitle();
		assert actualChosenDEpartmentTitle.contains(expectedChosenDEpartmentTitle);
	}

	@Test
	public void tc03_chooseCategoryFromProductCategoriesMenu() {
		String chosenCategory="CCTV & Alarm";
		homepage.chooseCategoryFromMenu(chosenCategory);
		String expectedPageTitle = chosenCategory;
		String actualPageTitle = homepage.getCategoryPageTitle();
		assert actualPageTitle.equalsIgnoreCase(expectedPageTitle);
	}

	@Test
	public void tc04_hoverCategoryAndChooseFromProductCategoriesMenu() {
		String chosenCategory="Memory Cards";
		homepage.hoverCategoryAndChoose("Accessories", chosenCategory);
		String expectedPageTitle = chosenCategory;
		String actualPageTitle = homepage.getCategoryPageTitle();
		assert actualPageTitle.equalsIgnoreCase(expectedPageTitle);
	}

	@Test
	public void tc05_chooseCategoryFromBelow() {
		String chosenCategory="MONITORS";
		homepage.chooseCategoryBelow(chosenCategory);
		String expectedPageTitle = chosenCategory;
		String actualPageTitle = homepage.getCategoryPageTitle();
		assert actualPageTitle.contains(expectedPageTitle);
	}
}
