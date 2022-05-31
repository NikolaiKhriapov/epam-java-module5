package basics_of_oop.task01;

import java.util.Scanner;

/*
 * Задача 1. Создать объект класса Текстовый файл, используя классы Файл, Директория.
 * Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить.
 */

public class Main {

    public static void main(String[] args) {

	Directory directory = new Directory();

	showActions();

	while (true) {
	    initActions(directory);
	    System.out.println();
	}
    }

    private static void showActions() {
	System.out.println("Control panel:");
	System.out.println("1. Show files in directory");
	System.out.println("2. Create new text file");
	System.out.println("3. Rename file");
	System.out.println("4. Show file content");
	System.out.println("5. Add content to file");
	System.out.println("6. Delete file");
	System.out.println("0. Terminate the program");
	System.out.println();
    }

    private static void initActions(Directory directory) {
	ActionsLogic actionsLogic = new ActionsLogic();

	switch (inputNumber("Input a number: ")) {
	case 1 -> actionsLogic.showListOfFilesInDirectory(directory);
	case 2 -> actionsLogic.createNewTextFile(directory);
	case 3 -> actionsLogic.renameFile(directory);
	case 4 -> actionsLogic.showFileContent(directory);
	case 5 -> actionsLogic.addContentToFile(directory);
	case 6 -> actionsLogic.deleteFile(directory);
	case 0 -> actionsLogic.terminate();
	default -> initActions(directory);
	}
    }

    private static int inputNumber(String message) {
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);

	System.out.print(message);
	while (!scanner.hasNextInt()) {
	    System.out.print(message);
	    scanner.next();
	}
	return scanner.nextInt();
    }
}