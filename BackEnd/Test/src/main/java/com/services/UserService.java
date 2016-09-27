package com.services;


import java.util.ArrayList;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.model.Response;
import com.model.User;
import com.util.HibernateUtil;


@Service
public class UserService {
	
	SessionFactory sf = HibernateUtil.getSessionFactory();
	
	@Autowired
	private UserDao userDao;
	
	
	
	public Response<User> addUser(User u) {
		
		return userDao.addUser(u);

	}
	public Response<User> signIn(String username,String password){
		return userDao.signIn(username, password);
	}
	
	public User getOwner(String id){
		return userDao.getOwner(id);
	}
	public ArrayList<User> getAllUsers(){
		return userDao.getAllusers();
	}
	public void deleteUser(User user){
			userDao.deleteUser(user);
	}
	public User makeAdmin(User user){
		return userDao.makeAdmin(user);
	}
	public void AllUsersPdf() throws Exception
	{
		userDao.AllUsersPdf();
	}
	public void AllUsersXls() throws Exception{
		userDao.AllUsersXls();
	}
	public void OwnersPdf() throws Exception{
		userDao.OwnersPdf();
	}

}
		
	
