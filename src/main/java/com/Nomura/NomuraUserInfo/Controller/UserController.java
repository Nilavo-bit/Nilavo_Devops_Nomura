package com.Nomura.NomuraUserInfo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Nomura.NomuraUserInfo.Entity.User;
import com.Nomura.NomuraUserInfo.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user)
	{
		User savedUser = service.addUser(user);
		
		return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
	}
	
	@GetMapping("/fetchUserById/{userId}")
	public ResponseEntity<User> fetchUserDetailsById(@PathVariable int userId)
	{
		return service.fetchUserDetailsById(userId);
	}
	
	@GetMapping("/check")
	public ResponseEntity<String> dockercheck()
	{
		return new ResponseEntity<String>("Hii Docker is Working fine",HttpStatus.OK);
	}
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers()
	{
		List<User> allUsers = service.getAllUsers();
		
		return new ResponseEntity<>(allUsers,HttpStatus.OK);
	}
	

}
