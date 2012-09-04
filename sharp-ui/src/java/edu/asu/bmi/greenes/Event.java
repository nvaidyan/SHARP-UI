package edu.asu.bmi.greenes;

public interface Event {
	public abstract String getName();
	public abstract String getDescription();
	/**
	 * getOccurence() returns the time the event triggered. 
	 * 
	 * @return long -- allows for platform independence by ensuring cross-platform date since epoch (1/1/1970)
	 */
	public abstract long getOccurrence();
	public Object getPayload();
}
