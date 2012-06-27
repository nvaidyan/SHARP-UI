package edu.asu.bmi.greenes

import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class RuleControllerSpec {

	def populateValidParams(params) {
		assert params != null
		params["name"] = 'HgA1C'
		params["description"] = 'Common test among Greenes group'
		params["logic"] = 'If HgA1C < 10%, order a test'
	}
	
    void setUp() {
        // Setup logic here
    }

    void tearDown() {
        // Tear down logic here
    }

    void testSomething() {
        fail "Implement me"
    }
}
