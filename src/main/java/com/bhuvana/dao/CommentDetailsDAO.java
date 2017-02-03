package com.bhuvana.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import com.bhuvana.model.Articles;
import com.bhuvana.model.AuthorDetails;
import com.bhuvana.model.CommentDetails;
import com.bhuvana.util.ConnectionUtil;

public class CommentDetailsDAO {
	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	/**
	 * TO INSERT A RECORD INTO THE COMMENTS RELATION
	 * 
	 * @param comments
	 */
	public void save(final CommentDetails comments) {
		final String sql = "insert into comment_details (ARTICLE_ID,AUTHOR_ID,COMMENTS_GIVEN) values (?,?,?) ";
		final Object[] params = { comments.getCommentArticleId().getId(), comments.getCommentUserId().getId(),
				comments.getCommentText() };
		jdbcTemplate.update(sql, params);

	}

	/**
	 * TO DELETE A RECORD FROM THE COMMENTS RELATION
	 * 
	 * @param comments
	 */
	public void delete(final CommentDetails comments) {
		final String sql = "delete from comment_details where ARTICLE_ID=?";
		final Object[] params = { comments.getCommentArticleId().getId() };
		jdbcTemplate.update(sql, params);

	}

	/**
	 * TO UPDATE A RECORD IN THE COMMENTS RELATION
	 * 
	 * @param comments
	 */
	public void update(final CommentDetails comments) {
		final String sql = "update comment_details set COMMENT_TEXT=? where ARTICLE_ID=?";
		final Object[] params = { comments.getCommentText(), comments.getCommentArticleId().getId() };
		jdbcTemplate.update(sql, params);

	}

	public List<CommentDetails> list() {
		final String sql = "select ID,ARTICLE_ID,USER_ID,COMMENT_TEXT from comment_details";
		return jdbcTemplate.query(sql, (rs, rowNum) -> convert(rs));

	}

	/**
	 * Converts Object to ResultSet
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	static CommentDetails convert(final ResultSet rs) throws SQLException {
		CommentDetails comments = new CommentDetails();
		comments.setId(rs.getInt("ID"));
		Articles article = new Articles();
		article.setId(rs.getInt("ARTICLE_ID"));
		comments.setCommentArticleId(article);
		AuthorDetails user = new AuthorDetails();
		user.setId(rs.getInt("AUTHOR_ID"));
		comments.setCommentUserId(user);
		return comments;
	}
}
