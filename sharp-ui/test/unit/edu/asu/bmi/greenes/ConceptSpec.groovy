package edu.asu.bmi.greenes

import grails.test.mixin.support.*
import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
@TestFor(Concept)
class ConceptSpec extends Specification {

	void "A Concept should have a name that is not blank"() {
       given: "A concept, with either a blank name or real name"
	   	def concept = new Concept(name:name, description:"a")
	   when: "I try to validate it"
	   	concept.validate()
	   then: "It should have errors if the name is blank"
	   	concept.hasErrors() == !valid
		where: "a valid concept has a name, an invalid concept is blank"
	   		name | valid
		   ""	 | false
		   "HgA1c" | true
    }
	
	void "A Concept should have a unique name"() {
		given: "two concepts with identical names"
			def concept = new Concept(name:"HgA1C", description:"a")
			def concept2 = new Concept(name:"HgA1C", description:"a")
			mockForConstraintsTests(Concept, [concept, concept2])
		when: "I try to validate it"
			concept.save()
			concept2.validate()
		then: "It should have errors,and the error should be a unique name"
			concept2.hasErrors() == true
			"unique" == concept2.errors["name"]
	}
	
	void "A Concept should have a description that is not blank"() {
		given: "A concept with either a blank or non blank description"
			def concept = new Concept(name:"cool", description:desc)
		when: "I try to validate it"
			concept.validate()
		then: "a valid concept has a non-blank description, an invalid concept is blank"
			concept.hasErrors() == !valid
		where: "a valid concept has a description, an invalid concept is blank"
			desc | valid
			""	 | false
			"concept rocks" | true
	}
}