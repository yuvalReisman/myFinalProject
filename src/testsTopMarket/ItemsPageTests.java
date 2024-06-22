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
import org.testng.annotations.Test;

import bsh.Console;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;
import pagesTopMarket.HomePage;

public class ItemsPageTests extends BaseTest {

	@Test
	public void tc01_hoverCategoryAndChooseFromProductCategoriesMenu() {
		homepage.hoverCategoryAndChoose("Hardware", "Networking Cards");
		WebElement pageTitle = driver.findElement(By.cssSelector("h1.ty-mainbox-title>span"));
		assert pageTitle.getText().equalsIgnoreCase("Networking Cards");
	}

	@Test
	public void tc2_changeAmountOfItems() {
		String chosenAmountToDisplay="16 Per Page";
		itemspage.amountOfItems(chosenAmountToDisplay);
		WebElement amountOfItemsButton=driver.findElement(By.cssSelector("#sw_elm_pagination_steps"));
		assert amountOfItemsButton.getText().equalsIgnoreCase(chosenAmountToDisplay);
		boolean amountOfItems=driver.findElements(By.cssSelector(".ty-product-list")).size()==16;
		assertEquals(amountOfItems, true);
	}
	
	@Test
	public void tc3_chooseSquareDisplayItems() {
		itemspage.squareDisplayItems();
		boolean itemsDisplay = driver.findElements(By.cssSelector(".ty-grid-list__item")).size() > 0;
		assertEquals(itemsDisplay, true);
	}

	@Test
	public void tc4_chooseSquareAndListDisplayItems() {
		itemspage.squareAndListDisplayItems();
		boolean itemsDisplay = driver.findElements(By.cssSelector(".ty-product-list")).size() > 0;
		assertEquals(itemsDisplay, true);
	}

	@Test
	public void tc5_chooseListDisplayItems() {
		itemspage.listDisplayItems();
		boolean itemsDisplay = driver.findElements(By.cssSelector(".ty-compact-list__content")).size() > 0;
		assertEquals(itemsDisplay, true);
	}

	@Test
	public void tc6_searchForCompany() {
		String companyName = "Nedis";
		itemspage.searchForCompany(companyName);
		List<WebElement> CompaniesName = driver.findElements(By.cssSelector("a>label"));
		for (WebElement eachCompany : CompaniesName) {
			if (eachCompany.getText().equalsIgnoreCase(companyName)) {
				assert eachCompany.isDisplayed();
				break;
			}
		}
	}

	@Test
	public void tc7_hideProductsFilter() {
		itemspage.hideProductsFilter();
		WebElement productsFilter = driver.findElement(By.cssSelector(".cm-product-filters"));
		assert productsFilter.isEnabled();
	}
}
