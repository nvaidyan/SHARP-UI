<%@ page import="edu.asu.bmi.greenes.users.Person" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="bootstrap">
		<g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
		<title><g:message code="workbench.register" /></title>
	</head>
	<body>
		<div class="row-fluid">
			<div class="span12">

				<div class="page-header">
					<h1><g:message code="workbench.register" /></h1>
				</div>
				
				<g:hasErrors bean="${personInstance}">
				<bootstrap:alert class="alert-error">
				<ul>
					<g:eachError bean="${personInstance}" var="error">
					<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
					</g:eachError>
				</ul>
				</bootstrap:alert>
				</g:hasErrors>

				<fieldset>
					<g:form class="form-horizontal" action="register" >
						<fieldset>
							<f:field bean="personInstance" property="username" />
							<f:field bean="personInstance" property="email" />
							<f:field bean="personInstance" property="password" />
							<div class="form-actions">
								<button type="submit" class="btn btn-primary">
									<i class="icon-ok icon-white"></i>
									<g:message code="default.button.create.label" default="Create" />
								</button>
							</div>
						</fieldset>
					</g:form>
				</fieldset>
				
			</div>

		</div>
	</body>
</html>
