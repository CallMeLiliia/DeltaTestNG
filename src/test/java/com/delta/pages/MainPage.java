package com.delta.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.delta.utils.BrowserUtils;
import com.delta.utils.Driver;

public class MainPage {
	public MainPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	Actions action = new Actions(Driver.getDriver());

	@FindBy(id = "fromAirportName")
	public WebElement fromAirportName;
	@FindBy(id = "search_input")
	public WebElement departureSearchInput;
	@FindBy(xpath = "//span[.='WAS']")
	public WebElement pickFromDropDownWAS;

	@FindBy(id = "toAirportName")
	public WebElement destinationAirportName;
	@FindBy(id = "search_input")
	public WebElement destinationSearchInput;
	@FindBy(xpath = "//span[.='MIA']")
	public WebElement pickFromDropDownMIA;

	@FindBy(id = "input_departureDate_1")
	public WebElement departureDateCalendar;
	@FindBy(linkText = "30")
	public WebElement departureDateFromCalendar;
	@FindBy(xpath = "//a [@data-date='05/10/2020|S, May 10|10 May 2020, Sunday']")
	public WebElement returnDateFromCalendar;
	@FindBy(xpath = "//button[.='done']")
	public WebElement doneCalendarButton;

	@FindBy(xpath = "(//span[@class='select-ui-wrapper '])[2]")
	public WebElement quantityOfPassengers;
	@FindBy(id = "ui-list-passengers1")
	public WebElement pick2Passengers;
	
	@FindBy(id = "btn-book-submit")
	public WebElement submitButton;

	public void departureAirportName(String departureName) {
		fromAirportName.click();
		departureSearchInput.clear();
		departureSearchInput.sendKeys(departureName);
		action.moveToElement(pickFromDropDownWAS).build().perform();
		action.click().build().perform();
	}

	public void destinationAirportName(String destName) {
		destinationAirportName.click();
		destinationSearchInput.clear();
		destinationSearchInput.sendKeys(destName);

		action.moveToElement(pickFromDropDownMIA).build().perform();
		BrowserUtils.waitForClickablility(pickFromDropDownMIA, 2);
		action.click().build().perform();
	}

	public void departureDate() {
		departureDateCalendar.click();
		action.moveToElement(departureDateFromCalendar).build().perform();
		BrowserUtils.waitForClickablility(departureDateFromCalendar, 2);
		action.click().build().perform();
	}

	public void returnDate() {
		action.moveToElement(returnDateFromCalendar).build().perform();
		action.click().build().perform();
		action.moveToElement(doneCalendarButton).build().perform();
		action.click().build().perform();
	}
	public void passengersquantity() {
		quantityOfPassengers.click();
		BrowserUtils.waitForClickablility(pick2Passengers, 2);
		action.moveToElement(pick2Passengers).build().perform();
		action.click().build().perform();
	}
	public void clickSubmitButton() {
		submitButton.click();
	}

}
