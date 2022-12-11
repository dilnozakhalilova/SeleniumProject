package Class10;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _01_ExcelIntro {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\Dilnoza\\Desktop\\ExcelSeleniumSample1.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook1 = new XSSFWorkbook(fis);
        Sheet sheet = workbook1.getSheet("Лист1");
        Row row = sheet.getRow(1);
        Cell cell = row.getCell(1);
        System.out.println("cell = " + cell);






    }
}
