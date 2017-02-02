package com.bhuvana.validator;

import com.bhuvana.exception.RatingInvalidEntriesException;
import com.bhuvana.model.Ratings;

public class RatingsValidator {
public void validateSave(Ratings rating) throws RatingInvalidEntriesException
{
	if(rating.getRatingArticleId().getId()<=0)
	{
		throw new RatingInvalidEntriesException("Enter valid Article ID");
	}
	else if(rating.getRatingAuthorId().getId()<=0)
	{
		throw new RatingInvalidEntriesException("Enter Valid user ID");
	}
	else if(rating.getRatingsGiven()<0)
	{
		throw new RatingInvalidEntriesException("Enter valid rating value");
	}
}
public void validateUpdate(Ratings rating) throws RatingInvalidEntriesException
{
	if(rating.getRatingArticleId().getId()<=0)
	{
		throw new RatingInvalidEntriesException("Enter valid Article ID");
	}
	else if(rating.getRatingsGiven()<0)
	{
		throw new RatingInvalidEntriesException("Enter valid rating value");
	}
}
public void validateDelete(Ratings rating) throws RatingInvalidEntriesException
{
	if(rating.getRatingArticleId().getId()<=0)
	{
		throw new RatingInvalidEntriesException("Enter valid Article ID");
	}
}
}

