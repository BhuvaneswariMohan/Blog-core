package com.bhuvana.service;

import java.util.List;

import com.bhuvana.dao.CategoryDAO;
import com.bhuvana.exception.CategoryInvalidEntriesException;
import com.bhuvana.exception.ServiceException;
import com.bhuvana.model.Category;
import com.bhuvana.validator.CategoryValidator;

public class CategoryService {
	public void provideSave(Category category) throws ServiceException {
		CategoryValidator categoryValidator = new CategoryValidator();
		CategoryDAO categoryDAO = new CategoryDAO();
		try {
			categoryValidator.validateSave(category);
			categoryDAO.save(category);
		} catch (CategoryInvalidEntriesException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void provideUpdate(Category category) throws ServiceException {
		CategoryValidator categoryValidator = new CategoryValidator();
		CategoryDAO categoryDAO = new CategoryDAO();
		try {
			categoryValidator.validateUpdate(category);
			categoryDAO.update(category);
		} catch (CategoryInvalidEntriesException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void provideDelete(Category category) throws ServiceException {
		CategoryValidator categoryValidator = new CategoryValidator();
		CategoryDAO categoryDAO = new CategoryDAO();
		try {
			categoryValidator.validateDelete(category);
			categoryDAO.delete(category);
		} catch (CategoryInvalidEntriesException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<Category> provideListAllCategories() {
		CategoryDAO categoryDAO = new CategoryDAO();
		return categoryDAO.list();
	}
}

