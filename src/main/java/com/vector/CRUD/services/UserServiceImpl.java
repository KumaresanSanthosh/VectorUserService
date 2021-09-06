package com.vector.CRUD.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.CRUD.domain.UserMeth;
import com.vector.CRUD.exceptions.CustomException;
import com.vector.CRUD.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserMeth createUser(UserMeth userMeth) {
		UserMeth user=userRepository.save(userMeth);
		return user;
	
	}

	@Override
	public UserMeth findByEmailAddress(String emailAddress) {
		Optional<UserMeth> userDetails=userRepository.findByEmailAddress(emailAddress);
		return userDetails.get();
	}

	@Override
	public UserMeth updateUser(UserMeth userMeth) {
		try {
			UserMeth userObj=userRepository.findByEmailAddress(userMeth.getEmailAddress()).get();
			
			
			if(null==userObj) {
				throw new CustomException("No Record Found");
				}
			
			userObj.setFirstName(userMeth.getFirstName());
			userObj.setLastName(userMeth.getLastName());
			userObj.setPassword(userMeth.getPassword());
			
			userRepository.save(userObj);
			
			}
			catch(Exception e) {
				throw new CustomException("Error While Updating Record");
			}
		return userMeth;
		}

	@Override
	public void deleteUser(String email) {
		try {
	
			UserMeth userObj=userRepository.findByEmailAddress(email).get();
			
			if(null==userObj) {
				throw new CustomException("No Record Found");
			}
			
			userRepository.delete(userObj);
		}
		catch(Exception e) {
			throw new CustomException("Unable to delete Record");
		}
		
		
	}




}
