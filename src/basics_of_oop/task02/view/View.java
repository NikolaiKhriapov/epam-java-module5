package basics_of_oop.task02.view;

import java.util.Locale;

import basics_of_oop.task02.entity.Payment;

/*
 * Задача 2. Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из нескольких товаров.
 */

public class View {

    public void showProductInfo(Payment.Product product) {
	System.out.println(product.getName() + " – $" + product.getPrice());
    }
    
    public void showListOfProductsInfo(Payment payment) {
	if ((payment.getListOfProducts() == null) || (payment.getListOfProducts().size() == 0)) {
	    System.out.println("The list is empty!");
	} else {
	    for (Payment.Product product : payment.getListOfProducts()) {
		showProductInfo(product);
	    }
	}
    }

    public void showTotalAmount(Payment payment) {
	double totalAmount = 0;
	
	for (Payment.Product product : payment.getListOfProducts()) {
	    totalAmount += product.getPrice();
	}
	System.out.printf(Locale.ROOT, "%.2f", totalAmount); // Locale.ROOT - чтобы разделителем была точка, а не запятая
    }
}