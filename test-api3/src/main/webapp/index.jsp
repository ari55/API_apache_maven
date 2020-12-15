<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>

	<form modelAttribute="" action=""
		method="">
		<div className='container-input'>
			<label>Date de naissance </label> <input type='date'
				name="date_naissance" value="2018-07-22" min="2018-01-01"
				max="2018-12-31" minLength='2' maxLength='20' required />
		</div>

		<div className='container-input'>
			<label>Prenom</label> <input type='text' name="prenom" minLength='2'
				maxLength='20' required />
		</div>

		<div className='container-input'>
			<label>Nom</label> <input type='text' name="nom" minLength='2'
				maxLength='20' required />
		</div>

		<div className='container-input'>
			<label>Telephone</label> <input type='text' name="telephone" required />
		</div>
		<div>
			<label>Programme</label> <select id="programme" name="programme_id">
				<option value='1'>Jeux Videos</option>
				<option value="2">Programmation</option>
			</select>
		</div>

		<div className='container-input'>
			<label>Email</label> <input type='text' name='email' minLength='4'
				maxLength='20' required />
		</div>
		<div className='container-input'>
			<label>Password</label> <input type='password' name='password'
				minLength='4' maxLength='20' required />
		</div>


		<div className='btn_container'>
			<input type="submit" value="S'inscrire">
		</div>
	</form>
</body>
</html>
