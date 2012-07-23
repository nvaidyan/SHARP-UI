<%@ page import="edu.asu.bmi.greenes.GeneralRule" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="bootstrap">
		<g:set var="entityName" value="jQuery{message(code: 'generalRule.label', default: 'GeneralRule')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
		<r:script>
			
			var parseElement = function(element){
				return element.find("input[name='condition']").val() + " " +
						  element.find("input[name='state']").val() + " " +
						  element.find("input[name='choice']").val() + " "; 
				
			}
			
			var grabQualifiers = function(qualifier){
				var result = "";
				var qual = (qualifier == "And") ? ".conjunction" : ".disjunction";
				jQuery(".predicate").find(qual).each(function(index, element){
					result += qualifier + " " + parseElement(jQuery(element));
				});
				return result;
			}
			
			var updateRule = function(logic){ 
				var form =  "<form action='${g.createLink(controller:"generalRule", action:"edit") }' method='POST'></form>";
				var id = "<input name='id' value='${generalRuleInstance?.id}' />";
				var version = "<input name='version' value='${generalRuleInstance?.version}' />";
				var logic = "<input name='logic' value='" + logic + "' />"; 
				var toSub = jQuery(form);
				toSub.append(id).append(version).append(logic);
				toSub.submit(); 
			}
			
			var createConsequent = function(){ return parseElement(jQuery(".consequent")); }
			
			
			var createPredicate = function(){
				var result = "";
				var pred = jQuery(".predicate");
				result += parseElement(pred);
				result += grabQualifiers("And")
				result += grabQualifiers("Or")
				return result;
			}
			
			var combine = function(){
				var logic = "If " 
				logic += createPredicate();
				logic += " Then ";
				logic += createConsequent();
				updateRule(logic);
			}
		</r:script>
	</head>
	<body>
		<button id="save" class="btn btn-primary" onClick="return combine();">Save</button>
		<g:render template="logic" />
	</body>
</html>
