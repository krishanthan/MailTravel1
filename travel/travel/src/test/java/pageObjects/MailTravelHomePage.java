package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailTravelHomePage {
	
	public WebDriver driver;

	public MailTravelHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="onetrust-accept-btn-handler")
	@CacheLookup
	public WebElement acceptAllCookiesButton;
	
	@FindBy(id="searchtext_freetext_search_form")
	@CacheLookup
	public WebElement searchBox;
	
	public By suggestionsList = By.xpath("//div[@class='autosuggest']/ul/li");
	
	@FindBy(xpath="//h1[text()='India']")
	@CacheLookup
	public WebElement countryTitle;
	
	@FindBy(name="enterbookingflow")
	@CacheLookup
	public WebElement bookOnlineButton;
	
	@FindBy(xpath="(//div[@class='nbf_tpl_pms_buttonarea nbf_tpl_pms_book']//button)[2]")
	@CacheLookup
	public WebElement bookOnlineButtonAtFooter;
	
	@FindBy(className="fielderror")
	@CacheLookup
	public WebElement fieldError;
	
	@FindBy(id="travel-experience-wrap_tr_ex_iter_3_tr-experience-img")
	@CacheLookup
	public WebElement dateAndPricelabel;
	
	@FindBy(xpath="//div[@class='nbf_tpl_pms_calendar_next nbf_tpl_pms_calendar_update']")
	@CacheLookup
	public WebElement monthForwardIcon;
	
	@FindBy(name="seldate")
	@CacheLookup
	public WebElement dateSelectionRadioButton;
	
	@FindBy(css="div#calendar_segment>div>div>div:nth-of-type(2)>div>div:nth-of-type(3)>label>div>div:nth-of-type(2)>span")
	@CacheLookup
	public WebElement dispalyedAmountInDate;
	
	@FindBy(name="numAdults")
	@CacheLookup
	public WebElement adultsSelectionDropBox;
	
	@FindBy(xpath="//div[text()='Departure Airport:']/following-sibling::span")
	@CacheLookup
	public WebElement departureNoteText;
	
	@FindBy(css="span#tour-price>span")
	@CacheLookup
	public WebElement totalPrice;
	
	@FindBy(xpath="//div[@class='nbf_tpl_pms_bf_panel__title']//h2")
	@CacheLookup
	public WebElement dateDepartureAndPassengersTitle;
	
	@FindBy(xpath="//div[contains(@class,'nbf_tpl_pms_bf_passenger_number unit')]")
	@CacheLookup
	public WebElement dateDepartureDialogAdultsCount;
	
	@FindBy(xpath="//div[contains(@class,'nbf_tpl_pms_bf_departure_label unit')]/following-sibling::div[1]")
	@CacheLookup
	public WebElement dateDepartureAirportName;
	
	@FindBy(xpath="(//div[@class='nbf_tpl_pms_bf_panel__title']//h2)[3]")
	@CacheLookup
	public WebElement accomadationTitle;
	
	@FindBy(xpath="//select[@class='nbf_tpl_pms_roomselection_js']")
	@CacheLookup
	public WebElement accomadationRoomDropDown;
	
	@FindBy(xpath="//button[@class='nbf_button nbf_tpl_pms_book_button']")
	@CacheLookup
	public WebElement accomadationSelectYourRoomButton;
	
	@FindBy(xpath="//button[@class='nbf_button nbf_tpl_pms_button']")
	@CacheLookup
	public WebElement extrasContinueWithoutExtrasButton;
	
	@FindBy(xpath="//tr[@class='nbf_tpl_pms_bf_paxtitle']//select")
	@CacheLookup
	public WebElement passengerTitle1;
	
	@FindBy(xpath="//tr[@class='nbf_tpl_pms_bf_paxfirst']//input")
	@CacheLookup
	public WebElement passengerFirstName1;
	
	@FindBy(xpath="//tr[@class='nbf_tpl_pms_bf_paxlast']//input")
	@CacheLookup
	public WebElement passengerLastName1;
	
	@FindBy(id="pax-a-dobd-1")
	@CacheLookup
	public WebElement passengerDOBDate1;
	
	@FindBy(id="pax-a-dobm-1")
	@CacheLookup
	public WebElement passengerDOBMonth1;
	
	@FindBy(id="pax-a-doby-1")
	@CacheLookup
	public WebElement passengerDOBYear1;
	
	@FindBy(xpath="(//tr[@class='nbf_tpl_pms_bf_paxtitle']//select)[2]")
	@CacheLookup
	public WebElement passengerTitle2;
	
	@FindBy(xpath="(//tr[@class='nbf_tpl_pms_bf_paxfirst']//input)[2]")
	@CacheLookup
	public WebElement passengerFirstName2;
	
	@FindBy(xpath="(//tr[@class='nbf_tpl_pms_bf_paxlast']//input)[2]")
	@CacheLookup
	public WebElement passengerLastName2;
	
	@FindBy(id="pax-a-dobd-2")
	@CacheLookup
	public WebElement passengerDOBDate2;
	
	@FindBy(id="pax-a-dobm-2")
	@CacheLookup
	public WebElement passengerDOBMonth2;
	
	@FindBy(id="pax-a-doby-2")
	@CacheLookup
	public WebElement passengerDOBYear2;
	
	@FindBy(xpath="//tr[@id='contact-mobile-label']//input[1]")
	@CacheLookup
	public WebElement leadMobilePhoneNumber;
	
	@FindBy(xpath="//tr[@id='contact-email-label']//input[1]")
	@CacheLookup
	public WebElement leadEmailAddress;
	
	@FindBy(xpath="//tr[@id='contact-address1-label']//input[1]")
	@CacheLookup
	public WebElement leadAddress1;
	
	@FindBy(xpath="//label[text()='City']/following::input")
	@CacheLookup
	public WebElement leadCity;
	
	@FindBy(xpath="//tr[@id='contact-country-label']//select[1]")
	@CacheLookup
	public WebElement leadCountry;
	
	@FindBy(id="contact-hearabout")
	@CacheLookup
	public WebElement hearAboutUs;
	
	@FindBy(xpath="//button[@class='nbf_button nbf_tpl_pms_button']")
	@CacheLookup
	public WebElement passengerDetailsContinueButton;
	
	@FindBy(xpath="//h1[@class='nbf_fancy_payment_tourheader']/following-sibling::h1[1]")
	@CacheLookup
	public WebElement paymentsPageTitle;
	
	@FindBy(id="nbf_booknow_button")
	@CacheLookup
	public WebElement paymentsPageBookNowButton;
}