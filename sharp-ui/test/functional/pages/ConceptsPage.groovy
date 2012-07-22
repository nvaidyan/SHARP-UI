import geb.Page

class ConceptsPage extends Page {
	static url= "concept/list"
	
	static at = {
		$("h1").text() == "Concept List"
	}
	
	static content = {
		navigation  { module NavigationModule }
		
	}
}
