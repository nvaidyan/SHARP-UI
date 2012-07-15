<%@ page import="edu.asu.bmi.greenes.PersonalizedRule" %>



<div class="fieldcontain ${hasErrors(bean: personalizedRuleInstance, field: 'author', 'error')} ">
	<label for="author">
		<g:message code="personalizedRule.author.label" default="Author" />
		
	</label>
	<g:textField name="author" value="${personalizedRuleInstance?.author}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personalizedRuleInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="personalizedRule.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${personalizedRuleInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personalizedRuleInstance, field: 'logic', 'error')} ">
	<label for="logic">
		<g:message code="personalizedRule.logic.label" default="Logic" />
		
	</label>
	<g:textField name="logic" value="${personalizedRuleInstance?.logic}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personalizedRuleInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="personalizedRule.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${personalizedRuleInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personalizedRuleInstance, field: 'variantOf', 'error')} ">
	<label for="variantOf">
		<g:message code="personalizedRule.variantOf.label" default="Variant Of" />
		
	</label>
	<g:select id="variantOf" name="variantOf.id" from="${edu.asu.bmi.greenes.GeneralRule.list()}" optionKey="id" value="${personalizedRuleInstance?.variantOf?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personalizedRuleInstance, field: 'concepts', 'error')} ">
	<label for="concepts">
		<g:message code="personalizedRule.concepts.label" default="Concepts" />
		
	</label>
	<g:select name="concepts" from="${edu.asu.bmi.greenes.Concept.list()}" multiple="multiple" optionKey="id" size="5" value="${personalizedRuleInstance?.concepts*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personalizedRuleInstance, field: 'owner', 'error')} required">
	<label for="owner">
		<g:message code="personalizedRule.owner.label" default="Owner" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="owner" name="owner.id" from="${edu.asu.bmi.greenes.users.Person.list()}" optionKey="id" required="" value="${personalizedRuleInstance?.owner?.id}" class="many-to-one"/>
</div>

