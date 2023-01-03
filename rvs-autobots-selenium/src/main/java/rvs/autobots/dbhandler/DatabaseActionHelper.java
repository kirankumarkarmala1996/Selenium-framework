package rvs.autobots.dbhandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import rvs.autobots.exception.AutomationException;

public class DatabaseActionHelper extends DatabaseConnectionHelper {

	public DatabaseActionHelper() throws AutomationException {
		super();
	}

	ResultSet res;

	/**
	 * Method to retrieve data from a table
	 * 
	 * @author Kiran M G
	 * @param selectquery
	 * @return ResultSet
	 * @throws AutomationException
	 */
	public ResultSet getTableData(String selectquery) throws AutomationException {
		Statement stmt = null;
		ResultSet res;
		try {
			if (selectquery == null || selectquery.equals("")) {
				throw new AutomationException("");
			}
		} catch (Exception e) {
			e = new Exception("");
			throw new AutomationException(e);
		}
		try {
			stmt = new DatabaseConnectionHelper().getConnectionStatement();
			String query = selectquery;
			res = stmt.executeQuery(query);
		} catch (Exception e) {
			throw new AutomationException(e);
		}
		return res;
	}

	/**
	 * Method to retrieve integer data from a table based on the column number
	 * 
	 * @author Kiran M G
	 * @param selectquery
	 * @param index
	 * @return list
	 */
	public ArrayList<Integer> getIntegerValues_byColNum(String selectquery, int index)
			throws SQLException, AutomationException {
		ResultSet res = getTableData(selectquery);
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (res.next()) {
			list.add(res.getInt(index));
		}
		return list;
	}

	/**
	 * Method to retrieve String data from a table based on the column number
	 * 
	 * @author Kiran M G
	 * @param selectquery
	 * @param index
	 * @return list
	 */
	public ArrayList<String> getStringValues_byColNum(String selectquery, int index)
			throws SQLException, AutomationException {
		ResultSet res = getTableData(selectquery);
		ArrayList<String> list = new ArrayList<String>();
		while (res.next()) {
			list.add(res.getString(index));
		}
		return list;
	}
}
