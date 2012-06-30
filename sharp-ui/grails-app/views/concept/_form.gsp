<%@ page import="edu.asu.bmi.greenes.Concept" %>



<div class="fieldcontain ${hasErrors(bean: conceptInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="concept.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${conceptInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: conceptInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="concept.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${conceptInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: conceptInstance, field: 'children', 'error')} ">
	<label for="children">
		<g:message code="concept.children.label" default="Children" />
		
	</label>
	<g:select name="children" from="${edu.asu.bmi.greenes.Concept.list()}" multiple="multiple" optionKey="id" size="5" value="${conceptInstance?.children*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: conceptInstance, field: 'parents', 'error')} ">
	<label for="parents">
		<g:message code="concept.parents.label" default="Parents" />
		
	</label>
	<g:select name="parents" from="${edu.asu.bmi.greenes.Concept.list()}" multiple="multiple" optionKey="id" size="5" value="${conceptInstance?.parents*.id}" class="many-to-many"/>
</div>

