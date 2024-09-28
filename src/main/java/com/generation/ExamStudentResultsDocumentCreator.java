package com.generation;


import com.generation.model.DocumentShablon;
import com.generation.model.ExamStudent;
import com.generation.service.DocumentService;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExamStudentResultsDocumentCreator {

    static Scanner inTxt = new Scanner(System.in);
    static Scanner inNum = new Scanner(System.in);

    public static void main(String[] args) {

        DocumentService documentService = new DocumentService();

        System.out.print("Document uchun nomini kiriting: ");
        String documentName = inTxt.nextLine();

        System.out.print("Document uchun izoh kiriting: ");
        String documentDesc = inTxt.nextLine();

        System.out.print("Document avtorini kiriting: ");
        String documentAuthor = inTxt.nextLine();

        System.out.print("Document original nomini kiriting: ");
        String documentOriginalName = inTxt.nextLine();

        List<ExamStudent> examStudentList = new ArrayList<>();

        while (true) {

            System.out.print("Student ism familiya kiriting: ");
            String fullName = inTxt.next();

            System.out.print("Student teoriya balini kiriting: ");
            Integer theoreticalScore = inNum.nextInt();

            System.out.print("Studentni amaliy balini kiriting: ");
            Integer practicalScore = inNum.nextInt();

            Double result = (double) ((theoreticalScore + practicalScore) / 2);

            ExamStudent examStudent = new ExamStudent(
                    fullName, theoreticalScore,
                    practicalScore, result);

            examStudentList.add(examStudent);

            System.out.print("Student qo'shildi yana qo'shishni xoxlaysizmi? yes/no : ");
            String userChoice = inTxt.next();

            if (userChoice.equals("no")) {
                break;
            }
        }

        DocumentShablon shablon = new DocumentShablon(
                documentName,
                documentDesc,
                examStudentList,
                documentAuthor);

        XWPFDocument document = documentService.createDocument(shablon);

        try {
            FileOutputStream out = new FileOutputStream(documentOriginalName.isBlank() ? "example.docx" : documentOriginalName + ".docx");
            document.write(out);
            out.close();
            document.close();
        }catch (IOException e){
            System.out.println("Xatolik yozishda faylga!");
        }


    }
}
