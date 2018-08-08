package com.dao;

import java.io.*;

import org.springframework.stereotype.Component;

@Component
public class Dao {

public	int verification(String user,String pass)
	{
	int status=0;
		try{
			
			File file=new File("C:\\Documents\\credentials.txt");
			BufferedReader br=new BufferedReader(new FileReader(file));
			user=user.concat(" ");
			String word=user.concat(pass);
			String str;
			while((str=br.readLine())!=null){
				if(word.equals(str))
					status=1;
			}
			
		}
		catch(Exception e){
			System.out.println(e);
		}
	return status;
	}
	
}
