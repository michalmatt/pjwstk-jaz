package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.Comment;
import domain.Movie;
import domain.services.MovieService;

@Path("/movie")
public class MovieResources {
	
	private MovieService db = new MovieService();
	private static int currentCommentId = 1;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> getAll() {
		return db.getAll();
	}
	
	@GET
	@Path("/{movieId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("movieId") int movieId) {
		Movie result = db.get(movieId);
		if(result == null) {
			return Response.status(404).build();
		}
		return Response.ok(result).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Movie movie) {
		db.add(movie);
		return Response.ok(movie.getId()).build();
	}
	
	@PUT
	@Path("/{movieId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("movieId") int movieId, Movie m) {
		Movie result = db.get(movieId);
		if(result == null) {
			return Response.status(404).build();
		}
		m.setId(movieId);
		db.update(m);
		return Response.ok(result).build();
	}
	
	@GET
	@Path("/{movieId}/comment")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comment> getComments(@PathParam("movieId") int movieId) {
		Movie result = db.get(movieId);
		if(result == null) {
			return null;
		}
		if(result.getComments() == null) {
			result.setComments(new ArrayList<Comment>());
		}
		return result.getComments();
	}
	
	@POST
	@Path("/{movieId}/comment")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addComment(@PathParam("movieId") int movieId, Comment comment) {
		Movie result = db.get(movieId);
		if(result == null) {
			return Response.status(404).build();
		}
		if(result.getComments() == null) {
			result.setComments(new ArrayList<Comment>());
		}
		comment.setId(currentCommentId++);
		result.getComments().add(comment);
		return Response.ok(comment.getId()).build();
	}

}
