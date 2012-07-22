import geb.Module

class NavigationModule extends Module {
	static content = {
		nav { $('ul.nav') }
		home { nav.find("home > a") }
		rules { nav.find("rules > a") }
		concepts { nav.find("concepts > a") }
		people { nav.find("people > a") }
	}
}
