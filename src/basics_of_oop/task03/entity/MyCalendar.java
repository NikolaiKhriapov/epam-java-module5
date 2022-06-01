package basics_of_oop.task03.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/*
 * Задача 3. Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о выходных и праздничных днях.
 */

public class MyCalendar {
    private Calendar startDate;
    private Calendar endDate;
    private List<Holiday> holidays = new ArrayList<Holiday>();
    
    public MyCalendar(Calendar startDate, Calendar endDate, List<Holiday> holidays) {
	super();
	this.startDate = startDate;
	this.endDate = endDate;
	this.holidays = holidays;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public List<Holiday> getHolidays() {
        return holidays;
    }

    public void setHolidays(List<Holiday> holidays) {
        this.holidays = holidays;
    }

    
    public static class Holiday {
	private Calendar date;
	private String name;
	
	public Holiday(Calendar date, String name) {
	    super();
	    this.date = date;
	    this.name = name;
	}

	public Calendar getDate() {
	    return date;
	}

	public void setDate(Calendar date) {
	    this.date = date;
	}

	public String getName() {
	    return name;
	}

	public void setName(String name) {
	    this.name = name;
	}

	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((date == null) ? 0 : date.hashCode());
	    result = prime * result + ((name == null) ? 0 : name.hashCode());
	    return result;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
		return true;
	    if (obj == null)
		return false;
	    if (getClass() != obj.getClass())
		return false;
	    Holiday other = (Holiday) obj;
	    if (date == null) {
		if (other.date != null)
		    return false;
	    } else if (!date.equals(other.date))
		return false;
	    if (name == null) {
		if (other.name != null)
		    return false;
	    } else if (!name.equals(other.name))
		return false;
	    return true;
	}

	@Override
	public String toString() {
	    return "Holiday [date=" + date + ", name=" + name + "]";
	}
    }
}