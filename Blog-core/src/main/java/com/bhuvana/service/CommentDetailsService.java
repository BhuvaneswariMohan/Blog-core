package com.bhuvana.service;

import java.util.List;

import com.bhuvana.dao.CommentDetailsDAO;
import com.bhuvana.exception.ArticleInvalidEntriesException;
import com.bhuvana.exception.CommentsInvalidEntriesException;
import com.bhuvana.exception.ServiceException;
import com.bhuvana.model.Articles;
import com.bhuvana.model.CommentDetails;
import com.bhuvana.validator.ArticlesValidator;
import com.bhuvana.validator.CommentDetailsValidator;

public class CommentDetailsService {
	
	public void provideSave(CommentDetails comments) throws ServiceException {
		CommentDetailsValidator commentsValidator = new CommentDetailsValidator();
		CommentDetailsDAO commentsDAO = new CommentDetailsDAO();

		try {
			commentsValidator.validateSave(comments);
			commentsDAO.save(comments);
		} catch (CommentsInvalidEntriesException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void provideUpdate(CommentDetails comments) throws ServiceException {
		CommentDetailsValidator commentsValidator = new CommentDetailsValidator();
		CommentDetailsDAO commentsDAO = new CommentDetailsDAO();

		try {
			commentsValidator.validateUpdate(comments);
			commentsDAO.update(comments);
		} catch (CommentsInvalidEntriesException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void provideDelete(CommentDetails comments) throws ServiceException {
		CommentDetailsValidator commentsValidator = new CommentDetailsValidator();
		CommentDetailsDAO commentsDAO = new CommentDetailsDAO();

		try {
			commentsValidator.validateDelete(comments);
			commentsDAO.delete(comments);
		} catch (CommentsInvalidEntriesException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<CommentDetails> listAllComments() {
		CommentDetailsDAO commentsDAO = new CommentDetailsDAO();
		return commentsDAO.list();
	}
	public List<CommentDetails> serviceShowCommentsByArticles(Articles article) throws ArticleInvalidEntriesException, ServiceException{
		ArticlesValidator articleValidator=new ArticlesValidator();
		CommentDetailsDAO commentDAO = new CommentDetailsDAO();

		try {
			articleValidator.validateTitle(article);
		     return commentDAO.viewCommentsByArticles(article);
			
		} catch (ArticleInvalidEntriesException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
	
}

