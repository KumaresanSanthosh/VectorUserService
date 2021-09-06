package com.vector.CRUD.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vector.CRUD.domain.UserMeth;
import com.vector.CRUD.exceptions.CustomException;
import com.vector.CRUD.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping
	public ResponseEntity<?> createUser(@Valid @RequestBody UserMeth userMeth) {
		
		UserMeth userDetails=userService.createUser(userMeth);
		return new ResponseEntity<>(userDetails,HttpStatus.CREATED);
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<?> getUser(@PathVariable(required=true) String email) {
		System.out.println("coming to get user");
		UserMeth userDetails = userService.findByEmailAddress(email);

		return new ResponseEntity<>(userDetails, HttpStatus.OK);
	}
	
	@PutMapping("/{email}")
	public ResponseEntity<?> updateUser(@Valid @RequestBody UserMeth userMeth) {

		if (null == userMeth.getEmailAddress() || userMeth.getEmailAddress() == null) {
			throw new CustomException("Invalid Record");
		}

		UserMeth userDetails = userService.updateUser(userMeth);

		return new ResponseEntity<>(userDetails, HttpStatus.OK);
	}

	@DeleteMapping("/{email}")
	public ResponseEntity<?> deleteUser(@PathVariable(required = true) String email) {

		try {
			userService.deleteUser(email);
		} catch (Exception e) {
			throw new CustomException("Error while Deleting Record");
		}
		
		Map<String,Object> map=new HashMap<>();
		map.put("message", "Record Deleted :: "+email);

		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
}
