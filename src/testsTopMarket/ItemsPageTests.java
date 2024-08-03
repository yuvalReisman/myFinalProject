package testsTopMarket;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import bsh.Console;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;
import pagesTopMarket.HomePage;

public class ItemsPageTests extends BaseTest {

	@BeforeClass
	public void beforeAllClasses() {
		homepage.hoverCategoryAndChoose("Hardware", "Networking Cards");
	}
	
	@Test
	public void tc1_changeAmountOfDisplayedItemsInPage() {
		String chosenAmountToDisplay="16 Per Page";
		itemspage.amountOfItems(chosenAmountToDisplay);
		String expectedchosenAmountInField=chosenAmountToDisplay;
		String actualAmountInField=itemspage.getChosenAmountOfItemsInButton();
		assert actualAmountInField.equalsIgnoreCase(expectedchosenAmountInField);
		int expectedAmountOfItems=16;
		int actualAmountOfItems=itemspage.getAmountOfItems();
		Assert.assertEquals(expectedAmountOfItems, actualAmountOfItems);
	}
	
	@Test
	public void tc2_chooseSquareDisplayItems() {
		itemspage.squareDisplayItems();
		Assert.assertTrue(itemspage.isSquareDisplayItems());
	}

	@Test
	public void tc3_chooseSquareAndListDisplayItems() {
		itemspage.squareAndListDisplayItems();
		Assert.assertTrue(itemspage.isSquareAndListDisplayItems());
	}

	@Test
	public void tc4_chooseListDisplayItems() {
		itemspage.listDisplayItems();
		Assert.assertTrue(itemspage.isListDisplayItems());
	}

	@Test
	public void tc5_searchForCompany() {
		String companyName = "Nedis";
		itemspage.searchForCompany(companyName);
		Assert.assertTrue(itemspage.isChosenComapnyDisplayed(companyName));
	}

	@Test
	public void tc6_hideProductsFilter() {
		itemspage.hideProductsFilter();
		Assert.assertTrue(itemspage.isProductsFilterHidden());
	}
}
