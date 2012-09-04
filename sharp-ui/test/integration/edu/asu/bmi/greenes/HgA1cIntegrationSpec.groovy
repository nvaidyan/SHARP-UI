package edu.asu.bmi.greenes

import edu.asu.bmi.greenes.*
import edu.asu.bmi.greenes.users.*
import edu.asu.bmi.greenes.workflow.*

class HgA1cIntegrationSpec extends spock.lang.Specification {

	def "doctor greenes can create a workflow of tasks to happen when a patient of his has an HgA1c test"(){
		given: "the existence of a user, doctor greenes"
			def greenes = new Person(username:"greenes", password:"fake", email:"greenes@asu.edu", enabled:true)
		and: "a patient, bob"
			def bob = new Person(username:"bob", password:"fake", email:"bob@patient.com", enabled:true) 
		and: "I have a workflow that I want triggered"
			def workflow = new Workflow(name:"email doctor on patient test", 
										description:"when a patient has a test, e-mail the doctor")
			def task = new Task(name:"email doc", description: "email doctor")
			workflow.addToTasks(task)
		and: "I have an event that I want to trigger the workflow"
			def causingEvent = new BasicEvent(name:"HgA1c test", description: "an HgA1c test is performed", occurred: new Date())
		and: "I set the workflow to trigger on the event"
			def trigger = new Trigger(name:"on HgA1c", description:"hga1c trigger", cause:causingEvent)
		when: "bob has an hga1c test"
			def event = new BasicEvent("bob has an HgA1Z test", description: "had it good", occurred: new Date())
		then: "greenes should receive an email"
			
		
	}
}
