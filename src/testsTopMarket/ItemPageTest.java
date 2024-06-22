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

public class ItemPageTest extends BaseTest{

	
	@Test
	public void tc01_getToItem() {
		homepage.hoverCategoryAndChoose("Accessories","Memory Cards");
		itempage.chooseFirstItem();
		WebElement pageTitle=driver.findElement(By.cssSelector(".ty-product-block-title"));
		assert pageTitle.isDisplayed();
	}
	
	@Test
	public void tc02_increaseAmountOfItems() {
		WebElement amountBeforeIncreaseElement=driver.findElement(By.cssSelector(".cm-amount"));
		String valueOfTheAmountBeforeIncrease=amountBeforeIncreaseElement.getAttribute("value");
		int intValueOfTheAmountBeforeIncrease=Integer.parseInt(valueOfTheAmountBeforeIncrease);
		int AmountToIncrese=3;
		itempage.increseAmount(AmountToIncrese);
		WebElement amountAfterIncreaseElement=driver.findElement(By.cssSelector(".cm-amount"));
		String valueOfTheAmountAfterIncrease=amountAfterIncreaseElement.getAttribute("value");
		int intValueOfTheAmountAfterIncrease=Integer.parseInt(valueOfTheAmountAfterIncrease);
		Assert.assertEquals((intValueOfTheAmountBeforeIncrease+AmountToIncrese),intValueOfTheAmountAfterIncrease);
	}
	
	@Test
	public void tc03_decreaseAmountOfItems() {
		WebElement amountBeforeIncreaseElement=driver.findElement(By.cssSelector(".cm-amount"));
		String valueOfTheAmountBeforeIncrease=amountBeforeIncreaseElement.getAttribute("value");
		int intValueOfTheAmountBeforeIncrease=Integer.parseInt(valueOfTheAmountBeforeIncrease);
		int amount=3;
		itempage.increseAmount(amount);
		itempage.decreaseAmount(amount);
		WebElement amountAfterIncreaseAndDecreaseElement=driver.findElement(By.cssSelector(".cm-amount"));
		String valueOfTheAmountAfterIncreaseAndDecrease=amountAfterIncreaseAndDecreaseElement.getAttribute("value");
		int intValueOfTheAmountAfterIncreaseAndDecrease=Integer.parseInt(valueOfTheAmountAfterIncreaseAndDecrease);
		Assert.assertEquals(intValueOfTheAmountBeforeIncrease,intValueOfTheAmountAfterIncreaseAndDecrease);
	}
	
	@Test
	public void tc04_addToWishList() {
		itempage.addToWishList();
		WebElement notificationMessage =driver.findElement(By.cssSelector(".cm-notification-content"));
		assert notificationMessage.isDisplayed();
		itempage.closeNotificationMessage();
	}
	
	@Test
	public void tc05_addToCart() {
		itempage.addToCart();
		WebElement notificationMessage =driver.findElement(By.cssSelector(".cm-notification-content"));
		assert notificationMessage.isDisplayed();
		itempage.closeNotificationMessage();
	}
	
	@Test
	public void tc06_addToCompare() {
		itempage.addToCompare();
		WebElement notificationMessage =driver.findElement(By.cssSelector(".cm-notification-content"));
		assert notificationMessage.isDisplayed();
		itempage.closeNotificationMessage();
	}
}
