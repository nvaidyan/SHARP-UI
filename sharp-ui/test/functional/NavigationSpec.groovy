import geb.spock.GebReportingSpec

import spock.lang.*

import pages.*

@Stepwise
class NavgationSpec extends GebReportingSpec {

	def "when one clicks on home, one goes back to the index"() {
		when: "we click on the navigation's home link"
			to IndexPage
			navigation().home().click()
		then: "we should be back at the home page"
			at IndexPage
	}
	
	@Override 
	String getBaseUrl() {
		super.baseUrl ?: "http://localhost:8080"
	}
}