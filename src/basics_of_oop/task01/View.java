package basics_of_oop.task01;

/*
 * Задача 1. Создать объект класса Текстовый файл, используя классы Файл, Директория.
 * Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить.
 */

public class View {
    
    public void showFileInfo(File file) {
	System.out.println(file.getName() + file.getExtension() + ", content: " + file.getContent());
    }
    
    public void showFileContent(Directory directory, String name) {
	for (File file : directory.getListOfFiles()) {
	    if (file.getName().equals(name)) {
		System.out.println(file.getContent());
	    }
	}
    }

    public void showListOfFiles(Directory directory) {
	for (File file : directory.getListOfFiles()) {
	    showFileInfo(file);
	}
    }
}
