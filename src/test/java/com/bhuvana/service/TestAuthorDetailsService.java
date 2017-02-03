package com.bhuvana.service;

import com.bhuvana.exception.ServiceException;
import com.bhuvana.model.AuthorDetails;

public class TestAuthorDetailsService {

	public static void main(String[] args) {
		AuthorDetailsService service= new AuthorDetailsService();
		AuthorDetails user=new AuthorDetails();
		user.setName("as");
		user.setPassword("a");
		try {
			service.provideLogin(user);
		} catch (ServiceException e) {
			e.getMessage();
		}
	}
}

