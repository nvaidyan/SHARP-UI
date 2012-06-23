<%@ page import="edu.asu.bmi.greenes.users.PersonRole" %>



<div class="fieldcontain ${hasErrors(bean: personRoleInstance, field: 'person', 'error')} required">
	<label for="person">
		<g:message code="personRole.person.label" default="Person" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="person" name="person.id" from="${edu.asu.bmi.greenes.users.Person.list()}" optionKey="id" required="" value="${personRoleInstance?.person?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personRoleInstance, field: 'role', 'error')} required">
	<label for="role">
		<g:message code="personRole.role.label" default="Role" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="role" name="role.id" from="${edu.asu.bmi.greenes.users.Role.list()}" optionKey="id" required="" value="${personRoleInstance?.role?.id}" class="many-to-one"/>
</div>

