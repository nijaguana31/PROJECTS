package com.example.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepository repo;
	
	//get all records from the table
	public List<User> listAll()
	{
		return repo.findAll();	
	}
	
	//save the values to the table
	public void save(User usr)
	{
		repo.save(usr);
	}
	
	//retrieving the particular record
	public User get(Integer uid)
	{
		return repo.findById(uid).get();
	}
	
	//delete the particular record
	public void delete(Integer uid)
	{
		repo.deleteById(uid);
	}
}
