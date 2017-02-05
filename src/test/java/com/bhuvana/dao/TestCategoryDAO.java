package com.bhuvana.dao;




	import java.util.List;

import com.bhuvana.model.Articles;
import com.bhuvana.model.Category;

	

	public class TestCategoryDAO {

		
		public static void main(String[] args) {
			
			CategoryDAO categoryDAO=new CategoryDAO();
			Category category=new Category();
			category.setCategoryName("JAVA");
			List<Articles>list=categoryDAO.getArticlesOnCategory(category);
			for(Articles c:list)
			{
				System.out.println(c.getTitle()+"\t"+c.getContent());
			}
		}
	}

