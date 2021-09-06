package com.vector.CRUD.services;

import com.vector.CRUD.domain.UserMeth;

public interface UserService {
	
	public UserMeth createUser(UserMeth userMeth);
	
	public UserMeth findByEmailAddress(String emailAddress);
	
	public UserMeth updateUser(UserMeth userMeth);
	
	public void deleteUser(String emailAddress);
	

}
