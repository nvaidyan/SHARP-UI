import geb.Page

class IndexPage extends Page {
	static url= "index"
	
	static at = {
		$("h1").text() == "Welcome to SHARP Rules"
	}
	
	static content = {
		navigation  { module NavigationModule }
	}
}
