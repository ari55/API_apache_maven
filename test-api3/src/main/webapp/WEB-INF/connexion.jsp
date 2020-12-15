<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>connexion</title>
</head>
<body>
	<form  modelAttribute="user" action="login" method="post">
		<div className='container-input'>
			<label>Login</label> <input type='text' name="prenom" minLength='2'
				maxLength='20' required />
		</div>
		<div className='container-input'>
			<label>Password</label> <input type='password' name='password'
				minLength='4' maxLength='20' required />
		</div>
		<div className='btn_container'>
			<input type="submit" value="envoyer">
		</div>
	</form>
</body>
</html>
