package com.vector.CRUD.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vector.CRUD.domain.UserMeth;

@Repository
public interface UserRepository extends JpaRepository<UserMeth, String> {
	@Query(value = "SELECT * FROM USER WHERE email =?1", nativeQuery = true)
	Optional<UserMeth> findByEmailAddress(String emailAddress);

}
