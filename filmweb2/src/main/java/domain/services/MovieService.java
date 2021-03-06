package domain.services;

import java.util.ArrayList;
import java.util.List;

import domain.Movie;

public class MovieService {
	
	private static List<Movie> db = new ArrayList<Movie>();
	
	public List<Movie> getAll() {
		return db;
	}
	
	public Movie get (int id) {
		for(Movie m : db) {
			if(m.getId() == id) {
				return m;
			}
		}
		return null;
	}
	
	public void add (Movie m) {
		db.add(m);
		m.setId(db.indexOf(m));
	}
	
	public void update (Movie movie) {
		for (Movie m : db) {
			if(m.getId()== movie.getId()) {
				m.setTitle(movie.getTitle());
				m.setYear(movie.getYear());
				m.setType(movie.getType());
				m.setDescription(movie.getDescription());
			}
		}
	}
	
	public void delete (Movie m) {
		db.remove(m);
	}

}
