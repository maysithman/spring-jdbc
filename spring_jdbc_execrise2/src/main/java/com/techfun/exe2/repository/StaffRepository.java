package com.techfun.exe2.repository;

import com.techfun.exe2.model.Role;
import com.techfun.exe2.model.Staff;

public interface StaffRepository {
	
	void createStaff(Staff staff, Role role);
	
	Staff selectExactStaff(Staff staff);
	
	Staff updateStaffName(Staff staff);
	
	void deleteStaff(Staff staff);

	void createDuplicateErrorStaffId(Staff staff, Role role);

}
