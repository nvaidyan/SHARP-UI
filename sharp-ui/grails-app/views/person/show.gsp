
<%@ page import="edu.asu.bmi.greenes.users.Person" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="bootstrap">
		<g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="row-fluid">
			
			<div class="span3">
				<div class="well">
					<ul class="nav nav-list">
						<li class="nav-header">${entityName}</li>
						<li>
							<g:link class="list" action="list">
								<i class="icon-list"></i>
								<g:message code="default.list.label" args="[entityName]" />
							</g:link>
						</li>
						<li>
							<g:link class="create" action="create">
								<i class="icon-plus"></i>
								<g:message code="default.create.label" args="[entityName]" />
							</g:link>
						</li>
					</ul>
				</div>
			</div>
			
			<div class="span9">

				<div class="page-header">
					<h1><g:message code="default.show.label" args="[entityName]" /></h1>
				</div>

				<g:if test="${flash.message}">
				<bootstrap:alert class="alert-info">${flash.message}</bootstrap:alert>
				</g:if>

				<dl>
				
					<g:if test="${personInstance?.username}">
						<dt><g:message code="person.username.label" default="Username" /></dt>
						
							<dd><g:fieldValue bean="${personInstance}" field="username"/></dd>
						
					</g:if>
				
					<g:if test="${personInstance?.email}">
						<dt><g:message code="person.email.label" default="Email" /></dt>
						
							<dd><g:fieldValue bean="${personInstance}" field="email"/></dd>
						
					</g:if>
				
					<g:if test="${personInstance?.password}">
						<dt><g:message code="person.password.label" default="Password" /></dt>
						
							<dd><g:fieldValue bean="${personInstance}" field="password"/></dd>
						
					</g:if>
				
					<g:if test="${personInstance?.accountExpired}">
						<dt><g:message code="person.accountExpired.label" default="Account Expired" /></dt>
						
							<dd><g:formatBoolean boolean="${personInstance?.accountExpired}" /></dd>
						
					</g:if>
				
					<g:if test="${personInstance?.accountLocked}">
						<dt><g:message code="person.accountLocked.label" default="Account Locked" /></dt>
						
							<dd><g:formatBoolean boolean="${personInstance?.accountLocked}" /></dd>
						
					</g:if>
				
					<g:if test="${personInstance?.enabled}">
						<dt><g:message code="person.enabled.label" default="Enabled" /></dt>
						
							<dd><g:formatBoolean boolean="${personInstance?.enabled}" /></dd>
						
					</g:if>
				
					<g:if test="${personInstance?.passwordExpired}">
						<dt><g:message code="person.passwordExpired.label" default="Password Expired" /></dt>
						
							<dd><g:formatBoolean boolean="${personInstance?.passwordExpired}" /></dd>
						
					</g:if>
				
				</dl>

				<g:form>
					<g:hiddenField name="id" value="${personInstance?.id}" />
					<div class="form-actions">
						<g:link class="btn" action="edit" id="${personInstance?.id}">
							<i class="icon-pencil"></i>
							<g:message code="default.button.edit.label" default="Edit" />
						</g:link>
						<button class="btn btn-danger" type="submit" name="_action_delete">
							<i class="icon-trash icon-white"></i>
							<g:message code="default.button.delete.label" default="Delete" />
						</button>
					</div>
				</g:form>

			</div>

		</div>
	</body>
</html>
