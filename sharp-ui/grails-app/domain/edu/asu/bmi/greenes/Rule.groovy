package edu.asu.bmi.greenes

class Rule {
	String name
	String description
	String logic
	
    static constraints = {
		name blank : false, unique : true
		description blank : false
		logic minSize : 10
	}
	
	static hasMany = [ concepts : Concept ]
}
