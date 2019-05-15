package domain;

public class CityWeather {
	
	private int id;
	private String name;
	private CityWeatherMain main;
	private CityWeatherClouds clouds;
	private CityWeatherWind wind;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CityWeatherMain getMain() {
		return main;
	}
	public void setMain(CityWeatherMain main) {
		this.main = main;
	}
	public CityWeatherClouds getClouds() {
		return clouds;
	}
	public void setClouds(CityWeatherClouds clouds) {
		this.clouds = clouds;
	}
	public CityWeatherWind getWind() {
		return wind;
	}
	public void setWind(CityWeatherWind wind) {
		this.wind = wind;
	}

}
