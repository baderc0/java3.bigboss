use java3;

create table employmentgroups (
	groupid			varchar(2) NOT NULL ,
	groupname		varchar(40),
  PRIMARY KEY ( groupid )
);

insert into employmentgroups values ('FT','Full-Time');
insert into employmentgroups values ('SS','Sessional');
insert into employmentgroups values ('PL','Partial-Load');
insert into employmentgroups values ('OT','Part-Time');
insert into employmentgroups values ('CT','Contract');
insert into employmentgroups values ('FL','Freelance');

create table members (
 id  int NOT NULL AUTO_INCREMENT,
 membername varchar(100) NOT NULL,
 password varchar(20) NOT NULL,
 email varchar(250) NOT NULL,
 basesalary double(20,2), 
 bonus double(20,2),
 employmentgroup varchar(60),
 PRIMARY KEY (id)
);

insert into members values (1, 'admin', 'admin', 'admin@service.com', 123456.78, 23456.78, 'Full-Time');
insert into members values (2, 'guest', 'guest', 'guest@service.com', 987654.32, 87654.32, 'Contract');

create table memberrole (
 membername varchar(100) NOT NULL,
 rolename varchar(20) NOT NULL,
 PRIMARY KEY (membername, rolename)
);

insert into memberrole values ('admin', 'admin');
insert into memberrole values ('guest', 'guest');
