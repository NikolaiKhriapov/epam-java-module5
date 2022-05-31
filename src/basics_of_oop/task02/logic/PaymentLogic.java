package basics_of_oop.task02.logic;

import basics_of_oop.task02.database.ProductsDatabase;
import basics_of_oop.task02.entity.Payment;
import basics_of_oop.task02.entity.Product;

/*
 * Задача 2. Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из нескольких товаров.
 */

public class PaymentLogic {

    public void addProductToList(ProductsDatabase productsDatabase, Payment payment, String productToBeAdded) {
	for (Product product : productsDatabase.getProducts()) {
	    if (product.getName().equals(productToBeAdded)) {
		payment.getListOfProducts().add(product);
	    }
	}
    }

    public void removeProductFromList(Payment payment, String productToBeRemoved) {
	payment.getListOfProducts().removeIf(product -> product.getName().equals(productToBeRemoved));
    }
}