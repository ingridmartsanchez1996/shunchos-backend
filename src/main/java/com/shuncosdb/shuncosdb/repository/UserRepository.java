package com.shuncosdb.shuncosdb.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.shuncosdb.shuncosdb.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
