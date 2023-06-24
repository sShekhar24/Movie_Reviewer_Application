package com.ss.movie.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
}
