// Generated from /Volumes/udisk/Workshop/Java/JungleTiger/src/main/antlr4/SQLParser.g4 by ANTLR 4.2.2
package com.alex.jungletiger.sqlparser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SQLParserParser}.
 */
public interface SQLParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SQLParserParser#on_node_def_all}.
	 * @param ctx the parse tree
	 */
	void enterOn_node_def_all(@NotNull SQLParserParser.On_node_def_allContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParserParser#on_node_def_all}.
	 * @param ctx the parse tree
	 */
	void exitOn_node_def_all(@NotNull SQLParserParser.On_node_def_allContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLParserParser#column_def}.
	 * @param ctx the parse tree
	 */
	void enterColumn_def(@NotNull SQLParserParser.Column_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParserParser#column_def}.
	 * @param ctx the parse tree
	 */
	void exitColumn_def(@NotNull SQLParserParser.Column_defContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLParserParser#add_node_stmt}.
	 * @param ctx the parse tree
	 */
	void enterAdd_node_stmt(@NotNull SQLParserParser.Add_node_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParserParser#add_node_stmt}.
	 * @param ctx the parse tree
	 */
	void exitAdd_node_stmt(@NotNull SQLParserParser.Add_node_stmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLParserParser#pk_id}.
	 * @param ctx the parse tree
	 */
	void enterPk_id(@NotNull SQLParserParser.Pk_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParserParser#pk_id}.
	 * @param ctx the parse tree
	 */
	void exitPk_id(@NotNull SQLParserParser.Pk_idContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLParserParser#node_id}.
	 * @param ctx the parse tree
	 */
	void enterNode_id(@NotNull SQLParserParser.Node_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParserParser#node_id}.
	 * @param ctx the parse tree
	 */
	void exitNode_id(@NotNull SQLParserParser.Node_idContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLParserParser#on_node_def_node_list}.
	 * @param ctx the parse tree
	 */
	void enterOn_node_def_node_list(@NotNull SQLParserParser.On_node_def_node_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParserParser#on_node_def_node_list}.
	 * @param ctx the parse tree
	 */
	void exitOn_node_def_node_list(@NotNull SQLParserParser.On_node_def_node_listContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLParserParser#primary_key_def}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_key_def(@NotNull SQLParserParser.Primary_key_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParserParser#primary_key_def}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_key_def(@NotNull SQLParserParser.Primary_key_defContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLParserParser#type_def}.
	 * @param ctx the parse tree
	 */
	void enterType_def(@NotNull SQLParserParser.Type_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParserParser#type_def}.
	 * @param ctx the parse tree
	 */
	void exitType_def(@NotNull SQLParserParser.Type_defContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLParserParser#null_def}.
	 * @param ctx the parse tree
	 */
	void enterNull_def(@NotNull SQLParserParser.Null_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParserParser#null_def}.
	 * @param ctx the parse tree
	 */
	void exitNull_def(@NotNull SQLParserParser.Null_defContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLParserParser#split_method}.
	 * @param ctx the parse tree
	 */
	void enterSplit_method(@NotNull SQLParserParser.Split_methodContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParserParser#split_method}.
	 * @param ctx the parse tree
	 */
	void exitSplit_method(@NotNull SQLParserParser.Split_methodContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLParserParser#node_def}.
	 * @param ctx the parse tree
	 */
	void enterNode_def(@NotNull SQLParserParser.Node_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParserParser#node_def}.
	 * @param ctx the parse tree
	 */
	void exitNode_def(@NotNull SQLParserParser.Node_defContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLParserParser#statment}.
	 * @param ctx the parse tree
	 */
	void enterStatment(@NotNull SQLParserParser.StatmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParserParser#statment}.
	 * @param ctx the parse tree
	 */
	void exitStatment(@NotNull SQLParserParser.StatmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLParserParser#create_table_stmt}.
	 * @param ctx the parse tree
	 */
	void enterCreate_table_stmt(@NotNull SQLParserParser.Create_table_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParserParser#create_table_stmt}.
	 * @param ctx the parse tree
	 */
	void exitCreate_table_stmt(@NotNull SQLParserParser.Create_table_stmtContext ctx);
}