package edu.asu.bmi.greenes

class SearchController {

    def index() { 
		def results = []
		def crit = params.criteria
		if (!["author", "rule", "concept"].contains(crit)){
			flash.message = message(code: 'search.criteria.nonexistant', args: [crit])
		}
		else if(crit == "rule"){
			def rules = GeneralRule.findByName(params.desired)
			results.addAll(rules)
		}
		render view:"results", model : [results : results ]
	}
}
