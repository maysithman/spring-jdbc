package com.techfun.exe2.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DuplicateKeyException;

import com.techfun.exe2.model.Role;
import com.techfun.exe2.model.Staff;
import com.techfun.exe2.service.StaffService;


public class AppStaff 
{
    public static void main( String[] args )
    {
    	ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		StaffService staffService = appContext.getBean("staffService", StaffService.class);
		
        //testCreateStaff(staffService);
		//testUpdateStaffName(staffService);
		//testDeleteStaff(staffService);
		testErrorInsertDuplicateStaff(staffService);
    }

	private static void testErrorInsertDuplicateStaff(StaffService staffService) {
		Staff staff = new Staff();
		staff.setStaff_id(3);
		staff.setStaff_name("Ma Ma");
		staff.setAge(23);
		staff.setPosition("Java Developer");
		
		Role role = new Role();
		role.setStaff_id(3);
		role.setRole_name("Senior");
		
		try{
			staffService.createDuplicateErrorStaffId(staff, role);
		}catch(DuplicateKeyException e) {
			System.out.println("Duplicate staff: you can't insert");
		}
		System.out.println("Insert Duplicate New Staff Successfully.");
	}

	private static void testDeleteStaff(StaffService staffService) {
		Staff staff = new Staff();
		staff.setStaff_id(9);
		
		staffService.deleteStaff(staff);
		System.out.println("Deleted Staff Successfully.");
	}

	private static void testUpdateStaffName(StaffService staffService) {
		Staff staff = new Staff();
		staff.setStaff_name("Su Ei San");
		staff.setStaff_id(6);
		
		Staff s = staffService.updateStaffName(staff);
		
		System.out.println(
						"The Updated Name : \n \n" +
						"Id : " + s.getStaff_id() + "\t" +
						"Name : " + s.getStaff_name() + "\t" +
						"Age : " + s.getAge() + "\t" +
						"Position : " + s.getPosition()
				);
	}

	private static void testCreateStaff(StaffService staffService) {
		Staff staff = new Staff();
		staff.setStaff_name("Phyu Mon Thant");
		staff.setAge(23);
		staff.setPosition("Java Developer");
		
		Role role = new Role();
		role.setRole_name("Senior");
		
		staffService.createStaff(staff, role);
		System.out.println("Insert New Staff Successfully.");
	}
}
