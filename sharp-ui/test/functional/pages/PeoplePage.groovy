import geb.Page

class PeoplePage extends Page {
	static url= "person/list"
	
	static at = {
		$("h1").text() == "Person List"
	}
	
	static content = {
		navigation  { module NavigationModule }
		
	}
}