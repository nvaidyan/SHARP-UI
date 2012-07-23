package edu.asu.bmi.greenes

class GeneralRule implements Rule {
	String name
	String description
	String logic = "This rule is illogical. No logic has been customized yet."
	String author = "unknown"
	Date lastUpdated
	Date dateCreated
	
    static constraints = {
		name blank : false, unique : true
		description blank : false
		logic minSize : 10
		author blank:true
		lastUpdated()
		dateCreated()
	}
	
	static hasMany = [ concepts : RuleConcept ]
	
	@Override
	public String toString(){ name }
}
