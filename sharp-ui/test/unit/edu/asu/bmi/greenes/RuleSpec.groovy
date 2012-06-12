package edu.asu.bmi.greenes

import grails.test.mixin.*
import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Rule)
class RuleSpec extends Specification {
	Rule rule = new Rule( name:"Exercise when HgA1c too high", 
						  description: "Prescribe exercise when HgA1c > 7%", 
						  logic:"If HgA1C > 7% Then Tell Patient to Exercise")
	
    void "A Rule should have a name that is not blank"() {
       given: "A rule, with either a blank name or real name"
	   	rule.name = ruleName
	   when: "I try to validate it"
	   	rule.validate()
	   then: "It should have errors if the name is blank"
	   	rule.hasErrors() == !valid
		where: "a valid rule has a name, an invalid rule is blank"
	   	ruleName | valid
		   ""	 | false
		   "myRule" | true
    }
	
	void "A Rule should have a unique name"() {
		given: "two rules with identical names"
			def rule2 = new Rule(name:"Exercise when HgA1c too high", description:"b", logic:"illogical rule is illogical")
			mockForConstraintsTests(Rule, [rule, rule2])
		when: "I try to validate it"
			rule.save()
			rule2.validate()
		then: "It should have errors,and the error should be a unique name"
			rule2.hasErrors() == true
			"unique" == rule2.errors["name"]
	}
	
	void "A Rule should have a description that is not blank"() {
		given: "A rule with either a blank or non blank description"
			rule.description = desc
		when: "I try to validate it"
			rule.validate()
		then: "a valid rule has a non-blank description, an invalid rule is blank"
			rule.hasErrors() == !valid
		where: "a valid rule has a description, an invalid rule is blank"
			desc | valid
			""	 | false
			"rule rocks" | true
	}
	
	void "A Rule should have logic that is more than 10 characters, for understandabiity"() {
		given: "a Rule with logic that is too short"
			rule.logic = "a"
			mockForConstraintsTests(Rule, [rule])
		when: "I try to validate it"
			rule.validate()
		then: "It should have errors,and the error should be a unique name"
			rule.hasErrors() == true
			"minSize" == rule.errors["logic"]
	}
	
	void "A Rule should be able to have concepts added and searched by"() {
		given: "a Rule and a concept"
			def concept = new Concept(name:"HgA1C", description:"important test for Greenes group")
		when: "I add the concept to the rule, then try to find a rule by the concept"
			rule.addToConcepts(concept)
			rule.save()
			def result = Rule.findAllByConceptsInList([concept])
		then: "the original rule should be found"
			rule == result[0]
	}
}