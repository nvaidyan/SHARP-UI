package edu.asu.bmi.greenes



import org.junit.*
import grails.test.mixin.*

@TestFor(ConceptController)
@Mock(Concept)
class ConceptControllerTests {


    def populateValidParams(params) {
      assert params != null
      params["name"] = 'HgA1C'
	  params["description"] = 'Common test for greenes group'
    }

    void testIndex() {
        controller.index()
        assert "/concept/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.conceptInstanceList.size() == 0
        assert model.conceptInstanceTotal == 0
    }

    void testCreate() {
	   request.method = "GET"
       def model = controller.create()

       assert model.conceptInstance != null
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/concept/list'


        populateValidParams(params)
        def concept = new Concept(params)

        assert concept.save() != null

        params.id = concept.id

        def model = controller.show()

        assert model.conceptInstance == concept
    }

    void testEdit() {
		request.method = "GET"
		controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/concept/list'


        populateValidParams(params)
        def concept = new Concept(params)

        assert concept.save() != null

        params.id = concept.id

        def model = controller.edit()

        assert model.conceptInstance == concept
    }

    
    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/concept/list'

        response.reset()

        populateValidParams(params)
        def concept = new Concept(params)

        assert concept.save() != null
        assert Concept.count() == 1

        params.id = concept.id

        controller.delete()

        assert Concept.count() == 0
        assert Concept.get(concept.id) == null
        assert response.redirectedUrl == '/concept/list'
    }
}
