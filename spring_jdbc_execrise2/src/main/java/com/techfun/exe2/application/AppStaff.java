package com.techfun.exe2.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
		testUpdateStaffName(staffService);
    }

	private static void testUpdateStaffName(StaffService staffService) {
		Staff staff = new Staff();
		staff.setStaff_name("Laye Htaw");
		staff.setStaff_id(4);
		
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
		staff.setStaff_name("Yin Yin Cho");
		staff.setAge(23);
		staff.setPosition("Java Developer");
		
		Role role = new Role();
		role.setRole_name("Junior");
		
		staffService.createStaff(staff, role);
	}
}
