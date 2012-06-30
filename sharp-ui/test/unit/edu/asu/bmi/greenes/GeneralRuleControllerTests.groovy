package edu.asu.bmi.greenes



import org.junit.*
import grails.test.mixin.*

@TestFor(GeneralRuleController)
@Mock(GeneralRule)
class GeneralRuleControllerTests {


    def populateValidParams(params) {
      assert params != null
      params["name"] = 'HgA1C'
	  params["description"] = 'Common test for greenes group'
	  params["logic"] = "If HgA1C > 0.7% Then conceive true Else conceive false"
	  
    }

    void testIndex() {
        controller.index()
        assert "/generalRule/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.generalRuleInstanceList.size() == 0
        assert model.generalRuleInstanceTotal == 0
    }

    void testCreate() {
	   request.method = "GET"
       def model = controller.create()

       assert model.generalRuleInstance != null
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/generalRule/list'


        populateValidParams(params)
        def generalRule = new GeneralRule(params)

        assert generalRule.save() != null

        params.id = generalRule.id

        def model = controller.show()

        assert model.generalRuleInstance == generalRule
    }

    void testEdit() {
		request.method = "GET"
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/generalRule/list'


        populateValidParams(params)
        def generalRule = new GeneralRule(params)

        assert generalRule.save() != null

        params.id = generalRule.id

        def model = controller.edit()

        assert model.generalRuleInstance == generalRule
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/generalRule/list'

        response.reset()

        populateValidParams(params)
        def generalRule = new GeneralRule(params)

        assert generalRule.save() != null
        assert GeneralRule.count() == 1

        params.id = generalRule.id

        controller.delete()

        assert GeneralRule.count() == 0
        assert GeneralRule.get(generalRule.id) == null
        assert response.redirectedUrl == '/generalRule/list'
    }
}
