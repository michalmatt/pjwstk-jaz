package domain;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class CityWeatherClient {
	
	public static final String URL = "https://api.openweathermap.org/data/2.5/weather";
	public static final String APPID = "1ccef0bebccb8cca4359554e3647bfac";
	public static final String units = "metric";
	
	public CityWeather getByCityId(int cityId){
		Response response = ClientBuilder
		.newClient()
		.target(URL+"?id="+cityId+"&units="+units+"&APPID="+APPID)
		//.path("weather")
		//.resolveTemplate("resource", "weather")
		//.queryParam("id", cityId)
		.request(MediaType.APPLICATION_JSON)
		.get();
		
		if(response.getStatus() == 200) {
			return response.readEntity(CityWeather.class);
		}
		return null;
	}

}
