package edu.asu.bmi.greenes

import grails.test.mixin.*
import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Rule)
class RuleSpec extends spock.lang.Specification {

    void "A Rule should have a name that is not blank"() {
       given: "A rule, with either a blank name or real name"
	   	def rule = new Rule(name:ruleName, description:"a")
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
			def rule = new Rule(name:"new rule", description:"a")
			def rule2 = new Rule(name:"new rule", description:"b")
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
			def rule = new Rule(name:"new rule", description:desc)
		when: "I try to validate it"
			rule.validate()
		then: "a valid rule has a non-blank description, an invalid rule is blank"
			rule.hasErrors() == !valid
		where: "a valid rule has a description, an invalid rule is blank"
			desc | valid
			""	 | false
			"rule rocks" | true
	}
}