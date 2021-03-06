
<%@ page import="edu.asu.bmi.greenes.Concept" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="bootstrap">
		<g:set var="entityName" value="${message(code: 'concept.label', default: 'Concept')}" />
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
				
					<g:if test="${conceptInstance?.name}">
						<dt><g:message code="concept.name.label" default="Name" /></dt>
						
							<dd><g:fieldValue bean="${conceptInstance}" field="name"/></dd>
						
					</g:if>
				
					<g:if test="${conceptInstance?.description}">
						<dt><g:message code="concept.description.label" default="Description" /></dt>
						
							<dd><g:fieldValue bean="${conceptInstance}" field="description"/></dd>
						
					</g:if>
				
					<g:if test="${conceptInstance?.children}">
						<dt><g:message code="concept.children.label" default="Children" /></dt>
						
							<g:each in="${conceptInstance.children}" var="c">
							<dd><g:link controller="concept" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></dd>
							</g:each>
						
					</g:if>
				
					<g:if test="${conceptInstance?.parents}">
						<dt><g:message code="concept.parents.label" default="Parents" /></dt>
						
							<g:each in="${conceptInstance.parents}" var="p">
							<dd><g:link controller="concept" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></dd>
							</g:each>
						
					</g:if>
				
				</dl>

				<g:form>
					<g:hiddenField name="id" value="${conceptInstance?.id}" />
					<div class="form-actions">
						<g:link class="btn" action="edit" id="${conceptInstance?.id}">
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
