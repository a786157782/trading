package com.jindi.trading.serviceImpl;

import com.jindi.trading.entity.User;
import com.jindi.trading.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


	@Override
	@Cacheable(value="users", key="'user_'+#id")
	public User getUser(String id) {
		System.out.println(id+"进入实现类获取数据！");
		User user = new User();
		user.setId(id);
		user.setName("香菇");
		user.setAge(18);
		return user;
	}


	@Override
	@CacheEvict(value="users", key="'user_'+#id",condition="#id!=1")
	public void deleteUser(String id) {
		System.out.println(id+"进入实现类删除数据！");
	}

}
