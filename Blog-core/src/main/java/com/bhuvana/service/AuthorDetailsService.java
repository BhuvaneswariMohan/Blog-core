package com.bhuvana.service;

import com.bhuvana.dao.AuthorDetailsDAO;
import com.bhuvana.exception.ServiceException;
import com.bhuvana.exception.UserInvalidEntriesException;
import com.bhuvana.model.AuthorDetails;
import com.bhuvana.validator.AuthorDetailsValidator;

public class AuthorDetailsService {
		public void provideSave(AuthorDetails user) throws ServiceException {
			AuthorDetailsValidator userValidator = new AuthorDetailsValidator();
			AuthorDetailsDAO userDAO = new AuthorDetailsDAO();

			try {
				userValidator.validateSave(user);
				userDAO.save(user);
			} catch (UserInvalidEntriesException e) {
				throw new ServiceException(e.getMessage(), e);
			}

		}

		public void provideUpdate(AuthorDetails user) throws ServiceException {
			AuthorDetailsValidator userValidator = new AuthorDetailsValidator();
			AuthorDetailsDAO userDAO = new AuthorDetailsDAO();

			try {
				userValidator.validateUpdate(user);
				userDAO.update(user);
			} catch (UserInvalidEntriesException e) {
				throw new ServiceException(e.getMessage(), e);
			}

		}

		public void provideDelete(AuthorDetails user) throws ServiceException {
			AuthorDetailsValidator userValidator = new AuthorDetailsValidator();
			AuthorDetailsDAO userDAO = new AuthorDetailsDAO();

			try {
				userValidator.validateDelete(user);
				userDAO.delete(user);
			} catch (UserInvalidEntriesException e) {
				throw new ServiceException(e.getMessage(), e);
			}

		}
		public void provideLogin(AuthorDetails user) throws ServiceException {
			AuthorDetailsValidator userValidator = new AuthorDetailsValidator();
			AuthorDetailsDAO userDAO = new AuthorDetailsDAO();

			try {
				userValidator.validateUpdate(user);
				userDAO.login(user);
			} catch (UserInvalidEntriesException e) {
				throw new ServiceException(e.getMessage(), e);
			}

		}
		

//		public void provideListAllUsers() {
//			AuthorDetailsDAO userDAO = new AuthorDetailsDAO();
//			userDAO.list();
//		}
//		public int login() throws ServiceException
//		{   AuthorDetailsDAO userDAO = new AuthorDetailsDAO();
//		    AuthorDetails user = new AuthorDetails();
//		    try{
//		    	if(userDAO.isValidUserName(user.getName()))
//		    	{
//		    		throw new Exception("Invalid Username");
//		    	}
//		    	else if(!userDAO.isValidPassword(user.getName(), user.getPassword()))
//	    		{
//	    		  throw new Exception("Invalid Password");
//	    		}
//		    }
//		    catch(Exception e)
//		    {
//		    	throw new ServiceException("Unable to login",e);
//		    }
//			return 1;
//			
//			
		}
