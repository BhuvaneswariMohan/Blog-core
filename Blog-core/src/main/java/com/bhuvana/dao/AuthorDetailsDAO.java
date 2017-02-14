package com.bhuvana.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.bhuvana.model.AuthorDetails;
import com.bhuvana.model.Roles;
import com.bhuvana.util.ConnectionUtil;

public class AuthorDetailsDAO {
	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	/**
	 * TO INSERT A RECORD INTO THE USER RELATION
	 * 
	 * @param user
	 */
	public void save(final AuthorDetails user) {
		final String sql = "insert into Author_details (NAME,EMAIL_ID,PASSWORD,ROLE_ID) values (?,?,?,?) ";
		final Object[] params = { user.getName(),user.getEmailid(),user.getPassword(),user.getRole().getId() };
		jdbcTemplate.update(sql, params);

	}

	/**
	 * TO DELETE A RECORD FROM THE USER RELATION
	 * 
	 * @param user
	 */
	public void delete(final AuthorDetails user) {
		final String sql = "delete from author_details where ID=?";
		final Object[] params = { user.getId() };
		jdbcTemplate.update(sql, params);

	}

	/**
	 * TO UPDATE A RECORD IN THE USER RELATION
	 * 
	 * @param user
	 */
	public void update(final AuthorDetails user) {
		final String sql = "update author_details set PASSWORD=? where NAME=?";
		final Object[] params = { user.getPassword(), user.getName() };
		jdbcTemplate.update(sql, params);

	}

	public List<AuthorDetails> list() {
		final String sql = "select ID,NAME,EMAIL_ID,PASSWORD,ROLE_ID from author_details";
		return jdbcTemplate.query(sql, (rs, rowNum) -> convert(rs));

	}

	/**
	 * Converts Object to ResultSet
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	static AuthorDetails convert(final ResultSet rs) throws SQLException {
		AuthorDetails user = new AuthorDetails();
		user.setId(rs.getInt("ID"));
		user.setName(rs.getString("NAME"));
		user.setEmailid(rs.getString("EMAIL_ID"));
		user.setPassword(rs.getString("PASSWORD"));
		Roles role = new Roles();
		role.setId(rs.getInt("ROLE_ID"));
		user.setRole(role);
		return user;
	}
//	public Boolean isValidUserName(String username) {
//		String sql = "select FN_IS_VALID_USER(?)";
//		return jdbcTemplate.queryForObject(sql, new Object[] {username}, Boolean.class);
//	}
//	public Boolean isValidPassword(String username,String password) {
//		String sql = "select FN_IS_VALID_PASSWORD(?)";
//		return jdbcTemplate.queryForObject(sql, new Object[] {username,password}, Boolean.class);
//	}
	public void login(final AuthorDetails user) {
		final String sql = "SELECT IFNULL((SELECT 1 FROM AUTHOR_DETAILS WHERE EMAIL_ID=? AND PASSWORD=?),NULL)";
		final Object[] params = { user.getEmailid(),user.getPassword() };
		Integer value =jdbcTemplate.queryForObject(sql, params,Integer.class);
		if(value!=null)
		{
			System.out.println("success");
		}
		else
		{
			System.out.println("failure");
		}
}
	public AuthorDetails getIdByEI(String emailid){
		String sql="SELECT ID FROM AUTHOR_DETAILS WHERE EMAIL_ID=?";
		Object[] params={emailid};
		return jdbcTemplate.queryForObject(sql,params, (rs, rowNum) ->{
			AuthorDetails user = new AuthorDetails();
			user.setId(rs.getInt("ID"));
			return user;
	});
	}
		public AuthorDetails getIdByPW(String password){
			String sql="SELECT ID FROM AUTHOR_DETAILS WHERE PASSWORD=?";
			Object[] params={password};
			return jdbcTemplate.queryForObject(sql,params, (rs, rowNum) ->{
				AuthorDetails user = new AuthorDetails();
				user.setId(rs.getInt("ID"));
				return user;
		});
		}
			public void checkUser(Integer i , Integer j ) {
				if (i == j) {
					
				} 
}
}