package com.ss.movie.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import com.ss.movie.app.model.User;

public interface UserRepo extends JpaRepository<User,Long> {

	@Query("select u from User u where u.username=?1")
	UserDetails findByUsername(String username);

}
