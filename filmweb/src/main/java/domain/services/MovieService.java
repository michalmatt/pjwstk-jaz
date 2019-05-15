package domain.services;

import java.util.ArrayList;
import java.util.List;

import domain.Movie;

public class MovieService {
	
	private static List<Movie> db = new ArrayList<Movie>();
	private static int currentMovieId = 1;
	
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
	
	//public Comment getComment (int commentId) {
	//	for(Comment c : dbc) {
	//		if(c.getId() == commentId) {
	//			return c;
	//		}
	//	}
	//	return null;
	//}
	
	public void add (Movie m) {
		m.setId(currentMovieId++);
		db.add(m);
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
	
	//public void deleteComment (Comment c) {
	//	dbc.remove(c);
	//}

}
