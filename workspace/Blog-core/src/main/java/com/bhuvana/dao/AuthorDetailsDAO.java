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
		final String sql = "insert into user (NAME,EMAIL_ID,PASSWORD,ROLE_ID) values (?,?,?,?) ";
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

}
