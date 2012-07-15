
<%@ page import="edu.asu.bmi.greenes.PersonalizedRule" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="bootstrap">
		<g:set var="entityName" value="${message(code: 'personalizedRule.label', default: 'PersonalizedRule')}" />
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
				
					<g:if test="${personalizedRuleInstance?.author}">
						<dt><g:message code="personalizedRule.author.label" default="Author" /></dt>
						
							<dd><g:fieldValue bean="${personalizedRuleInstance}" field="author"/></dd>
						
					</g:if>
				
					<g:if test="${personalizedRuleInstance?.dateCreated}">
						<dt><g:message code="personalizedRule.dateCreated.label" default="Date Created" /></dt>
						
							<dd><g:formatDate date="${personalizedRuleInstance?.dateCreated}" /></dd>
						
					</g:if>
				
					<g:if test="${personalizedRuleInstance?.description}">
						<dt><g:message code="personalizedRule.description.label" default="Description" /></dt>
						
							<dd><g:fieldValue bean="${personalizedRuleInstance}" field="description"/></dd>
						
					</g:if>
				
					<g:if test="${personalizedRuleInstance?.lastUpdated}">
						<dt><g:message code="personalizedRule.lastUpdated.label" default="Last Updated" /></dt>
						
							<dd><g:formatDate date="${personalizedRuleInstance?.lastUpdated}" /></dd>
						
					</g:if>
				
					<g:if test="${personalizedRuleInstance?.logic}">
						<dt><g:message code="personalizedRule.logic.label" default="Logic" /></dt>
						
							<dd><g:fieldValue bean="${personalizedRuleInstance}" field="logic"/></dd>
						
					</g:if>
				
					<g:if test="${personalizedRuleInstance?.name}">
						<dt><g:message code="personalizedRule.name.label" default="Name" /></dt>
						
							<dd><g:fieldValue bean="${personalizedRuleInstance}" field="name"/></dd>
						
					</g:if>
				
					<g:if test="${personalizedRuleInstance?.variantOf}">
						<dt><g:message code="personalizedRule.variantOf.label" default="Variant Of" /></dt>
						
							<dd><g:link controller="generalRule" action="show" id="${personalizedRuleInstance?.variantOf?.id}">${personalizedRuleInstance?.variantOf?.encodeAsHTML()}</g:link></dd>
						
					</g:if>
				
					<g:if test="${personalizedRuleInstance?.concepts}">
						<dt><g:message code="personalizedRule.concepts.label" default="Concepts" /></dt>
						
							<g:each in="${personalizedRuleInstance.concepts}" var="c">
							<dd><g:link controller="concept" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></dd>
							</g:each>
						
					</g:if>
				
					<g:if test="${personalizedRuleInstance?.owner}">
						<dt><g:message code="personalizedRule.owner.label" default="Owner" /></dt>
						
							<dd><g:link controller="person" action="show" id="${personalizedRuleInstance?.owner?.id}">${personalizedRuleInstance?.owner?.encodeAsHTML()}</g:link></dd>
						
					</g:if>
				
				</dl>

				<g:form>
					<g:hiddenField name="id" value="${personalizedRuleInstance?.id}" />
					<div class="form-actions">
						<g:link class="btn" action="edit" id="${personalizedRuleInstance?.id}">
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
