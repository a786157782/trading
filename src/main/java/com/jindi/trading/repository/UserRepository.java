package com.jindi.trading.repository;

import com.jindi.trading.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {

	User findByName(String name);


	@Query(value = "select u.id,u.name from users u",nativeQuery = true)
	List<User> listUsers();
}
