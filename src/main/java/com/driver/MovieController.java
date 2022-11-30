package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@Component
public class MovieController {

	@Autowired
	MovieRepository Movierepo;
	
//1
	@PostMapping("/movies/addMovie")
	public ResponseEntity<String> addMovie(@RequestBody Movie e) {
		try {
		Movierepo.AddMovie(e);
		return new ResponseEntity("success",HttpStatus.ACCEPTED);
		}
		catch(Exception e1) {
			return new ResponseEntity("not success",HttpStatus.BAD_GATEWAY);
		}
	}
	
//2
	@PostMapping("/movies/add-director")
	public ResponseEntity<String> addDirector(@RequestBody Director d) {
		try {
		Movierepo.addDirector(d);
		return new ResponseEntity("success",HttpStatus.ACCEPTED); 
		}catch(Exception e) {
			return new ResponseEntity("not success",HttpStatus.BAD_REQUEST); 
		}
	}
	
//3
	
	@PutMapping("/movies/add-movie-director-pair")
	public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie_name,@RequestParam String director_name){
		try {
		Movierepo.addMovieDirectorPair(movie_name,director_name);
		return new ResponseEntity("success",HttpStatus.ACCEPTED); 
		}catch(Exception e) {
			return  new ResponseEntity("not success",HttpStatus.NO_CONTENT); 
		}
	}
	
	//4
	
	@GetMapping("/movies/get-movie-by-name/{name}")
	public ResponseEntity<Movie>getMovieByName(@PathVariable String name){
		try {
		return new ResponseEntity(Movierepo.get_movie_by_name(name),HttpStatus.FOUND);
		}catch(Exception e) {
			return  new ResponseEntity("not success",HttpStatus.NO_CONTENT); 
		}
		
	}
	
	
//5
	
	@GetMapping("/movies/get_director_by_name/{name}")
	public ResponseEntity<Director>getDirectorByName(@PathVariable String name){
		try {
		return new ResponseEntity(Movierepo.get_director_by_name(name),HttpStatus.FOUND);
		}catch(Exception e){
			return  new ResponseEntity("not success",HttpStatus.NOT_EXTENDED); 
		}
	}
	
	
//6
	
	
	@GetMapping("/movies/get-movies-by-director-name/{name}")
	public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String name){
	//	List<String>movies=Movierepo.getMoviesByDirector(name);
		try{
			List<String>muvi=Movierepo.getMoviesByDirector(name);
		return  new ResponseEntity(muvi,HttpStatus.ACCEPTED);
		}catch(Exception e) {
			return  new ResponseEntity("not success",HttpStatus.METHOD_FAILURE); 
		}
		
	}
	
	
	//7
	
	@GetMapping("/movies/get-all-movies")
	public  ResponseEntity<List<String>>findAllMovies(){
		try {
		return new ResponseEntity(Movierepo.findAllmovies(),HttpStatus.ACCEPTED);
		}catch(Exception e) {
			return  new ResponseEntity("not success",HttpStatus.BAD_REQUEST); 
		}
	}
	
	//8
	@DeleteMapping("/movies/delete-director-by-name")
	public ResponseEntity<String> deleteDirectorByName(@RequestParam String name) {
		try {
		Movierepo.deletedirector(name);
		return  new ResponseEntity("success",HttpStatus.ACCEPTED); 
		}catch(Exception e) {
			return  new ResponseEntity("not success",HttpStatus.BAD_REQUEST); 
		}
	}
	
	
	//error not deleteing
	//9
	@DeleteMapping("/movies/delete")
	public ResponseEntity<String> deleteAllDirectors(){
		try {
		Movierepo.deleteAlldirectors();
		return  new ResponseEntity("success",HttpStatus.ACCEPTED); 
		}catch(Exception e) {
			return  new ResponseEntity("not success",HttpStatus.BAD_REQUEST);
		}
	}
}
