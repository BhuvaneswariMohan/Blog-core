package com.bhuvana.model;


	import java.time.LocalDateTime;

	import lombok.Data;
	@Data
	public class Articles {

		private Integer id;
		private AuthorDetails authorId;
		private String title;
		private LocalDateTime createdDate;
		private String content;
		private LocalDateTime modifiedDate;
		private Boolean status;
	}
