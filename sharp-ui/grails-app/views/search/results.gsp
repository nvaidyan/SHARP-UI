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
					<g:render template="search" />
				</div>
			</aside>

			<section id="main" class="span9">
				<g:if test="${results}">
						<h2>${message(code:'search.criteria.found', args:[criteria, desired])}</h2>
						<ul id="searchResults">
						<g:each in="${results}">
							<li>
								<g:link controller="generalRule" action="show" id="${it.id}">
									${it}
								</g:link>
							</li>
						</g:each>
					</ul>
				</g:if>
				<g:else>
					<h2>${message(code:'search.criteria.nonexistant',args:[criteria, desired])}</h2>
				</g:else>
			</section>
		</div>
	</body>
</html>
