package utils;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtil {
    private static XSSFWorkbook book;
    private static XSSFSheet sheet;
    private static String workDir = System.getProperty("user.dir");
    private static String testDataPath = workDir + "\\testData\\testdata.xlsx";

    public static Object[][] getTestData(String sheetName) {
        Object[][] dataTable = null;
        int totalCell;
        int totalColumn;
        try {
            FileInputStream file = new FileInputStream(testDataPath);
            book = new XSSFWorkbook(file);
            sheet = book.getSheet(sheetName);
            totalCell = sheet.getLastRowNum();
            totalColumn = sheet.getRow(0).getLastCellNum();
            dataTable = new Object[totalCell][totalColumn];
            for (int i = 0; i < totalCell; i++) {
                for (int j = 0; j < totalColumn; j++) {
                    dataTable[i][j] = sheet.getRow(i + 1).getCell(j).toString();
                }
            }
            return dataTable;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return dataTable;
    }
}

