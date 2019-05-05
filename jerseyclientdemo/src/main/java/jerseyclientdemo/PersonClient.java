package jerseyclientdemo;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class PersonClient {
	
	public static final String URL = "http://localhost:8080/samplerestapp2/rest/people";
	
	public int postPerson (Person person) {
		return ClientBuilder
			.newClient() //-> utworzenie klienta
			.target(URL) //-> wprowadzenie adresu URL
			.request() //-> pobranie obiektu zadania
			.post(Entity.entity(person, MediaType.APPLICATION_JSON)) //-> deklarujemy uzycie metody HTTP POST
			.getStatus(); //-> odczytanie statusu odpowiedzi
	}
	
	public List<Person> getAll(){
		return ClientBuilder
		.newClient()
		.target(URL)
		.request(MediaType.APPLICATION_JSON) //-> podajemy typ jakiego sie spodziewamy w odpowiedzi
		.get() //->deklarujemy metode HTTP GET
		.readEntity(People.class) //-> metoda readEntity sluzy do zmapowania odpowiedzi na obiekt encji
		.getPeople(); //-> metoda encji zwracaj¹ca liste osob
	}
	
	public Person getById(int id){
		Response response = ClientBuilder
		.newClient()
		.target(URL)
		.path(""+id) //-> dolozenie id do adresu URL //np. http://localhost:8080/samplerestapp/rest/people/1
		.request(MediaType.APPLICATION_JSON)
		.get();
		
		if(response.getStatus() == 200) {
			return response.readEntity(Person.class); //->szczytujemy encje tylko jesli status to 200 
		}
		return null;
	}
	
	public int update(Person person, int personToUpdateId){
		return ClientBuilder
		.newClient()
		.target(URL)
		.path(""+personToUpdateId)
		.request()
		.put(Entity.entity(person, MediaType.APPLICATION_JSON))
		.getStatus();
	}
	
	public int delete(int personId){
		Response response = ClientBuilder
		.newClient()
		.target(URL)
		.path(""+personId)
		.request()
		.delete();
		return response.getStatus();
	}
	
}