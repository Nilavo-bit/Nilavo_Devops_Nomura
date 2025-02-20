package com.Nomura.NomuraUserInfo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Nomura.NomuraUserInfo.Entity.User;
import com.Nomura.NomuraUserInfo.Repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;

	public User addUser(User user) {
		
		User saveUser = repo.save(user);
		return saveUser;
	}

	public ResponseEntity<User> fetchUserDetailsById(int userId) {
		
		Optional<User> byId = repo.findById(userId);
		
		if(byId.isPresent())
		{
			return new ResponseEntity<User>(byId.get(),HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}

	public List<User> getAllUsers() {
		
		List<User> all = repo.findAll();
		
		return all;
	}
	
	

}
