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

import com.ss.movie.app.model.Review;
import com.ss.movie.app.repo.ReviewRepo;

@RestController
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	ReviewRepo reviewRepo;

	@GetMapping("/all")
	public List<Review> getAllReviews(@RequestBody Review review){
		return reviewRepo.findAll();
	}

	@PostMapping("")
	public Review createNewReview(@RequestBody Review review) {
		return reviewRepo.save(review);
	}

	@DeleteMapping("/{id}")
	public void deleteReview(@RequestParam long id) {
		reviewRepo.deleteById(id);
	}

	@PutMapping("/{id}")
	public Review updateReview(@RequestParam long id,@RequestBody Review updatedReview) {

		Review existingReview = reviewRepo.findById(id).orElse(null);

		if(existingReview != null) {
			return reviewRepo.save(updatedReview);
		}

		return existingReview;

	}


}
