modules = {
    application {
        resource url:'js/application.js'
    }
	
	editLogic {
		dependsOn: 'application'
		resource url:'js/editLogic.js'
	}
}