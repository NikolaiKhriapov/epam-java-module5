package basics_of_oop.task02.main;

import java.util.Scanner;

import basics_of_oop.task02.entity.Payment;

/*
 * Задача 2. Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из нескольких товаров.
 */

/**
 * 
 * убрать totalAmount из payment
 *
 */

public class Main {

    public static void main(String[] args) {

	Payment payment = new Payment();

	printActions();

	while (true) {
	    initActions(payment);
	    System.out.println();
	}
    }
    
    private static void printActions() {
	System.out.println("Control panel:");
	System.out.println("1. Add new product to the list");
	System.out.println("2. Remove product from the list");
	System.out.println("3. Show list of products");
	System.out.println("4. Show total amount");
	System.out.println("0. Terminate the program");
	System.out.println();
    }
    
    private static void initActions(Payment payment) {
	ActionsLogic actionsLogic = new ActionsLogic();
	
	switch (inputNumber("Input a number: ")) {
	case 1 -> actionsLogic.addProductToList(payment);
	case 2 -> actionsLogic.removeProductFromList(payment);
	case 3 -> actionsLogic.showListOfProducts(payment);
	case 4 -> actionsLogic.showTotalAmount(payment);
	case 0 -> actionsLogic.terminate();
	default -> initActions(payment);
	}
    }
    
    private static int inputNumber(String message) {
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);
	
	System.out.print(message);
	while (!scanner.hasNextInt()) {
	    System.out.print(message);
	    scanner.next();
	}
	
	return scanner.nextInt();
    }
}