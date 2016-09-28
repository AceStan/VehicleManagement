package com.controller;

import java.util.ArrayList;
import java.util.ResourceBundle;

import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.LanguageResponse;

@Controller
public class InitController {
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/initConfigSignIn", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public LanguageResponse initSignInStrings(@RequestBody String language) throws UnsupportedEncodingException{
		
		LanguageResponse return_res = new LanguageResponse();
		ArrayList<String> res = new ArrayList<String>();
		
		if(language.equals("english"))
		{
        ResourceBundle labels = ResourceBundle.getBundle("resource_bundles/vehicle_management");
        // WELCOME STRINGS
        res.add(labels.getString("welcome")); 
        res.add(labels.getString("signIn")); 
        res.add(labels.getString("subtitle"));
        res.add(labels.getString("username")); 
        res.add(labels.getString("password")); 
        res.add(labels.getString("signUp")); 
        res.add(labels.getString("select"));
        // USER PROFILE STRINGS
        res.add(labels.getString("user"));
        res.add(labels.getString("role"));
        res.add(labels.getString("list"));
        res.add(labels.getString("search"));
        res.add(labels.getString("searchCars"));
        res.add(labels.getString("logOut"));
        res.add(labels.getString("car"));
        res.add(labels.getString("addCar"));
        res.add(labels.getString("stats"));
        res.add(labels.getString("editUsers"));
        //SIGN UP STRINGS
        res.add(labels.getString("back"));
        res.add(labels.getString("form"));
        res.add(labels.getString("formSubtitle"));
        res.add(labels.getString("name"));
        res.add(labels.getString("lastName"));
        res.add(labels.getString("mobile"));
        res.add(labels.getString("ssid"));
        res.add(labels.getString("email"));
        //CARS STRINGS
        res.add(labels.getString("id"));
        res.add(labels.getString("brand"));
        res.add(labels.getString("model"));
        res.add(labels.getString("engine"));
        res.add(labels.getString("lastService"));
        res.add(labels.getString("fuel"));
        res.add(labels.getString("delete"));
        res.add(labels.getString("edit"));
        res.add(labels.getString("km"));
        res.add(labels.getString("add"));
        res.add(labels.getString("kms"));
        res.add(labels.getString("service"));
        //OTHER STRINGS
        res.add(labels.getString("uniqueId"));
        res.add(labels.getString("kmsls"));
        res.add(labels.getString("deleteUser"));
        res.add(labels.getString("makeAdmin"));
        res.add(labels.getString("report"));
        res.add(labels.getString("owner"));
        res.add(labels.getString("seeOwner"));
        res.add(labels.getString("doc"));
        res.add(labels.getString("results"));
        
        
		}
		else{
		
			ResourceBundle labels = ResourceBundle.getBundle("resource_bundles/vehicle_management_mk_MK");
			
			res.add(new String(labels.getString("welcome").getBytes("ISO-8859-1"),"utf-8")); // ArrayList[0] = title
			res.add(new String(labels.getString("signIn").getBytes("ISO-8859-1"),"utf-8")); // ArrayList[1] = signIn
	        res.add(new String(labels.getString("subtitle").getBytes("ISO-8859-1"),"utf-8")); // ArrayList[2] = subtitle
	        res.add(new String(labels.getString("username").getBytes("ISO-8859-1"),"utf-8")); // ArrayList[3] = username
	        res.add(new String(labels.getString("password").getBytes("ISO-8859-1"),"utf-8")); // ArrayList[4] = password
	        res.add(new String(labels.getString("signUp").getBytes("ISO-8859-1"),"utf-8")); // ArrayList[5] = signUp
	        res.add(new String(labels.getString("select").getBytes("ISO-8859-1"),"utf-8"));  // ArrayList[6] = select
	        //USER PROFILE STRINGS
	        res.add(new String(labels.getString("user").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("role").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("list").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("search").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("searchCars").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("logOut").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("car").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("addCar").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("stats").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("editUsers").getBytes("ISO-8859-1"),"utf-8"));
	        //SIGN UP STRINGS
	        res.add(new String(labels.getString("back").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("form").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("formSubtitle").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("name").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("lastName").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("mobile").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("ssid").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("email").getBytes("ISO-8859-1"),"utf-8"));
	        //CARS STRINGS
	        res.add(new String(labels.getString("id").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("brand").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("model").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("engine").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("lastService").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("fuel").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("delete").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("edit").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("km").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("add").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("kms").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("service").getBytes("ISO-8859-1"),"utf-8"));
	        //OTHER STRINGS
	        res.add(new String(labels.getString("uniqueId").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("kmsls").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("deleteUser").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("makeAdmin").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("report").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("owner").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("seeOwner").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("doc").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels.getString("results").getBytes("ISO-8859-1"),"utf-8"));
	        
		}
		return_res.setSignInStrings(res);
		return return_res ;
	}
	
}
