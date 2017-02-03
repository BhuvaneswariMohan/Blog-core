package com.bhuvana.service;

import com.bhuvana.dao.ArticleCategoryDAO;
import com.bhuvana.dao.ArticlesDAO;
import com.bhuvana.dao.CategoryDAO;
import com.bhuvana.exception.ArticleInvalidEntriesException;
import com.bhuvana.exception.ServiceException;
import com.bhuvana.model.Articles;
import com.bhuvana.model.Category;
import com.bhuvana.validator.ArticlesValidator;

public class ArticlesService {
		public void provideSave(Articles article) throws ServiceException {
			ArticlesValidator articleValidator = new ArticlesValidator();
			ArticlesDAO articleDAO = new ArticlesDAO();
			try {
				articleValidator.validateSave(article);
				articleDAO.save(article);

			} catch (ArticleInvalidEntriesException e) {
				throw new ServiceException(e.getMessage(), e);
			}
		}

		public void provideUpdate(Articles article) throws ServiceException {
			ArticlesValidator articleValidator = new ArticlesValidator();
			ArticlesDAO articleDAO = new ArticlesDAO();
			try {
				articleValidator.validateUpdate(article);
				articleDAO.update(article);

			} catch (ArticleInvalidEntriesException e) {
				throw new ServiceException(e.getMessage(), e);
			}
		}

		public void provideDelete(Articles article) throws ServiceException {
			ArticlesValidator articleValidator = new ArticlesValidator();
			ArticlesDAO articleDAO = new ArticlesDAO();
			try {
				articleValidator.validateDelete(article);
				articleDAO.delete(article);

			} catch (ArticleInvalidEntriesException e) {
				throw new ServiceException(e.getMessage(), e);
			}
		}

		public void provideListAllUsers() {
			ArticlesDAO articleDAO = new ArticlesDAO();
			System.out.println(articleDAO.list());
		}
		public void postArticleService(Articles article,Category category,ArticlesDAO articleDAO,CategoryDAO categoryDAO) 
		{
			
			articleDAO.save(article);
			
			categoryDAO.save(category);
			ArticleCategoryDAO articleCategoryDAO = new ArticleCategoryDAO();
			articleCategoryDAO.save(articleDAO,categoryDAO);
			
		}
	}

