package xie.shu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import xie.shu.mapper.UserMapper;
import xie.shu.po.User;
import xie.shu.po.UserExample;
import xie.shu.service.LoginService;

public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private UserMapper userMapper;
	@Override
	public User Login(User user) {
		//设置查询条件
		UserExample example = new UserExample();
		example.or()
		.andNameEqualTo(user.getName())
		.andPasswordEqualTo(user.getPassword());
		
		//用查询条件查询
		List<User> users = userMapper.selectByExample(example);
		if (users.isEmpty()) {
			return null;
		}else{
			return users.get(0);
		}
	}
	@Override
	public User register(User user) {
		userMapper.insert(user); 
		int userId = userMapper.getLastUserId();
		User u = userMapper.selectByPrimaryKey(userId);
		return u;
	}

}
