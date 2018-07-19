package com.jindi.trading.controller;

import com.jindi.trading.utils.JsonResult;
import com.jindi.trading.utils.ResultCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web")
public class TestController {

	@RequestMapping("/nimabi")
	public JsonResult sayHello(){
		Object o = "啦啦啦";
		return new JsonResult(ResultCode.SUCCESS,"请求成功",o);

	}
}
