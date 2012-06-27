package edu.asu.bmi.greenes.users

import grails.test.mixin.*
import grails.test.mixin.support.*

import spock.lang.*
/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
@TestFor(RegisterController)
@Mock(Person)
class RegisterControllerSpec extends Specification {

    void setup() {
        Person.metaClass.encodePassword = {  -> }
    }

    void tearDown() {
        // Tear down logic here
    }
	
	def populateValidParams(params) {
		assert params != null
		params["username"] = "Joe cool"
		params["email"] = "joe@cool.com"
		params["password"] = "abcdefghi"
	}

    void "registration index has a username, email, and password"() {
        when: "I try to access the registration page"
			def result = controller.index()
		then: "then I should get a person back with empty username, email, password"
			!result.username
			!result.password
			!result.email
    }
	
	void "when registration successful, person is saved"() {
		given: "I enter the details of a person I would like to register"
			populateValidParams(params)
		when: "I try to register"
			def result = controller.register()
		then: "then the person should be created"
			assert Person.count() == 1
		and: "I should be redirected to the person show page"
			assert controller.flash.message != null
			assert response.redirectedUrl == '/person/show/1'
	}
	
	void "when registration results in domain constraint violation, redirect back to page"() {
		given: "I enter the details of a person I would like to register, with invalid data such as a bad e-mail"
			populateValidParams(params)
			controller.params.email ="invalid.email"
		when: "I try to register"
			def result = controller.register()
		then: "then the registration should not happen.Redirect back to index"
			assert Person.count() == 0
			assert view == "/register/index"
	}
}
