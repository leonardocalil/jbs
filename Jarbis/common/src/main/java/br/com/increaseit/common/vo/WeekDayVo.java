package br.com.increaseit.common.vo;

import br.com.increaseit.common.constants.EnumWeekDay;

public class WeekDayVo extends ScheduleVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6595241402279841618L;
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
