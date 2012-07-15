package edu.asu.bmi.greenes

import org.springframework.dao.DataIntegrityViolationException

class PersonalizedRuleController {

    static allowedMethods = [create: ['GET', 'POST'], edit: ['GET', 'POST'], delete: 'POST']

    def index() {
        redirect action: 'list', params: params
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [personalizedRuleInstanceList: PersonalizedRule.list(params), personalizedRuleInstanceTotal: PersonalizedRule.count()]
    }

    def create() {
		switch (request.method) {
		case 'GET':
        	[personalizedRuleInstance: new PersonalizedRule(params)]
			break
		case 'POST':
	        def personalizedRuleInstance = new PersonalizedRule(params)
	        if (!personalizedRuleInstance.save(flush: true)) {
	            render view: 'create', model: [personalizedRuleInstance: personalizedRuleInstance]
	            return
	        }

			flash.message = message(code: 'default.created.message', args: [message(code: 'personalizedRule.label', default: 'PersonalizedRule'), personalizedRuleInstance.id])
	        redirect action: 'show', id: personalizedRuleInstance.id
			break
		}
    }

    def show() {
        def personalizedRuleInstance = PersonalizedRule.get(params.id)
        if (!personalizedRuleInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'personalizedRule.label', default: 'PersonalizedRule'), params.id])
            redirect action: 'list'
            return
        }

        [personalizedRuleInstance: personalizedRuleInstance]
    }

    def edit() {
		switch (request.method) {
		case 'GET':
	        def personalizedRuleInstance = PersonalizedRule.get(params.id)
	        if (!personalizedRuleInstance) {
	            flash.message = message(code: 'default.not.found.message', args: [message(code: 'personalizedRule.label', default: 'PersonalizedRule'), params.id])
	            redirect action: 'list'
	            return
	        }

	        [personalizedRuleInstance: personalizedRuleInstance]
			break
		case 'POST':
	        def personalizedRuleInstance = PersonalizedRule.get(params.id)
	        if (!personalizedRuleInstance) {
	            flash.message = message(code: 'default.not.found.message', args: [message(code: 'personalizedRule.label', default: 'PersonalizedRule'), params.id])
	            redirect action: 'list'
	            return
	        }

	        if (params.version) {
	            def version = params.version.toLong()
	            if (personalizedRuleInstance.version > version) {
	                personalizedRuleInstance.errors.rejectValue('version', 'default.optimistic.locking.failure',
	                          [message(code: 'personalizedRule.label', default: 'PersonalizedRule')] as Object[],
	                          "Another user has updated this PersonalizedRule while you were editing")
	                render view: 'edit', model: [personalizedRuleInstance: personalizedRuleInstance]
	                return
	            }
	        }

	        personalizedRuleInstance.properties = params

	        if (!personalizedRuleInstance.save(flush: true)) {
	            render view: 'edit', model: [personalizedRuleInstance: personalizedRuleInstance]
	            return
	        }

			flash.message = message(code: 'default.updated.message', args: [message(code: 'personalizedRule.label', default: 'PersonalizedRule'), personalizedRuleInstance.id])
	        redirect action: 'show', id: personalizedRuleInstance.id
			break
		}
    }

    def delete() {
        def personalizedRuleInstance = PersonalizedRule.get(params.id)
        if (!personalizedRuleInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'personalizedRule.label', default: 'PersonalizedRule'), params.id])
            redirect action: 'list'
            return
        }

        try {
            personalizedRuleInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'personalizedRule.label', default: 'PersonalizedRule'), params.id])
            redirect action: 'list'
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'personalizedRule.label', default: 'PersonalizedRule'), params.id])
            redirect action: 'show', id: params.id
        }
    }
}
