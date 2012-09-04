package edu.asu.bmi.greenes.workflow

class Workflow {
	String name
	String description
	
	static hasMany = [ tasks : Task ]
	static constraints = {
		name blank:false, unique:true
		description blank:false
	}
}
