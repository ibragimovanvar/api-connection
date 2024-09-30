package com.generation.excel;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;

public class WordTableWithBoldBorders {
    public static void main(String[] args) {
        // Create a new Word document
        XWPFDocument document = new XWPFDocument();

        // Create a table with 2 rows and 2 columns
        XWPFTable table = document.createTable(2, 2);

        // Set text for the first row
        table.getRow(0).getCell(0).setText("Name");
        table.getRow(0).getCell(1).setText("Age");

        // Set text for the second row
        table.getRow(1).getCell(0).setText("John Doe");
        table.getRow(1).getCell(1).setText("25");

        // Make the borders of each cell bold
        for (XWPFTableRow row : table.getRows()) {
            for (XWPFTableCell cell : row.getTableCells()) {
                CTTcPr tcPr = cell.getCTTc().addNewTcPr();
                CTTcBorders borders = tcPr.addNewTcBorders();

                // Set border style and width for top, bottom, left, and right
                borders.addNewTop().setVal(STBorder.SINGLE);
                borders.addNewBottom().setVal(STBorder.SINGLE);
                borders.addNewLeft().setVal(STBorder.SINGLE);
                borders.addNewRight().setVal(STBorder.SINGLE);

                // Set border width (bold effect)
                borders.getTop().setSz(BigInteger.valueOf(24)); // 24 twips = 1/2 point
                borders.getBottom().setSz(BigInteger.valueOf(24));
                borders.getLeft().setSz(BigInteger.valueOf(24));
                borders.getRight().setSz(BigInteger.valueOf(24));
            }
        }

        // Write the document to a file
        try (FileOutputStream fos = new FileOutputStream("wordTableWithBoldBorders.docx")) {
            document.write(fos);
            System.out.println("Word document created with table and bold borders!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}