package assignment3_CIR.app;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

public class Output {

	public Output() {
		// showOutput();
	}

	private void showOutput() {

	}

	public String toString() {
		return null;
	}

	public void writeCSVFileAuthor(String fileName, ArrayList<AuthorObj> authorArr, int arraySize, String dataLoc) {
		ICsvBeanWriter beanWriter = null;
		List<AuthorObj> authorList = new ArrayList<AuthorObj>();

		for (int i = 0; i < arraySize; i++) {
			authorList.add(authorArr.get(i));
		}

		try {
			beanWriter = new CsvBeanWriter(
					new FileWriter(
							"D:\\CS3219-Assignment3\\src\\main\\java\\assignment3_CIR\\app\\d3\\" + fileName + ".csv"),
					CsvPreference.STANDARD_PREFERENCE);

			final String[] header = new String[] { "authorName", "count" };
			final CellProcessor[] processors = getProcessors();

			// Write the CSV file header
			beanWriter.writeHeader(header);

			// Write statistics
			for (AuthorObj authObject : authorList) {
				beanWriter.write(authObject, header, processors);
			}

			System.out.println("CSV file created successfully");

		} catch (Exception e) {
			System.out.println("Error in CSVFileWriter");
			e.printStackTrace();
		} finally {

			try {
				beanWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter");
				e.printStackTrace();
			}
		}
	}

	public void writeCSVFilePublication(String fileName, ArrayList<PubTrendObj> pubArr, int arraySize, String dataLoc) {
		ICsvBeanWriter beanWriter = null;
		List<PubTrendObj> publicationList = new ArrayList<PubTrendObj>();

		for (int i = 0; i < arraySize; i++) {
			publicationList.add(pubArr.get(i));
		}

		try {
			beanWriter = new CsvBeanWriter(
					new FileWriter(
							"D:\\CS3219-Assignment3\\src\\main\\java\\assignment3_CIR\\app\\d3\\" + fileName + ".csv"),
					CsvPreference.STANDARD_PREFERENCE);

			final String[] header = new String[] { "publishedYear", "publicationsCount" };
			final CellProcessor[] processors = getProcessors();

			// Write the CSV file header
			beanWriter.writeHeader(header);

			// Write statistics
			for (PubTrendObj pubObject : publicationList) {
				beanWriter.write(pubObject, header, processors);
			}

			System.out.println("CSV file created successfully");

		} catch (Exception e) {
			System.out.println("Error in CSVFileWriter");
			e.printStackTrace();
		} finally {

			try {
				beanWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter");
				e.printStackTrace();
			}
		}
	}

	private CellProcessor[] getProcessors() {
		CellProcessor[] PROCESSORS = new CellProcessor[] { null, null };
		return PROCESSORS;
	}

	public void writeCSVFileCitation(String fileName, ArrayList<CitObj> citTrend, int size, String dataLoc) {
		ICsvBeanWriter beanWriter = null;
		List<CitObj> citList = new ArrayList<CitObj>();

		for (int i = 0; i < size; i++) {
			citList.add(citTrend.get(i));
		}

		try {
			beanWriter = new CsvBeanWriter(
					new FileWriter(
							"D:\\CS3219-Assignment3\\src\\main\\java\\assignment3_CIR\\app\\d3\\" + fileName + ".csv"),
					CsvPreference.STANDARD_PREFERENCE);

			final String[] header = new String[] { "year", "citCount" };
			final CellProcessor[] processors = getProcessors();

			// Write the CSV file header
			beanWriter.writeHeader(header);

			// Write statistics
			for (CitObj citObject : citList) {
				beanWriter.write(citObject, header, processors);
			}

			System.out.println("CSV file created successfully");

		} catch (Exception e) {
			System.out.println("Error in CSVFileWriter");
			e.printStackTrace();
		} finally {

			try {
				beanWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter");
				e.printStackTrace();
			}
		}

	}

}
