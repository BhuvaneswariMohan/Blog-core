package com.bhuvana.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.bhuvana.model.Roles;
import com.bhuvana.util.ConnectionUtil;

public class RoleDAO {
	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	/**
	 * TO INSERT A RECORD INTO THE ROLE RELATION
	 * 
	 * @param role
	 */
	public void save(final Roles role) {
		final String sql = "insert into role (ROLE_NAME) values (?) ";
		final Object[] params = {role.getRoleName()};
		jdbcTemplate.update(sql, params);

	}

	/**
	 * TO DELETE A RECORD FROM THE ROLE RELATION
	 * 
	 * @param role
	 */
	public void delete(final Roles role) {
		final String sql = "delete from role where ID=?";
		final Object[] params = { role.getId() };
		jdbcTemplate.update(sql, params);

	}

	/**
	 * TO UPDATE A RECORD IN THE ROLE RELATION
	 * 
	 * @param role
	 */
	public void update(final Roles role) {
		final String sql = "update role set ROLE_NAME=? where ID=?";
		final Object[] params = {role.getRoleName(),role.getId()};
		jdbcTemplate.update(sql, params);

	}

	public List<Roles> list() {
		final String sql = "select ID,ROLE_NAME from role";
		return jdbcTemplate.query(sql, (rs, rowNum) -> convert(rs));

	}

	/**
	 * Converts Object to ResultSet
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	static Roles convert(final ResultSet rs) throws SQLException {
	Roles role = new Roles();
	role.setId(rs.getInt("ID"));
	role.setRoleName(rs.getString("ROLE_NAME"));
		return role;
	}

}

