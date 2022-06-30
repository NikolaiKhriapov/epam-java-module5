package my.home.epam.module_5.task01.main;

import java.util.Scanner;

import my.home.epam.module_5.task01.entity.Directory;
import my.home.epam.module_5.task01.entity.File;
import my.home.epam.module_5.task01.entity.TextFile;
import my.home.epam.module_5.task01.logic.FileLogic;
import my.home.epam.module_5.task01.view.View;

/*
 * Задача 1. Создать объект класса Текстовый файл, используя классы Файл, Директория.
 * Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить.
 */

public class ActionsLogic {
    private FileLogic fileLogic = new FileLogic();
    private View view = new View();

    // 1. Show files in directory
    public void showListOfFilesInDirectory(Directory directory) {
	if (directory.getListOfFiles().size() == 0) {
	    System.out.println("No files found!");
	} else {
	    System.out.println("List of files:");
	    view.showListOfFiles(directory);
	}
    }

    // 2. Create new text file
    public void createNewTextFile(Directory directory) {
	fileLogic.createFile(directory, new TextFile());
	System.out.println("New text file created!");
    }

    // 3. Rename file
    public void renameFile(Directory directory) {
	String oldFileName;
	String newFileName;

	oldFileName = inputText("Input file name: ");

	boolean isExisting = checkIfFileExists(directory, oldFileName);

	if (!isExisting) {
	    System.out.println("File not found!");
	} else {
	    newFileName = inputText("Input new file name: ");
	    for (File file : directory.getListOfFiles()) {
		if (file.getName().equals(oldFileName)) {
		    fileLogic.renameFile(directory, oldFileName, newFileName);
		}
	    }
	}
    }

    // 4. Show file content
    public void showFileContent(Directory directory) {
	String fileName = inputText("Input file name: ");

	boolean isExisting = checkIfFileExists(directory, fileName);

	if (!isExisting) {
	    System.out.println("File not found!");
	} else {
	    view.showFileContent(directory, fileName);
	}
    }

    // 5. Add content to file
    public void addContentToFile(Directory directory) {
	String fileName = inputText("Input file name: ");
	String newContent = inputText("Input new content: ");

	boolean isExisting = checkIfFileExists(directory, fileName);

	if (!isExisting) {
	    System.out.println("File not found!");
	} else {
	    for (File file : directory.getListOfFiles()) {
		if (file.getName().equals(fileName)) {
		    fileLogic.addFileContent(directory, fileName, newContent);
		}
	    }
	}
    }

    // 6. Delete file
    public void deleteFile(Directory directory) {
	String fileName = inputText("Input file name: ");

	boolean isExisting = checkIfFileExists(directory, fileName);

	if (!isExisting) {
	    System.out.println("File not found!");
	} else {
	    fileLogic.deleteFile(directory, fileName);
	}
    }

    // 0. Terminate the program
    public void terminate() {
	System.out.println("Program terminated!");
	System.exit(0);
    }
    
    // Other
    private static String inputText(String message) {
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);

	System.out.print(message);
	while (!scanner.hasNextLine()) {
	    System.out.print(message);
	    scanner.next();
	}
	return scanner.nextLine();
    }

    private static boolean checkIfFileExists(Directory directory, String fileName) {
	boolean isExisting = false;

	for (File file : directory.getListOfFiles()) {
	    if (file.getName().equals(fileName)) {
		isExisting = true;
	    }
	}

	return isExisting;
    }
}
