package com.generation.word;

import org.apache.poi.xwpf.usermodel.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WordExample {
    public static void main(String[] args) {

        XWPFDocument document = new XWPFDocument();

        XWPFParagraph headerParag = document.createParagraph();
        headerParag.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun headerParagContent = headerParag.createRun();
        headerParagContent.setText("hello world");
        headerParagContent.setFontSize(23);
        headerParagContent.setBold(true);
        headerParagContent.setCapitalized(true);
        headerParagContent.addBreak();

        XWPFParagraph secondHeaderParag = document.createParagraph();
        secondHeaderParag.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun secondHeaderParagContent = secondHeaderParag.createRun();
        secondHeaderParagContent.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ac faucibus odio");
        secondHeaderParagContent.setFontSize(17);
//        secondHeaderParagContent.setBold(true);
        secondHeaderParagContent.addBreak();

        XWPFTable table = document.createTable(10, 4);
        XWPFTableRow row1 = table.getRow(0);
        XWPFTableCell cell1 = row1.getCell(0);
        cell1.setText("Ism Familiya");
        XWPFTableCell cell2 = row1.getCell(1);
        cell2.setText("Yosh");
        XWPFTableCell cell3 = row1.getCell(2);
        cell3.setText("O'qish joyi");
        XWPFTableCell cell4 = row1.getCell(3);
        cell4.setText("Guruh nomi");

        XWPFTableRow row2 = table.getRow(1);
        XWPFTableCell cell21 = row2.getCell(0);
        cell21.setText("Orifjon Tursinboyev");
        XWPFTableCell cell22 = row2.getCell(1);
        cell22.setText("15");
        XWPFTableCell cell23 = row2.getCell(2);
        cell23.setText("37 maktab");
        XWPFTableCell cell24 = row2.getCell(3);
        cell24.setText("D28 Generation");

        XWPFParagraph emptyParag = document.createParagraph();
        XWPFRun emptyParagRun = emptyParag.createRun();
        emptyParagRun.addBreak();

        XWPFParagraph dateParag = document.createParagraph();
        XWPFRun dateParagRun = dateParag.createRun();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy | hh:mm:ss");
        String formattedDate = dateTimeFormatter.format(LocalDateTime.now());
        dateParagRun.setBold(true);
        dateParagRun.setText("Yaratilgan sana va vaqti: " + formattedDate);


        try {
            FileOutputStream out = new FileOutputStream("example.docx");
            document.write(out);
            document.close();
            out.close();
            System.out.println("Docuemtn yaratildi!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
