package edu.asu.bmi.greenes.workflow

import spock.lang.Specification;

import grails.test.mixin.*
import grails.test.mixin.support.*

@TestMixin(GrailsUnitTestMixin)
@TestFor(Workflow)
class WorkflowSpec extends Specification {

	void "A Workflow should have a name that is not blank"() {
		given: "A workflow, with either a blank name or real name"
			def workflow = new Workflow(name:name, description:"a")
		when: "I try to validate it"
			workflow.validate()
		then: "It should have errors if the name is blank"
			workflow.hasErrors() == !valid
		where: "a valid workflow has a name, an invalid workflow is blank"
			name    | valid
			""	    | false
			"HgA1c notification" | true
	}
	
	void "A workflow should have a description that is not blank"() {
		given: "A workflow with either a blank or non blank description"
			def workflow = new Workflow(name:"cool", description:desc)
		when: "I try to validate it"
			workflow.validate()
		then: "a valid workflow has a non-blank description, an invalid workflow is blank"
			workflow.hasErrors() == !valid
		where: "a valid workflow has a description, an invalid workflow is blank"
			desc             | valid
			""	             | false
			"valid workflow" | true
	}
	
}