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

public class CheckoutTests extends BaseTest {

	@Test
	public void tc01_goToCart() {
		homepage.hoverCategoryAndChoose("Accessories", "Memory Cards");
		itempage.chooseFirstItem();
		itempage.addToCart();
		checkoutpage.goToCheckout();
		WebElement pageTitle =driver.findElement(By.cssSelector(".ty-checkout__title"));
		assert pageTitle.isDisplayed();
	}

	@Test
	public void tc02_fillRightEmail() {
		checkoutpage.fillEmail("yuval@gmail.com");
		boolean noSuchElement = false;
		try {
			driver.findElement(By.cssSelector("#email_error_message"));
		} catch (Exception e) {
			noSuchElement = true;
			assertTrue(noSuchElement);
		}
	}

	@Test
	public void tc03_fillWrongEmail() {
		checkoutpage.clearEmail();
		checkoutpage.fillEmail("yuval");
		WebElement error = driver.findElement(By.cssSelector("#email_error_message"));
		assert error.isDisplayed();
	}

	@Test
	public void tc04_fillOnlyFirstPasswordAndEnter() {
		checkoutpage.clearAllPasswordsFields();
		checkoutpage.fillFirstPasswordAndEnter("123");
		WebElement firstPassworderror = driver.findElement(By.cssSelector("#password1_error_message"));
		WebElement secondPassworderror = driver.findElement(By.cssSelector("#password2_error_message"));
		assert firstPassworderror.getText()
				.equalsIgnoreCase("The passwords in the Confirm password and Password fields do not match.");
		assert secondPassworderror.getText().equalsIgnoreCase("The Confirm password field is mandatory.");
	}

	@Test
	public void tc05_fillOnlySecondPasswordAndEnter() {
		checkoutpage.clearAllPasswordsFields();
		checkoutpage.fillSecondPasswordAndEnter("123");
		WebElement firstPassworderror = driver.findElement(By.cssSelector("#password1_error_message"));
		WebElement secondPassworderror = driver.findElement(By.cssSelector("#password2_error_message"));
		assert secondPassworderror.getText()
				.equalsIgnoreCase("The passwords in the Password and Confirm password fields do not match.");
		assert firstPassworderror.getText().equalsIgnoreCase("The Password field is mandatory.");
	}

	@Test
	public void tc06_fillBothPasswordsTheSame() {
		checkoutpage.clearAllPasswordsFields();
		checkoutpage.fillFirstPassword("123");
		checkoutpage.fillSecondPasswordAndEnter("123");
		boolean noFirstError = false;
		boolean noSecondError = false;
		try {
			driver.findElement(By.cssSelector("#password1_error_message"));
		} catch (Exception e) {
			noFirstError = true;
			try {
				driver.findElement(By.cssSelector("#password2_error_message"));
			} catch (Exception e2) {
				noSecondError = true;
				assertTrue(noFirstError);
				assertTrue(noSecondError);
			}
		}
	}

	@Test
	public void tc07_fillPasswordsDifferently() {
		checkoutpage.clearAllPasswordsFields();
		checkoutpage.fillFirstPassword("123");
		checkoutpage.fillSecondPasswordAndEnter("456");
		WebElement firstPassworderror = driver.findElement(By.cssSelector("#password1_error_message"));
		WebElement secondPassworderror = driver.findElement(By.cssSelector("#password2_error_message"));
		assert firstPassworderror.getText()
				.equalsIgnoreCase("The passwords in the Confirm password and Password fields do not match.");
		assert secondPassworderror.getText()
				.equalsIgnoreCase("The passwords in the Password and Confirm password fields do not match.");
	}

	@Test
	public void tc08_fillCardNumbersRight() {
		checkoutpage.fillCardNumbers("1284569255427784");
		boolean noSuchElement;
		try {
			driver.findElement(By.cssSelector(".cm-cc-number.cm-failed-label"));
		} catch (Exception e) {
			noSuchElement = true;
			assertTrue(noSuchElement);
		}
	}

	@Test
	public void tc09_fillCardNumbersWrong() {
		checkoutpage.clearCardNumbers();
		checkoutpage.fillCardNumbers("12");
		WebElement error = driver.findElement(By.cssSelector(".cm-cc-number.cm-failed-label"));
		assert error.isDisplayed();
	}
}
