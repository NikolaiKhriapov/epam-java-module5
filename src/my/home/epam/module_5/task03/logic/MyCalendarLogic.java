package my.home.epam.module_5.task03.logic;

import java.util.Calendar;
import java.util.GregorianCalendar;

import my.home.epam.module_5.task03.entity.MyCalendar;

/*
 * Задача 3. Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о выходных и праздничных днях.
 */

public class MyCalendarLogic {

    public int findNoOfWeekends(MyCalendar calendar) {
	Calendar temp = GregorianCalendar.getInstance();
	temp.setTime(calendar.getStartDate().getTime());

	int countOfWeekends = 0;
	while (calendar.getStartDate().before(calendar.getEndDate())) {
	    if ((calendar.getStartDate().get(Calendar.DAY_OF_WEEK) == (Calendar.SATURDAY)) || (calendar.getStartDate().get(Calendar.DAY_OF_WEEK) == (Calendar.SATURDAY))) {
		countOfWeekends++;
	    }
	    calendar.getStartDate().add(Calendar.DAY_OF_YEAR, 1);
	}

	calendar.getStartDate().setTime(temp.getTime());

	return countOfWeekends;
    }

    public int findNoOfHolidays(MyCalendar calendar) {
	Calendar temp = GregorianCalendar.getInstance();
	temp.setTime(calendar.getStartDate().getTime());

	int countOfHolidays = 0;
	while (calendar.getStartDate().before(calendar.getEndDate())) {

	    for (MyCalendar.Holiday holiday : calendar.getHolidays()) {
		if (calendar.getStartDate().get(Calendar.DAY_OF_YEAR) == holiday.getDate().get(Calendar.DAY_OF_YEAR)) {
		    countOfHolidays++;
		}
	    }
	    calendar.getStartDate().add(Calendar.DAY_OF_YEAR, 1);
	}

	calendar.getStartDate().setTime(temp.getTime());

	return countOfHolidays;
    }

    public MyCalendar.Holiday findNextHoliday(MyCalendar calendar) {
	Calendar today = GregorianCalendar.getInstance();

	MyCalendar.Holiday nextHoliday = calendar.getHolidays().get(calendar.getHolidays().size() - 1);
	for (int i = 0; i < calendar.getHolidays().size() - 1; i++) {
	    if (today.after(calendar.getHolidays().get(i).getDate())) {
		nextHoliday = calendar.getHolidays().get(i + 1);
		continue;
	    }
	}

	return nextHoliday;
    }
}