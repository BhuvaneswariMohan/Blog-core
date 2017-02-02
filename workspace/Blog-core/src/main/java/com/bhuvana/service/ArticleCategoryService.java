package com.bhuvana.service;

import com.bhuvana.dao.ArticleCategoryDAO;
import com.bhuvana.exception.ArticleCategoryInvalidEntriesException;
import com.bhuvana.exception.ServiceException;
import com.bhuvana.model.ArticleCategory;
import com.bhuvana.validator.ArticleCategoryValidator;

public class ArticleCategoryService {
		public void provideSave(ArticleCategory articleCategory) throws ServiceException {
			ArticleCategoryValidator articleCategoryValidator = new ArticleCategoryValidator();
			ArticleCategoryDAO articleCategoryDAO = new ArticleCategoryDAO();
			try {
				articleCategoryValidator.validateSave(articleCategory);
				articleCategoryDAO.save(articleCategory);
			} catch (ArticleCategoryInvalidEntriesException e) {
				throw new ServiceException(e.getMessage(), e);
			}
		}

		public void provideUpdate(ArticleCategory articleCategory) throws ServiceException {
			ArticleCategoryValidator articleCategoryValidator = new ArticleCategoryValidator();
			ArticleCategoryDAO articleCategoryDAO = new ArticleCategoryDAO();
			try {
				articleCategoryValidator.validateUpdate(articleCategory);
				articleCategoryDAO.update(articleCategory);
			} catch (ArticleCategoryInvalidEntriesException e) {
				throw new ServiceException(e.getMessage(), e);
			}
		}

		public void provideDelete(ArticleCategory articleCategory) throws ServiceException {
			ArticleCategoryValidator articleCategoryValidator = new ArticleCategoryValidator();
			ArticleCategoryDAO articleCategoryDAO = new ArticleCategoryDAO();
			try {
				articleCategoryValidator.validateDelete(articleCategory);
				articleCategoryDAO.delete(articleCategory);
			} catch (ArticleCategoryInvalidEntriesException e) {
				throw new ServiceException(e.getMessage(), e);
			}
		}

		public void listAllArticleCategory() {
			ArticleCategoryDAO articleCategoryDAO = new ArticleCategoryDAO();
			articleCategoryDAO.list();
		}
	}

