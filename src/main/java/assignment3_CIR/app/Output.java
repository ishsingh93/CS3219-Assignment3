package assignment3_CIR.app;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.CsvListWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.io.ICsvListWriter;
import org.supercsv.prefs.CsvPreference;

public class Output {
	
	public Output() {
		//showOutput();
	}

	private void showOutput() {
		
	}
	
	public String toString() {
		return null;
	}
	
	public void writeCSVFile(String fileName, ArrayList<AuthorObj> authorArr) {
		 ICsvBeanWriter beanWriter = null;
		 List<AuthorObj> authorList = new ArrayList<AuthorObj>();
		
		for (int i=0; i<authorArr.size(); i++) {
			authorList.add(authorArr.get(i));
		}
		
		try {
            beanWriter = new CsvBeanWriter(new FileWriter("output.csv"),
                    CsvPreference.STANDARD_PREFERENCE);
            
            final String[] header = new String[] { "authorName", "count"};
            final CellProcessor[] processors = getProcessors();
			
			//Write the CSV file header
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

	private CellProcessor[] getProcessors() {
		CellProcessor[] PROCESSORS = new CellProcessor[] {
				null,
				null
		};
		return PROCESSORS;
	}

}
