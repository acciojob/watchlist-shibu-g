package com.driver;

import java.util.*;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class MovieRepository {
  Map<String,List<Movie>>movie_director=new HashMap<>();
  Map<String,Movie>movie=new HashMap<>();
  Map<String,Director>director=new HashMap<>();
  
  public void AddMovie(Movie e) {
		movie.put(e.getName(),e);
	}
  public void addDirector(Director d) {
	  director.put(d.getName(),d);
  }
  public void addMovieDirectorPair(String movie_name,String director_name) {
	  
	  Movie m1=movie.get(movie_name);
	 // Director d1=director.get(director_name);
	  if(movie_director.get(director_name)!=null) {
		  List<Movie>movies=movie_director.get(director_name);
		  movies.add(m1);
		  movie_director.put(director_name,movies);
	  }
	  else {
		  List<Movie>movies=new ArrayList<>();
		  movies.add(m1);
		  movie_director.put(director_name,movies);
	  }
  }
  public Movie get_movie_by_name(String name) {
	  return movie.get(name);
  }
  
  public Director get_director_by_name(String name) {
	  return director.get(name);
  }
  
  public List<String> getMoviesByDirector(String name){
	  //Director d1=director.get(name);
	  List<String>moviename=new ArrayList<>();
	  List<Movie>movies=movie_director.get(name);
	  for(Movie m:movies) {
		  moviename.add(m.getName());
	  }
	  return moviename;
  }
  
  public List<String> findAllmovies(){
	  List<String>movies=new ArrayList<>();
	  for(String m:movie.keySet()) {
		  movies.add(m);
	  }
	  return movies;
  }
  public void deletedirector(String name) {
	  if(director.containsKey(name)) {
	  //String  d=director.get(name);
	    if(movie_director.containsKey(name)) {
	    	List<Movie>movi=movie_director.get(name);
	    	for(Movie m:movi) {
	    		movie.remove(m.getName());
	    	}
	    	movie_director.remove(name);
	    }
	   director.remove(name);
  }
  }
  public void deleteAlldirectors() {
	  for(String d:director.keySet()) {
		  if(movie_director.containsKey(d)) {
			  List<Movie>movi=movie_director.get(d);
			  for(Movie m:movi) {
				  movie.remove(m.getName());
			  }
			  movie_director.remove(d);
		  }
		  director.remove(d);
	  }
  }
  }
