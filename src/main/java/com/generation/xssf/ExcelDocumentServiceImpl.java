package com.generation.xssf;

import com.generation.model.WorkbookTemplate;
import com.generation.model.Workplace;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelDocumentServiceImpl implements ExcelDocumentService {
    @Override
    public Workbook createWorkbookWithTemplate(WorkbookTemplate workbookTemplate) {
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet1 = workbook.createSheet(workbookTemplate.getSheetName());

        Font italicBold16SizeArialFont = workbook.createFont();
        italicBold16SizeArialFont.setBold(true);
        italicBold16SizeArialFont.setFontHeight((short) 16);
        italicBold16SizeArialFont.setFontName("Arial");
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(italicBold16SizeArialFont);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);

        Row sheet1Row1 = sheet1.createRow(0);
        Cell sheet1Row1Cell1 = sheet1Row1.createCell(0);
        sheet1Row1Cell1.setCellValue("ID");
        sheet1Row1Cell1.setCellStyle(cellStyle);
        Cell sheet1Row1Cell2 = sheet1Row1.createCell(1);
        sheet1Row1Cell2.setCellValue("STIR");
        sheet1Row1Cell2.setCellStyle(cellStyle);
        Cell sheet1Row1Cell3 = sheet1Row1.createCell(2);
        sheet1Row1Cell3.setCellValue("ISH JOYI");
        sheet1Row1Cell3.setCellStyle(cellStyle);
        Cell sheet1Row1Cell4 = sheet1Row1.createCell(3);
        sheet1Row1Cell4.setCellValue("Boshlagan sanasi");
        sheet1Row1Cell4.setCellStyle(cellStyle);
        Cell sheet1Row1Cell5 = sheet1Row1.createCell(4);
        sheet1Row1Cell5.setCellValue("Tugagan sanasi");
        sheet1Row1Cell5.setCellStyle(cellStyle);
        Cell sheet1Row1Cell6 = sheet1Row1.createCell(5);
        sheet1Row1Cell6.setCellValue("Oylik maoshi $ da");
        sheet1Row1Cell6.setCellStyle(cellStyle);

        int i = 1;
        for (Workplace workplace : workbookTemplate.getWorkplaceList()) {

            Row row = sheet1.createRow(i);
            Cell sheet1Row2Cell1 = row.createCell(0);
            sheet1Row2Cell1.setCellValue(workplace.getId());
            Cell sheet1Row2Cell2 = row.createCell(1);
            sheet1Row2Cell2.setCellValue(workplace.getStir());
            Cell sheet1Row2Cell3 = row.createCell(2);
            sheet1Row2Cell3.setCellValue(workplace.getWorkplace());
            Cell sheet1Row2Cell4 = row.createCell(3);
            sheet1Row2Cell4.setCellValue(workplace.getStartDate());
            Cell sheet1Row2Cell5 = row.createCell(4);
            sheet1Row2Cell5.setCellValue(workplace.getEndDate());
            Cell sheet1Row2Cell6 = row.createCell(5);
            sheet1Row2Cell6.setCellValue(workplace.getSalary());

            i++;
        }

        return workbook;
    }
}
