package pagesTopMarket;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bsh.Console;

public class NavigationPage extends BasePage {

	@FindBy(css = "#search_input")
	private WebElement searchField;
	@FindBy(css = "[title='Search']")
	private WebElement searchButton;
	@FindBy(css = ".top-logo")
	private WebElement logoButton;
	@FindBy(css = ".top-cart-content")
	private WebElement cartButton;
	@FindBy(css = ".ty-float-left>.ty-btn")
	private WebElement viewCartButton;
	@FindBy(css = "select.energo-searchbox")
	private WebElement searchDepatmentsButton;
	@FindBy(css = "select.energo-searchbox option")
	private List<WebElement> searchDepatmentsOptions;
	
	
	public NavigationPage(WebDriver driver) {
		super(driver);
	}

	public void searchForItem(String itemName) {
		click(searchField);
		fillInfo(searchField, itemName);
		click(searchButton);
	}
	
	public void searchDepartment(String departmentName) {
		click(searchDepatmentsButton);
		for (WebElement departemnt : searchDepatmentsOptions) {
			if(departemnt.getText().contains(departmentName))
			{
				click(departemnt);
				click(searchButton);
				break;
			}
		}
	}
	
	public void getHome() {
		click(logoButton);
	}
	
	public void getIntoCart() {
		waitForElementToBeClickable(cartButton);
		click(cartButton);
		click(viewCartButton);
	}
	
	
}
