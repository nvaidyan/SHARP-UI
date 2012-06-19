package edu.asu.bmi.greenes.users

class PersonController {
    static scaffold = true
	
	def register() {
		[ person : new Person() ]
	}
}
