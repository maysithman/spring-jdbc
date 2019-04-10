package com.techfun.exe2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techfun.exe2.model.Role;
import com.techfun.exe2.model.Staff;
import com.techfun.exe2.repository.util.StaffRowMapper;

@Repository("staffRepository")
public class StaffRepositoryImpl implements StaffRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Transactional
	@Override
	public void createStaff(Staff staff, Role role) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		String insertStaff = "INSERT INTO Staff(staff_name, age, position) VALUES(?, ?, ?)";

		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

				PreparedStatement ps = con.prepareStatement(insertStaff,
						new String[] { "staff_id" });
				ps.setString(1, staff.getStaff_name());
		        ps.setInt(2, staff.getAge());
		        ps.setString(3, staff.getPosition());
				return ps;
			}
		}, keyHolder);
		
		Integer staff_id = (Integer) keyHolder.getKey();
		
		String insertRole = "INSERT INTO Role(staff_id, role_name) VALUES(?, ?)";
		jdbcTemplate.update(insertRole, staff_id, role.getRole_name());
	}

	@Override
	public Staff updateStaffName(Staff staff) {
		String insertStaff = "UPDATE Staff SET staff_name=? WHERE staff_id=?";

		jdbcTemplate.update(insertStaff, staff.getStaff_name(), staff.getStaff_id());
		
		return selectExactStaff(staff);
	}

	@Override
	public Staff selectExactStaff(Staff staff) {
		return jdbcTemplate.queryForObject("SELECT * FROM Staff WHERE staff_id=?", new StaffRowMapper(), staff.getStaff_id());
	}

	@Override
	public void deleteStaff(Staff staff) {
		jdbcTemplate.update("DELETE FROM Staff WHERE Staff_id=?", staff.getStaff_id());
	}

	@Transactional
	@Override
	public void createDuplicateErrorStaffId(Staff staff, Role role) {
		
		String insertStaff = "INSERT INTO Staff(staff_id, staff_name, age, position) VALUES(?, ?, ?, ?)";

		jdbcTemplate.update(insertStaff, staff.getStaff_id(), staff.getStaff_name(), staff.getAge(), staff.getPosition());
		
		String insertRole = "INSERT INTO Role(staff_id, role_name) VALUES(?, ?)";
		jdbcTemplate.update(insertRole, staff.getStaff_id(), role.getRole_name());
	}

}
