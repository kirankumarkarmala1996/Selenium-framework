package rvs.autobots.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import rvs.autobots.base.AutomationBase;
import rvs.autobots.exception.AutomationException;
import rvs.autobots.utils.AutomationConstants;

public class GeneralUtilityHelper extends AutomationBase {

	public Random random;

	/**
	 * Method to GET a random number between the lowerBound and upperBound
	 * 
	 * @author kiran.mg
	 * @since 20-04-2020
	 * @param lowerBound
	 * @param upperBound
	 * @throws AutomationException
	 */
	public int getRandomNumber(int lowerBound, int upperBound) throws AutomationException {
		try {
			random = new Random();
			int randomNum = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
			return randomNum;
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to GET a random number with the a number length mentioned
	 * 
	 * @author kiran.mg
	 * @since 20-04-2020
	 * @param numberLength
	 * @throws AutomationException
	 */
	public String getRandomNumber(int numberLength) throws AutomationException {
		try {
			random = new Random();
			int randomNum = 0;
			boolean loop = true;
			while (loop) {
				randomNum = random.nextInt();
				if (Integer.toString(randomNum).length() == numberLength
						&& !Integer.toString(randomNum).startsWith("-")) {
					loop = false;
				}
			}
			String randomNumber = Integer.toString(randomNum);
			return randomNumber;
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to GET a random string value with the string length mentioned
	 * 
	 * @author kiran.mg
	 * @since 20-04-2020
	 * @param stringLength
	 * @throws AutomationException
	 */
	public String getRandomString(int stringLength) throws AutomationException {
		try {
			String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
			StringBuilder sb = new StringBuilder(stringLength);
			for (int i = 0; i < stringLength; i++) {
				int index = (int) (AlphaNumericString.length() * Math.random());
				sb.append(AlphaNumericString.charAt(index));
			}
			return sb.toString();
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to GET a random string which has only alphabets with the string length mentioned
	 * 
	 * @author kiran.mg
	 * @since 20-04-2020
	 * @param stringLength
	 * @throws AutomationException
	 */
	public String getRandomStringOnlyAlphabets(int stringLength) throws AutomationException {
		try {
			String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";
			StringBuilder sb = new StringBuilder(stringLength);
			for (int i = 0; i < stringLength; i++) {
				int index = (int) (AlphaNumericString.length() * Math.random());
				sb.append(AlphaNumericString.charAt(index));
			}
			return sb.toString();
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to GET the current date
	 * 
	 * @author kiran.mg
	 * @since 20-04-2020
	 * @throws AutomationException
	 */
	public String getCurrentDate() throws AutomationException {
		try {
			DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy_HH-mm-ss");
			Date date = new Date();
			String filePathdate = dateFormat.format(date).toString();
			return filePathdate;
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to GET the current date in the date format ddMMMyyyy
	 * 
	 * @author kiran.mg
	 * @since 20-04-2020
	 * @throws AutomationException
	 */
	public String getCurrentDateInFormatddMMMyyyy() throws AutomationException {
		try {
			DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
			Date date = new Date();
			String filePathdate = dateFormat.format(date).toString();
			return filePathdate;
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to GET a current date in the date format ddMMyyyy
	 * 
	 * @author kiran.mg
	 * @since 20-04-2020
	 * @throws AutomationException
	 */
	public String getCurrentDateInFormatddMMyyyy() throws AutomationException {
		try {
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date date = new Date();
			String filePathdate = dateFormat.format(date).toString();
			return filePathdate;
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to GET the day from the current date
	 * 
	 * @author kiran.mg
	 * @since 20-04-2020
	 * @throws AutomationException
	 */
	public String getDayFromCurrentDate() throws AutomationException {
		try {
			DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy_HH-mm-ss");
			Date date = new Date();
			String filePathdate = dateFormat.format(date).toString();
			String day = filePathdate.substring(0, 2);
			return day;
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to CONVERT a double value to an Integer
	 * 
	 * @author kiran.mg
	 * @since 20-04-2020
	 * @param doubleValue
	 * @throws AutomationException
	 */
	public int convertDoubleToInt(double doubleValue) throws AutomationException {
		try {
			int intValue = (int) doubleValue;
			return intValue;
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to CONVERT a float value to an Integer
	 * 
	 * @author kiran.mg
	 * @since 20-04-2020
	 * @param floatValue
	 * @throws AutomationException
	 */
	public int convertFloatToInt(float floatValue) throws AutomationException {
		try {
			int intValue = (int) floatValue;
			return intValue;
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to CONVERT a string value to an Integer
	 * 
	 * @author kiran.mg
	 * @since 20-04-2020
	 * @param stringValue
	 * @throws AutomationException
	 */
	public int convertStringToInt(String stringValue) throws AutomationException {
		try {
			int intValue = Integer.parseInt(stringValue);
			return intValue;
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to CONVERT a string value to a double value
	 * 
	 * @author kiran.mg
	 * @since 20-04-2020
	 * @param stringValue
	 * @throws AutomationException
	 */
	public double convertStringToDouble(String stringValue) throws AutomationException {
		try {
			double doubleValue = Double.parseDouble(stringValue);
			return doubleValue;
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to CONVERT an Integer to a string value
	 * 
	 * @author kiran.mg
	 * @since 20-04-2020
	 * @param intValue
	 * @throws AutomationException
	 */
	public String convertIntToString(int intValue) throws AutomationException {
		try {
			String stringValue = String.valueOf(intValue);
			return stringValue;
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to CONVERT a double value to a string value
	 * 
	 * @author kiran.mg
	 * @since 20-04-2020
	 * @param doubleValue
	 * @throws AutomationException
	 */
	public String convertDoubleToString(double doubleValue) throws AutomationException {
		try {
			String stringValue = String.valueOf(doubleValue);
			return stringValue;
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}

	/**
	 * Method to CONVERT a string value to a long value
	 * 
	 * @author kiran.mg
	 * @since 20-04-2020
	 * @param doubleValue
	 * @throws AutomationException
	 */
	public long convertStringToLong(String stringValue) throws AutomationException {
		try {
			long longValue = Long.parseLong(stringValue);
			return longValue;
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}
}
