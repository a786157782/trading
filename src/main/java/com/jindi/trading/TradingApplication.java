package com.jindi.trading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@RestController
@EnableCaching
public class TradingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradingApplication.class, args);
	}

/*	private static Logger logger= LoggerFactory.getLogger(TradingApplication.class);
	@RequestMapping("/hello")
	public String helloWorld(){
		//logger.info("liupi a ");
		return "hello world";
	}*/
}
