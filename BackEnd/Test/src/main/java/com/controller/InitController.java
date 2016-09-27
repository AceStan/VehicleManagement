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
        ResourceBundle labels = ResourceBundle.getBundle("resource_bundles/sign_in_page/signIn");
        ResourceBundle labels1 = ResourceBundle.getBundle("resource_bundles/user_profile_page/userProfile");
        ResourceBundle labels2 = ResourceBundle.getBundle("resource_bundles/sign_up_page/signUp");
        ResourceBundle labels3 = ResourceBundle.getBundle("resource_bundles/cars_page/cars");
        ResourceBundle labels4 = ResourceBundle.getBundle("resource_bundles/other_required_strings/other");
        // WELCOME STRINGS
        res.add(labels.getString("title")); // ArrayList[0] = title
        res.add(labels.getString("signIn")); // ArrayList[1] = signIn
        res.add(labels.getString("subtitle")); // ArrayList[2] = subtitle
        res.add(labels.getString("username")); // ArrayList[3] = username
        res.add(labels.getString("password")); // ArrayList[4] = password
        res.add(labels.getString("signUp")); // ArrayList[5] = signUp
        res.add(labels.getString("select")); // ArrayList[6] = select
        // USER PROFILE STRINGS
        res.add(labels1.getString("user"));
        res.add(labels1.getString("role"));
        res.add(labels1.getString("list"));
        res.add(labels1.getString("search"));
        res.add(labels1.getString("searchCars"));
        res.add(labels1.getString("logOut"));
        res.add(labels1.getString("car"));
        res.add(labels1.getString("addCar"));
        res.add(labels1.getString("stats"));
        res.add(labels1.getString("editUsers"));
        //SIGN UP STRINGS
        res.add(labels2.getString("back"));
        res.add(labels2.getString("form"));
        res.add(labels2.getString("formSubtitle"));
        res.add(labels2.getString("name"));
        res.add(labels2.getString("lastName"));
        res.add(labels2.getString("mobile"));
        res.add(labels2.getString("ssid"));
        res.add(labels2.getString("email"));
        //CARS STRINGS
        res.add(labels3.getString("id"));
        res.add(labels3.getString("brand"));
        res.add(labels3.getString("model"));
        res.add(labels3.getString("engine"));
        res.add(labels3.getString("lastService"));
        res.add(labels3.getString("fuel"));
        res.add(labels3.getString("delete"));
        res.add(labels3.getString("edit"));
        res.add(labels3.getString("km"));
        res.add(labels3.getString("add"));
        res.add(labels3.getString("kms"));
        res.add(labels3.getString("service"));
        //OTHER STRINGS
        res.add(labels4.getString("uniqueId"));
        res.add(labels4.getString("kmsls"));
        res.add(labels4.getString("deleteUser"));
        res.add(labels4.getString("makeAdmin"));
        res.add(labels4.getString("report"));
        res.add(labels4.getString("owner"));
        res.add(labels4.getString("seeOwner"));
        res.add(labels4.getString("doc"));
        res.add(labels4.getString("results"));
        
        
		}
		else{
		
			ResourceBundle labels = ResourceBundle.getBundle("resource_bundles/sign_in_page/signIn_mk_MK");
			ResourceBundle labels1 = ResourceBundle.getBundle("resource_bundles/user_profile_page/userProfile_mk_MK");
			ResourceBundle labels2 = ResourceBundle.getBundle("resource_bundles/sign_up_page/signUp_mk_MK");
			ResourceBundle labels3 = ResourceBundle.getBundle("resource_bundles/cars_page/cars_mk_MK");			
			ResourceBundle labels4 = ResourceBundle.getBundle("resource_bundles/other_required_strings/other_mk_MK");// SIGN IN STRINGS
			res.add(new String(labels.getString("title").getBytes("ISO-8859-1"),"utf-8")); // ArrayList[0] = title
			res.add(new String(labels.getString("signIn").getBytes("ISO-8859-1"),"utf-8")); // ArrayList[1] = signIn
	        res.add(new String(labels.getString("subtitle").getBytes("ISO-8859-1"),"utf-8")); // ArrayList[2] = subtitle
	        res.add(new String(labels.getString("username").getBytes("ISO-8859-1"),"utf-8")); // ArrayList[3] = username
	        res.add(new String(labels.getString("password").getBytes("ISO-8859-1"),"utf-8")); // ArrayList[4] = password
	        res.add(new String(labels.getString("signUp").getBytes("ISO-8859-1"),"utf-8")); // ArrayList[5] = signUp
	        res.add(new String(labels.getString("select").getBytes("ISO-8859-1"),"utf-8"));  // ArrayList[6] = select
	        //USER PROFILE STRINGS
	        res.add(new String(labels1.getString("user").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels1.getString("role").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels1.getString("list").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels1.getString("search").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels1.getString("searchCars").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels1.getString("logOut").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels1.getString("car").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels1.getString("addCar").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels1.getString("stats").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels1.getString("editUsers").getBytes("ISO-8859-1"),"utf-8"));
	        //SIGN UP STRINGS
	        res.add(new String(labels2.getString("back").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels2.getString("form").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels2.getString("formSubtitle").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels2.getString("name").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels2.getString("lastName").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels2.getString("mobile").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels2.getString("ssid").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels2.getString("email").getBytes("ISO-8859-1"),"utf-8"));
	        //CARS STRINGS
	        res.add(new String(labels3.getString("id").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels3.getString("brand").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels3.getString("model").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels3.getString("engine").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels3.getString("lastService").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels3.getString("fuel").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels3.getString("delete").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels3.getString("edit").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels3.getString("km").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels3.getString("add").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels3.getString("kms").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels3.getString("service").getBytes("ISO-8859-1"),"utf-8"));
	        //OTHER STRINGS
	        res.add(new String(labels4.getString("uniqueId").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels4.getString("kmsls").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels4.getString("deleteUser").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels4.getString("makeAdmin").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels4.getString("report").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels4.getString("owner").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels4.getString("seeOwner").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels4.getString("doc").getBytes("ISO-8859-1"),"utf-8"));
	        res.add(new String(labels4.getString("results").getBytes("ISO-8859-1"),"utf-8"));
	        
		}
		return_res.setSignInStrings(res);
		return return_res ;
	}
	
}
