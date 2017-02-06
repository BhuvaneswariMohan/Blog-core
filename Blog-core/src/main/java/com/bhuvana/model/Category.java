package com.bhuvana.model;



import lombok.Data;

@Data
public class Category {	
	private Integer id;
	private String categoryName;
	private AuthorDetails categoryAuthorId;
}

