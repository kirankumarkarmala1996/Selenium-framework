package rvs.autobots.dbhandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import rvs.autobots.base.AutomationBase;
import rvs.autobots.data.PropertyDataHandler;
import rvs.autobots.exception.AutomationException;
import rvs.autobots.utils.AutomationConstants;

public class DatabaseConnectionHelper {

	public Statement stmt = null;
	public Connection con = null;
	public String className;
	
	AutomationBase baseObj = new AutomationBase();

	public DatabaseConnectionHelper() throws AutomationException {
		PropertyDataHandler propertyObject = new PropertyDataHandler();
		String databaseSystem = propertyObject.getProperty(AutomationConstants.DB_CONFIG, "databaseSystem");
		if(databaseSystem.equalsIgnoreCase("MySql")){
			className = "com.mysql.cj.jdbc.Driver";
		}
		else {
			className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		}
	}
	/**
	 * Method to create the statement
	 * 
	 * @param databaseSystem
	 * @return Statement
	 * @throws AutomationException
	 */
	public Statement getConnectionStatement() throws AutomationException {
		try {
			PropertyDataHandler propertyObject = new PropertyDataHandler();
			Class.forName(className);

			String dbUsername = propertyObject.getProperty(AutomationConstants.DB_CONFIG, "dbUsername");
			String dbPassword = propertyObject.getProperty(AutomationConstants.DB_CONFIG, "dbPassword");

			con = DriverManager.getConnection(propertyObject.getProperty(AutomationConstants.DB_CONFIG, "dbUrl"),
					dbUsername, dbPassword);

			stmt = con.createStatement();

			return stmt;
		} catch (Exception e) {
			throw new AutomationException(baseObj.getExceptionMessage() + "\n" + AutomationConstants.CAUSE + e.getMessage());
		}
	}
}
