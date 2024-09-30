package com.generation.excel;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("generation.xlsx");
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheetAt(0);

            for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                XSSFRow row = sheet.getRow(rowIndex);
                if (row != null) {
                    for (int colIndex = 0; colIndex < row.getLastCellNum(); colIndex++) {
                        XSSFCell cell = row.getCell(colIndex);
                        if (cell != null) {
                            switch (cell.getCellType()) {
                                case STRING:
                                    System.out.print(cell.getStringCellValue() + "\t");
                                    break;
                                case NUMERIC:
                                    System.out.print(cell.getNumericCellValue() + "\t");
                                    break;
                                case BOOLEAN:
                                    System.out.print(cell.getBooleanCellValue() + "\t");
                                    break;
                                default:
                                    System.out.print("Unknown Type\t");
                                    break;
                            }
                        }
                    }
                    System.out.println(); 
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

