package rvs.autobots.data;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;

public class CSVDataHandler {

	/**
	 * This method is to get data from column index.
	 * 
	 * @author rahul.raman
	 * @param colNumber
	 * @param csvPath
	 * @return
	 */
	public List<String> getDataFromCSV(int colNumber, String csvPath) {
		List<String> list = new ArrayList<String>();
		try {
			CSVReader reader = new CSVReader(new FileReader(csvPath));
			List<String[]> li = reader.readAll();
			Iterator<String[]> i1 = li.iterator();
			while (i1.hasNext()) {
				String[] str = i1.next();
				list.add(str[colNumber]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
