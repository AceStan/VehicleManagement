package com.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class GetPathUtil{
	
	public GetPathUtil(){
	}
	
	public String getPath() throws Exception{
	ClassLoader classLoader = getClass().getClassLoader();
	File file = new File(classLoader.getResource("config/path-config.txt").getFile());
	FileInputStream fis = new FileInputStream(file);
	BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	String path = null;
	br.readLine(); // The first line isn't useful so it is just skipped
	path = br.readLine();
	br.close();
	return path;
	}
	
}
