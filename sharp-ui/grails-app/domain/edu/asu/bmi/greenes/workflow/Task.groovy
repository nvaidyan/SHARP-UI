package edu.asu.bmi.greenes.workflow

import edu.asu.bmi.greenes.Event 

class Task {
	String name
	String description
	
	static hasMany = [ events : Event ]
	
	static constraints = {
		name blank:false, unique:true
		description blank:false
	}
}
