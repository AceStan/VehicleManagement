package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.config.Response;
import com.model.SignedInUser;
import com.model.User;
import com.services.UserService;

@Controller
public class UserController {


	@Autowired
	private UserService userService;
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/getUserInfo", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Response<User> getUserInfo(@RequestBody User data) {
		Response<User> r = new Response<>();
		r = userService.addUser(data);
		return r;

	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/signIn", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Response<User> signIn(@RequestBody SignedInUser data) {
		Response<User> r = new Response<>();
		r = userService.signIn(data.getUsername(), data.getPassword());
		return r;

	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/getOwner", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public User getOwner(@RequestBody String id) {
		User r = new User();
		r = userService.getOwner(id);
		System.out.println("O W N E R : "+ r);
		return r;

	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ArrayList<User> getAllUsers() {
		ArrayList<User> r = new ArrayList<>();
		r = userService.getAllUsers();
		return r;

	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void deleteUser(@RequestBody User user) {
	userService.deleteUser( user);

	}
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/makeAdmin", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public User makeAdmin(@RequestBody User user) {
	User res =  new User();
	 res=userService.makeAdmin( user);
	 return res;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/AllUsersPdf", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void AllUsersPdf() throws Exception {
		System.out.println("HERE 1");
		userService.AllUsersPdf();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/AllUsersXls", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void AllUsersXls() throws Exception {
		System.out.println("HERE 2");
		userService.AllUsersXls();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/OwnersPdf", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void OwnersPdf() throws Exception {
		System.out.println("HERE 3");
		userService.OwnersPdf();
	}
	
	
}
