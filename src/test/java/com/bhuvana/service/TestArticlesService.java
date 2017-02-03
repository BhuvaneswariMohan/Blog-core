package com.bhuvana.service;

import java.util.List;

import com.bhuvana.dao.ArticlesDAO;
import com.bhuvana.dao.CategoryDAO;
import com.bhuvana.model.Articles;
import com.bhuvana.model.AuthorDetails;
import com.bhuvana.model.Category;

public class TestArticlesService {
	public static void main(String[] args) {
//		Articles article = new Articles();
//		Category category = new Category();
//		AuthorDetails user = new AuthorDetails();
//		user.setId(1);
//		article.setAuthorId(user);
//		article.setTitle("MAVEN PROJECT");
//		article.setContent("HELLO");
//		category.setCategoryName("JAVA");
//		category.setCategoryAuthorId(user);
//		ArticlesDAO articleDAO = new ArticlesDAO();
//		CategoryDAO categoryDAO = new CategoryDAO();
//		ArticlesService articleService = new ArticlesService();
//		articleService.postArticleService(article, category, articleDAO, categoryDAO);
//ArticlesService article=new ArticlesService();
//article.provideListAllUsers();
ArticlesDAO articledao=new ArticlesDAO();
List<Articles> a=articledao.listarticles(1);
for(Articles s:a)
	System.out.println(s.getTitle()+" " +s.getContent());
	}
}
