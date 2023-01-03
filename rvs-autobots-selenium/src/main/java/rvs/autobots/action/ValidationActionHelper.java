package rvs.autobots.action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import rvs.autobots.base.AutomationBase;
import rvs.autobots.exception.AutomationException;
import rvs.autobots.utils.AutomationConstants;

public class ValidationActionHelper extends AutomationBase {

	UtilityActionHelpers utilityActionHelper = new UtilityActionHelpers();

	/**
	 * Method to verify the element is present
	 * 
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param driver
	 * @param elementExpression
	 * @throws AutomationException
	 */
	public boolean isElementPresent(WebDriver driver, String elementExpression) throws AutomationException {
		boolean elementPresent = false;
		try {
			if (elementExpression != null) {
				if (utilityActionHelper.waitForElements(driver, elementExpression).size() != 0) {
					elementPresent = true;
				} else {
					elementPresent = false;
				}
			} else {
				throw new AutomationException(elementExpression + AutomationConstants.ELEMENT_NOT_FOUND);
			}
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return elementPresent;
	}

	/**
	 * Method to verify the element is visible
	 * 
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param driver
	 * @param elementExpression
	 * @throws AutomationException
	 */
	public boolean isElementVisible(WebDriver driver, String elementExpression) throws AutomationException {
		boolean elementVisible = false;
		try {
			if (elementExpression != null) {
				WebElement element = utilityActionHelper.waitForElement(driver, elementExpression);
				if (element.isDisplayed()) {
					elementVisible = true;
				} else {
					elementVisible = false;
				}
			} else {
				throw new AutomationException(elementExpression + AutomationConstants.ELEMENT_NOT_FOUND);
			}
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return elementVisible;
	}

	/**
	 * Method to verify the element is selected
	 * 
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param driver
	 * @param elementExpression
	 * @throws AutomationException
	 */
	public boolean isElementSelected(WebDriver driver, String elementExpression) throws AutomationException {
		boolean elementSelected = false;
		try {
			if (elementExpression != null) {
				if (utilityActionHelper.waitForElement(driver, elementExpression).isSelected()) {
					elementSelected = true;
				} else {
					elementSelected = false;
				}
			} else {
				throw new AutomationException(elementExpression + AutomationConstants.ELEMENT_NOT_FOUND);
			}
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return elementSelected;
	}

	/**
	 * Method to verify the element is enabled
	 * 
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param driver
	 * @param elementExpression
	 * @throws AutomationException
	 */
	public boolean isElementEnabled(WebDriver driver, String elementExpression) throws AutomationException {
		boolean elementEnabled = false;
		try {
			if (elementExpression != null) {
				if (utilityActionHelper.waitForElement(driver, elementExpression).isEnabled()) {
					elementEnabled = true;
				} else {
					elementEnabled = false;
				}
			} else {
				throw new AutomationException(elementExpression + AutomationConstants.ELEMENT_NOT_FOUND);
			}
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return elementEnabled;
	}

	/**
	 * Method to verify the element is displayed
	 * 
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param driver
	 * @param elementExpression
	 * @throws AutomationException
	 */
	public boolean isElementDisplayed(WebDriver driver, String elementExpression) throws AutomationException {
		boolean elementDisplayed = false;
		try {
			if (elementExpression != null) {
				if (utilityActionHelper.waitForElement(driver, elementExpression).isDisplayed()) {
					elementDisplayed = true;
				} else {
					elementDisplayed = false;
				}
			} else {
				throw new AutomationException(elementExpression + AutomationConstants.ELEMENT_NOT_FOUND);
			}
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return elementDisplayed;
	}

	/**
	 * Method to verify that the URL contains the element Text
	 * 
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param driver
	 * @param elementExpression
	 * @throws AutomationException
	 */
	public boolean verifyURLContains(WebDriver driver, String expectedText) throws AutomationException {
		boolean urlConatinsText = false;
		try {
			String actualURL = driver.getCurrentUrl();
			if (actualURL.contains(expectedText)) {
				urlConatinsText = true;
			} else {
				urlConatinsText = false;
				throw new AutomationException(expectedText + AutomationConstants.VERIFICATION_FAILED);
			}
			Assert.assertTrue(urlConatinsText);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return urlConatinsText;
	}

	/**
	 * Method to verify that the Element is present
	 * 
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param driver
	 * @param elementExpression
	 * @throws AutomationException
	 */
	public boolean verifyElementPresent(WebDriver driver, String elementExpression) throws AutomationException {
		boolean elementPresent = false;
		try {
			int count = utilityActionHelper.waitForElements(driver, elementExpression).size();
			if (count != 0) {
				elementPresent = true;
			} else {
				elementPresent = false;
				throw new AutomationException(elementExpression + AutomationConstants.VERIFICATION_FAILED);
			}
			Assert.assertTrue(elementPresent);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return elementPresent;
	}

	/**
	 * Method to verify that the Element is not present
	 * 
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param driver
	 * @param elementExpression
	 * @throws AutomationException
	 */
	public boolean verifyElementNotPresent(WebDriver driver, String elementExpression) throws AutomationException {
		boolean elementNotPresent = false;
		try {
			int count = utilityActionHelper.waitForElements(driver, elementExpression).size();
			if (count != 0) {
				elementNotPresent = true;
			} else {
				elementNotPresent = false;
				throw new AutomationException(elementExpression + AutomationConstants.VERIFICATION_FAILED);
			}
			Assert.assertTrue(elementNotPresent);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return elementNotPresent;
	}

	/**
	 * Method to verify that the Element is visible
	 * 
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param driver
	 * @param elementExpression
	 * @throws AutomationException
	 */
	public boolean verifyElementVisible(WebDriver driver, String elementExpression) throws AutomationException {
		boolean elementVisible = false;
		try {
			if (utilityActionHelper.waitForElement(driver, elementExpression).isDisplayed()) {
				elementVisible = true;
			} else {
				elementVisible = false;
				throw new AutomationException(elementExpression + AutomationConstants.VERIFICATION_FAILED);
			}
			Assert.assertTrue(elementVisible);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return elementVisible;
	}

	/**
	 * Method to verify that the Element is not visible
	 * 
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param driver
	 * @param elementExpression
	 * @throws AutomationException
	 */
	public boolean verifyElementNotVisible(WebDriver driver, String elementExpression) throws AutomationException {
		boolean elementNotVisible = false;
		try {
			if (utilityActionHelper.waitForElement(driver, elementExpression).isDisplayed()) {
				elementNotVisible = false;
				throw new AutomationException(AutomationConstants.VERIFICATION_FAILED);
			} else {
				elementNotVisible = true;
			}
			Assert.assertTrue(elementNotVisible);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return elementNotVisible;
	}

	/**
	 * Method to verify that the Element is selected
	 * 
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param driver
	 * @param elementExpression
	 * @throws AutomationException
	 */
	public boolean verifyElementSelected(WebDriver driver, String elementExpression) throws AutomationException {
		boolean elementSelected = false;
		try {
			if (utilityActionHelper.waitForElement(driver, elementExpression).isSelected()) {
				elementSelected = true;
			} else {
				elementSelected = false;
				throw new AutomationException(AutomationConstants.VERIFICATION_FAILED);
			}
			Assert.assertTrue(elementSelected);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return elementSelected;
	}

	/**
	 * Method to verify that the Element is enabled
	 * 
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param driver
	 * @param elementExpression
	 * @throws AutomationException
	 */
	public boolean verifyElementEnabled(WebDriver driver, String elementExpression) throws AutomationException {
		boolean elementEnabled = false;
		try {
			if (utilityActionHelper.waitForElement(driver, elementExpression).isEnabled()) {
				elementEnabled = true;
			} else {
				elementEnabled = false;
				throw new AutomationException(AutomationConstants.VERIFICATION_FAILED);
			}
			Assert.assertTrue(elementEnabled);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return elementEnabled;
	}

	/**
	 * Method to verify that the Element is not enabled
	 * 
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param driver
	 * @param elementExpression
	 * @throws AutomationException
	 */
	public boolean verifyElementNotEnabled(WebDriver driver, String elementExpression) throws AutomationException {
		boolean elementNotEnabled = false;
		try {
			if (utilityActionHelper.waitForElement(driver, elementExpression).isEnabled()) {
				elementNotEnabled = false;
				throw new AutomationException(AutomationConstants.VERIFICATION_FAILED);
			} else {
				elementNotEnabled = true;
			}
			Assert.assertTrue(elementNotEnabled);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return elementNotEnabled;
	}

	/**
	 * Method to verify that the Element is displayed
	 * 
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param driver
	 * @param elementExpression
	 * @throws AutomationException
	 */
	public boolean verifyElementDisplayed(WebDriver driver, String elementExpression) throws AutomationException {
		boolean elementDisplayed = false;
		try {
			if (utilityActionHelper.waitForElement(driver, elementExpression).isDisplayed()) {
				elementDisplayed = true;
			} else {
				elementDisplayed = false;
				throw new AutomationException(AutomationConstants.VERIFICATION_FAILED);
			}
			Assert.assertTrue(elementDisplayed);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return elementDisplayed;
	}

	/**
	 *  Method to verify that the Element is not displayed
	 *  
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param driver
	 * @param elementExpression
	 * @throws AutomationException
	 */
	public boolean verifyElementNotDisplayed(WebDriver driver, String elementExpression) throws AutomationException {
		boolean elementNotDisplayed = false;
		try {
			if (utilityActionHelper.waitForElement(driver, elementExpression).isDisplayed()) {
				elementNotDisplayed = false;
				throw new AutomationException(AutomationConstants.VERIFICATION_FAILED);
			} else {
				elementNotDisplayed = true;
			}
			Assert.assertTrue(elementNotDisplayed);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return elementNotDisplayed;
	}

	/**
	 * Method to verify that the Element Text has the expected text
	 * 
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param driver
	 * @param elementExpression
	 * @param expectedText
	 * @throws AutomationException
	 */
	public boolean verifyElementText(WebDriver driver, String elementExpression, String expectedText) throws AutomationException {
		boolean textVerified = false;
		try {
			WebElement element = utilityActionHelper.waitForElement(driver, elementExpression);
			String actualText = element.getText();
			if (actualText.contentEquals(expectedText)) {
				textVerified = true;
			} else {
				textVerified = false;
				throw new AutomationException(AutomationConstants.VERIFICATION_FAILED);
			}
			Assert.assertTrue(textVerified);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return textVerified;
	}

	/**
	 * Method to verify that the Element Attribute has the expected text
	 * 
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param driver
	 * @param elementExpression
	 * @param attributeName
	 * @param expectedText
	 * @throws AutomationException
	 */
	public boolean verifyElementAttributeHasText(WebDriver driver, String elementExpression, String attributeName, String expectedText)
			throws AutomationException {
		boolean textVerified = false;
		try {
			WebElement element = utilityActionHelper.waitForElement(driver, elementExpression);
			String actualAttributeValue = element.getAttribute(attributeName);
			if (actualAttributeValue.contentEquals(expectedText)) {
				textVerified = true;
			} else {
				textVerified = false;
				throw new AutomationException(AutomationConstants.VERIFICATION_FAILED);
			}
			Assert.assertTrue(textVerified);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return textVerified;
	}

	/**
	 * Method to verify that the Element CSS value has the expected text
	 * 
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param driver
	 * @param elementExpression
	 * @param attributeName
	 * @param expectedText
	 * @throws AutomationException
	 */
	public boolean verifyElementHasCssValue(WebDriver driver, String elementExpression, String attributeName, String expectedText)
			throws AutomationException {
		boolean textVerified = false;
		try {
			WebElement element = utilityActionHelper.waitForElement(driver, elementExpression);
			String actualAttributeValue = element.getCssValue(attributeName);
			if (actualAttributeValue.contentEquals(expectedText)) {
				textVerified = true;
			} else {
				textVerified = false;
				throw new AutomationException(AutomationConstants.VERIFICATION_FAILED);
			}
			Assert.assertTrue(textVerified);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return textVerified;
	}

	/**
	 * Method to verify that the Element text contains the expected text
	 * 
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param driver
	 * @param elementExpression
	 * @param expectedText
	 * @throws AutomationException
	 */
	public boolean verifyElementContainsText(WebDriver driver, String elementExpression, String expectedText) throws AutomationException {
		boolean textContains = false;
		try {
			WebElement element = utilityActionHelper.waitForElement(driver, elementExpression);
			String actualText = element.getText();
			if (actualText.contains(expectedText)) {
				textContains = true;
			} else {
				textContains = false;
				throw new AutomationException(AutomationConstants.VERIFICATION_FAILED);
			}
			Assert.assertTrue(textContains);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return textContains;
	}

	/**
	 * Method to verify that the expected text is not in the Element text
	 * 
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param driver
	 * @param elementExpression
	 * @param expectedText
	 * @throws AutomationException
	 */
	public boolean verifyElementHasNotText(WebDriver driver, String elementExpression, String expectedText) throws AutomationException {
		boolean elementHasNotText = false;
		try {
			WebElement element = utilityActionHelper.waitForElement(driver, elementExpression);
			String actualText = element.getText();
			if (actualText.contentEquals(expectedText)) {
				elementHasNotText = false;
				throw new AutomationException(AutomationConstants.VERIFICATION_FAILED);
			} else {
				elementHasNotText = true;
			}
			Assert.assertTrue(elementHasNotText);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return elementHasNotText;
	}

	/**
	 * Method to verify the actual and expected text are equal
	 * 
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param actualText
	 * @param expectedText
	 * @throws AutomationException
	 */
	public boolean verifyEqual(String actualText, String expectedText) throws AutomationException {
		boolean textVerified = false;
		try {
			if (actualText.contentEquals(expectedText)) {
				textVerified = true;
			} else {
				textVerified = false;
				throw new AutomationException(AutomationConstants.VERIFICATION_FAILED);
			}
			Assert.assertTrue(textVerified);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return textVerified;
	}

	/**
	 * Method to verify the actual and expected text are not equal
	 * 
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param actualText
	 * @param expectedText
	 * @throws AutomationException
	 */
	public boolean verifyNotEqual(String actualText, String expectedText) throws AutomationException {
		boolean textNotEqual = false;
		try {
			if (actualText.contentEquals(expectedText)) {
				textNotEqual = false;
				throw new AutomationException(AutomationConstants.VERIFICATION_FAILED);
			} else {
				textNotEqual = true;
			}
			Assert.assertTrue(textNotEqual);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return textNotEqual;
	}

	/**
	 * Method to verify that the actual number is greater than the expected text
	 * 
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param actualNumber
	 * @param expectedNumber
	 * @throws AutomationException
	 */
	public boolean verifyGreaterThan(int actualNumber, int expectedNumber) throws AutomationException {
		boolean numberGreaterThan = false;
		try {
			if (actualNumber > expectedNumber) {
				numberGreaterThan = true;
			} else {
				numberGreaterThan = false;
				throw new AutomationException(AutomationConstants.VERIFICATION_FAILED);
			}
			Assert.assertTrue(numberGreaterThan);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return numberGreaterThan;
	}

	/**
	 * Method to verify that the actual number is less than the expected text
	 * 
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param actualNumber
	 * @param expectedNumber
	 * @throws AutomationException
	 */
	public boolean verifyLessThan(int actualNumber, int expectedNumber) throws AutomationException {
		boolean numberLessThan = false;
		try {
			if (actualNumber < expectedNumber) {
				numberLessThan = true;
			} else {
				numberLessThan = false;
				throw new AutomationException(AutomationConstants.VERIFICATION_FAILED);
			}
			Assert.assertTrue(numberLessThan);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return numberLessThan;
	}
}
