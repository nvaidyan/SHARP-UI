package edu.asu.bmi.greenes.workflow

import edu.asu.bmi.greenes.Event

class BasicEvent implements Event {
	String name
	String description
	Date occurred
	transient Object payload
	
	@Override
	public long getOccurrence() {
		return occurred?.fastTime;
	}
	
	static constraints = {
		name blank:false
		description blank:false
		occurrence()
	}	
}
