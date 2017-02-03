package com.bhuvana.dao;



	import java.util.Iterator;
	import java.util.List;

import com.bhuvana.model.AuthorDetails;
import com.bhuvana.model.Roles;



	public class TestAuthorDetailsDAO {
		public static void main(final String[] args) {
			AuthorDetailsDAO userDAO = new 	AuthorDetailsDAO();			 
			AuthorDetails user= new  AuthorDetails();

			 user.setId(1);
			user.setName("Bhuvana");
			user.setEmailid("vfdvgsgfg");
			user.setPassword("ffgfg");
			Roles rl=new Roles();
			rl.setId(1);
			


			 userDAO.save(user);
		}
	}