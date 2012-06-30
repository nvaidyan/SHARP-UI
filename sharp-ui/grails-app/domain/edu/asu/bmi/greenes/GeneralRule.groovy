package edu.asu.bmi.greenes

class GeneralRule implements Rule {
	String name
	String description
	String logic
	Date lastUpdated
	Date dateCreated
	
    static constraints = {
		name blank : false, unique : true
		description blank : false
		logic minSize : 10
		lastUpdated()
		dateCreated()
	}
	
	static hasMany = [ concepts : Concept ]
}
