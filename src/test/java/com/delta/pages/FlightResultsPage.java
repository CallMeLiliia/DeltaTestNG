package com.delta.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.delta.utils.BrowserUtils;
import com.delta.utils.Driver;

public class FlightResultsPage {

	public FlightResultsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//div[@class='text-right col-sm-2 col-lg-2']//button[@class='btn btn-default btn-filter rounded-0 outlineArea']")
	public WebElement sortAndFilterButton;

	@FindBy(xpath = "//div[@class='select-ui-element-wrapper flight-result-blue-theme ng-star-inserted']//span[@class='select-ui-wrapper']")
	public WebElement sortByDropDown;

	@FindBy(xpath = "//ul[@id='sortby-desc']//li[@class='select-ui-optionList']")
	public List<WebElement> listSortByElements;

	public List<String> getElementName() {
		List<String> textValue = new ArrayList<String>();

		for (WebElement webElement : listSortByElements) {

			textValue.add(webElement.getText());
		}

		return textValue;
	}

	public void clickOnSortAndFilterButton() {

		Actions action = new Actions(Driver.getDriver());
		action.moveToElement(sortAndFilterButton).build().perform();
		action.click().build().perform();
	}

	public void clickOnSortByDropDown() {
		Actions action = new Actions(Driver.getDriver());
		action.moveToElement(sortByDropDown).click().build().perform();
	}

	public WebElement sortByelement(String element) {
		String customXpath = "(//div[@class='bottom-border filtercontent']//li[.='" + element + "'])";
		return Driver.getDriver().findElement(By.xpath(customXpath));
	}

	public void clickOnSortBy(String element) {
		Actions action = new Actions(Driver.getDriver());
		action.moveToElement(sortByelement(element)).click().build().perform();
	}
	public void clickOnSortByValue(String element) {
		WebElement el = sortByelement(element);
		Actions action = new Actions(Driver.getDriver());
		action.moveToElement(el).click().build().perform();
		clickOnSortByDropDown();
	}

}
