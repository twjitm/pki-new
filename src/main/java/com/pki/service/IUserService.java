package com.pki.service;



import com.pki.entity.User;
import com.pki.utils.Page;

import java.util.List;

public interface IUserService {
	
	public void register(User user);
	public User login(String name, String psd);
	public User getUserById(int uId);

	public List<User> getUserByList(Page<User> page);
	
	public Long getUserByListLong();
}
