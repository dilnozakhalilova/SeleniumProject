package Class10;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _04_ExcelToMap {

    public static void main(String[] args) throws IOException {

        String filePath = System.getProperty("user.dir") + "/testData/EmployeeList.xlsx";
        FileInputStream fis = new FileInputStream(filePath);

        Workbook workbook  = new XSSFWorkbook(fis);
        Sheet sheet1 = workbook.getSheet("Sheet1");


        // Pre-requsite: Before I start looping data (cells) first I need to identify total number of ROWS & COLUMNS

        int rows = sheet1.getPhysicalNumberOfRows();        // <----Retriave total number of the rowns in a given sheet
        int columns = sheet1.getRow(0).getLastCellNum(); //<---- Retriave total number of the columns in a given sheet

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(sheet1.getRow(i).getCell(j)+"  ");
            }
            System.out.println();
        }



    }




}
