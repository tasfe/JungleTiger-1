package com.alex.jungletiger.sqlparser;

import java.util.*;
import java.io.*;

public class SQLStruct {
    // sql statment type
    //   0 - add node
    //   1 - create table
    public SQLType type;

    public SQLAddNode sql_add_node; 
    public SQLCreateTable sql_create_table;
}