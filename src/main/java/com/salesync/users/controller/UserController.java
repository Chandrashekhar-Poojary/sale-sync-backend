package com.salesync.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.salesync.users.entity.Users;
import com.salesync.users.repository.UsersRepository;

@RestController
public class UserController {
	
	@Autowired
	UsersRepository userRepo;
	
	//get all users already registered
	@CrossOrigin
	@GetMapping("/user")
	public List<Users> getAllUsers(){
		List<Users> users = userRepo.findAll();
		
		
		return users;
	}
	
	@CrossOrigin
	@GetMapping("/user/{id}")
	public Users getStudent(@PathVariable int id) {
		Users user = userRepo.findById(id).get();
		
		return user;
	}

	// create user
	@CrossOrigin
	@PostMapping("/user/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Users createUser(@RequestBody Users user) {
		Users save = userRepo.save(user);
		
		return save;
	}
	
	//update user
	@CrossOrigin
	@PutMapping("/user/update/{id}")
	public Users updateUsers(@PathVariable int id, @RequestBody Users user) {
		//Users user1 = userRepo.findById(id).get();
		user.setUsername(user.getUsername());
		user.setPassword(user.getPassword());
		
		Users save = userRepo.save(user); 
		
		return save;
		
	}
	
	@CrossOrigin
	@DeleteMapping("/user/delete/{id}")
	public void deleteUser(@PathVariable int id) {
		
		Users user = userRepo.findById(id).get();
		
		userRepo.delete(user);
		
	}
}
