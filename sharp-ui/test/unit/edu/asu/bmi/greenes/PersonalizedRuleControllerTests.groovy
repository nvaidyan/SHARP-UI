package edu.asu.bmi.greenes



import org.junit.*

import edu.asu.bmi.greenes.users.Person;
import grails.test.mixin.*

@TestFor(PersonalizedRuleController)
@Mock([PersonalizedRule, Person])
class PersonalizedRuleControllerTests {
	Person nick
	
	@Before
	public void setUp(){
		Person.metaClass.encodePassword = {  -> }
		nick = new Person(username:"nick", email:"nicholas.vaidyanathan@asu.edu", password:"youwish").save(flush:true)
	}

    def populateValidParams(params) {
      assert params != null
      params["name"] = 'HgA1C'
	  params["description"] = 'Common test for greenes group'
	  params["logic"] = "If HgA1C > 0.7% Then conceive true Else conceive false"
	  params["author"] = "Boo magoo"
	  params["dateCreated"] = new Date()
	  params["lastUpdated"] = new Date()
	  params["owner"] = nick
    }

    void testIndex() {
        controller.index()
        assert "/personalizedRule/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.personalizedRuleInstanceList.size() == 0
        assert model.personalizedRuleInstanceTotal == 0
    }

    void testCreate() {
	   request.method = "GET"
       def model = controller.create()

       assert model.personalizedRuleInstance != null
    }

	void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/personalizedRule/list'


        populateValidParams(params)
        def personalizedRule = new PersonalizedRule(params)

        assert personalizedRule.save() != null

        params.id = personalizedRule.id

        def model = controller.show()

        assert model.personalizedRuleInstance == personalizedRule
    }

    void testEdit() {
		request.method = "GET"
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/personalizedRule/list'


        populateValidParams(params)
        def personalizedRule = new PersonalizedRule(params)

		assert personalizedRule.save() != null

        params.id = personalizedRule.id

        def model = controller.edit()

        assert model.personalizedRuleInstance == personalizedRule
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/personalizedRule/list'

        response.reset()

        populateValidParams(params)
        def personalizedRule = new PersonalizedRule(params)

        assert personalizedRule.save() != null
        assert PersonalizedRule.count() == 1

        params.id = personalizedRule.id

        controller.delete()

        assert PersonalizedRule.count() == 0
        assert PersonalizedRule.get(personalizedRule.id) == null
        assert response.redirectedUrl == '/personalizedRule/list'
    }
}
