package rvs.autobots.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import rvs.autobots.base.AutomationBase;
import rvs.autobots.exception.AutomationException;
import rvs.autobots.utils.AutomationConstants;

public class PropertyDataHandler extends AutomationBase {

	/**
	 * @author kiran.mg
	 * @param fileName
	 * @param propertName
	 * @return propValue
	 * @throws AutomationException
	 */
	public String getProperty(String fileName, String propertyName) throws AutomationException {
		try {
			String propValue = "";
			Properties props = new Properties();
			ClassLoader classLoader = PropertyDataHandler.class.getClassLoader();
			InputStream input = classLoader.getResourceAsStream(fileName + ".properties");
			props.load(input);
			propValue = props.getProperty(propertyName);
			return propValue;
		} catch (IOException e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

}
