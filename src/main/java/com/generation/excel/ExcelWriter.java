package com.generation.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriter {
    public static void main(String[] args) {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Generation");

        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);

        Row row1 = sheet.createRow(0);
        Cell cell11 = row1.createCell(0);
        cell11.setCellValue("Ism Familiya");
        cell11.setCellStyle(style);
        Cell cell12 = row1.createCell(1);
        cell12.setCellValue("Yosh");
        cell12.setCellStyle(style);

        Row row2 = sheet.createRow(1);
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("Anvar Ibragimov");
        Cell cell22 = row2.createCell(1);
        cell22.setCellValue("20");

        try(FileOutputStream fos = new FileOutputStream("generation.xlsx")) {
            workbook.write(fos);
            workbook.close();
            System.out.println("Excel fayl yaratildi!");
        }catch (IOException e){

        }

    }
}
