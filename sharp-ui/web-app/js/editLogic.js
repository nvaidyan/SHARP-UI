var enableQualifiers = function() {
	$("#and").removeAttr("disabled");
	$("#or").removeAttr("disabled");
}

var createBlock = function(element, logic) {
	var newElem = element.append("<h3>" + logic + "</h3>");
	var text = "<input type='text' name='condition' placeholder='condition e.g Discharge Diagnosis' />";
	text += "<input type='text' name='state' placeholder='state e.g. is In' />"
	text += "<input type='text' name='choice' placeholder='choice e.g. Problem_List' />"
	newElem.append(text);
}

var andHandler = function() {
	$(".predicate").append("<div class='conjunction' />");
	createBlock($(".conjunction:last-child"), "And");
}

var orHandler = function() {
	$(".predicate").append("<div class='disjunction' />");
	createBlock($(".disjunction:last-child"), "Or");
}

jQuery(document).ready(function() {
	var ifHandler = function() {
		enableQualifiers();
		createBlock($(".predicate"), "If");
		createBlock($(".consequent"), "Then");
		$(this).hide();

	}

	$("#if").click(ifHandler);
	$("#and").click(andHandler);
	$("#or").click(orHandler);
});
