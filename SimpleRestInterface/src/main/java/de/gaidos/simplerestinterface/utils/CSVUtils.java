
package de.gaidos.simplerestinterface.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVUtils {

  public static final String DEFAULT_SEPARATOR = ",";

  public static void writeCSVFile() {

  }

  public static List<String> readCSVFile(String csvFilePath) {
    List<String> lines = new ArrayList<String>();
    try {
      Scanner scanner = new Scanner(new File(csvFilePath));
      while (scanner.hasNext()) {
        lines.add(scanner.nextLine());
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      // TODO: handle exception
    }
    return lines;
  }

}