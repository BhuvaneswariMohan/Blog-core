package com.bhuvana.service;

import com.bhuvana.dao.CommentDetailsDAO;
import com.bhuvana.exception.CommentsInvalidEntriesException;
import com.bhuvana.exception.ServiceException;
import com.bhuvana.model.CommentDetails;
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

	public void listAllComments() {
		CommentDetailsDAO commentsDAO = new CommentDetailsDAO();
		commentsDAO.list();
	}
}

