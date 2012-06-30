<%@ page import="edu.asu.bmi.greenes.GeneralRule" %>



<div class="fieldcontain ${hasErrors(bean: generalRuleInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="generalRule.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${generalRuleInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: generalRuleInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="generalRule.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${generalRuleInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: generalRuleInstance, field: 'logic', 'error')} ">
	<label for="logic">
		<g:message code="generalRule.logic.label" default="Logic" />
		
	</label>
	<g:textField name="logic" value="${generalRuleInstance?.logic}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: generalRuleInstance, field: 'concepts', 'error')} ">
	<label for="concepts">
		<g:message code="generalRule.concepts.label" default="Concepts" />
		
	</label>
	<g:select name="concepts" from="${edu.asu.bmi.greenes.Concept.list()}" multiple="multiple" optionKey="id" size="5" value="${generalRuleInstance?.concepts*.id}" class="many-to-many"/>
</div>

