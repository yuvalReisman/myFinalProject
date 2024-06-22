package pagesTopMarket;

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
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	public void goToCheckout() {
		waitForElementToBeVisible(checkoutButton);
		click(checkoutButton);
	}
	
	public void clearEmail() {
		emailField.clear();
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
	
	public void clearCardNumbers() {
		cardNumbersField.clear();
	}
}
