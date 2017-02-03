package com.bhuvana.validator;

import com.bhuvana.exception.ArticleCategoryInvalidEntriesException;
import com.bhuvana.model.ArticleCategory;

public class ArticleCategoryValidator {

		private static final String ENTER_VALID_ARTICLE_ID = "Enter valid article ID";
		public void validateSave(ArticleCategory articleCategory) throws ArticleCategoryInvalidEntriesException
		{
			if(articleCategory.getArticleId().getId()<0)
			{
				throw new ArticleCategoryInvalidEntriesException(ENTER_VALID_ARTICLE_ID);
			}
			else if(articleCategory.getCategoryId().getId()<0)
			{
				throw new ArticleCategoryInvalidEntriesException("Enter valid category ID");
			}
		}
		public void validateUpdate(ArticleCategory articleCategory) throws ArticleCategoryInvalidEntriesException
		{
			if(articleCategory.getArticleId().getId()<0)
			{
				throw new ArticleCategoryInvalidEntriesException(ENTER_VALID_ARTICLE_ID);
			}
			else if(articleCategory.getCategoryId().getId()<0)
			{
				throw new ArticleCategoryInvalidEntriesException("Enter valid category ID");
			}
		}
		public void validateDelete(ArticleCategory articleCategory) throws ArticleCategoryInvalidEntriesException
		{
			if(articleCategory.getArticleId().getId()<0)
			{
				throw new ArticleCategoryInvalidEntriesException(ENTER_VALID_ARTICLE_ID);
			}
		}
	}

