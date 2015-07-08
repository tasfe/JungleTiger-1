package com.alex.jungletiger.sqlparser;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.*;
import java.util.*;
import java.io.*;

public class SQLParserLoader extends SQLParserBaseListener {
    public SQLStruct ss = new SQLStruct();

    /*****************************************************************************/
    /***********                                                         *********/
    /***********             add node statment                           *********/
    /***********                                                         *********/
    /*****************************************************************************/
        
    public void enterAdd_node_stmt(SQLParserParser.Add_node_stmtContext ctx) { 
        ss.sql_add_node = new SQLAddNode();
        ss.type = SQLType.ADD_NODE;
    }

    public void exitNode_def(SQLParserParser.Node_defContext ctx) { 
        SQLAddNode.NodeStruct ns = ss.sql_add_node.new NodeStruct();

        ns.id = ctx.NUM().getText();
        ns.name = ctx.STR().getText();
        ns.dsn = ctx.DSN().getText();
        ss.sql_add_node.add_node_list.add(ns);
    }

    /*****************************************************************************/
    /***********                                                         *********/
    /***********             create table statment                       *********/
    /***********                                                         *********/
    /*****************************************************************************/
        
    public void enterCreate_table_stmt(SQLParserParser.Create_table_stmtContext ctx) { 
        ss.sql_create_table = new SQLCreateTable();
        ss.sql_create_table.column_list = new ArrayList<SQLCreateTable.ColumnStruct>();
        ss.type = SQLType.CREATE_TABLE;
    }

    public void exitCreate_table_stmt(SQLParserParser.Create_table_stmtContext ctx) {
        ss.sql_create_table.table_name = ctx.ID().getText();
    }

    public void enterColumn_def(SQLParserParser.Column_defContext ctx) { 
        SQLCreateTable.ColumnStruct cs = ss.sql_create_table.new ColumnStruct();
        cs.not_null = false;
        ss.sql_create_table.column_list.add(cs);
    }

    public void exitColumn_def(SQLParserParser.Column_defContext ctx) { 
        int pos = ss.sql_create_table.column_list.size()-1;
        ss.sql_create_table.column_list.get(pos).name = ctx.ID().getText();
    }

    public void exitType_def(SQLParserParser.Type_defContext ctx) { 
        int pos = ss.sql_create_table.column_list.size()-1;
        ss.sql_create_table.column_list.get(pos).type = ctx.getText();
    }

    public void exitNull_def(SQLParserParser.Null_defContext ctx) { 
        // if (ctx.getText().equals("not null")) { ss.tmpNotNull = true; }
        int pos = ss.sql_create_table.column_list.size()-1;
        if (ctx.getText().equals("not null")) { 
            ss.sql_create_table.column_list.get(pos).not_null = true;
        }
    }

    public void enterPrimary_key_def(SQLParserParser.Primary_key_defContext ctx) { 
        ss.sql_create_table.pk_list = new ArrayList<String>();
    }
        
    public void exitPk_id(SQLParserParser.Pk_idContext ctx) { 
        ss.sql_create_table.pk_list.add(ctx.ID().getText());
    }

    public void exitOn_node_def_all(SQLParserParser.On_node_def_allContext ctx) { 
        ss.sql_create_table.on_all = true;
    }

    public void enterOn_node_def_node_list(SQLParserParser.On_node_def_node_listContext ctx) { 
        ss.sql_create_table.on_all = false;
        ss.sql_create_table.node_list = new ArrayList<String>();
    }

    public void exitNode_id(SQLParserParser.Node_idContext ctx) { 
        ss.sql_create_table.node_list.add(ctx.ID().getText());
    }

    public void exitSplit_method(SQLParserParser.Split_methodContext ctx) { 
        ss.sql_create_table.split_method = ctx.getText();
    }
}