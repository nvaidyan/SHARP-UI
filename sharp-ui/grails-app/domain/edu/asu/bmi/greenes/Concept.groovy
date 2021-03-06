package edu.asu.bmi.greenes

class Concept {
	String name
	String description
	
    static constraints = {
		name blank : false, unique : true
		description blank: false
    }
	
	static hasMany = [ 
		               parents : Concept, 
					   children: Concept,
					   rules : RuleConcept
					 ]
}
