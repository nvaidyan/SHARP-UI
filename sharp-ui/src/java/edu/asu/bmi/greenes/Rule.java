package edu.asu.bmi.greenes;

import java.util.Date;

public interface Rule {
	public abstract String getName();
	public abstract String getDescription();
	public abstract String getLogic();
	public abstract Date getLastUpdated();
	public abstract Date getDateCreated();
}
