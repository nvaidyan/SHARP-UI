package edu.asu.bmi.greenes



import grails.test.mixin.*
import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Rule)
class RuleSpec extends spock.lang.Specification {

    void "A Rule should have a name that is not blank"() {
       given: "A rule with a blank name"
	   def rule = new Rule(name:ruleName)
	   when: "I try to validate it"
	   	rule.validate()
	   then: "It should have errors,and the error should be a blank name"
	   	rule.hasErrors() == !valid
	   where: "a valid rule has a name, an invalid rule is blank"
	   	ruleName | valid
		   ""	 | false
		   "myRule" | true
    }
}