package com.generation.xssf;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelFayl {
    public static void main(String[] args) {

        Workbook workbook = new XSSFWorkbook();

        Sheet sheet1 = workbook.createSheet("D28 Guruh");

        Font italicBold16SizeArialFont = workbook.createFont();
        italicBold16SizeArialFont.setBold(true);
        italicBold16SizeArialFont.setItalic(true);
        italicBold16SizeArialFont.setFontHeight((short) 16);
        italicBold16SizeArialFont.setFontName("Arial");
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(italicBold16SizeArialFont);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);

        Row sheet1Row1 = sheet1.createRow(0);
        Cell sheet1Row1Cell1 = sheet1Row1.createCell(0);
        sheet1Row1Cell1.setCellValue("Ism Familiya");
        sheet1Row1Cell1.setCellStyle(cellStyle);
        Cell sheet1Row1Cell2 = sheet1Row1.createCell(1);
        sheet1Row1Cell2.setCellValue("Yosh");
        Cell sheet1Row1Cell3 = sheet1Row1.createCell(2);
        sheet1Row1Cell3.setCellValue("Nazariy bal");
        Cell sheet1Row1Cell4 = sheet1Row1.createCell(3);
        sheet1Row1Cell4.setCellValue("Amaliy bal");
        Cell sheet1Row1Cell5 = sheet1Row1.createCell(4);
        sheet1Row1Cell5.setCellValue("Umumiy bal");

        Row sheet1Row2 = sheet1.createRow(1);
        Cell sheet1Row2Cell1 = sheet1Row2.createCell(0);
        sheet1Row2Cell1.setCellValue("Orifjon");
        Cell sheet1Row2Cell2 = sheet1Row2.createCell(1);
        sheet1Row2Cell2.setCellValue("15");
        Cell sheet1Row2Cell3 = sheet1Row2.createCell(2);
        sheet1Row2Cell3.setCellValue("65");
        Cell sheet1Row2Cell4 = sheet1Row2.createCell(3);
        sheet1Row2Cell4.setCellValue("0");
        Cell sheet1Row2Cell5 = sheet1Row2.createCell(4);
        sheet1Row2Cell5.setCellValue("32");

        try {
            FileOutputStream fos = new FileOutputStream("example.xlsx");
            workbook.write(fos);
            fos.close();
            workbook.close();
        } catch (IOException e) {
        }


    }
}
