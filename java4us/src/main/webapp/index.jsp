<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Formularz zgłoszeniowy</title>
</head>
<body>
	<form action="add" method="get">
		<h3>Formularz zgłoszeniowy:</h3>
		<table>
			<tr>
				<td style="text-align:right">Imię:</td>
				<td><input name="name" id="name" type="text" style="width:200px"></td>
			</tr>
			<tr>
				<td style="text-align:right">Nazwisko:</td>
				<td><input name="surname" id="surname" type="text" style="width:200px"></td>
			</tr>
			<tr>
				<td style="text-align:right">Pracodawca:</td>
				<td><input name="employement" id="employment" type="text" style="width:200px"></td>
			</tr>
			<tr>
				<td style="text-align:right">Adres e-mail:</td>
				<td><input name="email" id="email" type="email" style="width:200px"></td>
			</tr>
			<tr>
				<td style="text-align:right">Potwierdź adres e-mail:</td>
				<td><input name="confirmemail" id="email" type="text" style="width:200px"></td>
			</tr>
			<tr>
				<td>Skąd się dowiedziałeś o konferencji:</td>
			</tr>
			<tr>
				<td style="text-align:right"><input name="info" value="work" type="radio"></td>
				<td>Ogłoszenie w pracy</td>
			</tr>
			<tr>
				<td style="text-align:right"><input name="info" value="school" type="radio"></td>
				<td>Ogłoszenie na uczelni</td>
			</tr>
			<tr>
				<td style="text-align:right"><input name="info" value="facebook" type="radio"></td>
				<td>Facebook</td>
			</tr>
			<tr>
				<td style="text-align:right"><input name="info" value="friends" type="radio"></td>
				<td>Znajomi</td>
			</tr>
			<tr>
				<td style="text-align:right"><input type="submit" value="Wyślij"></td>
			</tr>
			</table>
	</form>
</body>
</html>