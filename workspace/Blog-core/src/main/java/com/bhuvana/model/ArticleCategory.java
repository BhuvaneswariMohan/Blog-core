package com.bhuvana.model;



import lombok.Data;

@Data
public class ArticleCategory {
private Integer id;
private Articles articleId;
private Category categoryId;
}

