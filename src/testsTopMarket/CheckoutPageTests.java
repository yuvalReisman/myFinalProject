package testsTopMarket;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.NoSuchElementException;

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

public class CheckoutPageTests extends BaseTest {

	@Test
	public void tc01_goToCheckout() {
		homepage.hoverCategoryAndChoose("Accessories", "Memory Cards");
		itempage.chooseFirstItem();
		itempage.addToCart();
		checkoutpage.goToCheckout();
		String expectedPageTitle="SECURE CHECKOUT";
		String actualPageTitle= cartpage.getCheckoutPageTitle();
		Assert.assertEquals(expectedPageTitle, actualPageTitle);
	}

	@Test
	public void tc02_fillRightEmail() {
		checkoutpage.fillEmail("yuval@gmail.com");
		boolean expectedNoError=true;
		Assert.assertEquals(expectedNoError,checkoutpage.isThereNoEmailError());
	}

	@Test
	public void tc03_fillWrongEmail() {
		checkoutpage.clearEmail();
		checkoutpage.fillEmail("yuval");
		String expectedError="The email address in the Email field is invalid.";
		String actualError= checkoutpage.getEmailErrorMessage();
		Assert.assertEquals(expectedError, actualError);
	}

	@Test
	public void tc04_fillOnlyFirstPasswordAndEnter() {
		checkoutpage.clearAllPasswordsFields();
		checkoutpage.fillFirstPasswordAndEnter("123");
		String expectedFirstPasswordError="The passwords in the Confirm password and Password fields do not match.";
		String ActualFirstPasswordError=checkoutpage.getFirstPasswordError();
		Assert.assertEquals(expectedFirstPasswordError, ActualFirstPasswordError);
		String expectedSecondPasswordError="The Confirm password field is mandatory.";
		String ActualSecondPasswordError=checkoutpage.getSecondPasswordError();
		Assert.assertEquals(expectedSecondPasswordError, ActualSecondPasswordError);
	}

	@Test
	public void tc05_fillOnlySecondPasswordAndEnter() {
		checkoutpage.clearAllPasswordsFields();
		checkoutpage.fillSecondPasswordAndEnter("123");
		String expectedFirstPasswordError="The Password field is mandatory.";
		String ActualFirstPasswordError=checkoutpage.getFirstPasswordError();
		Assert.assertEquals(expectedFirstPasswordError, ActualFirstPasswordError);
		String expectedSecondPasswordError="The passwords in the Password and Confirm password fields do not match.";
		String ActualSecondPasswordError=checkoutpage.getSecondPasswordError();
		Assert.assertEquals(expectedSecondPasswordError, ActualSecondPasswordError);
	}

	@Test
	public void tc06_fillBothPasswordsTheSame() {
		checkoutpage.clearAllPasswordsFields();
		checkoutpage.fillFirstPassword("123");
		checkoutpage.fillSecondPasswordAndEnter("123");
		boolean expectedNoError=true;
		Assert.assertEquals(expectedNoError,checkoutpage.isThereNoPasswordsError());
	}

	@Test
	public void tc07_fillPasswordsDifferently() {
		checkoutpage.clearAllPasswordsFields();
		checkoutpage.fillFirstPassword("123");
		checkoutpage.fillSecondPasswordAndEnter("456");
		String expectedFirstPasswordError="The passwords in the Confirm password and Password fields do not match.";
		String ActualFirstPasswordError=checkoutpage.getFirstPasswordError();
		Assert.assertEquals(expectedFirstPasswordError, ActualFirstPasswordError);
		String expectedSecondPasswordError="The passwords in the Password and Confirm password fields do not match.";
		String ActualSecondPasswordError=checkoutpage.getSecondPasswordError();
		Assert.assertEquals(expectedSecondPasswordError, ActualSecondPasswordError);
	}

	@Test
	public void tc08_fillCardNumbersRight() {
		checkoutpage.fillCardNumbers("1284569255427784");
		boolean expectedNoError=true;
		Assert.assertEquals(expectedNoError,checkoutpage.isThereNoCardNumbersError());
	}

	@Test
	public void tc09_fillCardNumbersWrong() {
		checkoutpage.clearCardNumbers();
		checkoutpage.fillCardNumbers("12");
		boolean expectedExistingError=true;
		Assert.assertEquals(expectedExistingError,checkoutpage.isThereCardNumbersError());
	}
}
