package com.bhuvana.model;

	import lombok.Data;

	@Data

public class CommentDetails {
	private Integer id;
	private Articles commentArticleId;
	private AuthorDetails commentUserId;
	private String commentText;
	}

