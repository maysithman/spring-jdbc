package com.techfun.exe2.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.techfun.exe2.model.Staff;

public class StaffRowMapper implements RowMapper<Staff> {

	@Override
	public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
		Staff staff = new Staff();
		staff.setStaff_id(rs.getInt("staff_id"));
		staff.setStaff_name(rs.getString("staff_name"));
		staff.setAge(rs.getInt("age"));
		staff.setPosition(rs.getString("position"));
		return staff;
	}

}
