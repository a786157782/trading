package com.jindi.trading.service;

import com.jindi.trading.entity.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface UserService {

	User getUser(int id);


	void deleteUser(int id);

	User findUserByName(String name);

	List<User> putListUser();


	void addUser(User user);


	void updateUser(User user);

	List<User> testNative();


}
