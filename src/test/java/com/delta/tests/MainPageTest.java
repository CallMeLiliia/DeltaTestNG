package com.delta.tests;

import org.testng.annotations.Test;
import com.delta.pages.MainPage;

public class MainPageTest extends SetUPTest {
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
}