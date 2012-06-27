package edu.asu.bmi.greenes.users

class RegisterController {

	def index() {
		[personInstance: new Person(params)]
	}

	def register() {

		def personInstance = new Person(params)
		if (!personInstance.save(flush: true)) {
			render view: 'index', model: [personInstance: personInstance]
			return
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'person.label', default: 'Person'),
			personInstance.id
		])
		redirect controller:'person', action: 'show', id: personInstance.id
	}
}
