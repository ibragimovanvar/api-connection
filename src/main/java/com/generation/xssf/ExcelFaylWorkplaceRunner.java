package com.generation.xssf;

import com.generation.model.WorkbookTemplate;
import com.generation.model.Workplace;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExcelFaylWorkplaceRunner {
    static Scanner inTxt = new Scanner(System.in);
    static Scanner inNum = new Scanner(System.in);

    public static void main(String[] args) {
        ExcelDocumentService excelDocumentService = new ExcelDocumentServiceImpl();

        System.out.print("Original nomini kiriting:");
        String originalName = inTxt.next();
        System.out.print("Sheet nomini kiriting:");
        String sheet = inTxt.next();

        List<Workplace> workplaceList = new ArrayList<>();

        while (true) {
            System.out.print("Ish joyni nomini kiriting:");
            String workplaceName = inTxt.next();
            System.out.print("Boshlagan yilni kriiting:");
            Integer year = inNum.nextInt();
            System.out.print("Boshlagan kun kriiting:");
            Integer day = inNum.nextInt();
            System.out.print("Boshlagan oyni kriiting:");
            Integer month = inNum.nextInt();
            System.out.print("Tugagan yilni kriiting:");
            Integer endYear = inNum.nextInt();
            System.out.print("Tugagan kun kriiting:");
            Integer endDay = inNum.nextInt();
            System.out.print("Tugagan oyni kriiting:");
            Integer endMonth = inNum.nextInt();
            System.out.print("Oylik maoshni kriiting:");
            Integer salary = inNum.nextInt();
            Workplace workplace = new Workplace(salary, workplaceName, LocalDate.of(year, month, day), LocalDate.of(endYear, endMonth, endDay));
            workplaceList.add(workplace);
            System.out.print("Davom etishni xoxlasangiz 1 ni bosing: ");
            int choice  = inNum.nextInt();
            if(choice != 1) break;
        }

        WorkbookTemplate template = new WorkbookTemplate(originalName,
                              sheet, workplaceList,
                "", "");

        Workbook workbook = excelDocumentService.createWorkbookWithTemplate(template);

        try {
            FileOutputStream fos = new FileOutputStream(template.getOriginalFileName()+ ".xlsx");
            workbook.write(fos);
            fos.close();
            workbook.close();
        } catch (IOException e) {
        }
    }
}
