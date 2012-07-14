package edu.asu.bmi.greenes

import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
@TestFor(SearchController)
@Mock([GeneralRule, Concept, RuleConcept, SearchService])
class SearchControllerSpec extends Specification {
	GeneralRule rule = new GeneralRule(
		name:"HgA1C",
		description:"common test for Greenes group",
		logic: "order a test when HgA1c>0.7",
		author:"Bob Greenes"
    )
	
	public void setup(){
		given: "the existence of a rule"
		rule.save(failOnError:true)
	}
	
	void "the search should alert the user when an invalid criteria is given"(){
		when: "invalid criteria is provided"
			def bear = "bears"
			controller.params["criteria"] = bear
			controller.params["desired"] = "bipolar"
			controller.index()
		then: "The flash message should let the user know it was gobbledegook"
			flash.message != null 
	}
	
	void "The search should return nothing when invoked with non-existing data"() {
		when: "the search action is called by a query with non-existing data"
			controller.params["criteria"] = "rule"
			controller.params["desired"] = "Cancer"
			controller.index()
		then: "The results page should be shown, but the resuts should be empty"
			view == "/search/results"
			model.results == []
	}
	
    void "The search should return results by rule name when invoked"() {
        when: "the search action is called by a query with the rule name in it"
			controller.params["criteria"] = "rule"
			controller.params["desired"] = "HgA1C"
			controller.index()
		then: "The rule should be a part of the results"
			view == "/search/results"
			model.results == [rule]
	}
	
	void "The search should return results by author when invoked"() {
		when: "the search action is called by a query with the rule name in it"
			controller.params["criteria"] = "author"
			controller.params["desired"] = "Bob Greenes"
			controller.index()
		then: "The rule should be a part of the results"
			view == "/search/results"
			model.results == [rule]
	}
	
	void "The search should return results by concept when invoked"() {
		given: "The existence of a concept and rules with it"
			def diabetes = new Concept(
					name:"Diabetes",
					description:"a nasty autoimmune condition",
				).save(failOnError:true)
			def tests = new Concept(
				name:"Test",
				description:"a set of tests that can be performed on patients",
				).save(failOnError:true)
			RuleConcept.create(rule, diabetes)
			RuleConcept.create(rule, tests)
			rule.save(failOnError:true)
		when: "the search action is called by a query with the rule name in it"
			controller.params["criteria"] = "concept"
			controller.params["desired"] = "Diabetes"
			controller.index()
		then: "The rule should be a part of the results"
			view == "/search/results"
			model.results == [rule]
	}
}
