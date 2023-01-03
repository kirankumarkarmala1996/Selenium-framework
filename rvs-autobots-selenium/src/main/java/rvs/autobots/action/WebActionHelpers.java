package rvs.autobots.action;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import rvs.autobots.base.AutomationBase;
import rvs.autobots.exception.AutomationException;
import rvs.autobots.utils.AutomationConstants;

public class WebActionHelpers extends AutomationBase {

	UtilityActionHelpers utilsObj = new UtilityActionHelpers();

	/**
	 * Method to Switch to a new Browser Instance
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @throws AutomationException
	 */
	public void switchToNewlyOpenedTab(WebDriver driver) throws AutomationException {
		try {
			ArrayList<String> windowHandles = new ArrayList<String>();
			windowHandles.addAll(driver.getWindowHandles());
			int countOfTabs = windowHandles.size();
			String newWindowHandle = windowHandles.get(countOfTabs - 1);
			driver.switchTo().window(newWindowHandle);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to Get the Current URL
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @throws AutomationException
	 */
	public String getCurrentUrl(WebDriver driver) throws AutomationException {
		String currentURL = "";
		try {
			currentURL = driver.getCurrentUrl();
		} catch (final Exception lException) {
			throw new AutomationException(
					getExceptionMessage() + "\n" + AutomationConstants.CAUSE + lException.getMessage());
		}
		return currentURL;
	}

	/**
	 * Method to Get the Title of the web page
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @throws AutomationException
	 */
	public String getTitle(WebDriver driver) throws AutomationException {
		String title = "";
		try {
			title = driver.getTitle();
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return title;
	}

	/**
	 * Method to Accept the alert
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @throws AutomationException
	 */
	public void acceptAlert(WebDriver driver) throws AutomationException {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to Dismiss the alert
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @throws AutomationException
	 */
	public void dismissAlert(WebDriver driver) throws AutomationException {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();

		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to Get the Text from the Alert
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @throws AutomationException
	 */
	public String getAlertText(WebDriver driver) throws AutomationException {
		String alertText = "";
		try {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
		return alertText;
	}

	/**
	 * Method to Get the List of Window Handles
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @throws AutomationException
	 */
	public ArrayList<String> getWindowHandles(WebDriver driver) throws AutomationException {
		try {
			ArrayList<String> windowHandles = new ArrayList<String>();
			windowHandles.addAll(driver.getWindowHandles());
			return windowHandles;
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}
	
	/**
	 * Method to Navigate to the URL
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @param url
	 * @throws AutomationException
	 */
	public void navigateToBrowser(WebDriver driver, String url) throws AutomationException {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			throw new AutomationException(AutomationConstants.EXCEPTION_MESSAGE_FOR_LOAD_URL);
		}
	}

	/**
	 * Method to Navigate Back to the previous web page
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @throws AutomationException
	 */
	public void navigateBack(WebDriver driver) throws AutomationException {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			throw new AutomationException(AutomationConstants.EXCEPTION_MESSAGE_FOR_LOAD_URL);
		}
	}

	/**
	 * Method to Navigate Forward to the previous web page
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @throws AutomationException
	 */
	public void navigateForward(WebDriver driver) throws AutomationException {
		try {
			driver.navigate().forward();
		} catch (Exception e) {
			throw new AutomationException(AutomationConstants.EXCEPTION_MESSAGE_FOR_LOAD_URL);
		}
	}

	/**
	 * Method to Refresh the web page
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @throws AutomationException
	 */
	public void refreshPage(WebDriver driver) throws AutomationException {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to Load the URL
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @param Url
	 * @throws AutomationException
	 */
	public void loadBrowser(WebDriver driver, String Url) throws AutomationException {
		try {
			driver.get(Url);
		} catch (Exception lException) {
			throw new AutomationException(AutomationConstants.EXCEPTION_MESSAGE_FOR_LOAD_URL);
		}
	}

	/**
	 * Method to Close the Browser instance
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @throws AutomationException
	 */
	public void closeBrowser(WebDriver driver) throws AutomationException {
		try {
			driver.close();
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to Quit the Web Browser
	 * 
	 * @author kiran.mg
	 * @since 16-04-2020
	 * @param driver
	 * @throws AutomationException
	 */
	public void quitBrowser(WebDriver driver) throws AutomationException {
		try {
			driver.quit();
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}
}
