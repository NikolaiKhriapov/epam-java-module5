package basics_of_oop.task02.database;

import java.util.ArrayList;
import java.util.List;

import basics_of_oop.task02.entity.Product;

/*
 * Задача 2. Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из нескольких товаров.
 */

public class ProductsDatabase {
    private List<Product> products = new ArrayList<Product>();
    
    {
	products.add(new Product("Milk", 1.15));
	products.add(new Product("Cottage Cheese", 0.59));
	products.add(new Product("Natural Yogurt", 0.70));
	products.add(new Product("Cherry Tomatoes 1lb", 1.29));
	products.add(new Product("Bananas 1lb", 0.77));
	products.add(new Product("Cheese Crackers", 2.19));
	products.add(new Product("Chocolate Cookies", 1.82));
    }

    public List<Product> getProducts() {
        return products;
    }
    
    public String printListOfProducts() {
	StringBuilder listOfProducts = new StringBuilder(products.get(0).getName());

	for (int i = 1; i < products.size(); i++) {
	    listOfProducts.append(", " + products.get(i).getName());
	}
	
	return listOfProducts.toString();
    }
}