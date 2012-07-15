
<%@ page import="edu.asu.bmi.greenes.PersonalizedRule" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="bootstrap">
		<g:set var="entityName" value="${message(code: 'personalizedRule.label', default: 'PersonalizedRule')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="row-fluid">
			
			<div class="span3">
				<div class="well">
					<ul class="nav nav-list">
						<li class="nav-header">${entityName}</li>
						<li class="active">
							<g:link class="list" action="list">
								<i class="icon-list icon-white"></i>
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
					<h1><g:message code="default.list.label" args="[entityName]" /></h1>
				</div>

				<g:if test="${flash.message}">
				<bootstrap:alert class="alert-info">${flash.message}</bootstrap:alert>
				</g:if>
				
				<table class="table table-striped">
					<thead>
						<tr>
						
							<g:sortableColumn property="author" title="${message(code: 'personalizedRule.author.label', default: 'Author')}" />
						
							<g:sortableColumn property="dateCreated" title="${message(code: 'personalizedRule.dateCreated.label', default: 'Date Created')}" />
						
							<g:sortableColumn property="description" title="${message(code: 'personalizedRule.description.label', default: 'Description')}" />
						
							<g:sortableColumn property="lastUpdated" title="${message(code: 'personalizedRule.lastUpdated.label', default: 'Last Updated')}" />
						
							<g:sortableColumn property="logic" title="${message(code: 'personalizedRule.logic.label', default: 'Logic')}" />
						
							<g:sortableColumn property="name" title="${message(code: 'personalizedRule.name.label', default: 'Name')}" />
						
							<th></th>
						</tr>
					</thead>
					<tbody>
					<g:each in="${personalizedRuleInstanceList}" var="personalizedRuleInstance">
						<tr>
						
							<td>${fieldValue(bean: personalizedRuleInstance, field: "author")}</td>
						
							<td><g:formatDate date="${personalizedRuleInstance.dateCreated}" /></td>
						
							<td>${fieldValue(bean: personalizedRuleInstance, field: "description")}</td>
						
							<td><g:formatDate date="${personalizedRuleInstance.lastUpdated}" /></td>
						
							<td>${fieldValue(bean: personalizedRuleInstance, field: "logic")}</td>
						
							<td>${fieldValue(bean: personalizedRuleInstance, field: "name")}</td>
						
							<td class="link">
								<g:link action="show" id="${personalizedRuleInstance.id}" class="btn btn-small">Show &raquo;</g:link>
							</td>
						</tr>
					</g:each>
					</tbody>
				</table>
				<div class="pagination">
					<bootstrap:paginate total="${personalizedRuleInstanceTotal}" />
				</div>
			</div>

		</div>
	</body>
</html>
