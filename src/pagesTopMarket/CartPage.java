package pagesTopMarket;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bsh.Console;

public class CartPage extends BasePage {

	
	@FindBy(css = ".ty-float-left.ty-cart-content__left-buttons a.ty-btn.ty-btn__secondary")
	private List<WebElement> closeCartButtons;
	@FindBy(css = ".ty-float-left.ty-cart-content__left-buttons a.text-button")
	private WebElement clearCartButton;
	@FindBy(css = "#button_cart")
	private WebElement recalculateButton;
	@FindBy(css = ".ty-float-right.ty-cart-content__right-buttons a.ty-btn.ty-btn__primary")
	private List<WebElement> proceedToCheckoutButtons;
	@FindBy(css = ".cm-increase")
	private WebElement increaseButton;
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	public void closeCart() {
		WebElement firstCloseButton=closeCartButtons.get(0);
		click(firstCloseButton);
	}
	
	public void clearCart() {
		click(clearCartButton);
	}
	
	public void recalculateCart() {
		click(recalculateButton);
	}
	
	public void proceedToCheckout() {
		WebElement firstproceedToCheckoutButton=proceedToCheckoutButtons.get(0);
		click(firstproceedToCheckoutButton);
	}
	
	public void increaseItem() {
		click(increaseButton);
	}
}
