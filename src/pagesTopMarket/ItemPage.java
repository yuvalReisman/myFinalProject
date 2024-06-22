package pagesTopMarket;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bsh.Console;

public class ItemPage extends BasePage {

	@FindBy(css = ".ty-product-list__item-name")
	private List<WebElement> itemButton;
	@FindBy(css = ".ty-value-changer__increase")
	private WebElement increaseAmountButton;
	@FindBy(css = ".ty-value-changer__decrease")
	private WebElement decreaseAmountButton;
	@FindBy(css = ".advanced-buttons>.ty-add-to-wish")
	private WebElement addToWishListButton;
	@FindBy(css = ".cm-notification-content")
	private WebElement notificationMessage;
	@FindBy(css = ".ty-btn__add-to-cart")
	private WebElement addToCartButton;
	@FindBy(css = ".ty-add-to-compare")
	private WebElement addToCompareButton;
	@FindBy(css = ".cm-notification-close.close")
	private WebElement closeNotificationMessage;
	
	
	public ItemPage(WebDriver driver) {
		super(driver);
	}

	public void chooseFirstItem() {
		waitForElementToBeVisible(itemButton.get(0));
		itemButton.get(0).click();
	}
	
	public void increseAmount(int amountToIncrease) {
		int count=0;
		while(count<amountToIncrease) {
			click(increaseAmountButton);
			count++;
		}
	}
	
	public void decreaseAmount(int amountToDecrease) {
		int count=0;
		while(count<amountToDecrease) {
			click(decreaseAmountButton);
			count++;
		}
	}
	
	public void addToWishList() {
		click(addToWishListButton);
		waitForElementToBeVisible(notificationMessage);
	}
	
	public void addToCart() {
		click(addToCartButton);
		waitForElementToBeVisible(notificationMessage);
	}
	
	public void addToCompare() {
		click(addToCompareButton);
		waitForElementToBeVisible(notificationMessage);
	}
	
	public void closeNotificationMessage() {
		click(closeNotificationMessage);
	}
}
