insert into useraccount(`password`, `usertype`, `username`, `adminaccount_id`, `studentaccount_id`, `instituteAccount_id`) values('admin', 0, 'admin', null, null, null);
insert into admin_account(`name`) values ('admin');
update useraccount set `adminaccount_id`=1 where `id`=1;
insert into states (`stateName`) values ('Delhi');
insert into states (`stateName`) values ('Mumbai');
insert into states (`stateName`) values ('Gujrat');
insert into states (`stateName`) values ('Andra Pradesh');
insert into states (`stateName`) values ('Vishakapatnam');
insert into states (`stateName`) values ('Kolkatta');
insert into states (`stateName`) values ('Chennai');
insert into states (`stateName`) values ('Pune');
insert into states (`stateName`) values ('Banglore');
insert into states (`stateName`) values ('Manipal');
insert into states (`stateName`) values ('Agra');
insert into states (`stateName`) values ('Bihar');
insert into states (`stateName`) values ('Gurgaon');


insert into subjects (`streamType`, `subject_code`, `subject_name`) values (0, '05321', 'Digital Electronics');
insert into subjects (`streamType`, `subject_code`, `subject_name`) values (0, '05322', 'Web Programming');
insert into subjects (`streamType`, `subject_code`, `subject_name`) values (0, '05323', 'Data Security');
insert into subjects (`streamType`, `subject_code`, `subject_name`) values (1, '05324', 'Java');
insert into subjects (`streamType`, `subject_code`, `subject_name`) values (1, '05325', 'Computer Networks');
insert into subjects (`streamType`, `subject_code`, `subject_name`) values (1, '05326', 'Computer Graphics');
insert into subjects (`streamType`, `subject_code`, `subject_name`) values (2, '05327', 'Marketing');
insert into subjects (`streamType`, `subject_code`, `subject_name`) values (2, '05328', 'Knowledge Management');
insert into subjects (`streamType`, `subject_code`, `subject_name`) values (3, '05329', 'Business Management');
insert into subjects (`streamType`, `subject_code`, `subject_name`) values (3, '05330', 'Business Strategy');
