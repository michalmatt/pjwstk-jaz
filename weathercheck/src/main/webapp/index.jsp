<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
<title>WeatherCheck</title>
</head>
<body>
	<form action="weathercheck" method="post">
		<h3>WeatherCheck application</h3>
		<table>
			<tr>
				<td>Choose a city:</td>
				<td><select name="cityName">
					<option value=6695624>Warsaw</option>
					<option value=3099434 selected>Gdansk</option>
					<option value=3094802>Cracow</option>
					<option value=3081368>Wroclaw</option>
					<option value=3088171>Poznan</option>
					<option value=3093133>Lodz</option>
					<option value=3096472>Katowice</option>
					<option value=766307>Lidzbark Warminski</option>
					<option value=3080414>Zdunska Wola</option>
					<option value=0>Error test</option>
					</select>
				</td>
			</tr>
		</table>
		<br><input type="submit" value="Check weather" name="submit">
	</form>
</body>
</html>