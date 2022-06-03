package my.home.epam.module_5.task01.logic;

import java.util.ArrayList;

import my.home.epam.module_5.task01.entity.Directory;
import my.home.epam.module_5.task01.entity.File;

/*
 * Задача 1. Создать объект класса Текстовый файл, используя классы Файл, Директория.
 * Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить.
 */

public class FileLogic {

    public void createFile(Directory directory, File file) {
	if (directory.getListOfFiles() == null) {
	    directory.setListOfFiles(new ArrayList<File>());
	}
	directory.getListOfFiles().add(file);
    }

    public void renameFile(Directory directory, String name, String newName) {
	for (File file : directory.getListOfFiles()) {
	    if (file.getName().equals(name)) {
		file.setName(newName);
	    }
	}
    }

    public void addFileContent(Directory directory, String name, String content) {
	for (File file : directory.getListOfFiles()) {
	    if (file.getName().equals(name)) {
		String newContent = file.getContent() + content;
		file.setContent(newContent);
	    }
	}
    }

    public void deleteFile(Directory directory, String name) {
	directory.getListOfFiles().removeIf(file -> file.getName().equals(name));
    }
}