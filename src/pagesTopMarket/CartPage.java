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
	@FindBy(css = ".basket-cart-amount")
	private WebElement amountOfItemsInCart;
	@FindBy(css = ".cm-notification-close")
	private WebElement exitNotificationMessage;
	@FindBy(css = "[name='checkout_form']>.ty-mainbox-title")
	private WebElement cartPageTitle;
	@FindBy(css = ".cm-notification-content")
	private WebElement notificationRecalculateMessage;
	@FindBy(css = "*[id*='product_price']")
	private WebElement priceOfTheItem;
	@FindBy(css = "*[id*='product_subtotal']")
	private WebElement totalPriceOfItems;
	@FindBy(css = "h1.ty-mainbox-title")
	private WebElement itemsPageTitle;
	@FindBy(css = ".ty-no-items")
	private WebElement noItemsInCartMessage;
	@FindBy(css = ".ty-mainbox-body>.buttons-container .ty-btn")
	private WebElement closeCartAfterClear;
	@FindBy(css = ".ty-checkout__title")
	private WebElement checkoutPageTitle;
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	public String getAmountOfItemsInCartInHomePage() {
		return yourText(amountOfItemsInCart);
	}
	
	public void clickOnExitNotificationMessage() {
		click(exitNotificationMessage);
	}
	
	public String getCartPageTitle() {
		return yourText(cartPageTitle);
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
	
	public String getSuccessfulNotificationMessage() {
		return yourText(notificationRecalculateMessage);
	}
	
	public void proceedToCheckout() {
		WebElement firstproceedToCheckoutButton=proceedToCheckoutButtons.get(0);
		click(firstproceedToCheckoutButton);
	}
	
	public void increaseItem() {
		click(increaseButton);
	}
	
	public String getPriceOfTheItem() {
		return yourText(priceOfTheItem);
	}
	
	public String getTotalPriceOfTheItems() {
		return yourText(totalPriceOfItems);
	}
	
	public String getItemsPageTitle() {
		return yourText(itemsPageTitle);
	}
	
	public String getNoItemsInCartMessage() {
		return yourText(noItemsInCartMessage);
	}
	
	public void closeCartAfterClear() {
		click(closeCartAfterClear);
	}
	
	public String getCheckoutPageTitle() {
		return yourText(checkoutPageTitle);
	}
}
