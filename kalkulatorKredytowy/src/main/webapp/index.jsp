<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
<title>Kalukator kredytowy</title>
</head>
<body>
	<form action="kalkulatorkredytowy" method="post">
		<h3>Kalkulator kredytowy:</h3>
		<table>
			<tr>
				<td>Wnioskowana kwota kredytu:</td>
				<td><input name="wnioskowanaKwotaKredytu" type="number" min="1" step=".01" style="width:100px"> PLN</td>
			</tr>
			<tr>
				<td>Ilosc rat:</td>
				<td><input name="iloscRat" type="number" min="6" max="60" style="width:100px"> (minimum: 6 / maximum: 60)</td>
			</tr>
			<tr>
				<td>Oprocentowanie:</td>
				<td><input name="oprocentowanie" type="number" min="0" step=".01" style="width:100px"> % (w skali roku)</td>
			</tr>
			<tr>
				<td>Oplata stala:</td>
				<td><input name="oplataStala" type="number" style="width:100px"> PLN</td>
			</tr>
			<tr>
				<td>Rodzaj rat:</td>
				<td><select name="rodzajRat">
					<option value="stala_wysokosc_rat">stala wysokosc rat</option>
					<option value="raty_malejace">raty malejace</option>
					</select>
				</td>
			</tr>
			</table>
		<br><input type="submit" value="Oblicz" name="oblicz">
	</form>
</body>
</html>