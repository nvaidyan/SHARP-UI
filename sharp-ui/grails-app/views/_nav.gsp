<nav class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container-fluid">

			<a class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a> <a class="brand" href="${createLink(uri: '/')}">SHARP UI</a>

			<div class="nav-collapse">
				<ul class="nav">
					<li
						<%= request.forwardURI == "${createLink(uri: '/')}" ? ' class="active"' : '' %>><a
						href="${createLink(uri: '/')}">Home</a></li>
					<g:each var="c"
						in="${grailsApplication.controllerClasses.sort { it.fullName } }">
						<li
							<%= c.logicalPropertyName == controllerName ? ' class="active"' : '' %>><g:link
								controller="${c.logicalPropertyName}">
								${c.naturalName}
							</g:link></li>
					</g:each>
				</ul>
			</div>
		</div>
	</div>
</nav>