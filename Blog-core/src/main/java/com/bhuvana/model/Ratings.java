package com.bhuvana.model;



import lombok.Data;

@Data
public class Ratings {
private Integer id;
private AuthorDetails ratingAuthorId;
private Articles ratingArticleId;
private Integer ratingsGiven;
private Boolean like;
}

