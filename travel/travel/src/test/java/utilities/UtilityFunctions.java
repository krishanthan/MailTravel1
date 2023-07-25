package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UtilityFunctions {
	
	// Check whether an element is present or not
	public static boolean isElementPresent(WebElement locatorKey) {
	    try {
	    	locatorKey.isDisplayed();
	        return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        return false;
	    }
	}
	
	// Check whether an element is enabled or not
	public static boolean isElementEnabled(WebElement locatorKey) {
	    try {
	    	locatorKey.isEnabled();
	        return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        return false;
	    }
	}
	
	// Select the first option from the list of auto-suggestions
	public static void selectInAutoSuggestion(WebDriver driver,By suggestionList,String suggestKey) throws InterruptedException{
		List<WebElement> suggestions = driver.findElements(suggestionList);
	     for(int i=0;i<suggestions.size();i++){
	    	 String option=suggestions.get(i).getText();
	    	 if(option.contains(suggestKey)) {
	    		 suggestions.get(i).click();
	    		 break;
	    	 }
	     }

	}
	
	// Calculate the total price based on no. of Items multiplied by price of an item
	public static double totalPriceCalculator(int noOfItems, double priceOfAnItem) {
		double result = (noOfItems *priceOfAnItem);
		return result;
	}

}
