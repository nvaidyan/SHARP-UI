package edu.asu.bmi.greenes.workflow

class Task {
	String name
	String description
	
	static constraints = {
		name blank:false, unique:true
		description blank:false
	}
}
