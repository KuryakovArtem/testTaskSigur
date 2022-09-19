create table departments (
    id bigint not null,
    name varchar(32),
    primary key (id)
);

create table employees (
    card tinyblob,
    id bigint not null,
    primary key (id)
);

create table guests (
    id bigint not null,
    primary key (id)
);

 create table hibernate_sequence
 (next_val bigint) engine=InnoDB

 insert into hibernate_sequence values ( 1 )

 create table persons (
     dtype varchar(31) not null,
     uid bigint not null,
     type integer,
     department_id bigint,
     fired_time date,
     hire_time date,
     emp_id bigint,
     visit_date date,
    primary key (uid)
);

 alter table employees
 add constraint employee_fk
 foreign key(id) references persons (uid)

 alter table guests
 add constraint guest_fk
 foreign key (id) references persons (uid)