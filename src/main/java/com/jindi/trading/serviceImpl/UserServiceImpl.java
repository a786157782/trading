package com.jindi.trading.serviceImpl;

import com.jindi.trading.entity.User;
import com.jindi.trading.repository.UserRepository;
import com.jindi.trading.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private  UserRepository userRepository;



	/**
	 * 新增用户
	 * @return
	 * @CachePut 应用到写数据的方法上，如新增/修改方法，调用方法时会自动把相应的数据放入缓存
	 */

	/**
	 *删除
	 * @return
	 * @CacheEvict 应用到删除数据的方法上，调用方法时会从缓存中删除对应key的数据
	 * 会删除名称为“user”的集合对象
	 */


	/**
	 *根据name和id查询
	 *
	 *
	 * 1、@Cacheable：作用是主要针对方法配置，能够根据方法的请求参数对其结果进行缓存
	 主要参数说明：
	 (1)value ：
	 缓存的名称，在 spring 配置文件中定义，必须指定至少一个，例如：@Cacheable(value=”mycache”) 或者 @Cacheable(value={”cache1”,”cache2”}。
	 (2)key ：缓存的 key，可以为空，如果指定要按照 SpEL 表达式编写，如果不指定，则缺省按照方法的所有参数进行组合，例如：@Cacheable(value=”testcache”,key=”#userName”)。
	 (3)condition ：缓存的条件，可以为空，使用 SpEL 编写，返回 true 或者 false，只有为 true 才进行缓存，例如：@Cacheable(value=”testcache”,condition=”#userName.length()>2。
	 *
	 *
	 *
	 * @Cacheable 应用到读取数据的方法上，
	 * 先从缓存中读取，如果没有再从DB获取数据，然后把数据添加到缓存中
	 * value 非必填。用于注定缓存数据的储存集合名称
	 * unless 表示条件表达式成立的话不放入缓存
	 */
	@Override
	@Cacheable(value="users", key="'user_'+#id")
	public User getUser(int id) {
		System.out.println(id+"进入实现类获取数据！");
		User user = new User();
		user.setId(id);
		user.setName("香菇");
		user.setAge(18);
		return user;
	}


	@Override
	@CacheEvict(value="users", key="'user_'+#id",condition="#id!=1")
	public void deleteUser(int id) {
		System.out.println(id+"进入实现类删除数据！");
	}

	@Override
	@Cacheable(value = "getAllUsers")
	public User findUserByName(String name) {
		return userRepository.findByName(name);
	}

	@Override
	@Cacheable(value="listUser",key="'user_'+#User.id")
	public List<User> putListUser() {
		User user = new User();
		user.setId(11);
		user.setName("香菇");
		user.setAge(18);


		User user2 = new User();
		user2.setId(111);
		user2.setName("香菇2");
		user2.setAge(182);

		List<User> list2 = new ArrayList<>();
		list2.add(user);
		list2.add(user2);

		return list2;
	}

	@Override
	@Cacheable(value="totalUser",key="'userid'+#user.id")
	public void addUser(User user) {
		//数据库存储方法需放在外面,id自动增长,但是这里不会增长,需要先保存到库 然后调用adduser到redis,或者直接用redisTemolate保存
		userRepository.save(user);
		System.out.println("redis 添加 user");
	}

	@Override
	@CachePut(value="totalUser",key="'userid'+#user.id")
	public void updateUser(User user) {
		System.out.println("redis update user");

	}


	@Override
	public List<User> testNative() {
		return userRepository.listUsers();
	}
}
