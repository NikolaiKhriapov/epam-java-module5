package my.home.epam.module_5.task01.entity;

/*
 * Задача 1. Создать объект класса Текстовый файл, используя классы Файл, Директория.
 * Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить.
 */

public abstract class File {
    private String name;
    private String content;
    private String extension;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getContent() {
	return content;
    }

    public void setContent(String content) {
	this.content = content;
    }

    public String getExtension() {
	return extension;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((content == null) ? 0 : content.hashCode());
	result = prime * result + ((extension == null) ? 0 : extension.hashCode());
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
	File other = (File) obj;
	if (content == null) {
	    if (other.content != null)
		return false;
	} else if (!content.equals(other.content))
	    return false;
	if (extension == null) {
	    if (other.extension != null)
		return false;
	} else if (!extension.equals(other.extension))
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
	return "File [name=" + name + ", content=" + content + ", extension=" + extension + "]";
    }
}