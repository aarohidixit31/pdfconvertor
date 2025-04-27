import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PDFService service = new PDFService();
        TaskManager tasks = new TaskManager();
        UndoManager undo = new UndoManager();

        while (true) {
            System.out.println("\n========= PDF CONVERTER =========");
            System.out.println("1. Create Text to PDF");
            System.out.println("2. Merge PDFs");
            System.out.println("3. Split PDF");
            System.out.println("4. Extract Text from PDF");
            System.out.println("5. Password Protect PDF");
            System.out.println("6. Undo Last Operation");
            System.out.println("7. Show Task Queue");
            System.out.println("8. Exit");
            System.out.print("Choose Option: ");
            
            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter text to convert into PDF: ");
                        String text = sc.nextLine();
                        System.out.print("Enter output PDF file path: ");
                        String textPath = sc.nextLine();
                        service.createPDF(text, textPath);
                        tasks.addTask("Created PDF at " + textPath);
                        undo.addUndoAction(() -> service.deleteFile(textPath));
                        break;
                    case 2:
                        System.out.print("Enter number of PDFs to merge: ");
                        int n = sc.nextInt();
                        sc.nextLine();
                        String[] files = new String[n];
                        for (int i = 0; i < n; i++) {
                            System.out.print("Enter path of PDF " + (i + 1) + ": ");
                            files[i] = sc.nextLine();
                        }
                        System.out.print("Enter output merged PDF path: ");
                        String mergedPath = sc.nextLine();
                        service.mergePDFs(files, mergedPath);
                        tasks.addTask("Merged PDFs into " + mergedPath);
                        undo.addUndoAction(() -> service.deleteFile(mergedPath));
                        break;
                    case 3:
                        System.out.print("Enter path of PDF to split: ");
                        String splitPath = sc.nextLine();
                        System.out.print("Enter output folder path: ");
                        String outFolder = sc.nextLine();
                        service.splitPDF(splitPath, outFolder);
                        tasks.addTask("Split PDF " + splitPath);
                        // Not adding undo for split for simplicity
                        break;
                    case 4:
                        System.out.print("Enter PDF file path to extract text: ");
                        String extractPath = sc.nextLine();
                        service.extractText(extractPath);
                        tasks.addTask("Extracted text from " + extractPath);
                        break;
                    case 5:
                        System.out.print("Enter input PDF path: ");
                        String inputPath = sc.nextLine();
                        System.out.print("Enter output password-protected PDF path: ");
                        String outputPath = sc.nextLine();
                        System.out.print("Enter password: ");
                        String password = sc.nextLine();
                        service.passwordProtect(inputPath, outputPath, password);
                        tasks.addTask("Password protected PDF " + outputPath);
                        undo.addUndoAction(() -> service.deleteFile(outputPath));
                        break;
                    case 6:
                        undo.undoLastAction();
                        break;
                    case 7:
                        tasks.showTasks();
                        break;
                    case 8:
                        System.out.println("Exiting... Thank you!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Option!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
