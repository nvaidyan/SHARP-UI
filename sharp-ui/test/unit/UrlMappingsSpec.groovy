import grails.test.mixin.*

import edu.asu.bmi.greenes.users.PersonController
import edu.asu.bmi.greenes.GeneralRuleController
import edu.asu.bmi.greenes.ConceptController

@TestFor(UrlMappings)
@Mock([PersonController, GeneralRuleController, ConceptController])
class UrlMappingsSpec extends spock.lang.Specification {
	void "assert people url sugar resolves successfully"(){
		expect: "I try to go to /people"
			assertUrlMapping("/people", action:'list', controller:'person')
	}
	
	void "assert rule url sugar resolves successfully"(){
		expect: "I try to go to /rules"
			assertUrlMapping("/rules", action:'list', controller:'generalRule')
	}
	
	void "assert concept url sugar resolves successfully"(){
		expect: "I try to go to /concepts"
			assertUrlMapping("/concepts", action:'list', controller:'concept')
	}
}