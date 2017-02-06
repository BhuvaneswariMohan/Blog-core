package com.bhuvana.dao;


	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.List;

	import org.springframework.jdbc.core.JdbcTemplate;

import com.bhuvana.model.ArticleCategory;
import com.bhuvana.model.Articles;
import com.bhuvana.model.Category;
import com.bhuvana.util.ConnectionUtil;

	
	public class ArticleCategoryDAO {
		private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
		/**
		 * TO INSERT A RECORD INTO THE ARTICLE CATEGORY RELATION
		 * 
		 * @param articlecategory
		 */
		public void save(final ArticlesDAO articleDAO,CategoryDAO categoryDAO) {
			final String sql = "insert into article_category (ARTICLE_ID,CATEGORY_ID) values (?,?) ";
			final Object[] params = {articleDAO.getArticleLastInsertedId(),categoryDAO.getCategoryLastInsertedId()};
			jdbcTemplate.update(sql, params);

		}
		

		/**
		 * TO DELETE A RECORD FROM THE ARTICLE CATEGORY RELATION
		 * 
		 * @param articleCategory
		 */
		public void delete(final ArticleCategory articleCategory) {
			final String sql = "delete from article_Category where ARTICLE_ID=?";
			final Object[] params = { articleCategory.getArticleId().getId() };
			jdbcTemplate.update(sql, params);

		}

		
		/**
		 * TO UPDATE A RECORD IN THE ARTICLE CATEGORY RELATION
		 * 
		 * @param articlecategory
		 */
		public void update(final ArticleCategory articleCategory) {
			final String sql = "update article_category set CATEGORY_ID where ARTICLE_ID=?";
			final Object[] params = {articleCategory.getCategoryId(),articleCategory.getArticleId()};
			jdbcTemplate.update(sql, params);

		}
		public List<ArticleCategory> list() {
			final String sql = "select ID,ARTICLE_ID,CATEGORY_ID from article_category";
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
		static ArticleCategory convert(final ResultSet rs) throws SQLException {
			ArticleCategory articleCategory = new ArticleCategory();
			articleCategory.setId(rs.getInt("ID"));
			Articles article = new Articles();
			article.setId(rs.getInt("ARTICLE_ID"));
			articleCategory.setArticleId(article);
			Category category = new Category();
			category.setId(rs.getInt("CATEGORY_ID"));
			articleCategory.setCategoryId(category);
			return articleCategory;
		}
		
}
