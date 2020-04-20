package com.delta.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.delta.pages.FlightResultsPage;
import com.delta.pages.MainPage;

public class FlightResultPageTest extends SetUPTest {

	MainPage mainPage = new MainPage();

	@Test(priority = 0)
	public void departure() {
		mainPage.departureAirportName("Was");

	}

	@Test(priority = 1)
	public void destination() {
		mainPage.destinationAirportName("Miami");

	}

	@Test(priority = 2)
	public void departureDate() {
		mainPage.departureDate();
	}

	@Test(priority = 3)
	public void returnDate() {
		mainPage.returnDate();
	}

	@Test(priority = 4)
	public void passengersQuantity() {
		mainPage.passengersquantity();
	}

	@Test(priority = 5)
	public void submitSutton() {
		mainPage.clickSubmitButton();
	}

	@Test(priority = 6)
	public void bestMatch() {
		FlightResultsPage flightResultPage = new FlightResultsPage();

		flightResultPage.clickOnSortAndFilterButton();
		flightResultPage.clickOnSortByDropDown();

	}

	@Test(dataProvider = "dropDownValues", priority = 7, groups = "data")
	public void clickOnSortBy(String element) {
		FlightResultsPage flightResultPage = new FlightResultsPage();
		flightResultPage.clickOnSortByValue(element);


	}
//
//	@BeforeMethod(groups = "data")
//	public void clickOnDropDown() {
//		FlightResultsPage flightResultPage = new FlightResultsPage();
//
//		flightResultPage.clickOnSortByDropDown();
//
//			}
	@DataProvider
	public static Iterator<Object[]> dropDownValues() {
		FlightResultsPage flightResultPage = new FlightResultsPage();
		List<Object[]> data = new ArrayList<>();
		List<String> text = flightResultPage.getElementName();

		for (String t : text) {

			data.add(new String[] { t });
		}

//		data.add(new String[] { "Price" });
//		data.add(new String[] { "Number of Stops" });

		return data.iterator();
	}

}
