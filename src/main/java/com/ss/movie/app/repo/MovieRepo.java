package com.ss.movie.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.movie.app.model.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie,Long> {

}