package edu.asu.bmi.greenes

class SearchController {
	def searchService
	
    def index() { 
		def results = []
		def crit = params.criteria
		def desired = params.desired
		if (!["author", "rule", "concept"].contains(crit)){
			flash.message = message(code: 'search.criteria.nonexistant', args: [crit, desired])
		}
		switch(crit){
			case "rule":
				results = searchService.searchForRulesByName(desired)
				break
			case "concept":
				results = searchService.searchForRulesByConcept(desired)
				break
			case "author":
				results = searchService.searchForRulesByAuthor(desired)
				break
		}
		render view:"results", model : [results : results, criteria : crit, desired: desired ]
	}
}
