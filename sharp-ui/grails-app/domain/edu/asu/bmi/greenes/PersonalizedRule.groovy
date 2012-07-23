package edu.asu.bmi.greenes

import edu.asu.bmi.greenes.users.Person;

class PersonalizedRule implements Rule {
	String name
	String description
	String logic = "This rule is illogical. No logic has been customized yet."
	String author
	Date lastUpdated
	Date dateCreated
	
	GeneralRule variantOf
	
	static belongsTo = [ owner : Person ]
	
    static constraints = {
		name blank : false, unique : true
		description blank : false
		logic minSize : 10
		author blank:true
		lastUpdated()
		dateCreated()
		variantOf nullable:true
    }
	
	static hasMany = [ concepts : Concept ]
	
	static PersonalizedRule personalize(Rule rule, Person person){
		def newRule = new PersonalizedRule(rule.properties)
		Date timeStamp = new Date()
		newRule.dateCreated = timeStamp
		newRule.lastUpdated = timeStamp
		newRule.owner = person
		newRule.variantOf = rule
		newRule
	}}

