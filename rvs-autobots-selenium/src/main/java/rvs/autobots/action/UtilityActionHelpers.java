package rvs.autobots.action;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import rvs.autobots.base.AutomationBase;
import rvs.autobots.data.PropertyDataHandler;
import rvs.autobots.exception.AutomationException;
import rvs.autobots.utils.AutomationConstants;
import rvs.autobots.utils.ObjectRepositoryHandler;

public class UtilityActionHelpers extends AutomationBase {

	GeneralUtilityHelper generalUtils = new GeneralUtilityHelper();
	public WebDriverWait wait;

	/**
	 * Method to wait for the element using the object mentioned in the Object
	 * Repository
	 * 
	 * @author kiran.mg
	 * @modified sanoj
	 * @since 15-04-2020
	 * @param driver
	 * @param elementName
	 * @return element
	 * @throws AutomationException
	 */
	public WebElement waitForElement(WebDriver driver, String elementKey) throws AutomationException {
		WebElement element = null;
		ObjectRepositoryHandler objRepository = new ObjectRepositoryHandler();
		PropertyDataHandler objProertyData = new PropertyDataHandler();
		try {
			long timeout = Long
					.parseLong(objProertyData.getProperty(AutomationConstants.FRAMEWORK_CONFIG, "SHORT_LOADING"));
			wait = new WebDriverWait(driver, timeout);
			By actualElement = objRepository.getElementByLocator(elementKey);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(actualElement));
			((JavascriptExecutor) driver)
					.executeScript("window.scrollTo(" + element.getLocation().x + "," + element.getLocation().y + ")");
		} catch (Exception e) {
			throw new AutomationException(AutomationConstants.ELEMENT_NOT_FOUND);
		}
		return element;
	}

	/**
	 * Method to wait for the elements using the object mentioned in the Object
	 * Repository
	 * 
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param driver
	 * @param elementName
	 * @return elements
	 * @throws AutomationException
	 */
	public List<WebElement> waitForElements(WebDriver driver, String elementKey) throws AutomationException {
		List<WebElement> elements;
		ObjectRepositoryHandler objRepository = new ObjectRepositoryHandler();
		PropertyDataHandler objProertyData = new PropertyDataHandler();
		try {
			if (elementKey != null) {
				long timeout = Long
						.parseLong(objProertyData.getProperty(AutomationConstants.FRAMEWORK_CONFIG, "SHORT_LOADING"));
				wait = new WebDriverWait(driver, timeout);
				By actualElement = objRepository.getElementByLocator(elementKey);
				wait.until(ExpectedConditions.presenceOfElementLocated(actualElement));
				elements = driver.findElements(actualElement);
			} else
				throw new AutomationException(elementKey + AutomationConstants.ELEMENT_NOT_FOUND);
		} catch (Exception e) {
			throw new AutomationException(AutomationConstants.ELEMENT_NOT_FOUND);
		}
		return elements;
	}

	/**
	 * Method to wait for the element using the By elementlocator
	 * 
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param driver
	 * @param elementLocator
	 * @return element
	 * @throws AutomationException
	 */
	public WebElement waitForElement(WebDriver driver, By elementLocator) throws AutomationException {
		WebElement element = null;
		PropertyDataHandler objProertyData = new PropertyDataHandler();
		try {
			long timeout = Long
					.parseLong(objProertyData.getProperty(AutomationConstants.FRAMEWORK_CONFIG, "SHORT_LOADING"));
			wait = new WebDriverWait(driver, timeout);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
		} catch (Exception e) {
			throw new AutomationException(AutomationConstants.ELEMENT_NOT_FOUND);
		}
		return element;
	}

	/**
	 * Method to Wait for the element to get Visible
	 * 
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param driver
	 * @param elementLocator
	 * @return isElementVisible
	 * @throws AutomationException
	 */
	public boolean waitForElementVisible(WebDriver driver, String elementKey) throws AutomationException {
		boolean isElementVisible = false;
		PropertyDataHandler objPropertyData = new PropertyDataHandler();
		ObjectRepositoryHandler objRepository = new ObjectRepositoryHandler();
		try {
			long timeout = Long
					.parseLong(objPropertyData.getProperty(AutomationConstants.FRAMEWORK_CONFIG, "SHORT_LOADING"));
			wait = new WebDriverWait(driver, timeout);
			By actualElement = objRepository.getElementByLocator(elementKey);
			wait.until(ExpectedConditions.visibilityOfElementLocated(actualElement));
			isElementVisible = true;
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return isElementVisible;
	}

	/**
	 * Method to Wait for the element to get Invisible
	 * 
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param driver
	 * @param elementKey
	 * @return isElementInVisible
	 * @throws AutomationException
	 */
	public boolean waitForElementInVisible(WebDriver driver, String elementKey) throws AutomationException {
		boolean isElementInVisible = false;
		PropertyDataHandler objPropertyData = new PropertyDataHandler();
		ObjectRepositoryHandler objRepository = new ObjectRepositoryHandler();
		try {
			long timeout = Long
					.parseLong(objPropertyData.getProperty(AutomationConstants.FRAMEWORK_CONFIG, "SHORT_LOADING"));
			wait = new WebDriverWait(driver, timeout);
			By actualElement = objRepository.getElementByLocator(elementKey);
			isElementInVisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(actualElement));
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return isElementInVisible;
	}

	/**
	 * Method to Wait for the element Text to be present
	 * 
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param driver
	 * @param elementKey
	 * @return element
	 * @throws AutomationException
	 */
	public boolean waitForTextPresent(WebDriver driver, String elementKey, String expectedText)
			throws AutomationException {
		boolean isTextPresent = false;
		PropertyDataHandler objPropertyData = new PropertyDataHandler();
		ObjectRepositoryHandler objRepository = new ObjectRepositoryHandler();
		try {
			long timeout = Long
					.parseLong(objPropertyData.getProperty(AutomationConstants.FRAMEWORK_CONFIG, "SHORT_LOADING"));
			wait = new WebDriverWait(driver, timeout);
			By actualElement = objRepository.getElementByLocator(elementKey);
			isTextPresent = wait.until(ExpectedConditions.textToBePresentInElementLocated(actualElement, expectedText));
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return isTextPresent;
	}

	/**
	 * Method to Drag and Drop an element from source to destination
	 * 
	 * @author kiran.mg
	 * @since 15-04-2020
	 * @param driver
	 * @param elementKey
	 * @return element
	 * @throws AutomationException
	 */
	public void dragAndDrop(WebDriver driver, String sourceElementExpression, String destinationElementExpression)
			throws AutomationException {
		try {
			WebElement sourceElement = waitForElement(driver, sourceElementExpression);
			WebElement destinationElement = waitForElement(driver, destinationElementExpression);
			Actions action = new Actions(driver);
			action.dragAndDrop(sourceElement, destinationElement);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to Take a Screenshot
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @throws AutomationException
	 */
	public String takeScreenshot(WebDriver driver) throws AutomationException {
		try {
			TakesScreenshot screenShot = ((TakesScreenshot) driver);
			File sourceFile = screenShot.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir") + "/screenshots/" + "_" + generalUtils.getCurrentDate()
					+ "_" + "screenshot.jpg";
			File destinationFile = new File(destination);
			FileUtils.copyFile(sourceFile, destinationFile);
			return destination;
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to Scroll to the Element
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @param elementExpression
	 * @throws AutomationException
	 */
	public void scrollToElement(WebDriver driver, String elementExpression) throws AutomationException {
		try {
			WebElement element = waitForElement(driver, elementExpression);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to Scroll to the Bottom of the web page
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @throws AutomationException
	 */
	public void scrollToBottom(WebDriver driver) throws AutomationException {
		try {
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to Scroll to the Top of the web page
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @throws AutomationException
	 */
	public void scrollToTop(WebDriver driver) throws AutomationException {
		try {
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to Move to the Web element
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @param elementExpression
	 * @throws AutomationException
	 */
	public void moveToElement(WebDriver driver, String elementExpression) throws AutomationException {
		try {
			Actions actions = new Actions(driver);
			WebElement element = waitForElement(driver, elementExpression);
			actions.moveToElement(element).perform();
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to Move to the Web element based on the provided X and Y co-ordinates
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @param elementExpression
	 * @param xOffset
	 * @param yOffset
	 * @throws AutomationException
	 */
	public void moveToElementByXandY(WebDriver driver, String elementExpression, int xOffset, int yOffset)
			throws AutomationException {
		try {
			Actions actions = new Actions(driver);
			WebElement element = waitForElement(driver, elementExpression);
			actions.moveToElement(element, xOffset, yOffset).perform();
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to Get the X co-ordinate of the Web element
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @param elementExpression
	 * @throws AutomationException
	 */
	public int getXcoordinate(WebDriver driver, String elementExpression) throws AutomationException {
		try {
			WebElement element = waitForElement(driver, elementExpression);
			Point point = element.getLocation();
			return point.getX();
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to Get the Y co-ordinate of the Web element
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @param elementExpression
	 * @throws AutomationException
	 */
	public int getYcoordinate(WebDriver driver, String elementExpression) throws AutomationException {
		try {
			WebElement element = waitForElement(driver, elementExpression);
			Point point = element.getLocation();
			return point.getY();
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to Get the Count of the Elements from the Web Element List
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @param elementExpression
	 * @throws AutomationException
	 */
	public int countOfElementsFromList(WebDriver driver, String elementExpression) throws AutomationException {
		try {
			List<WebElement> elements = waitForElements(driver, elementExpression);
			return elements.size();
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to Clear the input field (which is referred by the user from the
	 * Object Repository)
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @param elementExpression
	 * @throws AutomationException
	 */
	public void clearInputField(WebDriver driver, String elementExpression) throws AutomationException {
		try {
			WebElement element = waitForElement(driver, elementExpression);
			element.clear();
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to Copy and Paste the value from one input field to another input
	 * field
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @param sourceElementName
	 * @param destinationElementName
	 * @throws AutomationException
	 */
	public void copyAndPasteFromOneInputFieldToAnother(WebDriver driver, String sourceElementName,
			String destinationElementName) throws AutomationException {
		try {
			WebElement sourceElement = waitForElement(driver, sourceElementName);
			sourceElement.sendKeys(Keys.CONTROL + "a");
			sourceElement.sendKeys(Keys.CONTROL + "c");

			WebElement destinationElement = waitForElement(driver, destinationElementName);
			destinationElement.clear();
			destinationElement.sendKeys(Keys.CONTROL + "v");
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to Delete the value from input field (which is referred by the user
	 * from the Object Repository)
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @param elementExpression
	 * @throws AutomationException
	 */
	public void deleteInputFieldText(WebDriver driver, String elementExpression) throws AutomationException {
		try {
			WebElement sourceElement = waitForElement(driver, elementExpression);
			sourceElement.sendKeys(Keys.CONTROL + "a");
			sourceElement.sendKeys(Keys.DELETE);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to Get the Text of the Web Element
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @param elementExpression
	 * @throws AutomationException
	 */
	public String getElementText(WebDriver driver, String elementExpression) throws AutomationException {
		String elementText = "";
		try {
			WebElement element = waitForElement(driver, elementExpression);
			elementText = element.getText();
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return elementText;
	}

	/**
	 * Method to Get the Attribute value of the web element
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @param elementExpression
	 * @param attributeName
	 * @throws AutomationException
	 */
	public String getElementAttributeValue(WebDriver driver, String elementExpression, String attributeName)
			throws AutomationException {
		String elementAttribute = "";
		try {
			WebElement element = waitForElement(driver, elementExpression);
			elementAttribute = element.getAttribute(attributeName);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return elementAttribute;
	}

	/**
	 * Method to Select the value from the drop down using the visible Text
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @param elementExpression
	 * @param visibleText
	 * @throws AutomationException
	 */
	public void selectDropDownValueByVisibleText(WebDriver driver, String elementExpression, String visibleText)
			throws AutomationException {
		try {
			Select select = new Select(waitForElement(driver, elementExpression));
			select.selectByVisibleText(visibleText);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to Select the value from the drop down using the index
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @param elementExpression
	 * @param index
	 * @throws AutomationException
	 */
	public void selectDropDownValueByIndex(WebDriver driver, String elementExpression, int index)
			throws AutomationException {
		try {
			Select select = new Select(waitForElement(driver, elementExpression));
			select.selectByIndex(index);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to Select the value from the drop down using value
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @param elementExpression
	 * @param valueToSelect
	 * @throws AutomationException
	 */
	public void selectDropDownValueByValue(WebDriver driver, String elementExpression, String valueToSelect)
			throws AutomationException {
		try {
			Select select = new Select(waitForElement(driver, elementExpression));
			select.selectByValue(valueToSelect);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to Release the depressed left mouse button at the current mouse
	 * location
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @throws AutomationException
	 */
	public void releaseMouse(WebDriver driver) throws AutomationException {
		try {
			Actions actions = new Actions(driver);
			actions.release();
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}
}
