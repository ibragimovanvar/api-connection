package com.generation.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        PDDocument document = null;
        PDPageContentStream contentStream = null;

        try {
            document = new PDDocument();
            PDPage a4Page = new PDPage(PDRectangle.A4);
            document.addPage(a4Page);

            contentStream = new PDPageContentStream(document, a4Page);
            contentStream.beginText();
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 25);
            contentStream.newLineAtOffset(50, 500);
            contentStream.showText("My pdf text");
            contentStream.endText();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (contentStream != null) {
                    contentStream.close();
                }
                if (document != null) {
                    document.save("output.pdf");
                    document.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
