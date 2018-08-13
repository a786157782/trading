package com.jindi.trading.serviceImpl;

import com.jindi.trading.entity.User;
import com.jindi.trading.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService2")
public class UserServiceImpl2  implements UserService{
	@Override
	public User getUser(int id) {
		return null;
	}

	@Override
	public void deleteUser(int id) {

	}

	@Override
	public User findUserByName(String name) {
		return null;
	}

	@Override
	public List<User> putListUser() {
		return null;
	}

	@Override
	public void addUser(User user) {

	}

	@Override
	public void updateUser(User user) {

	}

	@Override
	public List<User> testNative() {
		return null;
	}

	@Override
	public void judgeWhich() {
		System.out.println("this is method 2");
	}
}
