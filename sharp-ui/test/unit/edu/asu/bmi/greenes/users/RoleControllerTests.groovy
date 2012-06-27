package edu.asu.bmi.greenes.users



import org.junit.*
import grails.test.mixin.*

@TestFor(RoleController)
@Mock(Role)
class RoleControllerTests {


    def populateValidParams(params) {
      assert params != null
      params["authority"] = 'Admin'
	}

    void testIndex() {
        controller.index()
        assert "/role/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.roleInstanceList.size() == 0
        assert model.roleInstanceTotal == 0
    }

    void testCreate() {
		request.method = "GET"
	   def model = controller.create()
	   assert model.roleInstance != null
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/role/list'


        populateValidParams(params)
        def role = new Role(params)

        assert role.save() != null

        params.id = role.id

        def model = controller.show()

        assert model.roleInstance == role
    }

    void testEdit() {
		request.method = "GET"
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/role/list'


        populateValidParams(params)
        def role = new Role(params)

        assert role.save() != null

        params.id = role.id

        def model = controller.edit()

        assert model.roleInstance == role
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/role/list'

        response.reset()

        populateValidParams(params)
        def role = new Role(params)

        assert role.save() != null
        assert Role.count() == 1

        params.id = role.id

        controller.delete()

        assert Role.count() == 0
        assert Role.get(role.id) == null
        assert response.redirectedUrl == '/role/list'
    }
}
