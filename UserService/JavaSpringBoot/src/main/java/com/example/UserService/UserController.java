package com.example.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



import jakarta.persistence.NoResultException;

public class UserController {
	@Autowired
	private UserService service;
	
	@GetMapping("/userservice")
	public List<User> list()
	{
		return service.listAll();
		
	}
	
	@PostMapping("/userservice")
	public void add(@RequestBody User usr)
	{
		service.save(usr);
	}
	
	@PutMapping("/userservice")
	public ResponseEntity<?> update(@RequestBody User usr)
	{
		service.save(usr);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	@GetMapping("/userservice/{uid}")
	public ResponseEntity<User> get(@PathVariable Integer uid)
	{
		try
		{
			
			User usr=service.get(uid);	
			return new ResponseEntity<User>(usr,HttpStatus.OK);
		}
		catch(NoResultException e)
		{
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/userservice/{uid}")
	public void delete(@PathVariable Integer uid)
	{
		service.delete(uid);
	}
}
