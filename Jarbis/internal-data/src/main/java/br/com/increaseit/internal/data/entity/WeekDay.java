package br.com.increaseit.internal.data.entity;

import br.com.increaseit.common.constants.EnumWeekDay;

public class WeekDay extends Schedule{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1278156522936110562L;
	private EnumWeekDay weekDay;
	private String time;

	public EnumWeekDay getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(EnumWeekDay weekDay) {
		this.weekDay = weekDay;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
	
}
