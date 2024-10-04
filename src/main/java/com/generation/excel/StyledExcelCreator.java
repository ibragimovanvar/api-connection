package com.generation.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class StyledExcelCreator {
    public static void main(String[] args) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Acquisition Plan - 5 Year Plan");

        // Create a bold font
        Font boldFont = workbook.createFont();
        boldFont.setBold(true);

        // Create a cell style for the header
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(boldFont);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // Create a cell style for the outlay cells
        CellStyle outlayStyle = workbook.createCellStyle();
        outlayStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        outlayStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        outlayStyle.setBorderBottom(BorderStyle.THIN);
        outlayStyle.setBorderTop(BorderStyle.THIN);
        outlayStyle.setBorderRight(BorderStyle.THIN);
        outlayStyle.setBorderLeft(BorderStyle.THIN);

        // Create a cell style for the inflow cells
        CellStyle inflowStyle = workbook.createCellStyle();
        inflowStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        inflowStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        inflowStyle.setBorderBottom(BorderStyle.THIN);
        inflowStyle.setBorderTop(BorderStyle.THIN);
        inflowStyle.setBorderRight(BorderStyle.THIN);
        inflowStyle.setBorderLeft(BorderStyle.THIN);

        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Outlays:");
        headerRow.getCell(0).setCellStyle(headerStyle);
        for (int year = 1; year <= 5; year++) {
            headerRow.createCell(year).setCellValue("Year " + (2009 + year));
            headerRow.getCell(year).setCellStyle(headerStyle);
        }

        // Create subheader row
        String[] categories = {
                "Purchase cost", "Installation costs", "Facilities renovation",
                "Principal Payments", "Interest", "Maintenance",
                "Inventory", "Salaries", "Working Capital"
        };
        double[][] outlayData = {
                {5000, 10000, 12000, 12000, 20000},
                {5000, 10000, 11000, 12000, 15000},
                {5000, 10000, 11000, 12000, 15000},
                {5000, 10000, 11000, 12000, 15000},
                {5000, 10000, 11000, 12000, 15000},
                {5000, 10000, 11000, 12000, 15000},
                {5000, 10000, 11000, 12000, 15000},
                {5000, 10000, 11000, 12000, 15000}
        };

        // Populate outlay data
        for (int i = 0; i < categories.length - 2; i++) {
            Row row = sheet.createRow(i + 2);
            row.createCell(0).setCellValue(categories[i]);
            for (int j = 0; j < outlayData[i].length; j++) {
                Cell cell = row.createCell(j + 1);
                cell.setCellValue(outlayData[i][j]);
                cell.setCellStyle(outlayStyle);
            }
        }

        // Total Annual Outlays Row
        Row totalOutlaysRow = sheet.createRow(categories.length + 2);
        totalOutlaysRow.createCell(0).setCellValue("Total Annual Outlays:");
        totalOutlaysRow.getCell(0).setCellStyle(headerStyle);
        double[] totalOutlays = {45000, 90000, 99000, 108000, 180000};
        for (int j = 0; j < totalOutlays.length; j++) {
            Cell cell = totalOutlaysRow.createCell(j + 1);
            cell.setCellValue(totalOutlays[j]);
            cell.setCellStyle(outlayStyle);
        }

        // Create inflows section
        Row inflowHeaderRow = sheet.createRow(categories.length + 4);
        inflowHeaderRow.createCell(0).setCellValue("Inflows:");
        inflowHeaderRow.getCell(0).setCellStyle(headerStyle);

        String[] inflowCategories = {
                "Gain on Equipment Replaced", "Additional Revenues"
        };
        double[][] inflowData = {
                {10000, 11000, 12500, 15000, 25000},
                {50000, 100000, 100000, 100000, 200000}
        };

        // Populate inflow data
        for (int i = 0; i < inflowCategories.length; i++) {
            Row row = sheet.createRow(categories.length + 5 + i);
            row.createCell(0).setCellValue(inflowCategories[i]);
            for (int j = 0; j < inflowData[i].length; j++) {
                Cell cell = row.createCell(j + 1);
                cell.setCellValue(inflowData[i][j]);
                cell.setCellStyle(inflowStyle);
            }
        }

        // Total Annual Inflows Row
        Row totalInflowsRow = sheet.createRow(categories.length + 7);
        totalInflowsRow.createCell(0).setCellValue("Total Annual Inflows:");
        totalInflowsRow.getCell(0).setCellStyle(headerStyle);
        double[] totalInflows = {60000, 111000, 112500, 115000, 225000};
        for (int j = 0; j < totalInflows.length; j++) {
            Cell cell = totalInflowsRow.createCell(j + 1);
            cell.setCellValue(totalInflows[j]);
            cell.setCellStyle(inflowStyle);
        }

        // Net Annual Cash Flows
        Row netAnnualCashFlowsRow = sheet.createRow(categories.length + 9);
        netAnnualCashFlowsRow.createCell(0).setCellValue("Net Annual Cash Flows:");
        netAnnualCashFlowsRow.getCell(0).setCellStyle(headerStyle);
        double[] netCashFlows = {15000, 21000, 13500, 7000, 45000};
        for (int j = 0; j < netCashFlows.length; j++) {
            Cell cell = netAnnualCashFlowsRow.createCell(j + 1);
            cell.setCellValue(netCashFlows[j]);
            cell.setCellStyle(inflowStyle);
        }

        // Cumulative Net Cash Flow
        Row cumulativeNetCashFlowRow = sheet.createRow(categories.length + 10);
        cumulativeNetCashFlowRow.createCell(0).setCellValue("Cumulative Net Cash Flow:");
        cumulativeNetCashFlowRow.getCell(0).setCellStyle(headerStyle);
        double[] cumulativeCashFlow = {15000, 36000, 49500, 56500, 101500};
        for (int j = 0; j < cumulativeCashFlow.length; j++) {
            Cell cell = cumulativeNetCashFlowRow.createCell(j + 1);
            cell.setCellValue(cumulativeCashFlow[j]);
            cell.setCellStyle(inflowStyle);
        }

        // Save the file
        try (FileOutputStream fileOut = new FileOutputStream("AcquisitionPlanStyled.xlsx")) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Closing the workbook
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
