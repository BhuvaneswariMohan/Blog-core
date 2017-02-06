package com.bhuvana.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.bhuvana.model.Articles;
import com.bhuvana.model.AuthorDetails;
import com.bhuvana.model.Ratings;
import com.bhuvana.util.ConnectionUtil;

public class RatingsDAO {
	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	/**
	 * TO INSERT A RECORD INTO THE RATING RELATION
	 * 
	 * @param rating
	 */
	public void save(final Ratings rating) {
		final String sql = "insert into ratings (AUTHOR_ID,ARTICLE_ID,RATINGS_GIVEN) values (?,?,?) ";
		final Object[] params = {rating.getRatingAuthorId().getId(),rating.getRatingArticleId().getId(),rating.getRatingsGiven()};
		jdbcTemplate.update(sql, params);

	}
	/**
	 * TO DELETE A RECORD FROM THE RATING RELATION
	 * 
	 * @param rating
	 */
	public void delete(final Ratings rating) {
		final String sql = "delete from ratings where ARTICLE_ID=?";
		final Object[] params = { rating.getRatingArticleId().getId() };
		jdbcTemplate.update(sql, params);

	}
	/**
	 * TO UPDATE A RECORD IN THE RATING RELATION
	 * 
	 * @param user
	 */
	public void update(final Ratings rating) {
		final String sql = "update ratings set RATINGS_GIVEN=? where ARTICLE_ID=?";
		final Object[] params = {rating.getRatingsGiven(),rating.getRatingArticleId().getId()};
		jdbcTemplate.update(sql, params);

	}
	public List<Ratings> list() {
		final String sql = "Select ID,AUTHOR_ID,ARTICLE_ID,RATINGS_GIVEN from ratings";
		return jdbcTemplate.query(sql, (rs, rowNum) -> 
			 convert(rs)
	);

	}

	/**
	 * Converts Object to ResultSet
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	static Ratings convert(final ResultSet rs) throws SQLException {
		Ratings rating = new Ratings();
		rating.setId(rs.getInt("ID"));
		AuthorDetails user = new AuthorDetails();
		user.setId(rs.getInt("AUTHOR_ID"));
		rating.setRatingAuthorId(user);
		Articles article = new Articles();
		article.setId(rs.getInt("ARTICLE_ID"));
		rating.setRatingArticleId(article);
		rating.setLike(rs.getBoolean("LIKE"));
		return rating;
	}
}
