package pagesTopMarket;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

	WebDriver driver;
	WebDriverWait wait;
	Actions mouse;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		mouse = new Actions(driver);
	}

	public void click(WebElement el) {
		el.click();
	}

	public void fillInfo(WebElement el, String text) {
		el.sendKeys(text);
	}

	public String yourText(WebElement el) {
		return el.getText();
	}

	public void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Wait
	public void waitForElementToBeClickable(WebElement el) {
		wait.until(ExpectedConditions.elementToBeClickable(el));
	}

	public void waitForElementToBeVisible(WebElement el) {
		wait.until(ExpectedConditions.visibilityOf(el));
//		wait.until(ExpectedConditions.invisibilityOf(el));
	}

	public void waitForTextToBePresentInElement(WebElement el, String text) {
		wait.until(ExpectedConditions.textToBePresentInElement(el, text));
	}

	// Mouse
	public void mouseHover(WebElement el) {
		mouse.moveToElement(el).build().perform();
	}
}
