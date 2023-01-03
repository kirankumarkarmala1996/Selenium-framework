package rvs.autobots.data;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import rvs.autobots.action.GeneralUtilityHelper;
import rvs.autobots.exception.AutomationException;

public class ExcelDataHandler {

	static XSSFWorkbook workBook;
	static XSSFSheet sheet;

	public ExcelDataHandler(String excelPath, String sheetName) throws IOException {
		workBook = new XSSFWorkbook(excelPath);
		sheet = workBook.getSheet(sheetName);
	}

	/**
	 * This method is used to get rows count
	 * 
	 * @author kiran.mg
	 * @param filePath
	 * @param sheetName
	 * @return rowCount
	 */
	public static int getRowCount() {
		int rowCount = sheet.getPhysicalNumberOfRows();
		return rowCount;
	}

	/**
	 * This method is used to get Columns count
	 * 
	 * @author kiran.mg
	 * @param filePath
	 * @param sheetName
	 * @return colCount
	 */
	public static int getColCount() {
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		return colCount;
	}

	/**
	 * This method is used to get String or Numeric Data from the Cell
	 * 
	 * @author sanojs
	 * @param filePath
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @return cellValue
	 * @throws AutomationException
	 */
	public String getCellData(int rowNum, int colNum) throws AutomationException {
		String cellValue = null;
		try {
			CellType cellType = sheet.getRow(rowNum - 1).getCell(colNum - 1).getCellType();
			if (cellType.toString().toLowerCase().equals("numeric")) {
				cellValue = new GeneralUtilityHelper().convertIntToString(new GeneralUtilityHelper()
						.convertDoubleToInt(sheet.getRow(rowNum - 1).getCell(colNum - 1).getNumericCellValue()));
			}
			if (cellType.toString().toLowerCase().equals("string")) {
				cellValue = sheet.getRow(rowNum - 1).getCell(colNum - 1).getStringCellValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				workBook.close();
			} catch (Exception e) {
			}
		}
		return cellValue;
	}

	/**
	 * This method is used to get Date Data from the Cell
	 * 
	 * @author sanojs
	 * @param filePath
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @return cellValue
	 */
	public String getCellDateData(int rowNum, int colNum) {
		String dateValue = "";
		try {
			Date cellValue = sheet.getRow(rowNum - 1).getCell(colNum - 1).getDateCellValue();
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			dateValue = dateFormat.format(cellValue);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				workBook.close();
			} catch (Exception e) {
			}
		}
		return dateValue;
	}
}
