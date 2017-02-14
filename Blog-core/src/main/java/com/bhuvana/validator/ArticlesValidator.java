package com.bhuvana.validator;


import com.bhuvana.exception.ArticleInvalidEntriesException;
import com.bhuvana.model.Articles;



public class ArticlesValidator {
 private static final String ENTER_VALID_ID = "Enter valid ID";
private static final String ENTER_VALID_DATE = "Enter valid date";
public void validateSave(Articles article) throws ArticleInvalidEntriesException
 {
	 if(article.getAuthorId().getId()<0)
	 {
		 throw new ArticleInvalidEntriesException(ENTER_VALID_ID);
	 }
	 else if(article.getTitle()==null||"".equals(article.getTitle()))
	 {
		 throw new ArticleInvalidEntriesException("Enter valid Title");
		 
	 }
	 else if(article.getCreatedDate()==null)
	 {
		 throw new ArticleInvalidEntriesException(ENTER_VALID_DATE);
	 }
	 else if(article.getContent()==null || "".equals(article.getContent().trim()))
	 {
		 throw new ArticleInvalidEntriesException("Enter content");
	 }
	 else if(article.getModifiedDate()==null)
	 {
		 throw new ArticleInvalidEntriesException("Enter Valid date");
	 }
 }
 public void validateUpdate(Articles article) throws ArticleInvalidEntriesException
 {
	 if(article.getTitle()==null||"".equals(article.getTitle()))
	 {
		 throw new ArticleInvalidEntriesException("Enter valid Title");
		 
	 }
	 else if(article.getContent()==null || "".equals(article.getContent().trim()))
	 {
		 throw new ArticleInvalidEntriesException("Enter content");
	 }
	 else  if(article.getAuthorId().getId()<0)
	 {
		 throw new ArticleInvalidEntriesException(ENTER_VALID_ID);
	 }
	
 }
 public void validateDelete(Articles article) throws ArticleInvalidEntriesException
 {
	 if(article.getAuthorId().getId()<0)
	 {
		 throw new ArticleInvalidEntriesException(ENTER_VALID_ID);
	 } 
 }
 public void validateTitle(Articles article) throws ArticleInvalidEntriesException {
		if (article.getTitle() == null || "".equals(article.getTitle().trim())) {
			throw new ArticleInvalidEntriesException("Invalid Title");
		}
	}
}

