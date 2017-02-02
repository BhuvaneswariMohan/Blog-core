package com.bhuvana.validator;

import com.bhuvana.exception.CommentsInvalidEntriesException;
import com.bhuvana.model.CommentDetails;

public class CommentDetailsValidator {
	private static final String ENTER_VALID_ARTICLE_ID = "Enter valid Article ID";
	public void validateSave(CommentDetails comments) throws CommentsInvalidEntriesException
	{
		if(comments.getCommentArticleId().getId()<=0)
		{
			throw new CommentsInvalidEntriesException(ENTER_VALID_ARTICLE_ID);
		}
		else if(comments.getCommentText()==null||"".equals(comments.getCommentText()))
		{
			throw new CommentsInvalidEntriesException("Enter valid text");
		}
		else if(comments.getCommentUserId().getId()<=0)
		{
			throw new CommentsInvalidEntriesException("Enter valid User Id");
		}
		
	}
	public void validateUpdate(CommentDetails comments) throws CommentsInvalidEntriesException
	{
		if(comments.getCommentArticleId().getId()<=0)
		{
			throw new CommentsInvalidEntriesException(ENTER_VALID_ARTICLE_ID);
		}
		else if(comments.getCommentText()==null||"".equals(comments.getCommentText()))
		{
			throw new CommentsInvalidEntriesException("Enter valid text");
		}
	}
	public void validateDelete(CommentDetails comments) throws CommentsInvalidEntriesException
	{
		if(comments.getCommentArticleId().getId()<=0)
		{
			throw new CommentsInvalidEntriesException(ENTER_VALID_ARTICLE_ID);
		}
	}
	}

