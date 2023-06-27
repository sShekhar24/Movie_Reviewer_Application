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

import com.ss.movie.app.model.User;
import com.ss.movie.app.repo.UserRepo;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired 
	UserRepo userRepo;

	@GetMapping("/all")
	public List<User> findAllUSers(){
		return userRepo.findAll();
	}

	@PostMapping("")
	public User createUser(@RequestBody User user) {
		return userRepo.save(user);
	}


	@DeleteMapping("/{id}")
	public void deleteReview(@RequestParam long id) {
		
//		TODO:Admin can only delete other user or user can self delete ?
		
		userRepo.deleteById(id);
	}

	@PutMapping("/{id}")
	public User updateUser(@RequestParam long id, @RequestBody User updatedUser) {

		User existingUser = userRepo.findById(id).orElse(null);

		if(existingUser != null) {
			return userRepo.save(updatedUser);
		}

		return null;


	}








}
