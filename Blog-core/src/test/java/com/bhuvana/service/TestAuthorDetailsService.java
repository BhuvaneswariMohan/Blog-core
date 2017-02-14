package com.bhuvana.service;

import com.bhuvana.dao.AuthorDetailsDAO;
import com.bhuvana.exception.ServiceException;
import com.bhuvana.model.AuthorDetails;
import com.bhuvana.model.Roles;

public class TestAuthorDetailsService {

	public static void main(String[] args) {
		AuthorDetailsService service= new AuthorDetailsService();
		AuthorDetails user=new AuthorDetails();
		AuthorDetailsDAO dao=new AuthorDetailsDAO();
//		user.setName("bb");
//		user.setPassword("a");
//		try {
//			service.provideLogin(user);
//		} catch (ServiceException e) {
//			e.getMessage();
//		}
		//user.setId(3);
		user.setName("aaa");
		
		user.setEmailid("aaa@gmail.com");
		user.setPassword("aaa");
		Roles roleid=new Roles();
		roleid.setId(1);
		user.setRole(roleid);
		dao.save(user);
	}
}

