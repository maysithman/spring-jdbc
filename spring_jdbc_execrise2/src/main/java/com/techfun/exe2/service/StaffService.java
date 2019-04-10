package com.techfun.exe2.service;

import com.techfun.exe2.model.Role;
import com.techfun.exe2.model.Staff;

public interface StaffService {

	void createStaff(Staff staff, Role role);
	
	Staff updateStaffName(Staff staff);
	
	void deleteStaff(Staff staff);

	void createDuplicateErrorStaffId(Staff staff, Role role);
	
}
