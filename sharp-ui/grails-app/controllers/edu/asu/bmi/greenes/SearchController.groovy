package edu.asu.bmi.greenes

class SearchController {
	def searchService
	
    def index() { 
		def results = []
		def crit = params.criteria
		if (!["author", "rule", "concept"].contains(crit)){
			flash.message = message(code: 'search.criteria.nonexistant', args: [crit])
		}
		switch(crit){
			case "rule":
				results = searchService.searchForRulesByName(params.desired)
				break
			case "concept":
				results = searchService.searchForRulesByConcept(params.desired)
				break
			case "author":
				results = searchService.searchForRulesByAuthor(params.desired)
				break
		}
		render view:"results", model : [results : results ]
	}
}
