package my.home.epam.module_5.task01.entity;

/*
 * Задача 1. Создать объект класса Текстовый файл, используя классы Файл, Директория.
 * Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить.
 */

public class TextFile extends File {
    private String extension = ".txt";
    
    public TextFile() {
	super.setName("New_text_file");
	super.setContent("");
    }

    public String getExtension() {
        return this.extension;
    }

    public TextFile(String name, String content) {
	super.setName(name);
	super.setContent(content);
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((extension == null) ? 0 : extension.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (!super.equals(obj))
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	TextFile other = (TextFile) obj;
	if (extension == null) {
	    if (other.extension != null)
		return false;
	} else if (!extension.equals(other.extension))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "TextFile [name=" + super.getName() + ", extension=" + extension + ", content=" + super.getContent() + "]";
    }
}