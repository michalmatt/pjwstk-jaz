package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.CityWeather;
import domain.CityWeatherClient;

@WebServlet("/weathercheck")
public class CityChoiceServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	static void printCityWeather(HttpServletResponse r, CityWeather c) throws ServletException, IOException {
		PrintWriter writer = r.getWriter();
		writer.println("City name: " + c.getName());
		writer.println("Clouds level: " + c.getClouds().getAll() + " %");
		writer.println("Temperature: " + c.getMain().getTemp() + " Celsius");
		writer.println("Pressure: " + c.getMain().getPressure() + " hPa");
		writer.println("Speed of wind: " + c.getWind().getSpeed() + " meter/sec");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cityId = Integer.parseInt(request.getParameter("cityName"));
		CityWeatherClient client = new CityWeatherClient();
		CityWeather weather = client.getByCityId(cityId);
		printCityWeather(response, weather);
	}

}
