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

public class CartPageTests extends BaseTest{

	
	@Test
	public void tc01_zeroItemsInCart() {
		String expectedAmountOfItemsInEmptyCart="0";
		String actualAmountInCart= cartpage.getAmountOfItemsInCartInHomePage();
		Assert.assertEquals(expectedAmountOfItemsInEmptyCart, actualAmountInCart);
	}
	
	@Test
	public void tc02_addToCart() {
		homepage.hoverCategoryAndChoose("Accessories","Memory Cards");
		itempage.chooseFirstItem();
		itempage.addToCart();
		cartpage.clickOnExitNotificationMessage();
		String expectedAmountAfterAddingItem="1";
		String actualAmountOfItemsInCart= cartpage.getAmountOfItemsInCartInHomePage();
		Assert.assertEquals(expectedAmountAfterAddingItem, actualAmountOfItemsInCart);
	}
	
	@Test
	public void tc03_getIntoCart() {
		navigationpage.getIntoCart();
		String expectedPageTitle="CART CONTENTS";
		String actualPageTitle= cartpage.getCartPageTitle();
		Assert.assertEquals(expectedPageTitle, actualPageTitle);
	}
	
	@Test
	public void tc04_recalculateCart() {
		cartpage.recalculateCart();
		String expectedNotification="Notice The product(s) have been updated successfully";
		String actualNotification= cartpage.getSuccessfulNotificationMessage();
		assert actualNotification.contains(expectedNotification);
	}
	
	@Test
	public void tc05_increaseAndRecalculateCart() {
		String priceOfTheItemText=cartpage.getPriceOfTheItem();
		int priceOfTheItemInt=Integer.parseInt(priceOfTheItemText);
		cartpage.increaseItem();
		cartpage.recalculateCart();
		String totalPriceOfItemsText=cartpage.getTotalPriceOfTheItems();
		String totalPriceOfItemsTextWithoutComma=totalPriceOfItemsText.replace(",", "");
		int totalPriceOfItemsInt=Integer.parseInt(totalPriceOfItemsTextWithoutComma);
		Assert.assertEquals((priceOfTheItemInt*2),totalPriceOfItemsInt);
	}
	
	@Test
	public void tc06_closeCart() {
		cartpage.closeCart();
		String expectedPageTitle="MEMORY CARDS";
		String actualPageTitle= cartpage.getItemsPageTitle();
		Assert.assertEquals(expectedPageTitle, actualPageTitle);
	}
	
	@Test
	public void tc07_clearCart() {
		navigationpage.getIntoCart();
		cartpage.clearCart();
		String expectedMessage="Your cart is empty";
		String actualMessage= cartpage.getNoItemsInCartMessage();
		Assert.assertEquals(expectedMessage, actualMessage);
	}
	
	@Test
	public void tc08_proceedToCheckout() {
		cartpage.closeCartAfterClear();
		itempage.chooseFirstItem();
		itempage.addToCart();
		cartpage.clickOnExitNotificationMessage();
		navigationpage.getIntoCart();
		cartpage.proceedToCheckout();
		String expectedPageTitle="SECURE CHECKOUT";
		String actualPageTitle= cartpage.getCheckoutPageTitle();
		Assert.assertEquals(expectedPageTitle, actualPageTitle);
	}
}
