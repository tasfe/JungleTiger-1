package com.alex.jungletiger.admin;

import com.alex.jungletiger.sqlparser.*;
import com.alex.jungletiger.protocol.*;
import java.util.concurrent.*;
import java.sql.*;
import io.netty.channel.*;
import io.netty.buffer.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.*;
import org.slf4j.*;

public class JTAdminWorker implements Runnable 
{
    private ArrayBlockingQueue mq;
    private Logger logger;
    private String dsn;
    private Connection conn;
    private Statement stmt;

    public JTAdminWorker(String dsn, ArrayBlockingQueue mq) {
        logger = LoggerFactory.getLogger(JTAdminWorker.class);
        this.dsn = dsn;
        this.mq = mq;
        this.conn = null;
        this.stmt = null;
    }

    public void init() throws Exception {
        try {
            logger.info("connect database: " + dsn + "...");
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            DriverManager.setLoginTimeout(15);
            conn = DriverManager.getConnection(dsn);
            stmt = conn.createStatement();
        } catch (SQLException  se) {
            logger.error("mysql err: " + se.getMessage());
            throw se;
        } catch (Exception e) {
             e.printStackTrace();
             throw e;
        } finally {
            if(stmt != null) {
                try {stmt.close();}
                catch(SQLException e) {e.printStackTrace();}   
            }
            if(conn != null) {
                try {conn.close();}
                catch(SQLException e) {e.printStackTrace();}
            }
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                JTMySQLProtocolMessage mpmsg = (JTMySQLProtocolMessage)mq.take();
                Packet.dump_stderr(mpmsg.message);
                
                if (mpmsg.message[4] == 0x03 && mpmsg.message[5] != 's') {
                    handleQuery(mpmsg);
                } else {
                    OK okpacket = new OK();
                    okpacket.sequenceId = mpmsg.message[3]+1;
                    mpmsg.ctx.writeAndFlush(okpacket.toPacket());
                }
            }
        } catch (InterruptedException ie) {
            logger.error("get message failed: " + ie.getMessage());
        } catch (Exception e) {
             e.printStackTrace();
        }
    }

    private void handleQuery(JTMySQLProtocolMessage mpmsg) {
        String command = new String(mpmsg.message, 5, mpmsg.message.length-5);
        int seq_id = mpmsg.message[3]+1;
        logger.debug("handle COM_QUERY: " + command);

        ANTLRInputStream input = new ANTLRInputStream(command);
        SQLParserLexer lexer = new SQLParserLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SQLParserParser parser = new SQLParserParser(tokens);
        ParseTree tree = parser.statment();
        // create a standard ANTLR parse tree walker
        ParseTreeWalker walker = new ParseTreeWalker();
        // create listener then feed to walker
        SQLParserLoader loader = new SQLParserLoader();

        // walk parse tree
        walker.walk(loader, tree);
        if (loader.ss.type == SQLType.ADD_NODE) {
            handleSQLAddNode(loader.ss.sql_add_node, seq_id, mpmsg.ctx);
        } else if (loader.ss.type == SQLType.CREATE_TABLE) {
            // TODO
        } else {
            // TODO
        }
    }

    private void handleSQLAddNode(SQLAddNode sql_add_node, int seq_id, ChannelHandlerContext ctx) {
        logger.debug("handle ADD_NODE ...");
        OK okpacket = new OK();
        okpacket.sequenceId = seq_id;
        ctx.writeAndFlush(okpacket.toPacket());
    }
    /*
    private void handleQuery(JTMySQLProtocolMessage mpmsg) {
        logger.debug("handle COM_QUERY...");

        String command = new String(mpmsg.message, 4, mpmsg.message.length-4);
        com.alex.jungletiger.protocol.ResultSet rs = new com.alex.jungletiger.protocol.ResultSet();
        
        Column column = new Column();
        column.schema = "test";
        column.table = "tasks";
        column.org_table = "tasks";
        column.name = "name";
        column.org_name = "name";
        rs.addColumn(column);

        Row row = new Row();
        row.addData("hello");
        rs.addRow(row);

        // rs.sequenceId = mpmsg.message[3]+1;
        for (byte[] buf: rs.toPackets()) {
            mpmsg.ctx.writeAndFlush(buf);
        }
    }
    */
}
