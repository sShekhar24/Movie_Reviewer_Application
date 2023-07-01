package com.ss.movie.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.movie.app.model.Movie;

public interface MovieRepo extends JpaRepository<Movie,Long> {

}
