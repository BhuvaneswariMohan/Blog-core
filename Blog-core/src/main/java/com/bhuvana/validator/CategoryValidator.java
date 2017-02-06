package com.bhuvana.validator;

import com.bhuvana.exception.CategoryInvalidEntriesException;
import com.bhuvana.model.Category;

public class CategoryValidator {

	private static final String ENTER_VALID_CATEGORY_NAME = "Enter valid category name";
	private static final String ENTER_VALID_USER_ID = "Enter valid user Id";
	public void validateSave(Category category) throws CategoryInvalidEntriesException
	{
		if(category.getCategoryName()==null||"".equals(category.getCategoryName().trim()))
		{
			throw new CategoryInvalidEntriesException(ENTER_VALID_CATEGORY_NAME);
		}
		else if(category.getCategoryAuthorId().getId()<0)
		{
			throw new CategoryInvalidEntriesException(ENTER_VALID_USER_ID);
		}
		
	}
	public void validateUpdate(Category category) throws CategoryInvalidEntriesException
	{
		if(category.getCategoryName()==null||"".equals(category.getCategoryName().trim()))
		{
			throw new CategoryInvalidEntriesException(ENTER_VALID_CATEGORY_NAME);
		}
		else if(category.getCategoryAuthorId().getId()<0)
		{
			throw new CategoryInvalidEntriesException(ENTER_VALID_USER_ID);
		}
	}
	public void validateDelete(Category category) throws CategoryInvalidEntriesException
	{
		
		 if(category.getCategoryAuthorId().getId()<0)
		{
			throw new CategoryInvalidEntriesException(ENTER_VALID_USER_ID);
		}
	}
	
}

