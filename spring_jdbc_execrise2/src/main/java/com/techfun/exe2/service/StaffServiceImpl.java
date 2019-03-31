package com.techfun.exe2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techfun.exe2.model.Role;
import com.techfun.exe2.model.Staff;
import com.techfun.exe2.repository.StaffRepository;

@Service("staffService")
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	StaffRepository staffRepository;

	@Override
	public void createStaff(Staff staff, Role role) {
		staffRepository.createStaff(staff, role);
	}

}