package com.alex.jungletiger.sqlparser;

import java.util.*;
import java.io.*;

public class SQLCreateTable {
    // table desc
    public String table_name;

    // table column define
    class ColumnStruct {
        public String name;
        public String type;
        public boolean not_null;
    }

    // column list
    public String tmpType;
    public Boolean tmpNotNull = false;
    public List<ColumnStruct> column_list;

    // primary key
    public List<String> pk_list;

    // node list
    public Boolean on_all;
    public List<String> node_list;

    // split method
    public String split_method;

    public void desc() {
        System.out.printf("tablename = %s\n", table_name);

        {
            System.out.printf("column define ===> \n");
            Iterator<ColumnStruct> iterator = column_list.iterator();
            while(iterator.hasNext()) {
                ColumnStruct c = (ColumnStruct)iterator.next();
                System.out.printf("    name = %s, type = %s, not null = %s\n", 
                                  c.name, c.type, c.not_null);
            }
        }
        
        {
            System.out.printf("primary key ===> \n");
            Iterator<String> iterator = pk_list.iterator();
            while(iterator.hasNext()) {
                String pk = (String)iterator.next();
                System.out.printf("    pk = %s\n", pk);
            }
        }

        {
            System.out.printf("node list ===> \n");
            if (on_all) { 
                System.out.printf("    on all\n"); 
            } else {
                Iterator<String> iterator = pk_list.iterator();
                while(iterator.hasNext()) {
                    String node = (String)iterator.next();
                    System.out.printf("    node = %s\n", node);
                }
            }
        }

        {
            System.out.printf("split method ===> %s\n", split_method);
        }
    }
}