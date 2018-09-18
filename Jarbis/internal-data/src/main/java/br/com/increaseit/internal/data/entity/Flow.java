package br.com.increaseit.internal.data.entity;

import java.util.ArrayList;
import java.util.List;

import br.com.increaseit.common.constants.FlowFrequence;

public class Flow extends AEntity {


	/**
	 * 
	 */
	private static final long serialVersionUID = 251424678651379712L;
	private String name;
	private FlowFrequence frequence;
	private Interval interval;
	private List<WeekDay> weekDay;
	private List<DateScheduled> dateScheduled;
	private GroupAction groupAction;
	
	public Flow() {
		this.interval = new Interval();
		this.weekDay = new ArrayList<WeekDay>();
		this.dateScheduled = new ArrayList<DateScheduled>();		
		this.groupAction = new GroupAction();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public FlowFrequence getFrequence() {
		return frequence;
	}
	public void setFrequence(FlowFrequence frequence) {
		this.frequence = frequence;
	}
	
	public Interval getInterval() {
		return interval;
	}
	public void setInterval(Interval interval) {
		this.interval = interval;
	}

	public List<WeekDay> getWeekDay() {
		return weekDay;
	}
	public void setWeekDay(List<WeekDay> weekDay) {
		this.weekDay = weekDay;
	}
	public List<DateScheduled> getDateScheduled() {
		return dateScheduled;
	}
	public void setDateScheduled(List<DateScheduled> dateScheduled) {
		this.dateScheduled = dateScheduled;
	}

	public GroupAction getGroupAction() {
		return groupAction;
	}

	public void setGroupAction(GroupAction groupAction) {
		this.groupAction = groupAction;
	}

	

	
	
	
	
}
