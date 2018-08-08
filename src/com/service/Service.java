package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dao.Dao;

@Component
public class Service {
	@Autowired// automtic object creation--@ controller class obj can be created anywhere
	Dao dao;
	
public	int verification(String user,String pass)
	{
		return dao.verification(user,pass);
	
	}


}
