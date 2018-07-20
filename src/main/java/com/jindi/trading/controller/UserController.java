package com.jindi.trading.controller;

import com.jindi.trading.entity.User;
import com.jindi.trading.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
	//@Autowired
	private final  UserService userService;

	@Autowired
	public UserController(UserService userService){
		this.userService = userService;
	}



	@RequestMapping("/getUser")
	public User getUser(){
		return userService.getUser("laowan");
	}

	@RequestMapping("/deleteUser")
	public String deleteUser(){
		userService.deleteUser("laowan");
		return "执行了删除";
	}

}
