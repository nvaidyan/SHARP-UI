package edu.asu.bmi.greenes

import grails.test.mixin.*
import grails.test.mixin.support.*
import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
@TestFor(SearchService)
@Mock([GeneralRule, Concept, RuleConcept])
class SearchServiceSpec extends Specification {

   void "find rules by name"() {
        given: "A rule that exists"
			def hga1c = "HgA1C"
			def rule = new GeneralRule(
			name:hga1c,
			description:"common test for Greenes group",
			logic: "order a test when HgA1c>0.7"
			).save(failOnError:true)
		when: "I search for rules by name"
			def result = service.searchForRulesByName(hga1c)
		then: "the rule should be found"
			result == [rule]
    }
   
   void "find rules by author"() {
	   given: "A rule that exists"
		   def author = "Bob Greenes"
		   def rule = new GeneralRule(
		   name:"HgA1c",
		   description:"common test for Greenes group",
		   logic: "order a test when HgA1c>0.7",
		   author: author
		   ).save(failOnError:true)
	   when: "I search for rules by name"
		   def result = service.searchForRulesByAuthor(author)
	   then: "the rule should be found"
		   result == [rule]
   }
   
   void "find rules by concept"() {
	   given: "A rule that exists and has an associated concept"
		   def diabetes = "diabetes"
		   def concept = new Concept(name:diabetes, description:"a nasty autoimmune disease").save(failOnError:true)
		   def rule = new GeneralRule(
		   name:"HgA1C",
		   description:"common test for Greenes group",
		   logic: "order a test when HgA1c>0.7"
		   ).save(failOnError:true)
		   RuleConcept.create(rule, concept)
	   when: "I search for rules by name"
		   def result = service.searchForRulesByConcept(diabetes)
	   then: "the rule should be found"
		   result == [rule]
   }
}
