-- nodes
create table node_info(nid int, name varchar(16), dsn varchar(128), primary key(nid));

-- table's info
create table table_info(tid int auto_increment, name varchar(32), split_method varchar(6), split_id varchar(16), primary key(tid));

create table sub_table_info(sid int auto_increment, pid int, name varchar(32), nid int, 
	primary key(sid),
	constraint `pid_of_sid` foreign key(pid) references table_info(tid),
	constraint `nid_of_sid` foreign key(nid) references node_info(nid));

-- clear
drop table nodes;
drop table table_info;
drop table sub_table_info;