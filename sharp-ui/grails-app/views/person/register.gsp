<html>
<head>
<meta name='layout' content='bootstrap' />
<title><g:message code="workbench.register" /></title>
</head>
<body>
	<g:form name="register" action="create" controller="person">
		<p>
			<label for='username'> <g:message
					code="springSecurity.login.username.label" />:
			</label> <input type='text' class='text_' name='j_username' id='username' />
		</p>

		<p>
			<label for='email'> <g:message code="workbench.email.label" />:
			</label> <input type='text' class='text_' name='j_email' id='email' />
		</p>

		<p>
			<label for='password'> <g:message
					code="springSecurity.login.password.label" />:
			</label> <input type='password' class='text_' name='j_password' id='password' />
		</p>

		<p>
			<g:submitButton 
				class="btn btn-primary" id="submit"
				name= '${message(code: "workbench.register")}'
				value='${message(code: "workbench.register")}' />
		</p>
	</g:form>
</body>