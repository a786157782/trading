package com.jindi.trading.controller;

import com.jindi.trading.entity.User;
import com.jindi.trading.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {
	//@Autowired
	private final  UserService userService;


	@Autowired
	public UserController(UserService userService){
		this.userService = userService;
	}


	private RedisTemplate<String, Object> redisTemplate;

	@Autowired
	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}


	@RequestMapping("/getUser")
	public User getUser(){
		return userService.getUser(1);
	}

	@RequestMapping("/deleteUser")
	public String deleteUser(){
		userService.deleteUser(1);
		return "执行了删除";
	}

	@RequestMapping("/getlaowan")
	public User getUserByName(){
		String name = "laowan";
		return userService.findUserByName(name);

	}

	@RequestMapping("/putList")
	public void putList(){
		User user = new User("zhangsan",1);
		User user2 = new User("lisi",2);
		User user3 = new User("wangmazi",3);

		List<User> list = new ArrayList<>();
		list.add(user);
		list.add(user2);
		list.add(user3);

		redisTemplate.opsForList().leftPush("list",list);
	}


	@RequestMapping("/putListUser")
	public List<User> putListUser(){
		return userService.putListUser();
	}


	@RequestMapping("addUser")
	public void addUser(){
		User user = new User("zhangsan",1);
		user.setId(2);
		userService.addUser(user);
	}

	@RequestMapping("updateUser")
	public void updateUser(){
		User user = new User("zhangsan",1);
		user.setId(1);
		userService.updateUser(user);
	}

	@RequestMapping("/getTotalUser")
	public List<User> getTotalUser(){
		//List<User> list = (List<User>)redisTemplate.
		return null;
	}

}
