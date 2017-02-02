package com.bhuvana.dao;


	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.List;

	import org.springframework.jdbc.core.JdbcTemplate;

import com.bhuvana.model.AuthorDetails;
import com.bhuvana.model.Category;
import com.bhuvana.util.ConnectionUtil;

	
	public class CategoryDAO {
		private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
		/**
		 * TO INSERT A RECORD INTO THE CATEGORY RELATION
		 * 
		 * @param category
		 */
		public void save(final Category category) {
			final String sql = "insert into category (NAME_OF_CATEGORY,USER_ID) values (?,?) ";
			final Object[] params = {category.getCategoryName(),category.getCategoryAuthorId().getId() };
			jdbcTemplate.update(sql, params);

		}
		/**
		 * TO DELETE A RECORD FROM THE CATEGORY RELATION
		 * 
		 * @param category
		 */
		public void delete(final Category category) {
			final String sql = "delete from category where ID=?";
			final Object[] params = { category.getId() };
			jdbcTemplate.update(sql, params);

		}
		/**
		 * TO UPDATE A RECORD IN THE CATEGORY RELATION
		 * 
		 * @param category
		 */
		public void update(final Category category) {
			final String sql = "update category set CATEGORY_NAME=? where AUHTOR_ID=?";
			final Object[] params = {category.getCategoryName(),category.getCategoryAuthorId().getId()};
			jdbcTemplate.update(sql, params);

		}
		public List<Category> list() {
			final String sql = "select ID,CATEGORY_NAME,AUTHOR_ID from category";
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
		static Category convert(final ResultSet rs) throws SQLException {
			Category category = new Category();
			category.setId(rs.getInt("ID"));
			category.setCategoryName(rs.getString("CATEGORY_NAME"));
			AuthorDetails user= new AuthorDetails();
			user.setId(rs.getInt("AUTHOR_ID"));
			category.setCategoryAuthorId(user);
			return category;
		}
}
