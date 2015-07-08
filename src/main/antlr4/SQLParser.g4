grammar SQLParser;

@header {package com.alex.jungletiger.sqlparser;}

statment 
	: add_node_stmt
	| create_table_stmt
	;

/* add a mysql server as storage node
 * ex: add node(a,b,c)
 */
add_node_stmt 
	: 'add' 'node' '(' node_def (',' node_def)* ')'
	;

node_def
	: NUM ':' STR ':' DSN
	;

/* create table syntax
 * ex: create table t(a int, b char, c long not null, primary key (a, b)) on (a, b) split by hash
 */
create_table_stmt
	: 'create' 'table' ID '(' column_def (',' column_def)* ',' primary_key_def ')' on_node_def 'split' 'by' split_method
	;

primary_key_def
	: 'primary' 'key' '(' pk_id (',' pk_id)* ')'
	;

pk_id
	: ID
	;

on_node_def
	: 'on' 'all'							# on_node_def_all
	| 'on' '(' node_id (',' node_id)* ')'	# on_node_def_node_list
	;

node_id
	: ID
	;

column_def
	: ID type_def (null_def)?
	;

type_def
	: 'int'
	| 'char'
	| 'long'
	;

null_def
	: 'not null'
	;

split_method
	: 'hash'
	| 'range'
	;

ID   : [a-z][a-z0-9]*;
NUM  : [0-9]+;
STR  : '\'' [a-z0-9_\.]* '\'';

/* jdbc:mysql://localhost:3306/demo?user=root&password=123&useUnicode=true
 */
DSN  : '\'' 'jdbc:'[a-zA-Z0-9_\.\/@:\?=&]* '\'';
WS   : [ \t\r\n]+ -> skip ;
