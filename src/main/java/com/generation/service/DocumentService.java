package com.generation.service;

import com.generation.model.DocumentShablon;
import com.generation.model.ExamStudent;
import org.apache.poi.xwpf.usermodel.*;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DocumentService {

    public XWPFDocument createDocument(DocumentShablon shablon){
        XWPFDocument document = new XWPFDocument();

        XWPFParagraph nameParagraph = document.createParagraph();
        nameParagraph.setAlignment(ParagraphAlignment.CENTER);

        XWPFRun nameParagraphRun = nameParagraph.createRun();
        nameParagraphRun.setText(shablon.getName());
        nameParagraphRun.setFontSize(20);
        nameParagraphRun.setBold(true);
        nameParagraphRun.addBreak();

        XWPFParagraph descParagraph = document.createParagraph();
        XWPFRun descParagraphRun = descParagraph.createRun();
        descParagraphRun.setText(shablon.getDesc());
        descParagraphRun.setFontSize(15);
        descParagraphRun.setBold(true);
        descParagraphRun.addBreak();

        XWPFTable studentTable = document.createTable();
        XWPFTableRow studentTableRow = studentTable.getRow(0);
        studentTableRow.getCell(0).setText("Student ismi");
        studentTableRow.addNewTableCell().setText("Teoriya bilim bahosi");
        studentTableRow.addNewTableCell().setText("Amaliy bilim bahosi");
        studentTableRow.addNewTableCell().setText("Umumiy bilim bahosi");

        for (ExamStudent student : shablon.getStudents()) {
            XWPFTableRow row = studentTable.createRow();
            row.getCell(0).setText(student.getFullName());
            row.getCell(1).setText(Integer.toString(student.getTheroticalScore()));
            row.getCell(2).setText(Integer.toString(student.getPracticalScore()));
            row.getCell(3).setText(Double.toString(student.getResult()));
        }

        XWPFParagraph authorParagraph = document.createParagraph();
        XWPFRun authorParagraphRun = authorParagraph.createRun();
        authorParagraphRun.setText(shablon.getCreatedBy());
        authorParagraphRun.setFontSize(16);
        authorParagraphRun.setBold(true);
        authorParagraphRun.addBreak();

        LocalDateTime hozirgiVaqt = LocalDateTime.now();
        String formatlanganVaqt = hozirgiVaqt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

        XWPFParagraph dateParagraph = document.createParagraph();
        dateParagraph.createRun().setText("Yaratilgan vaqt: " + formatlanganVaqt);

        return document;
    }

}
