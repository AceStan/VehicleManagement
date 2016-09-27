package com.dao;

import java.util.ArrayList;

import com.model.Response;
import com.model.User;

public interface UserDao {
	public Response<User> addUser(User u);
	public Response<User> signIn(String username,String password);
	public User getOwner(String id);
	public ArrayList<User> getAllusers();
	public void deleteUser(User user);
	public User makeAdmin(User user);
	public void AllUsersPdf() throws Exception;
	public void AllUsersXls() throws Exception;
	public void OwnersPdf() throws Exception;
}
