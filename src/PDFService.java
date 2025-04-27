import java.io.*;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.encryption.*;
import org.apache.pdfbox.pdmodel.font.PDType1Font;


public class PDFService {

    public void createPDF(String text, String filePath) throws IOException {
        PDDocument doc = new PDDocument();
        PDPage page = new PDPage();
        doc.addPage(page);
        PDPageContentStream content = new PDPageContentStream(doc, page);
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(100, 700);
        content.showText(text);
        content.endText();
        content.close();
        doc.save(filePath);
        doc.close();
        System.out.println("PDF created successfully!");
    }

    public void mergePDFs(String[] files, String outputPath) throws IOException {
        PDFMergerUtility merger = new PDFMergerUtility();
        for (String file : files) {
            merger.addSource(file);
        }
        merger.setDestinationFileName(outputPath);
        merger.mergeDocuments(null);
        System.out.println("PDFs merged successfully!");
    }

    public void splitPDF(String inputPath, String outputFolder) throws IOException {
        PDDocument doc = PDDocument.load(new File(inputPath));
        int pageNum = 1;
        for (PDPage page : doc.getPages()) {
            PDDocument newDoc = new PDDocument();
            newDoc.addPage(page);
            newDoc.save(outputFolder + "/page_" + (pageNum++) + ".pdf");
            newDoc.close();
        }
        doc.close();
        System.out.println("PDF split successfully!");
    }

    public void extractText(String filePath) throws IOException {
        PDDocument doc = PDDocument.load(new File(filePath));
        PDFTextStripper stripper = new PDFTextStripper();
        String text = stripper.getText(doc);
        System.out.println("Extracted Text:\n" + text);
        doc.close();
    }

    public void passwordProtect(String inputPath, String outputPath, String password) throws IOException {
        PDDocument doc = PDDocument.load(new File(inputPath));
        AccessPermission ap = new AccessPermission();
        StandardProtectionPolicy policy = new StandardProtectionPolicy(password, password, ap);
        policy.setEncryptionKeyLength(128);
        policy.setPermissions(ap);
        doc.protect(policy);
        doc.save(outputPath);
        doc.close();
        System.out.println("PDF password protected successfully!");
    }

    public void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
            System.out.println("Undo: Deleted " + filePath);
        } else {
            System.out.println("Undo: File not found to delete.");
        }
    }
}
