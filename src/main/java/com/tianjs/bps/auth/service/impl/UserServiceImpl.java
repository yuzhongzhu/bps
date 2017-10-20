package com.tianjs.bps.auth.service.impl;



import java.util.Set;

import com.tianjs.bps.auth.entity.User;
import com.tianjs.bps.auth.service.UserService;

public class UserServiceImpl implements UserService {

	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public void changePassword(Long userId, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	public void correlationRoles(Long userId, Long... roleIds) {
		// TODO Auto-generated method stub
		
	}

	public void uncorrelationRoles(Long userId, Long... roleIds) {
		// TODO Auto-generated method stub
		
	}

	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> findRoles(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> findPermissions(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
