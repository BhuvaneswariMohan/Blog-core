package com.bhuvana.service;

import java.util.List;

import com.bhuvana.dao.ArticleCategoryDAO;
import com.bhuvana.dao.ArticlesDAO;
import com.bhuvana.dao.CategoryDAO;
import com.bhuvana.exception.ArticleInvalidEntriesException;
import com.bhuvana.exception.ServiceException;
import com.bhuvana.model.Articles;
import com.bhuvana.model.AuthorDetails;
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

		public List<Articles> provideListAllUsers() {
			ArticlesDAO articleDAO = new ArticlesDAO();
			System.out.println(articleDAO.list());
			return articleDAO.list();
		}
		public List<Articles> serviceListAllArticles() {
			ArticlesDAO articleDAO = new ArticlesDAO();
			return articleDAO.list();
		}
		public void postArticleService(Articles article,Category category,ArticlesDAO articleDAO,CategoryDAO categoryDAO) 
		{
			
			articleDAO.save(article);
			
			categoryDAO.save(category);
			ArticleCategoryDAO articleCategoryDAO = new ArticleCategoryDAO();
			articleCategoryDAO.save(articleDAO,categoryDAO);
			
		}
		public List<Articles> serviceGetArticlesPublishedByUser(AuthorDetails userDetail) {
		    ArticlesDAO articleDAO = new ArticlesDAO();
		  return articleDAO.getArticlesPublishedByUser(userDetail);
		
	}
		
	}

