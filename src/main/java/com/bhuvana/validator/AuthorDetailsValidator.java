package com.bhuvana.validator;

import com.bhuvana.exception.UserInvalidEntriesException;
import com.bhuvana.model.AuthorDetails;

public class AuthorDetailsValidator {
	private static final String ENTER_PROPER_EMAIL_ID = "Enter proper email id";
	private static final String ENTER_PROPER_PASSWORD = "Enter proper password";
	private static final String ENTER_PROPER_USER_NAME = "Enter proper user name";
	public void validateSave(AuthorDetails user) throws UserInvalidEntriesException
	{
	if(user.getName()==null||"".equals(user.getName()))
	{
		throw new UserInvalidEntriesException(ENTER_PROPER_USER_NAME);
	}
	else if(user.getPassword()==null||"".equals(user.getPassword().trim()))
	{
		throw new UserInvalidEntriesException(ENTER_PROPER_PASSWORD);
	}
	else if(user.getEmailid()==null||"".equals(user.getEmailid().trim()))
	{
		throw new UserInvalidEntriesException(ENTER_PROPER_EMAIL_ID);
	}
	}
	public void validateUpdate(AuthorDetails user) throws UserInvalidEntriesException
	{
		if(user.getName()==null||"".equals(user.getName()))
		{
			throw new UserInvalidEntriesException(ENTER_PROPER_USER_NAME);
		}
		else if(user.getPassword()==null||"".equals(user.getPassword().trim()))
		{
			throw new UserInvalidEntriesException(ENTER_PROPER_PASSWORD);
		}	
	}
	public void validateDelete(AuthorDetails user) throws UserInvalidEntriesException
	{
		if(user.getId()<0)
		{
			throw new UserInvalidEntriesException("Enter Valid ID");
		}
	}
}
