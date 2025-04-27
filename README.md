PDF Converter System (Console-Based)
This is a Java-based console application that allows users to create, merge, split, extract text, and password-protect PDF files. The project implements Data Structures and Algorithms (DSA) concepts like Stack and Queue for managing undo actions and task history.

📚 Features
Create PDF from Text

Merge multiple PDFs

Split a PDF into individual pages

Extract text from a PDF

Password protect any PDF file

Undo the last performed operation (using Stack)

Manage all operations through a Task Queue

🛠️ Technologies Used
Java (JDK 17)

Apache PDFBox Library

Data Structures: Stack and Queue

IDE: VS Code / IntelliJ IDEA

📦 Project Structure
plaintext
Copy
Edit
PDF_Converter_By_Aarohi/
│
├── src/
│   ├── Main.java
│   ├── PDFService.java
│   ├── TaskManager.java
│   ├── UndoManager.java
│
├── lib/
│   └── pdfbox-app-2.0.34.jar
│
├── README.md
🚀 How to Run
Download and setup Apache PDFBox:
Place pdfbox-app-2.0.34.jar inside the lib/ folder.

Compile the Java files:

bash
Copy
Edit
javac -cp "lib/pdfbox-app-2.0.34.jar" src/*.java -d bin
Run the Project:

bash
Copy
Edit
java -cp "lib/pdfbox-app-2.0.34.jar;bin" Main
(Use ; for Windows and : for Mac/Linux)

🧠 Concepts Applied
Stack:
Used for implementing undo functionality for file operations.

Queue:
Used for maintaining the task history of the performed operations.

✍️ Developed By
Aarohi Dixit

Supervisor: Mr. Sachin Garg

🎯 Conclusion

This project demonstrates real-world usage of Java, file handling, and DSA concepts.
A simple, efficient, and offline PDF manager — built entirely on the console without any external GUI!

