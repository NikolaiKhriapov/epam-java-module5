package basics_of_oop.task01.entity;

import java.util.ArrayList;
import java.util.List;

/*
 * Задача 1. Создать объект класса Текстовый файл, используя классы Файл, Директория.
 * Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить.
 */

public class Directory {
    private String name;
    private List<File> listOfFiles = new ArrayList<File>();
    
    public Directory() {
	super();
    }

    public Directory(String name, List<File> listOfFiles) {
	super();
	this.name = name;
	this.listOfFiles = listOfFiles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<File> getListOfFiles() {
        return listOfFiles;
    }

    public void setListOfFiles(List<File> listOfFiles) {
        this.listOfFiles = listOfFiles;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((listOfFiles == null) ? 0 : listOfFiles.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Directory other = (Directory) obj;
	if (listOfFiles == null) {
	    if (other.listOfFiles != null)
		return false;
	} else if (!listOfFiles.equals(other.listOfFiles))
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Directory [name=" + name + ", listOfFiles=" + listOfFiles + "]";
    }
}