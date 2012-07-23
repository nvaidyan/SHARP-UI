
<%@ page import="edu.asu.bmi.greenes.GeneralRule" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="bootstrap">
		<g:set var="entityName" value="${message(code: 'generalRule.label', default: 'GeneralRule')}" />
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
				
					<g:if test="${generalRuleInstance?.name}">
						<dt><g:message code="generalRule.name.label" default="Name" /></dt>
						
							<dd><g:fieldValue bean="${generalRuleInstance}" field="name"/></dd>
						
					</g:if>
				
					<g:if test="${generalRuleInstance?.description}">
						<dt><g:message code="generalRule.description.label" default="Description" /></dt>
						
							<dd><g:fieldValue bean="${generalRuleInstance}" field="description"/></dd>
						
					</g:if>
				
					<g:if test="${generalRuleInstance?.logic}">
						<dt><g:message code="generalRule.logic.label" default="Logic" /></dt>
						
							<dd><g:fieldValue bean="${generalRuleInstance}" field="logic"/></dd>
						
					</g:if>
				
					<g:if test="${generalRuleInstance?.lastUpdated}">
						<dt><g:message code="generalRule.lastUpdated.label" default="Last Updated" /></dt>
						
							<dd><g:formatDate date="${generalRuleInstance?.lastUpdated}" /></dd>
						
					</g:if>
				
					<g:if test="${generalRuleInstance?.dateCreated}">
						<dt><g:message code="generalRule.dateCreated.label" default="Date Created" /></dt>
						
							<dd><g:formatDate date="${generalRuleInstance?.dateCreated}" /></dd>
						
					</g:if>
				
					<g:if test="${generalRuleInstance?.concepts}">
						<dt><g:message code="generalRule.concepts.label" default="Concepts" /></dt>
						
							<g:each in="${generalRuleInstance.concepts}" var="c">
							<dd><g:link controller="concept" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></dd>
							</g:each>
						
					</g:if>
				
				</dl>

				<g:form>
					<g:hiddenField name="id" value="${generalRuleInstance?.id}" />
					<div class="form-actions">
						<g:link class="btn btn-primary" action="edit" id="${generalRuleInstance?.id}">
							<i class="icon-pencil"></i>
							<g:message code="default.button.edit.label" default="Edit" />
						</g:link>
						<g:link class="btn btn-inverse" action="editLogic" id="${generalRuleInstance?.id}">
							<i class="icon-eye-close"></i>
							<g:message code="rule.editLogic" default="Edit Logic" />
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
