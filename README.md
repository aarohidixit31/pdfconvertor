# 📄 PDF Converter System (Console-Based)

This is a **Java-based console application** that allows users to **create, merge, split, extract text, and password-protect PDF files**.  
The project uses **Data Structures and Algorithms (DSA)** concepts like **Stack** and **Queue** for managing undo actions and task history.

---

## 📚 Features

- **Create PDF** from Text
- **Merge** multiple PDFs
- **Split** a PDF into individual pages
- **Extract text** from a PDF
- **Password protect** any PDF file
- **Undo** the last performed operation (using **Stack**)
- **Manage Tasks** using **Queue**

---

## 🛠️ Technologies Used

- **Java (JDK 17)**
- **Apache PDFBox Library**
- **Data Structures:** Stack and Queue
- **IDE:** VS Code / IntelliJ IDEA

---

## 📦 Project Structure
```plaintext
PDF_Converter_By_Aarohi/
├── src/
│   ├── Main.java
│   ├── PDFService.java
│   ├── TaskManager.java
│   └── UndoManager.java
│
├── lib/
│   └── pdfbox-app-2.0.34.jar
│
├── bin/              (compiled .class files)
│
└── README.md

```
---

## 🚀 How to Run

1. **Download and setup Apache PDFBox:**
   - Place `pdfbox-app-2.0.34.jar` inside the `lib/` folder.

2. **Compile the Java files:**
   ```bash
   javac -cp "lib/pdfbox-app-2.0.34.jar" src/*.java -d bin
3. **Run the Project:**
   - java -cp "lib/pdfbox-app-2.0.34.jar;bin" Main
     (Use ; for Windows and : for Mac/Linux)
## 🧠 Concepts Applied
**Stack:**
Undo functionality to reverse the last file operation.

**Queue:**
Maintaining the task history for all operations.

## ✍️ Developed By
Aarohi Dixit (2310990173)

**Supervisor:**
Mr. Sachin Garg

## 🎯 Conclusion
This project showcases real-world usage of Java, file handling, and DSA concepts.
It is a lightweight, efficient, offline PDF management system built entirely on the console.

