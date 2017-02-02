package com.bhuvana.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.bhuvana.model.Articles;
import com.bhuvana.model.AuthorDetails;
import com.bhuvana.util.ConnectionUtil;


public class ArticlesDAO {

	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	/**
	 * TO INSERT A RECORD INTO THE ARTICLE RELATION
	 * 
	 * @param article
	 */
	public void save(final Articles article) {
		final String sql = "insert into articles(AUTHOR_ID,TITLE,CREATED_DATE,CONTENT,MODIFIED_DATE,STATUS) values (?,?,?,?,?,?)";
		final Object[] params = {article.getAuthorId().getId(),article.getTitle(),article.getCreatedDate(),article.getContent(),article.getModifiedDate(),article.getStatus()};
		jdbcTemplate.update(sql, params);

	}
	/**
	 * TO DELETE A RECORD FROM THE ARTICLE RELATION
	 * 
	 * @param article
	 */
	public void delete(final Articles article) {
		final String sql = "delete from articles where ID=?";
		final Object[] params = { article.getId() };
		jdbcTemplate.update(sql, params);

	}
	/**
	 * TO UPDATE A RECORD IN THE ARTICLE RELATION
	 * 
	 * @param article
	 */
	public void update(final Articles article) {
		final String sql = "update articles set TITLE=? where ID=?";
		final Object[] params = {article.getTitle(),article.getId() };
		jdbcTemplate.update(sql, params);

	}
	public List<Articles> list() {
		final String sql = "select ID,AUTHOR_ID,CREATED_DATE,ARTICLE_CONTENT,MODIFIED_DATE,STATUS from articles";
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
	static Articles convert(final ResultSet rs) throws SQLException {
		Articles article = new Articles();
		article.setId(rs.getInt("ID"));
		AuthorDetails user=new AuthorDetails();
		user.setId(rs.getInt("AUTHOR_ID"));
		article.setAuthorId(user);
		article.setTitle(rs.getString("TITLE"));
		article.setCreatedDate(rs.getTimestamp("CREATED_DATE").toLocalDateTime());
		article.setContent(rs.getString("CONTENT"));
		article.setModifiedDate(rs.getTimestamp("MODIFIED_DATE").toLocalDateTime());
		article.setStatus(rs.getBoolean("STATUS"));
		return article;
	}
	
}

