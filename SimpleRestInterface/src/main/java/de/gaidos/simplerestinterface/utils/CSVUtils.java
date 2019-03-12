
package de.gaidos.simplerestinterface.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVUtils {

	public static final String DEFAULT_SEPARATOR = ",";

	public static void writeCSVFile(String csvFilePath, String line) {
		try {
			FileWriter pw = new FileWriter(csvFilePath, true);
			pw.append("\n");
			pw.append(line);
			pw.append("\n");
            pw.flush();
            pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<String> readCSVFile(String csvFilePath) {
		List<String> lines = new ArrayList<String>();
		try {
			Scanner scanner = new Scanner(new File(csvFilePath));
			while (scanner.hasNext()) {
				String nextLine = scanner.nextLine();
				if (nextLine != null && !nextLine.trim().isEmpty()) {
					lines.add(nextLine);
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		}
		return lines;
	}

}