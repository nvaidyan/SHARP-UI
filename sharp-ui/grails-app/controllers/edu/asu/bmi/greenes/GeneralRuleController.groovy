package edu.asu.bmi.greenes

import org.springframework.dao.DataIntegrityViolationException

class GeneralRuleController {

    static allowedMethods = [create: ['GET', 'POST'], edit: ['GET', 'POST'], delete: 'POST']

    def index() {
        redirect action: 'list', params: params
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [generalRuleInstanceList: GeneralRule.list(params), generalRuleInstanceTotal: GeneralRule.count()]
    }

    def create() {
		switch (request.method) {
		case 'GET':
        	[generalRuleInstance: new GeneralRule(params)]
			break
		case 'POST':
	        def generalRuleInstance = new GeneralRule(params)
	        if (!generalRuleInstance.save(flush: true)) {
	            render view: 'create', model: [generalRuleInstance: generalRuleInstance]
	            return
	        }

			flash.message = message(code: 'default.created.message', args: [message(code: 'generalRule.label', default: 'GeneralRule'), generalRuleInstance.id])
	        redirect action: 'show', id: generalRuleInstance.id
			break
		}
    }
	
	def editLogic(){
		def generalRuleInstance = GeneralRule.get(params.id)
        if (!generalRuleInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'generalRule.label', default: 'GeneralRule'), params.id])
            redirect action: 'list'
            return
        }

        [generalRuleInstance: generalRuleInstance]
	}

    def show() {
        def generalRuleInstance = GeneralRule.get(params.id)
        if (!generalRuleInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'generalRule.label', default: 'GeneralRule'), params.id])
            redirect action: 'list'
            return
        }

        [generalRuleInstance: generalRuleInstance]
    }

    def edit() {
		switch (request.method) {
		case 'GET':
	        def generalRuleInstance = GeneralRule.get(params.id)
	        if (!generalRuleInstance) {
	            flash.message = message(code: 'default.not.found.message', args: [message(code: 'generalRule.label', default: 'GeneralRule'), params.id])
	            redirect action: 'list'
	            return
	        }

	        [generalRuleInstance: generalRuleInstance]
			break
		case 'POST':
	        def generalRuleInstance = GeneralRule.get(params.id)
	        if (!generalRuleInstance) {
	            flash.message = message(code: 'default.not.found.message', args: [message(code: 'generalRule.label', default: 'GeneralRule'), params.id])
	            redirect action: 'list'
	            return
	        }

	        if (params.version) {
	            def version = params.version.toLong()
	            if (generalRuleInstance.version > version) {
	                generalRuleInstance.errors.rejectValue('version', 'default.optimistic.locking.failure',
	                          [message(code: 'generalRule.label', default: 'GeneralRule')] as Object[],
	                          "Another user has updated this GeneralRule while you were editing")
	                render view: 'edit', model: [generalRuleInstance: generalRuleInstance]
	                return
	            }
	        }

	        generalRuleInstance.properties = params

	        if (!generalRuleInstance.save(flush: true)) {
	            render view: 'edit', model: [generalRuleInstance: generalRuleInstance]
	            return
	        }

			flash.message = message(code: 'default.updated.message', args: [message(code: 'generalRule.label', default: 'GeneralRule'), generalRuleInstance.id])
	        redirect action: 'show', id: generalRuleInstance.id
			break
		}
    }

    def delete() {
        def generalRuleInstance = GeneralRule.get(params.id)
        if (!generalRuleInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'generalRule.label', default: 'GeneralRule'), params.id])
            redirect action: 'list'
            return
        }

        try {
            generalRuleInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'generalRule.label', default: 'GeneralRule'), params.id])
            redirect action: 'list'
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'generalRule.label', default: 'GeneralRule'), params.id])
            redirect action: 'show', id: params.id
        }
    }
}
