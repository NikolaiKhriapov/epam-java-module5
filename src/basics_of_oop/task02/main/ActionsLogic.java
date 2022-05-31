package basics_of_oop.task02.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import basics_of_oop.task02.database.ProductsDatabase;
import basics_of_oop.task02.entity.Payment;
import basics_of_oop.task02.entity.Product;
import basics_of_oop.task02.logic.PaymentLogic;
import basics_of_oop.task02.view.View;

/*
 * Задача 2. Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из нескольких товаров.
 */

public class ActionsLogic {
    ProductsDatabase productsDatabase = new ProductsDatabase();
    PaymentLogic logic = new PaymentLogic();
    View view = new View();

    // 1. Add new product to the list
    public void addProductToList(Payment payment) {
	if (payment.getListOfProducts() == null) {
	    payment.setListOfProducts(new ArrayList<Product>());
	}

	String productToBeAdded = inputString("Input product name: ");

	boolean isPresent = checkIfOnTheList(productsDatabase.getProducts(), productToBeAdded);

	if (isPresent) {
	    logic.addProductToList(productsDatabase, payment, productToBeAdded);
	    System.out.println("\n" + "Product added to the shopping list.");
	} else {
	    System.out.println("Product not found!");
	}
    }

    // 2. Remove product from the list
    public void removeProductFromList(Payment payment) {
	String productToBeRemoved = inputString("Input product name: ");

	boolean isPresent = checkIfOnTheList(payment.getListOfProducts(), productToBeRemoved);

	if (isPresent) {
	    logic.removeProductFromList(payment, productToBeRemoved);
	    System.out.println("\n" + "Product removed from the shopping list.");
	} else {
	    System.out.println("Product not found!");
	}
    }

    // 3. Show list of products
    public void showListOfProducts(Payment payment) {
	System.out.println("\n" + "Shopping list:");
	view.showListOfProducts(payment);
    }

    // 4. Show total amount
    public void showTotalAmount(Payment payment) {
	System.out.print("Total amount: $");
	view.showTotalAmount(payment);
	System.out.println();
    }

    // 0. Terminate the program
    public void terminate() {
	System.out.println("Program terminated!");
	System.exit(0);
    }

    // Other
    private static String inputString(String message) {
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);

	System.out.print(message);
	while (!scanner.hasNextLine()) {
	    System.out.print(message);
	    scanner.next();
	}

	return scanner.nextLine();
    }

    private static boolean checkIfOnTheList(List<Product> listOfProducts, String productName) {
	boolean isPresent = false;

	int count = 0;
	for (Product product : listOfProducts) {
	    if (product.getName().equals(productName)) {
		count++;
	    }
	}
	if (count > 0) {
	    isPresent = true;
	}

	return isPresent;
    }
}
