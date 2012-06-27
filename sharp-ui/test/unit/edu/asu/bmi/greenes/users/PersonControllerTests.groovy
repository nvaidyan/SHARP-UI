package edu.asu.bmi.greenes.users



import org.junit.*
import grails.test.mixin.*

@TestFor(PersonController)
@Mock(Person)
class PersonControllerTests {

	@Before
	void setup() {
		Person.metaClass.encodePassword = {  -> }
	}

    def populateValidParams(params) {
      assert params != null
      params["username"] = "Joe cool"
	  params["email"] = "Joe@cool.com"
	  params["password"] = "dummy"
    }

    void testIndex() {
        controller.index()
        assert "/person/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.personInstanceList.size() == 0
        assert model.personInstanceTotal == 0
    }

    void testCreate() {
	   request.method = "GET"
       def model = controller.create()

       assert model.personInstance != null
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/person/list'


        populateValidParams(params)
        def person = new Person(params)

        assert person.save() != null

        params.id = person.id

        def model = controller.show()

        assert model.personInstance == person
    }

    void testEdit() {
		 request.method = "GET"
		 controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/person/list'


        populateValidParams(params)
        def person = new Person(params)

        assert person.save() != null

        params.id = person.id

        def model = controller.edit()

        assert model.personInstance == person
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/person/list'

        response.reset()

        populateValidParams(params)
        def person = new Person(params)

        assert person.save() != null
        assert Person.count() == 1

        params.id = person.id

        controller.delete()

        assert Person.count() == 0
        assert Person.get(person.id) == null
        assert response.redirectedUrl == '/person/list'
    }
}
