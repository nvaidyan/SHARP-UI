<div id="searchContainer">
	<g:form controller="search">
		<input type="search" name="desired" />
		<g:select name="criteria" from="['author','concept','rule']" />
		<g:submitButton name="search" value="Search" />
	</g:form>
</div>