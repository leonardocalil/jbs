package br.com.increaseit.internal.data.entity;

import java.util.Date;

public class DateScheduled extends Schedule {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6681111404847955166L;
	private Date dateTime;

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	
	
}
