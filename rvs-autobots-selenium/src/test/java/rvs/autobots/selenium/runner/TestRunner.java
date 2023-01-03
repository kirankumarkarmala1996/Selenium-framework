package rvs.autobots.selenium.runner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import rvs.autobots.action.WebActionHelpers;
import rvs.autobots.base.AutomationBase;
import rvs.autobots.exception.AutomationException;
import rvs.autobots.reporting.AutomationReport;

@Listeners(AutomationReport.class)
public class TestRunner extends AutomationBase {
	@BeforeClass
	@Parameters("browserName")
	public void setup(String browserName) throws Exception {
		launchBrowser(browserName);
	}

	@AfterSuite
	public void tearDownMethod() throws AutomationException, InterruptedException {
		WebActionHelpers webObj = new WebActionHelpers();
		webObj.closeBrowser(driver);
	}
}
