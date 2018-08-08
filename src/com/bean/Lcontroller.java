package com.bean;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bean.CustomPath;
import com.service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Lcontroller {

@Autowired
Service service;		

@RequestMapping("/login.htm")
 public ModelAndView logincon(HttpServletRequest request,
		HttpServletResponse response) throws Exception
{
	System.out.println("inside servlet nigga");
	String username=request.getParameter("USERNAME");
	String password=request.getParameter("PASSWORD");
 int status=service.verification(username,password);
 ModelAndView mView=new ModelAndView();
 
 if(status==1)
 {
	 mView.addObject("MESSAGE","welcome "+username);
	 mView.setViewName("/postLogin");// goes to that page (prefix sufix)//goes viewresolver
 }
 else
	 {mView.addObject("MESSAGE","Invalid details");
 mView.setViewName("/login");
	 }
 //if(username.equals("ajay")) mView.setViewName("multi");
 return mView;
	
}
	

@RequestMapping("/uploadFile.htm")
public ModelAndView uploadFileHandler(@RequestParam("file") MultipartFile file) {
 ModelAndView mView=new ModelAndView();
	if (!file.isEmpty()) {
		try {
			byte[] bytes = file.getBytes();

			ApplicationContext context = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			CustomPath path = (CustomPath) context.getBean("custompath");
			String rootPath=path.getPath();
			
			
			
			// Creating the directory to store file
			//String rootPath = "C:\\Users\\ajay\\Desktop\\wOrk\\Har\\uploadedfiles";//System.getProperty("catalina.home");
			
			System.out.println("root path:"+rootPath);
			File dir = new File(rootPath + File.separator + "tmpFiles");
			if (!dir.exists())
				dir.mkdirs();

			// Create the file on server
			File serverFile = new File(dir.getAbsolutePath()
					+ File.separator+file.getOriginalFilename());
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();

			mView.addObject("MESSAGE1","You successfully uploaded file");
		} catch (Exception e) {
			mView.addObject("MESSAGE1","You failed to upload " + e.getMessage());
		}
	} else {
		mView.addObject("MESSAGE1","You failed to upload  because the file was empty.");
	}
	
	mView.setViewName("/postLogin");
	return mView;
}

//multiple upload controller

@RequestMapping("/multifile.htm")
public ModelAndView uploadMultipleFileHandler(@RequestParam("file") MultipartFile[] files) {


	 ModelAndView mView=new ModelAndView();
	String message = "";
	for (int i = 0; i < files.length; i++) {
		MultipartFile file = files[i];
			try {
			byte[] bytes = file.getBytes();

			// Creating the directory to store file
			String rootPath = "C:\\Users\\ajay\\Desktop\\wOrk\\Har\\uploadedfiles";
			File dir = new File(rootPath + File.separator + "tmpFiles");
			if (!dir.exists())
				dir.mkdirs();

			// Create the file on server
			File serverFile = new File(dir.getAbsolutePath()
					+ File.separator + file.getOriginalFilename());
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();

			
			message = message + "You successfully uploaded file=" + file.getOriginalFilename()
					+ "<br />";
		} catch (Exception e) {
			mView.addObject("MESSAGE1", "You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage());
		}
	}
	mView.addObject("MESSAGE1",message);
	mView.setViewName("multi");
	return mView;
}
	
	
}

