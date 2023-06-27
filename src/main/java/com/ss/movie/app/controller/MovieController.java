package com.ss.movie.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ss.movie.app.model.Movie;
import com.ss.movie.app.repo.MovieRepo;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	MovieRepo movieRepo;

	@PostMapping("")
	public Movie createNewMovie(@RequestBody Movie movie) {
		return movieRepo.save(movie);
	}

	@GetMapping("/all")
	public List<Movie> fetchAllMovies(){
		return movieRepo.findAll();
	}

	@DeleteMapping("/{id}")
	public void deleteMovie(@RequestParam long id) {
		
//		TODO:Admin can only delete movie 
		
		movieRepo.deleteById(id);
	}

	@PutMapping("/{id}")
	public Movie updateMovie(@RequestParam long id,@RequestBody Movie updatedMovie) {

		Movie existingMovie = movieRepo.findById(id).orElse(null);

		if(existingMovie != null) {
			return movieRepo.save(updatedMovie);
		}

		return null;
	}


}
