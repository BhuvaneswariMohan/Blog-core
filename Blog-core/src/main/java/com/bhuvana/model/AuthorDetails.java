package com.bhuvana.model;



	import lombok.Data;

	@Data
	public class AuthorDetails {
	private Integer id;
	private String name;
	private String emailid;
	private String password; 
	private Roles role;
	}

