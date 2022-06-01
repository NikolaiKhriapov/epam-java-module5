package basics_of_oop.task03.view;

import java.util.Calendar;

import basics_of_oop.task03.entity.MyCalendar;
import basics_of_oop.task03.logic.MyCalendarLogic;

/*
 * Задача 3. Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о выходных и праздничных днях.
 */

public class View {
    private MyCalendarLogic logic = new MyCalendarLogic();

    public void showNumberOfWeekends(MyCalendar calendar) {
	int noOfWeekends = logic.findNoOfWeekends(calendar);
	System.out.println(noOfWeekends);
    }

    public void showNumberOfHolidays(MyCalendar calendar) {
	int noOfHolidays = logic.findNoOfHolidays(calendar);
	System.out.println(noOfHolidays);
    }

    public void showNextHoliday(MyCalendar calendar) {
	showHolidayInfo(logic.findNextHoliday(calendar));
    }
    
    public void showListOfHolidays(MyCalendar calendar) {
	for (MyCalendar.Holiday holiday : calendar.getHolidays()) {
	    showHolidayInfo(holiday);
	}
    }
    
    public void showHolidayInfo(MyCalendar.Holiday holiday) {
	String name = holiday.getName();
	int dayOfMonth = holiday.getDate().get(Calendar.DAY_OF_MONTH);
	int month = holiday.getDate().get(Calendar.MONTH) + 1;
	int year = holiday.getDate().get(Calendar.YEAR);
	
	System.out.println(name + ", " + dayOfMonth + "." + month + "." + year);
    }
}