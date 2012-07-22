import geb.Page

class RulesPage extends Page {
	static url= "generalRule/list"
	
	static at = {
		$("h1").text() == "General Rule List"
	}
	
	static content = {
		navigation  { module NavigationModule }
		
	}
}
