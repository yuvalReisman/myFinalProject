package pagesTopMarket;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bsh.Console;

public class CheckoutPage extends BasePage {

	@FindBy(css = ".ty-product-notification__buttons>div.ty-float-right>a.ty-btn")
	private WebElement checkoutButton;
	@FindBy(css = "input#email")
	private WebElement emailField;
	@FindBy(css = "#password1")
	private WebElement firstPasswordField;
	@FindBy(css = "#password2")
	private WebElement secondPasswordField;
	@FindBy(css = "input#eway_cc_number_")
	private WebElement cardNumbersField;
	@FindBy(css = "#email_error_message")
	private WebElement emailErrorMessage;
	@FindBy(css = "#password1_error_message")
	private WebElement firstPasswordError;
	@FindBy(css = "#password2_error_message")
	private WebElement secondPasswordError;
	@FindBy(css = ".cm-cc-number.cm-failed-label")
	private WebElement cardNumbersError;

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	public void goToCheckout() {
		waitForElementToBeVisible(checkoutButton);
		click(checkoutButton);
	}

	public boolean isThereNoEmailError() {
		boolean noError=true;
		try {
			if (emailErrorMessage.isDisplayed())
				noError=false;
		} catch (Exception e) {
			return noError;
		}
		return noError;
	}

	public String getEmailErrorMessage() {
		return yourText(emailErrorMessage);
	}
	
	public String getFirstPasswordError() {
		return yourText(firstPasswordError);
	}
	
	public String getSecondPasswordError() {
		return yourText(secondPasswordError);
	}
	
	public void clearEmail() {
		emailField.clear();
	}

	public boolean isThereNoPasswordsError() {
		boolean noError=true;
		try {
			if (firstPasswordError.isDisplayed() || secondPasswordError.isDisplayed())
				noError=false;
		} catch (Exception e) {
			return noError;
		}
		return noError;
	}
	
	public void fillEmail(String email) {
		fillInfo(emailField, email);
		emailField.sendKeys(Keys.ENTER);
	}

	public void clearAllPasswordsFields() {
		firstPasswordField.clear();
		secondPasswordField.clear();
	}

	public void fillFirstPassword(String password) {
		fillInfo(firstPasswordField, password);
	}

	public void fillFirstPasswordAndEnter(String password) {
		fillInfo(firstPasswordField, password);
		firstPasswordField.sendKeys(Keys.ENTER);
	}

	public void fillSecondPassword(String password) {
		fillInfo(secondPasswordField, password);
	}

	public void fillSecondPasswordAndEnter(String password) {
		fillInfo(secondPasswordField, password);
		secondPasswordField.sendKeys(Keys.ENTER);
	}

	public void fillCardNumbers(String numbers) {
		fillInfo(cardNumbersField, numbers);
		cardNumbersField.sendKeys(Keys.ENTER);
	}
	
	public boolean isThereNoCardNumbersError() {
		boolean noError=true;
		try {
			if (cardNumbersError.isDisplayed())
				noError=false;
		} catch (Exception e) {
			return noError;
		}
		return noError;
	}

	public boolean isThereCardNumbersError() {
		if(cardNumbersError.isDisplayed())
			return true;
		return false;
	}
	
	public void clearCardNumbers() {
		cardNumbersField.clear();
	}
}
