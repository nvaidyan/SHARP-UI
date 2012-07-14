<!doctype html>
<html>
	<head>
		<meta name="layout" content="bootstrap"/>
		<title>ASU BMI Clinical Decision Support</title>
	</head>

	<body>
		<div class="row-fluid">
			<aside id="application-status" class="span3">
				<div class="well sidebar-nav">
					<g:render template="/search/search" />
					<h5>Application Status</h5>
					<ul>
						<li>App version: <g:meta name="app.version"/></li>
						<li>Grails version: <g:meta name="app.grails.version"/></li>
						<li>Groovy version: ${org.codehaus.groovy.runtime.InvokerHelper.getVersion()}</li>
						<li>JVM version: ${System.getProperty('java.version')}</li>
						<li>Controllers: ${grailsApplication.controllerClasses.size()}</li>
						<li>Domains: ${grailsApplication.domainClasses.size()}</li>
						<li>Services: ${grailsApplication.serviceClasses.size()}</li>
						<li>Tag Libraries: ${grailsApplication.tagLibClasses.size()}</li>
					</ul>
					<h5>Installed Plugins</h5>
					<ul>
						<g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">
							<li>${plugin.name} - ${plugin.version}</li>
						</g:each>
					</ul>
				</div>
			</aside>

			<section id="main" class="span9">

				<div class="hero-unit">
					<h1>Welcome to SHARP Rules</h1>

					<p>This is a prototype of a customizable, collaborative rules library for physicians</p>
				</div>
					
				<div class="row-fluid">
					
					<div class="span4">
						<h2>Try It</h2>
						<p>This demo app includes a couple of controllers to show off its features.</p>
						<ul class="nav nav-list">
							<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
								<li><g:link controller="${c.logicalPropertyName}">${c.naturalName}</g:link></li>
							</g:each>
						</ul>
					</div>

					<div class="span4">
						<h2>Play With It</h2>
						<p>Try creating a Person, Logging in and Logging Out (not secured yet), and creating a Rule or two</p>
					</div>
					
					<div class="span4">
						<h2>Prepare Feedback</h2>
						<p>Most of the effort has gone onto rapid-prototyping functionality, so keep that in mind! Pretty, secure, etc will come later.</p>
					</div>

				</div>

			</section>
		</div>
		
		<a href="https://github.com/nvaidyan/SHARP-UI">
			<img id="github-ribbon" 
				 src="https://s3.amazonaws.com/github/ribbons/forkme_left_green_007200.png"
				 alt="Fork me on GitHub"/>
		</a>
	</body>
</html>
