package com.alex.jungletiger.sqlparser;

import java.util.*;
import java.io.*;

public final class SQLAddNode {
    // 1. add node
    // 1.1 node struct
    class NodeStruct {
        public String id;
        public String name;
        public String dsn;
    }

    // 1.2 node list
    public List<NodeStruct> add_node_list = new ArrayList<NodeStruct>();

    public void desc() {
        Iterator<NodeStruct> iterator = add_node_list.iterator();
        while(iterator.hasNext()) {
            NodeStruct n = (NodeStruct)iterator.next();
            System.out.printf("id = %s, name = %s, dsn = %s\n", n.id, n.name, n.dsn);
        }
    }
}