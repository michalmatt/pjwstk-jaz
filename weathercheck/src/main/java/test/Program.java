package test;

import domain.CityWeather;
import domain.CityWeatherClient;

public class Program {
	
	static void printCityWeather(CityWeather c){
		if(c == null) {
			System.out.println(404);
			return;
		}
		System.out.println("id: " + c.getId());
		System.out.println("name: " + c.getName());
		System.out.println("clouds: " + c.getClouds().getAll() + " %");
		System.out.println("temp: " + c.getMain().getTemp() + " Celsius");
		System.out.println("pressure: " + c.getMain().getPressure() + " hPa");
		System.out.println("speed of wind: " + c.getWind().getSpeed() + " meter/sec");
	}

	public static void main(String[] args) {
		CityWeatherClient client = new CityWeatherClient();
		printCityWeather(client.getByCityId(3099434));

	}

}
