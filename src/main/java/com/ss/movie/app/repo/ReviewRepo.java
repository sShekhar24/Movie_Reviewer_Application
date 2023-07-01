package com.ss.movie.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.movie.app.model.Review;

public interface ReviewRepo extends JpaRepository<Review,Long> {

}
