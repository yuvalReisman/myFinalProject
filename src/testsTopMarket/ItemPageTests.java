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

public class ItemPageTests extends BaseTest{

	
	@Test
	public void tc01_getToItem() {
		homepage.hoverCategoryAndChoose("Accessories","Memory Cards");
		itempage.chooseFirstItem();
		boolean ExpectedToBeInItemPage=true;
		Assert.assertEquals(ExpectedToBeInItemPage,itempage.isOnItemPage());
	}
	
	@Test
	public void tc02_increaseAmountOfItems() {
		int amountBeforeIncrease=itempage.getAmountOfItems();
		int AmountToIncrese=3;
		itempage.increseAmount(AmountToIncrese);
		int amountAfterIncrease=itempage.getAmountOfItems();
		Assert.assertEquals((amountBeforeIncrease+AmountToIncrese),amountAfterIncrease);
	}
	
	@Test
	public void tc03_decreaseAmountOfItems() {
		int amountBeforeIncrease=itempage.getAmountOfItems();
		int amount=3;
		itempage.increseAmount(amount);
		itempage.decreaseAmount(amount);
		int amountAfterIncreaseAndDecrease=itempage.getAmountOfItems();
		Assert.assertEquals(amountBeforeIncrease,amountAfterIncreaseAndDecrease);
	}
	
	@Test
	public void tc04_addToWishList() {
		itempage.addToWishList();
		String expectedMessage="THE PRODUCT WAS ADDED TO YOUR WISH LIST";
		String actualMessage=itempage.getNotificationMessageTitle();
		Assert.assertEquals(expectedMessage, actualMessage);
		itempage.closeNotificationMessage();
	}
	
	@Test
	public void tc05_addToCartMultipuleItems() {
		itempage.addToCart();
		String expectedMessage="THE PRODUCTS WERE ADDED TO YOUR CART";
		String actualMessage=itempage.getNotificationMessageTitle();
		Assert.assertEquals(expectedMessage, actualMessage);
		itempage.closeNotificationMessage();
	}
	
	@Test
	public void tc06_addToCartOneItem() {
		int amountWeAlreadyIncreased=3;
		itempage.decreaseAmount(amountWeAlreadyIncreased);
		itempage.addToCart();
		String expectedMessage="THE PRODUCT WAS ADDED TO YOUR CART";
		String actualMessage=itempage.getNotificationMessageTitle();
		Assert.assertEquals(expectedMessage, actualMessage);
		itempage.closeNotificationMessage();
	}
	
	@Test
	public void tc07_addToCompare() {
		itempage.addToCompare();
		String expectedMessage="THE PRODUCT WAS ADDED TO YOUR COMPARISON LIST";
		String actualMessage=itempage.getNotificationMessageTitle();
		Assert.assertEquals(expectedMessage, actualMessage);
	}
}
