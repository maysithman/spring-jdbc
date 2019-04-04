select * from staff;

delete from staff;

select * from role;

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