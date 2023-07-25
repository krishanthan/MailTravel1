package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import actions.ActionsWeb;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.junit.*;
import pageObjects.MailTravelHomePage;
import utilities.UtilityFunctions;

public class TravelBookSteps {
	
	public static String departureNote = null;
	public static int adultsCount = 0;

	public WebDriver driver; 
	public MailTravelHomePage mailTravelHomePage;
	public ActionsWeb actionsWeb;
	
	
	@Given("User want to launch chrome browser")
	public void user_want_to_launch_chrome_browser() {
		System.getProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	
		mailTravelHomePage = new MailTravelHomePage(driver);
		actionsWeb = new ActionsWeb(driver);
	
	}

	@When("User opens {string} website")
	public void user_opens_website(String siteURL) {
		actionsWeb.loadURL(siteURL);
	}
	
	
	@And("confirm the page title as {string}")
	public void confirm_the_page_title_as(String pageTitle) {
		Assert.assertEquals(pageTitle, actionsWeb.pageTitle());
	}
	
	@And("accept all the cookies")
	public void accept_all_the_cookies() throws InterruptedException {
		actionsWeb.clickButton(mailTravelHomePage.acceptAllCookiesButton);
	}

	@When("User search for {string} in search bar")
	public void user_search_for_in_search_bar(String searchKey) throws InterruptedException {
		actionsWeb.enterText(mailTravelHomePage.searchBox, searchKey);
	}

	@When("User gets the autosuggestion for {string} and select the first suggestion")
	public void user_gets_the_autosuggestion_for_and_select_the_first_suggestion(String suggestKey) throws InterruptedException {
		UtilityFunctions.selectInAutoSuggestion(driver, mailTravelHomePage.suggestionsList, suggestKey);
	}

	@Then("user confirms the country title as {string} in the result page")
	public void user_confirms_the_country_title_as_in_the_result_page(String countryName) {
		Assert.assertEquals(countryName, actionsWeb.elementText(mailTravelHomePage.countryTitle));
	}
	
	@When("user Click on BOOK ONLINE button in the result page")
	public void user_click_on_book_online_button_in_the_result_page() throws InterruptedException {
		actionsWeb.clickButton(mailTravelHomePage.bookOnlineButton);
	}

	@Then("user validates field error as {string} shown above the book online button")
	public void user_validates_field_error_as_shown_above_the_book_online_button(String fieldErrorMsg) {
		Assert.assertEquals(fieldErrorMsg, actionsWeb.elementText(mailTravelHomePage.fieldError));
	}

	@When("User scroll down to the bottom of the page")
	public void user_scroll_down_to_the_bottom_of_the_page() throws InterruptedException {
	    actionsWeb.scrollUpOrDownUsingElement(driver, mailTravelHomePage.dateAndPricelabel);
	}

	@When("User selects next available date")
	public void user_selects_next_available_date() throws InterruptedException {
		actionsWeb.clickButton(mailTravelHomePage.monthForwardIcon);
		actionsWeb.clickButton(mailTravelHomePage.dateSelectionRadioButton);
	}

	@When("User selects {int} adults and validate the total price")
	public void user_selects_adults_and_validate_the_total_price(Integer noOfAdults) {
		adultsCount = Integer.parseInt(actionsWeb.selectByIndexFromDropDown(mailTravelHomePage.adultsSelectionDropBox, noOfAdults));
		Assert.assertEquals(Double.parseDouble(actionsWeb.elementText(mailTravelHomePage.totalPrice).replaceAll("[£,]", "")), UtilityFunctions.totalPriceCalculator(adultsCount, Double.parseDouble(actionsWeb.elementText(mailTravelHomePage.dispalyedAmountInDate).replaceAll("[£,]", ""))),0.000001d);
	}

	@When("Make note of departure airport")
	public void make_note_of_departure_airport() {
		departureNote = actionsWeb.elementText(mailTravelHomePage.departureNoteText);
	}

	@When("Verify the field error message diasspears from Book online button")
	public void verify_the_field_error_message_diasspears_from_book_online_button() throws InterruptedException {
		 actionsWeb.scrollUpOrDownUsingElement(driver, mailTravelHomePage.countryTitle);
		 Assert.assertFalse(UtilityFunctions.isElementPresent(mailTravelHomePage.fieldError));
	}

	@Then("User click on Book online button to book the travel")
	public void user_click_on_book_online_button_to_book_the_travel() throws InterruptedException {
		actionsWeb.scrollUpOrDownUsingElement(driver, mailTravelHomePage.dateAndPricelabel);
		actionsWeb.clickButton(mailTravelHomePage.bookOnlineButtonAtFooter);
		Thread.sleep(5000);
	}

	@When("User land on next page and verify passengers count and departure airport details")
	public void user_land_on_next_page_and_verify_passengers_count_and_departure_airport_details() throws InterruptedException {
		actionsWeb.scrollUpOrDownUsingElement(driver, mailTravelHomePage.dateDepartureAndPassengersTitle);
		actionsWeb.clickButton(mailTravelHomePage.dateDepartureAndPassengersTitle);
		Assert.assertEquals(adultsCount, Integer.parseInt(actionsWeb.elementText(mailTravelHomePage.dateDepartureDialogAdultsCount)));
	    Assert.assertTrue(departureNote.contains(actionsWeb.elementText(mailTravelHomePage.dateDepartureAirportName).split(" ")[1]));
	}

	@When("In accommadation section select {int} room for selected adults")
	public void in_accommadation_section_select_room_for_adults(Integer roomCount) throws InterruptedException {
	    actionsWeb.scrollUpOrDownUsingElement(driver, mailTravelHomePage.accomadationTitle);
	    actionsWeb.selectByIndexFromDropDown(mailTravelHomePage.accomadationRoomDropDown, roomCount+1);
	}

	@Then("User click on Select your room and continue button")
	public void user_click_on_select_your_room_and_continue_button() throws InterruptedException {
		actionsWeb.clickButton(mailTravelHomePage.accomadationSelectYourRoomButton);
	}
	
	@And("Choose continue without Extras button")
	public void choose_continue_without_extras_button() throws InterruptedException {
	   actionsWeb.clickButton(mailTravelHomePage.extrasContinueWithoutExtrasButton);
	}

	@When("User enters passenger1 details with title as {string} and first name as {string} and last name as {string} and choose DOB as {string} {string} {string}")
	public void user_enters_passenger1_details_with_title_as_and_first_name_as_and_last_name_as_and_choose_dob_as(String title, String firstName, String lastName, String date, String month, String year) throws InterruptedException {
	    actionsWeb.selectByValueFromDropDown(mailTravelHomePage.passengerTitle1,title);
	    actionsWeb.enterText(mailTravelHomePage.passengerFirstName1, firstName);
	    actionsWeb.enterText(mailTravelHomePage.passengerLastName1, lastName);
	    actionsWeb.selectByValueFromDropDown(mailTravelHomePage.passengerDOBDate1,date);
	    actionsWeb.selectByVisibleTextFromDropDown(mailTravelHomePage.passengerDOBMonth1,month);
	    actionsWeb.selectByValueFromDropDown(mailTravelHomePage.passengerDOBYear1,year);
	    
	}
	
	@And("User enters passenger2 details with title as {string} and first name as {string} and last name as {string} and choose DOB as {string} {string} {string}")
	public void user_enters_passenger2_details_with_title_as_and_first_name_as_and_last_name_as_and_choose_dob_as(String title, String firstName, String lastName, String date, String month, String year) throws InterruptedException {
		actionsWeb.selectByValueFromDropDown(mailTravelHomePage.passengerTitle2,title);
	    actionsWeb.enterText(mailTravelHomePage.passengerFirstName2, firstName);
	    actionsWeb.enterText(mailTravelHomePage.passengerLastName2, lastName);
	    actionsWeb.selectByValueFromDropDown(mailTravelHomePage.passengerDOBDate2,date);
	    actionsWeb.selectByVisibleTextFromDropDown(mailTravelHomePage.passengerDOBMonth2,month);
	    actionsWeb.selectByValueFromDropDown(mailTravelHomePage.passengerDOBYear2,year);
	}


	@And("User enters lead details with mobile number as {string} and email as {string} and address1 as {string} and city as {string} and country as {string}")
	public void user_enters_lead_details_with_mobile_number_as_and_email_as_and_address1_as_and_city_as_and_country_as(String mobileNumber, String emailAddress, String address1, String city, String country) throws InterruptedException {
		actionsWeb.enterText(mailTravelHomePage.leadMobilePhoneNumber, mobileNumber);
	    actionsWeb.enterText(mailTravelHomePage.leadEmailAddress, emailAddress);
	    actionsWeb.enterText(mailTravelHomePage.leadAddress1, address1);
	    actionsWeb.enterText(mailTravelHomePage.leadCity, city);
	    actionsWeb.selectByVisibleTextFromDropDown(mailTravelHomePage.leadCountry,country);
	    
	}

	@And("User choose {string} from where did you hear about us dropdown")
	public void user_choose_from_where_did_you_hear_about_us_dropdown(String hearAboutUs) throws InterruptedException {
		actionsWeb.scrollUpOrDownUsingElement(driver, mailTravelHomePage.passengerDetailsContinueButton);
		actionsWeb.selectByVisibleTextFromDropDown(mailTravelHomePage.hearAboutUs,hearAboutUs);
	}

	@Then("User click on continue")
	public void user_click_on_continue() throws InterruptedException {
		actionsWeb.clickButton(mailTravelHomePage.passengerDetailsContinueButton);
		Thread.sleep(5000);
	}
	
	@And("User verify {string} page title")
	public void user_verify_page_title(String pageTitle) {
	    Assert.assertEquals(pageTitle, actionsWeb.elementText(mailTravelHomePage.paymentsPageTitle));
	}

	@And("User verify Book now button is enabled")
	public void user_verify_book_now_button_is_enabled() throws InterruptedException {
		actionsWeb.scrollUpOrDownUsingElement(driver, mailTravelHomePage.paymentsPageBookNowButton);
	    Assert.assertTrue(UtilityFunctions.isElementEnabled(mailTravelHomePage.paymentsPageBookNowButton));
	}

	@Then("user close the browser")
	public void user_close_the_browser() {
		actionsWeb.closeBrowser();
	}
}
