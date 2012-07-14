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
@Mock(GeneralRule)
class SearchControllerSpec extends Specification {

	void "the search should alert the user when an invalid criteria is given"(){
		when: "invalid criteria is provided"
			def bear = "bears"
			controller.params["criteria"] = bear
			controller.params["desired"] = "bipolar"
			controller.index()
		then: "The flash message should let the user know it was gobbledegook"
			flash.message != null 
	}
	
    void "The search should return results by rule name when invoked"() {
        given: "The existence of a rule"
			def rule = new GeneralRule(	
							name:"HgA1C", 
							description:"common test for Greenes group",
							logic: "order a test when HgA1c>0.7"
					   ).save(failOnError:true)
		when: "the search action is called by a query with the rule name in it"
			controller.params["criteria"] = "rule"
			controller.params["desired"] = "HgA1C"
			controller.index()
		then: "The rule should be a part of the results"
			view == "/search/results"
			model.results == [rule]
	}
}
