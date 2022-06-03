package my.home.epam.module_5.task03.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import my.home.epam.module_5.task03.entity.MyCalendar;

/*
 * Задача 3. Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о выходных и праздничных днях.
 */

public class Main {

    public static void main(String[] args) {
	MyCalendar calendar = initMyCalendar();

	printActions();

	while (true) {
	    initActions(calendar);
	    System.out.println();
	}
    }

    private static MyCalendar initMyCalendar() {
	Calendar startDate = Calendar.getInstance();
	Calendar endDate = Calendar.getInstance();

	startDate.set(2022, Calendar.JANUARY, 1);
	endDate.set(2022, Calendar.DECEMBER, 31);

	List<MyCalendar.Holiday> holidays = new ArrayList<MyCalendar.Holiday>();

	{
	    holidays.add(new MyCalendar.Holiday(new GregorianCalendar(2022, Calendar.MAY, 30), "Memorial Day"));
	    holidays.add(new MyCalendar.Holiday(new GregorianCalendar(2022, Calendar.JUNE, 20), "Juneteenth National Independence Day"));
	    holidays.add(new MyCalendar.Holiday(new GregorianCalendar(2022, Calendar.JULY, 4), "Independence Day"));
	    holidays.add(new MyCalendar.Holiday(new GregorianCalendar(2022, Calendar.SEPTEMBER, 5), "Labor Day"));
	    holidays.add(new MyCalendar.Holiday(new GregorianCalendar(2022, Calendar.OCTOBER, 10), "Columbus Day"));
	    holidays.add(new MyCalendar.Holiday(new GregorianCalendar(2022, Calendar.NOVEMBER, 11), "Veterans Day"));
	    holidays.add(new MyCalendar.Holiday(new GregorianCalendar(2022, Calendar.NOVEMBER, 24), "Thanksgiving Day"));
	    holidays.add(new MyCalendar.Holiday(new GregorianCalendar(2022, Calendar.DECEMBER, 26), "Christmas Day"));
	}

	return new MyCalendar(startDate, endDate, holidays);
    }

    private static void printActions() {
	System.out.println("Control panel: ");
	System.out.println("1. Show number of weekends");
	System.out.println("2. Show number of holidays");
	System.out.println("3. Show next holiday");
	System.out.println("4. Show list of holidays");
	System.out.println("0. Terminate the program");
	System.out.println();
    }

    private static void initActions(MyCalendar calendar) {
	ActionsLogic actionsLogic = new ActionsLogic();

	switch (inputNumber("Input a number: ")) {
	case 1 -> actionsLogic.showNumberOfWeekends(calendar);
	case 2 -> actionsLogic.showNumberOfHolidays(calendar);
	case 3 -> actionsLogic.showNextHoliday(calendar);
	case 4 -> actionsLogic.showListOfHolidays(calendar);
	case 0 -> actionsLogic.terminate();
	default -> initActions(calendar);
	}
    }

    public static int inputNumber(String message) {
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