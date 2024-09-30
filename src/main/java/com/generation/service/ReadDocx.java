package com.generation.service;

import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.util.List;

public class ReadDocx {
    public static void main(String[] args) {

        try (FileInputStream fis = new FileInputStream("11modulimtihon.docx");
             XWPFDocument document = new XWPFDocument(fis)) {

            List<XWPFTable> tables = document.getTables();
            for (XWPFTable table : tables) {
                for (XWPFTableRow row : table.getRows()) {
                    for (XWPFTableCell tableCell : row.getTableCells()) {
                        System.out.println(tableCell.getText());
                    }
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
