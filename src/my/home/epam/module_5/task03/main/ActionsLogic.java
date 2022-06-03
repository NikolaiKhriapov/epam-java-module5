package my.home.epam.module_5.task03.main;

import my.home.epam.module_5.task03.entity.MyCalendar;
import my.home.epam.module_5.task03.view.View;

/*
 * Задача 3. Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о выходных и праздничных днях.
 */

public class ActionsLogic {
    private View view = new View();
    
    // 1. Show number of weekends
    public void showNumberOfWeekends(MyCalendar calendar) {
	System.out.print("\n" + "Number of weekends: ");
	view.showNumberOfWeekends(calendar);
    }
    
    // 2. Show number of holidays
    public void showNumberOfHolidays(MyCalendar calendar) {
	System.out.print("\n" + "Number of holidays: ");
	view.showNumberOfHolidays(calendar);
    }
    
    // 3. Show next holiday
    public void showNextHoliday(MyCalendar calendar) {
	System.out.print("\n" + "The next holiday is ");
	view.showNextHoliday(calendar);
    }
    
    // 4. Show list of holidays
    public void showListOfHolidays(MyCalendar calendar) {
	System.out.println("\n" + "List of holidays:");
	view.showListOfHolidays(calendar);
    }
    
    // 0. Terminate the program
    public void terminate() {
	System.out.println("\n" + "Program terminated!");
	System.exit(0);
    }
}