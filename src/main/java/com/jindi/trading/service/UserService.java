package com.jindi.trading.service;

import com.jindi.trading.entity.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

public interface UserService {

	User getUser(String id);


	void deleteUser(String id);
}
