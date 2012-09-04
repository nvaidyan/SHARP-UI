package edu.asu.bmi.greenes.workflow

import spock.lang.Specification;

import grails.test.mixin.*
import grails.test.mixin.support.*

@TestMixin(GrailsUnitTestMixin)
@TestFor(Task)
class TaskSpec extends Specification {

	void "A task should have a name that is not blank"() {
		given: "A task, with either a blank name or real name"
			def task = new Task(name:name, description:"a")
		when: "I try to validate it"
			task.validate()
		then: "It should have errors if the name is blank"
			task.hasErrors() == !valid
		where: "a valid task has a name, an invalid task is blank"
			name    | valid
			""	    | false
			"HgA1c notification" | true
	}
	
	void "A task should have a description that is not blank"() {
		given: "A task with either a blank or non blank description"
			def task = new Task(name:"cool", description:desc)
		when: "I try to validate it"
			task.validate()
		then: "a valid task has a non-blank description, an invalid task is blank"
			task.hasErrors() == !valid
		where: "a valid task has a description, an invalid task is blank"
			desc             | valid
			""	             | false
			"valid task" | true
	}
	
	void "A task can have events"() {
		given: "A task with either a blank or non blank description"
			def task = new Task(name:"email doctor on results", description:"email the doctor when test results are received")
		and: "an event to associate with that task"
			def event = new BasicEvent(name:"results received", 
									   description:"test results computed",
									   occurred: new Date(), 
									   payload: [ "result" : 
										   					 [ 
																	"patient" : "tester" , 
																	"test" : "HgA1c", 
																	"level" : 0.745 
															 ] 
												])
		when: "I assign the event to the task"
			task.addToEvents(event)
		then: "the task should have those events"
			task.events != []
	}
}