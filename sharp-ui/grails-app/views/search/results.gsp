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
					<g:render template="/search" />
				</div>
			</aside>

			<section id="main" class="span9">
				<g:if test="${results}">
						<ul id="searchResults">
						<g:each in="${results}">
							<li>${it}</li>
						</g:each>
					</ul>
				</g:if>
				<g:else>
					<h2>${message(code:'search.no.results'}</h2>
				<g:else>
				
			</section>
		</div>
	</body>
</html>
