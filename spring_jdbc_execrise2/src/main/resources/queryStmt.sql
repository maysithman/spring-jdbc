select * from staff;

select * from role;

insert into staff(staff_id, staff_name, age,
position) values(14, "Mg Mg", 22, "Junior");

delete from staff;

alter table role drop column "staff_id";

alter table role add "staff_id" INT NOT NULL,
FOREIGN KEY (staff_id)
REFERENCE staff (staff_id)
ON DELETE CASCADE;


CREATE TABLE role (
	role_id Serial PRIMARY KEY,
	staff_id INT NOT NULL,
	role_name VARCHAR(100) NOT NULL,
	FOREIGN KEY (staff_id)
		REFERENCES staff (staff_id)
		ON DELETE CASCADE
		);

delete from staff where staff_id=8;

SET IDENTITY_INSERT Staff ON
	insert into MyTable(staff_id, staff_name,
	age, position) values (1, "MM", 22, "JJ");
SET IDENTITY_INSERT Staff OFF

