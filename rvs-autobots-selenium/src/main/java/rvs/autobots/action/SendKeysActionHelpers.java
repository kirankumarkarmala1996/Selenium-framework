package rvs.autobots.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import rvs.autobots.base.AutomationBase;
import rvs.autobots.exception.AutomationException;
import rvs.autobots.utils.AutomationConstants;

public class SendKeysActionHelpers extends AutomationBase {

	UtilityActionHelpers utilityActionHelper = new UtilityActionHelpers();

	/**
	 * Method to set text in the input field (which is referred by the user from the
	 * Object Repository)
	 * 
	 * @author Kiran
	 * @since 15-04-2020
	 * @param driver
	 * @param elementExpression
	 * @param inputText
	 * @throws AutomationException
	 */
	public void sendKeys(WebDriver driver, String elementName, String inputText) throws AutomationException {
		try {
			if (driver != null && elementName != null) {
				WebElement element = utilityActionHelper.waitForElement(driver, elementName);
				element.sendKeys(inputText);
				System.out.println("==========================================================");
				System.out.println("Data " + inputText + " successfully entered into " + elementName);
			} else {
				throw new AutomationException(elementName + AutomationConstants.ELEMENT_NOT_FOUND);
			}
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to clear the input field and then set text to the same input field
	 * (which is referred by the user from the Object Repository)
	 * 
	 * @author Kiran
	 * @since 15-0-2020
	 * @param driver
	 * @param expressionPath
	 * @param inputText
	 * @throws AutomationException
	 */
	public void clearTextAndSendKeys(WebDriver driver, String expressionPath, String inputText) throws AutomationException {
		try {
			if (expressionPath != null) {
				WebElement element = utilityActionHelper.waitForElement(driver, expressionPath);
				element.clear();
				element.sendKeys(inputText);
			} else {
				throw new AutomationException(expressionPath + AutomationConstants.ELEMENT_NOT_FOUND);
			}
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to set text in the input field based on xpath locator
	 * 
	 * @author Kiran
	 * @since 15-04-2020
	 * @param driver
	 * @param elementXpath
	 * @param inputText
	 * @throws AutomationException
	 */
	public void sendKeysByXpath(WebDriver driver, String elementXpath, String inputText) throws AutomationException {
		try {
			if (elementXpath != null) {
				By elementLocator = By.xpath(elementXpath);
				WebElement element = utilityActionHelper.waitForElement(driver, elementLocator);
				element.sendKeys(inputText);
			} else {
				throw new AutomationException(elementXpath + AutomationConstants.ELEMENT_NOT_FOUND);
			}
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to set text in the input field based on "name" locator
	 * 
	 * @author Kiran
	 * @since 15-04-2020
	 * @param driver
	 * @param nameLocator
	 * @param inputText
	 * @throws AutomationException
	 */
	public void sendKeysByName(WebDriver driver, String nameLocator, String inputText) throws AutomationException {
		try {
			if (nameLocator != null) {
				By elementLocator = By.name(nameLocator);
				WebElement element = utilityActionHelper.waitForElement(driver, elementLocator);
				element.sendKeys(inputText);
			} else {
				throw new AutomationException(nameLocator + AutomationConstants.ELEMENT_NOT_FOUND);
			}
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to set text in the input field based on "id" locator
	 * 
	 * @author Kiran
	 * @since 15-04-2020
	 * @param driver
	 * @param idLocator
	 * @param inputText
	 * @throws AutomationException
	 */
	public void sendKeysById(WebDriver driver, String idLocator, String inputText) throws AutomationException {
		try {
			if (idLocator != null) {
				By elementLocator = By.id(idLocator);
				WebElement element = utilityActionHelper.waitForElement(driver, elementLocator);
				element.sendKeys(inputText);
			} else {
				throw new AutomationException(idLocator + AutomationConstants.ELEMENT_NOT_FOUND);
			}
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to set text in the input field based on "CSSselector" locator
	 * 
	 * @author Kiran
	 * @since 15-04-2020
	 * @param driver
	 * @param cssSelectorLocator
	 * @param inputText
	 * @throws AutomationException
	 */
	public void sendKeysBycssSelectorLocator(WebDriver driver, String cssSelectorLocator, String inputText) throws AutomationException {
		try {
			if (cssSelectorLocator != null) {
				By elementLocator = By.cssSelector(cssSelectorLocator);
				WebElement element = utilityActionHelper.waitForElement(driver, elementLocator);
				element.sendKeys(inputText);
			} else {
				throw new AutomationException(cssSelectorLocator + AutomationConstants.ELEMENT_NOT_FOUND);
			}
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to set text in the input field based on "linkText" locator
	 * 
	 * @author Kiran
	 * @since 15-04-2020
	 * @param driver
	 * @param linkTextLocator
	 * @param inputText
	 * @throws AutomationException
	 */
	public void sendKeysBylinkText(WebDriver driver, String linkTextLocator, String inputText) throws AutomationException {
		try {
			if (linkTextLocator != null) {
				By elementLocator = By.linkText(linkTextLocator);
				WebElement element = utilityActionHelper.waitForElement(driver, elementLocator);
				element.sendKeys(inputText);
			} else {
				throw new AutomationException(linkTextLocator + AutomationConstants.ELEMENT_NOT_FOUND);
			}
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to set text in the input field based on "partialLinkText" locator
	 * 
	 * @author Kiran
	 * @since 15-04-2020
	 * @param driver
	 * @param partialLinkTextString
	 * @param inputText
	 * @throws AutomationException
	 */
	public void sendKeysBypartialLinkText(WebDriver driver, String partialLinkTextString, String inputText) throws AutomationException {
		try {
			if (partialLinkTextString != null) {
				By elementLocator = By.partialLinkText(partialLinkTextString);
				WebElement element = utilityActionHelper.waitForElement(driver, elementLocator);
				element.sendKeys(inputText);
			} else {
				throw new AutomationException(partialLinkTextString + AutomationConstants.ELEMENT_NOT_FOUND);
			}
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to set text in the input field based on "tagName" locator
	 * 
	 * @author Kiran
	 * @since 15-04-2020
	 * @param driver
	 * @param tagNameString
	 * @param inputText
	 * @throws AutomationException
	 */
	public void sendKeysBytagName(WebDriver driver, String tagNameString, String inputText) throws AutomationException {
		try {
			if (tagNameString != null) {
				By elementLocator = By.tagName(tagNameString);
				WebElement element = utilityActionHelper.waitForElement(driver, elementLocator);
				element.sendKeys(inputText);
			} else {
				throw new AutomationException(tagNameString + AutomationConstants.ELEMENT_NOT_FOUND);
			}
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to set text in the input field based on "className" locator
	 * 
	 * @author Kiran
	 * @since 15-04-2020
	 * @param driver
	 * @param classNameString
	 * @param inputText
	 * @throws AutomationException
	 */
	public void sendKeysByclassName(WebDriver driver, String classNameString, String inputText) throws AutomationException {
		try {
			if (classNameString != null) {
				By elementLocator = By.className(classNameString);
				WebElement element = utilityActionHelper.waitForElement(driver, elementLocator);
				element.sendKeys(inputText);
			} else {
				throw new AutomationException(classNameString + AutomationConstants.ELEMENT_NOT_FOUND);
			}
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}
}