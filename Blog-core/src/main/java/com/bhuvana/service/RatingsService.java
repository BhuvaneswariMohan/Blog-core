package com.bhuvana.service;

import com.bhuvana.dao.RatingsDAO;
import com.bhuvana.exception.RatingInvalidEntriesException;
import com.bhuvana.exception.ServiceException;
import com.bhuvana.model.Ratings;
import com.bhuvana.validator.RatingsValidator;

public class RatingsService {
		public void provideSave(Ratings rating) throws ServiceException {
			RatingsValidator ratingValidator = new RatingsValidator();
			RatingsDAO ratingDAO = new RatingsDAO();

			try {
				ratingValidator.validateSave(rating);
				ratingDAO.save(rating);
			} catch (RatingInvalidEntriesException e) {
				throw new ServiceException(e.getMessage(), e);
			}
		}

		public void provideUpdate(Ratings rating) throws ServiceException {
			RatingsValidator ratingValidator = new RatingsValidator();
			RatingsDAO ratingDAO = new RatingsDAO();

			try {
				ratingValidator.validateUpdate(rating);
				ratingDAO.update(rating);
			} catch (RatingInvalidEntriesException e) {
				throw new ServiceException(e.getMessage(), e);
			}
		}

		public void provideDelete(Ratings rating) throws ServiceException {
			RatingsValidator ratingValidator = new RatingsValidator();
			RatingsDAO ratingDAO = new RatingsDAO();

			try {
				ratingValidator.validateDelete(rating);
				ratingDAO.delete(rating);
			} catch (RatingInvalidEntriesException e) {
				throw new ServiceException(e.getMessage(), e);
			}
		}

		public void listAllRatings() {
			RatingsDAO ratingDAO = new RatingsDAO();
			ratingDAO.list();
		}
		
}
