package actions;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsWeb {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor executor;
	
	public ActionsWeb(WebDriver driver) {
		super();
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	public void loadURL(String url) {
		driver.get(url);	
	}

	public void clickButton(WebElement button) throws InterruptedException {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(button)).click();
		Thread.sleep(5000);
	}
	
	public void enterText(WebElement element, String text) throws InterruptedException {
		element.clear();
		element.sendKeys(text);
		Thread.sleep(3000);
	}
	
	public String pageTitle() {
		return driver.getTitle();
	}
	
	public String elementText(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}
	
	public void scrollUpOrDownUsingElement(WebDriver driver,WebElement element) throws InterruptedException {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(3000);
	}
	
	public String selectByIndexFromDropDown(WebElement dropDown, int index) {
		Select numOfItems = new Select(dropDown);
		numOfItems.selectByIndex(--index);
		return numOfItems.getFirstSelectedOption().getText();
	}
	
	public String selectByValueFromDropDown(WebElement dropDown, String value) {
		Select numOfItems = new Select(dropDown);
		numOfItems.selectByValue(value);
		return numOfItems.getFirstSelectedOption().getText();
	}
	
	public String selectByVisibleTextFromDropDown(WebElement dropDown, String visibleText) {
		Select numOfItems = new Select(dropDown);
		numOfItems.selectByVisibleText(visibleText);
		return numOfItems.getFirstSelectedOption().getText();
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	

}
