package edu.asu.bmi.greenes

class SearchService {

	def searchForRulesByName(String toSearchFor){
		def rules = GeneralRule.findAllByName(toSearchFor) 
		return rules ? rules : []
	}
	
	def searchForRulesByAuthor(String toSearchFor){
		def rules = GeneralRule.findAllByAuthor(toSearchFor)
		return rules ? rules : []
	}
	
	def searchForRulesByConcept(String toSearchFor){
		def results = []
		def concepts = Concept.findAllByName(toSearchFor)
		if(concepts){
			concepts.each{
				def rc = RuleConcept.findAllByConcept(it)
				rc.each{
					results.addAll(it.rule)
				}
			}
		}
		return results
	}
}
