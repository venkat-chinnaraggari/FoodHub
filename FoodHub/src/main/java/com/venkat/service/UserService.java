package com.venkat.service;

import java.util.List;


import com.venkat.dao.UserDAO;
import com.venkat.daoImpl.UserDAOImpl;
import com.venkat.exception.DAOException;
import com.venkat.model.User;

public class UserService {
	UserDAO userDao = new UserDAOImpl();
	
	public void save(User user) throws DAOException{
		userDao.save(user);
	}
	
	public void update(User user) throws DAOException{
		userDao.update(user);
	}
	
	public void delete(int userId) throws DAOException{
		userDao.delete(userId);
	}
	
	public User findById(int userId) throws DAOException{
		return userDao.findById(userId);
	}
	
	public User findByEmail(String email) throws DAOException
	{
		return userDao.findByEmail(email);
	}
	
	public List<User> findAll() throws DAOException{
		return userDao.findAll();
	}
}
