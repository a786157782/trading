package com.jindi.trading.controller;

import com.jindi.trading.utils.JsonResult;
import com.jindi.trading.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web")
public class TestController {


	//使用构造器注入String redis
	private final StringRedisTemplate template;

	@Autowired
	public TestController(StringRedisTemplate template) {
		this.template = template;
	}


	private RedisTemplate<String, Object> redisTemplate;

	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}



	//连接测试
	@RequestMapping("/liupia")
	public JsonResult sayHello(){
		Object o = "啦啦啦";
		return new JsonResult(ResultCode.SUCCESS,"请求成功",o);

	}

	//String redis存储测试
	@RequestMapping("/setValue")
	public JsonResult setValue(){
		Object b = template.hasKey("dongguai");
		if (null == b){
			return new JsonResult(ResultCode.SUCCESS,"请求成功","redis出错");
		}

		if(!(Boolean)b){
			template.opsForValue().append("dongguai", "我是洞拐");
			return new JsonResult(ResultCode.SUCCESS,"请求成功","使用redis缓存保存数据成功");
		}else{
			template.delete("dongguai");
			return new JsonResult(ResultCode.SUCCESS,"请求成功","key已存在");
		}

	}

	//String redis取值测试
	@RequestMapping("/getValue")
	public JsonResult getValue() {
		Object b = template.hasKey("dongguai");
		if (null == b){
			return new JsonResult(ResultCode.SUCCESS,"请求成功","redis出错");
		}

		if (!(Boolean)b) {
			return new JsonResult(ResultCode.SUCCESS,"请求成功","key不存在，请先保存数据");
		} else {
			String dongguai = template.opsForValue().get("dongguai");//根据key获取缓存中的val
			return new JsonResult(ResultCode.SUCCESS,"请求成功","获取到缓存中的数据：dongguai=" + dongguai);
		}

	}
}
