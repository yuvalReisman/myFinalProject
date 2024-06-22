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

public class CartPageTest extends BaseTest{

	
	@Test
	public void tc01_zeroItemsInCart() {
		WebElement amountOfItemsInCart=driver.findElement(By.cssSelector(".basket-cart-amount"));
		assert amountOfItemsInCart.getText().equalsIgnoreCase("0");
	}
	
	@Test
	public void tc02_addToCart() {
		homepage.hoverCategoryAndChoose("Accessories","Memory Cards");
		itempage.chooseFirstItem();
		itempage.addToCart();
		WebElement exitNotificationMessage =driver.findElement(By.cssSelector(".cm-notification-close"));
		exitNotificationMessage.click();
		WebElement amountOfItemsInCart=driver.findElement(By.cssSelector(".basket-cart-amount"));
		assert amountOfItemsInCart.getText().equalsIgnoreCase("1");
	}
	
	@Test
	public void tc03_getIntoCart() {
		navigationpage.getIntoCart();
		WebElement pageTitle=driver.findElement(By.cssSelector("[name='checkout_form']>.ty-mainbox-title"));
		assert pageTitle.getText().equalsIgnoreCase("cart contents");
	}
	
	@Test
	public void tc04_recalculateCart() {
		cartpage.recalculateCart();
		WebElement notificationMessage =driver.findElement(By.cssSelector(".cm-notification-content"));
		assert notificationMessage.isDisplayed();
	}
	
	@Test
	public void tc05_increaseAndRecalculateCart() {
		WebElement priceOfTheItem =driver.findElement(By.cssSelector("*[id*='product_price']"));
		String priceOfTheItemText=priceOfTheItem.getText();
		int priceOfTheItemInt=Integer.parseInt(priceOfTheItemText);
		cartpage.increaseItem();
		cartpage.recalculateCart();
		WebElement totalPriceOfItems =driver.findElement(By.cssSelector("*[id*='product_subtotal']"));
		String totalPriceOfItemsText=totalPriceOfItems.getText();
		String totalPriceOfItemsTextWithoutComma=totalPriceOfItemsText.replace(",", "");
		int totalPriceOfItemsInt=Integer.parseInt(totalPriceOfItemsTextWithoutComma);
		Assert.assertEquals((priceOfTheItemInt*2),totalPriceOfItemsInt);
	}
	
	@Test
	public void tc06_closeCart() {
		cartpage.closeCart();
		WebElement pageTitle=driver.findElement(By.cssSelector("h1.ty-mainbox-title"));
		assert pageTitle.getText().equalsIgnoreCase("Memory Cards");
	}
	
	@Test
	public void tc07_clearCart() {
		navigationpage.getIntoCart();
		cartpage.clearCart();
		WebElement noItemsMessage=driver.findElement(By.cssSelector(".ty-no-items"));
		assert noItemsMessage.isDisplayed();
	}
	
	@Test
	public void tc08_proceedToCheckout() {
		WebElement closeCartAfterClear =driver.findElement(By.cssSelector(".ty-mainbox-body>.buttons-container .ty-btn"));
		closeCartAfterClear.click();
		itempage.chooseFirstItem();
		itempage.addToCart();
		WebElement exitNotificationMessage =driver.findElement(By.cssSelector(".cm-notification-close"));
		exitNotificationMessage.click();
		navigationpage.getIntoCart();
		cartpage.proceedToCheckout();
		WebElement pageTitle =driver.findElement(By.cssSelector(".ty-checkout__title"));
		assert pageTitle.isDisplayed();
	}
}
