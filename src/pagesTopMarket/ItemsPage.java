package pagesTopMarket;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bsh.Console;

public class ItemsPage extends BasePage {

	@FindBy(css = ".ty-sort-container__views-a>.ty-icon-products-multicolumns")
	private WebElement squareDisplayItemsButton;
	@FindBy(css = ".ty-icon-products-without-options")
	private WebElement squareAndListDisplayItemsButton;
	@FindBy(css = ".ty-sort-container__views-a>.ty-icon-short-list")
	private WebElement listDisplayItemsButton;
	@FindBy(css = ".ty-compact-list__content")
	private WebElement itemsDisplayList;
	@FindBy(css = ".ty-grid-list__item")
	private WebElement itemsDisplaySquare;
	@FindBy(css = ".ty-product-list")
	private WebElement itemsDisplaySquareAndList;
	@FindBy(css = ".ty-sort-dropdown>a")
	private List<WebElement> dropDownButton;
	@FindBy(css = ".ty-sort-dropdown__content-item-a")
	private List<WebElement> optionsFromDropDown;
	@FindBy(css = ".hiddenFilter>a")
	private WebElement filterButton;
	@FindBy(css = ".ty-product-filters__search>input")
	private WebElement searchButton;
	
	
	public ItemsPage(WebDriver driver) {
		super(driver);
	}

	public void squareDisplayItems() {
		click(squareDisplayItemsButton);
		waitForElementToBeVisible(itemsDisplaySquare);
	}
	
	public void squareAndListDisplayItems() {
		click(squareAndListDisplayItemsButton);
		waitForElementToBeVisible(itemsDisplaySquareAndList);
	}
	
	public void listDisplayItems() {
		click(listDisplayItemsButton);
		waitForElementToBeVisible(itemsDisplayList);
	}
	
	public void amountOfItems(String chosenAmountToDisplay) {
		for (WebElement dropDown : dropDownButton) {
			if(dropDown.getText().equalsIgnoreCase("24 Per Page")) {
				dropDown.click();
				for (WebElement option : optionsFromDropDown) {
					if(option.getText().equalsIgnoreCase(chosenAmountToDisplay)){
						option.click();
						sleep(2000);
						break;
					}
				}
			}
		}
	}
	
	public void hideProductsFilter() {
		waitForElementToBeClickable(filterButton);
		click(filterButton);
	}
	
	public void searchForCompany(String company) {
		waitForElementToBeVisible(searchButton);
		click(searchButton);
		fillInfo(searchButton, company);
	}
}
