@TravelBookFeature @Regression
Feature: Travel booking using MailTravel website

 @LoginTest @Smoke
 Scenario: Navigate to MailTravel website and confirm the page title and accept the cookies
    Given User want to launch chrome browser
    When User opens "https://www.mailtravel.co.uk/" website
    And confirm the page title as "Home Page | Mail Travel"
    And accept all the cookies
    Then user close the browser

  @AutoSuggestionTest
	Scenario: Search for India in MailTravel website Search bar
    Given User want to launch chrome browser
    When User opens "https://www.mailtravel.co.uk/" website
    And accept all the cookies
    When User search for "India" in search bar 
    And User gets the autosuggestion for "India" and select the first suggestion
    Then user confirms the country title as "India" in the result page
    And user close the browser

  @FieldErrorTest @Smoke
	Scenario:  Click on BOOK ONLINE button and verify the field error
    Given User want to launch chrome browser
    When User opens "https://www.mailtravel.co.uk/" website
    And accept all the cookies
    When User search for "India" in search bar 
    And User gets the autosuggestion for "India" and select the first suggestion
    Then user confirms the country title as "India" in the result page
    When user Click on BOOK ONLINE button in the result page
    Then user validates field error as "Please select your departure date" shown above the book online button
    And user close the browser

  @ChoosingDateDeparturePassengerAndAccomadationTest
  Scenario:  Scroll to the bottom of the page and select the next available date and click book online
    Given User want to launch chrome browser
    When User opens "https://www.mailtravel.co.uk/" website
    And accept all the cookies
    When User search for "India" in search bar 
    And User gets the autosuggestion for "India" and select the first suggestion
    Then user confirms the country title as "India" in the result page
    When User scroll down to the bottom of the page
    And User selects next available date  
    And User selects 2 adults and validate the total price
    And Make note of departure airport 
    And Verify the field error message diasspears from Book online button
    Then User click on Book online button to book the travel
    And user close the browser

  @VerifyTheBookingTest
  Scenario: After booking travel on the next page Expand the Date, Departure & Passengers section and verify details.
    Given User want to launch chrome browser
    When User opens "https://www.mailtravel.co.uk/" website
    And accept all the cookies
    When User search for "India" in search bar 
    And User gets the autosuggestion for "India" and select the first suggestion
    Then user confirms the country title as "India" in the result page
    When User scroll down to the bottom of the page
    And User selects next available date  
    And User selects 2 adults and validate the total price
    And Make note of departure airport 
    And Verify the field error message diasspears from Book online button
    Then User click on Book online button to book the travel
    When User land on next page and verify passengers count and departure airport details
    And In accommadation section select 1 room for selected adults
    Then User click on Select your room and continue button
    And user close the browser

  @EnterPassengerAndLeadDetailsTest
  Scenario: After booking travel on the next page Expand the Date, Departure & Passengers section and verify details.
    Given User want to launch chrome browser
    When User opens "https://www.mailtravel.co.uk/" website
    And accept all the cookies
    When User search for "India" in search bar 
    And User gets the autosuggestion for "India" and select the first suggestion
    Then user confirms the country title as "India" in the result page
    When User scroll down to the bottom of the page
    And User selects next available date  
    And User selects 2 adults and validate the total price
    And Make note of departure airport 
    And Verify the field error message diasspears from Book online button
    Then User click on Book online button to book the travel
    When User land on next page and verify passengers count and departure airport details
    And In accommadation section select 1 room for selected adults
    Then User click on Select your room and continue button
    And Choose continue without Extras button
    When User enters passenger1 details with title as "Mr" and first name as "Krish" and last name as "Nathan" and choose DOB as "25" "January" "1991" 
    And User enters passenger2 details with title as "Mr" and first name as "Madhu" and last name as "Arun" and choose DOB as "15" "January" "1994" 
    And User enters lead details with mobile number as "+4423455657" and email as "abc@xyz.com" and address1 as "qwerty" and city as "London" and country as "United Kingdom"
    And User choose "Email" from where did you hear about us dropdown
    Then User click on continue 
    And user close the browser
  
   @e2eTravelBookTest
   Scenario: After booking travel on the next page Expand the Date, Departure & Passengers section and verify details.
    Given User want to launch chrome browser
    When User opens "https://www.mailtravel.co.uk/" website
    And accept all the cookies
    When User search for "India" in search bar 
    And User gets the autosuggestion for "India" and select the first suggestion
    Then user confirms the country title as "India" in the result page
    When User scroll down to the bottom of the page
    And User selects next available date  
    And User selects 2 adults and validate the total price
    And Make note of departure airport 
    And Verify the field error message diasspears from Book online button
    Then User click on Book online button to book the travel
    When User land on next page and verify passengers count and departure airport details
    And In accommadation section select 1 room for selected adults
    Then User click on Select your room and continue button
    And Choose continue without Extras button
    When User enters passenger1 details with title as "Mr" and first name as "Krish" and last name as "Nathan" and choose DOB as "25" "January" "1991" 
    And User enters passenger2 details with title as "Mr" and first name as "Madhu" and last name as "Arun" and choose DOB as "15" "January" "1994" 
    And User enters lead details with mobile number as "+4423455657" and email as "abc@xyz.com" and address1 as "qwerty" and city as "London" and country as "United Kingdom"
    And User choose "Email" from where did you hear about us dropdown
    Then User click on continue 
    And User verify "Confirm Details + Book" page title
    And User verify Book now button is enabled
    And user close the browser
    