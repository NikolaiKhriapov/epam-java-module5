package my.home.epam.module_5.task02.logic;

import my.home.epam.module_5.task02.entity.Payment;

/*
 * Задача 2. Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из нескольких товаров.
 */

public class PaymentLogic {

    public void addProductToList(Payment payment, String productName, double productPrice) {
		payment.getListOfProducts().add(new Payment.Product(productName, productPrice));
    }

    public void removeProductFromList(Payment payment, String productToBeRemoved) {
	payment.getListOfProducts().removeIf(product -> product.getName().equals(productToBeRemoved));
    }
}