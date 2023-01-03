package rvs.autobots.utils;

import org.openqa.selenium.By;

import rvs.autobots.base.AutomationBase;
import rvs.autobots.exception.AutomationException;

public class ObjectRepositoryHandler {

	AutomationBase baseObj = new AutomationBase();
	
	/**
	 * To get the By locator
	 * 
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param elementName
	 * @return
	 * @throws AutomationException 
	 */
	public By getElementByLocator(String elementName) throws AutomationException {
		By byElement= null;
		try {
			if (elementName.startsWith("#") || elementName.startsWith("td[") || elementName.startsWith("tr[")
					|| elementName.startsWith("td ") || elementName.startsWith("tr ") || elementName.startsWith("input[")
					|| elementName.startsWith("span[") || elementName.startsWith("div")) {
				byElement = By.cssSelector(elementName);
			} else if (elementName.startsWith("//") || elementName.startsWith(".//")) {
				byElement =  By.xpath(elementName);
			} else if (elementName.startsWith("name")) {
				byElement = By.name(elementName.split(">>")[1]);
			} else if (elementName.startsWith("id")) {
				byElement = By.id(elementName.split(">>")[1]);
			} else if (elementName.startsWith("className")) {
				byElement = By.className(elementName.split(">>")[1]);
			} else if (elementName.startsWith("linkText")) {
				byElement = By.linkText(elementName.split(">>")[1]);
			} else if (elementName.startsWith("partialLinkText")) {
				byElement = By.partialLinkText(elementName.split(">>")[1]);
			} else {
				byElement = By.tagName(elementName);
			}
		} catch (Exception e) {
			throw new AutomationException(baseObj.getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return byElement;
	}
}