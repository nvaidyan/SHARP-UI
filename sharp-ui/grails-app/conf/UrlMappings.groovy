class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/people"(action:'list', controller:'person')
		"/rules"(action:'list', controller:'generalRule')
		"/concepts"(action:'list', controller:'concept')
		"/admin"(view:'/admin')
		"/"(view:"/index")
		"500"(view:'/error')
	}
}
