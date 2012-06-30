package edu.asu.bmi.greenes

import org.springframework.dao.DataIntegrityViolationException

class ConceptController {

    static allowedMethods = [create: ['GET', 'POST'], edit: ['GET', 'POST'], delete: 'POST']

    def index() {
        redirect action: 'list', params: params
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [conceptInstanceList: Concept.list(params), conceptInstanceTotal: Concept.count()]
    }

    def create() {
		switch (request.method) {
		case 'GET':
        	[conceptInstance: new Concept(params)]
			break
		case 'POST':
	        def conceptInstance = new Concept(params)
	        if (!conceptInstance.save(flush: true)) {
	            render view: 'create', model: [conceptInstance: conceptInstance]
	            return
	        }

			flash.message = message(code: 'default.created.message', args: [message(code: 'concept.label', default: 'Concept'), conceptInstance.id])
	        redirect action: 'show', id: conceptInstance.id
			break
		}
    }

    def show() {
        def conceptInstance = Concept.get(params.id)
        if (!conceptInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'concept.label', default: 'Concept'), params.id])
            redirect action: 'list'
            return
        }

        [conceptInstance: conceptInstance]
    }

    def edit() {
		switch (request.method) {
		case 'GET':
	        def conceptInstance = Concept.get(params.id)
	        if (!conceptInstance) {
	            flash.message = message(code: 'default.not.found.message', args: [message(code: 'concept.label', default: 'Concept'), params.id])
	            redirect action: 'list'
	            return
	        }

	        [conceptInstance: conceptInstance]
			break
		case 'POST':
	        def conceptInstance = Concept.get(params.id)
	        if (!conceptInstance) {
	            flash.message = message(code: 'default.not.found.message', args: [message(code: 'concept.label', default: 'Concept'), params.id])
	            redirect action: 'list'
	            return
	        }

	        if (params.version) {
	            def version = params.version.toLong()
	            if (conceptInstance.version > version) {
	                conceptInstance.errors.rejectValue('version', 'default.optimistic.locking.failure',
	                          [message(code: 'concept.label', default: 'Concept')] as Object[],
	                          "Another user has updated this Concept while you were editing")
	                render view: 'edit', model: [conceptInstance: conceptInstance]
	                return
	            }
	        }

	        conceptInstance.properties = params

	        if (!conceptInstance.save(flush: true)) {
	            render view: 'edit', model: [conceptInstance: conceptInstance]
	            return
	        }

			flash.message = message(code: 'default.updated.message', args: [message(code: 'concept.label', default: 'Concept'), conceptInstance.id])
	        redirect action: 'show', id: conceptInstance.id
			break
		}
    }

    def delete() {
        def conceptInstance = Concept.get(params.id)
        if (!conceptInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'concept.label', default: 'Concept'), params.id])
            redirect action: 'list'
            return
        }

        try {
            conceptInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'concept.label', default: 'Concept'), params.id])
            redirect action: 'list'
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'concept.label', default: 'Concept'), params.id])
            redirect action: 'show', id: params.id
        }
    }
}
