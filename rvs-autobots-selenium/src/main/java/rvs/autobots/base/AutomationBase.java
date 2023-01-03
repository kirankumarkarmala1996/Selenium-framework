package rvs.autobots.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import rvs.autobots.exception.AutomationException;
import rvs.autobots.utils.AutomationConstants;

public class AutomationBase {

	public WebDriver driver;

	/**
	 * Method to launch the web browser
	 * 
	 * @since 22-04-2020
	 * @param browserName
	 * @throws AutomationException
	 */
	public void launchBrowser(String browserName) throws AutomationException {
		switch (browserName) {
		case "chrome":
			launchChromeBrowser();
			break;

		case "firefox":
			launchFirefoxBrowser();
			break;

		default:
			System.out.println(AutomationConstants.CHECKBROWSER_MESSAGE);
			break;
		}
	}

	/**
	 * Method to launch CHROME Browser
	 * 
	 * @author sanojs
	 * @throws AutomationException
	 * @since 13-04-2020
	 * @modified 16-03-2021
	 */
	private void launchChromeBrowser() throws AutomationException {
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage(), e);
		}
	}

	/**
	 * Method to launch FIREFOX Browser
	 * 
	 * @author sanojs
	 * @throws AutomationException
	 * @since 13-04-2020
	 * @modified 16-03-2021
	 */
	private void launchFirefoxBrowser() throws AutomationException {
		try {
			FirefoxProfile fp = new FirefoxProfile();
			fp.setPreference("intl.accept_languages", "no,en-us,en");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability(FirefoxDriver.MARIONETTE, true);
			capabilities.setCapability(FirefoxDriver.PROFILE, fp);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			FirefoxOptions firefoxOptions = new FirefoxOptions(capabilities);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(firefoxOptions);

			driver.manage().window().maximize();
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage(), e);
		}
	}

	/**
	 * Method to get the Exception message, to pass the message whenever an
	 * exception is encountered
	 * 
	 * @author Kiran
	 * @since 13-04-2020
	 */
	public String getExceptionMessage() {
		StringBuffer message = new StringBuffer();

		try {
			message.append("Exception in ");
			message.append(Thread.currentThread().getStackTrace()[2].getClassName());
			message.append(".");
			message.append(Thread.currentThread().getStackTrace()[2].getMethodName());
			message.append("()");
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}

		return message.toString();
	}

	/**
	 * Method to set driver for Web applications
	 * 
	 * @author sanojs
	 * @since 03-02-2017
	 * @param driver
	 */
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Method to get current running driver
	 * 
	 * @author sanojs
	 * @return driver
	 */
	public WebDriver getDriver() {
		return this.driver;
	}
}
