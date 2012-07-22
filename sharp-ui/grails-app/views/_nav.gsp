<nav class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container-fluid">

			<a class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a> <a class="brand" href="${createLink(uri: '/')}">SHARP UI</a>

			<div class="nav-collapse">
				<ul class="nav">
					<li id="home"
						<%= request.forwardURI == "${createLink(uri: '/')}" ? ' class="active"' : '' %>>
						<a href="${createLink(uri: '/')}">
							<g:message code="default.home.label" default="Home" />
						</a>
					</li>
					<li id="rules">
						<g:link uri="/rules">
							<g:message code="nav.rules" default="Rules" />
						</g:link>
					</li>
					<li id="concepts">
						<g:link uri="/concepts">
							<g:message code="nav.concepts" default="Concepts" />
						</g:link>
					</li>
					<li>
						<g:link uri="/people">
							<g:message code="nav.people" default="People" />
						</g:link>
					</li>
				</ul>
			</div>
		</div>
	</div>
</nav>