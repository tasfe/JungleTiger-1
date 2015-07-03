package com.alex.jungletiger.admin;

import java.util.concurrent.*;
import java.sql.*;
import io.netty.buffer.*;
import org.slf4j.*;

public class JTAdminWorker implements Runnable 
{
    private ArrayBlockingQueue mq;
    private Logger logger;
    private String dsn;

    public JTAdminWorker(String dsn, ArrayBlockingQueue mq) 
    {
        logger = LoggerFactory.getLogger(JTAdminWorker.class);
        this.dsn = dsn;
        this.mq = mq;
    }

    @Override
    public void run()
    {
        /*
        java.sql.Connection conn = null;
        java.sql.Statement stmt = null;
        try
        {
            logger.info("connect database: " + dsn + "...");
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(dsn);
            stmt = conn.createStatement();
            while (true)
            {
                JTInternalMessage message = (JTInternalMessage)mq.take();
                logger.info("get message: " + message.requestMessage.command);
                ByteBuf rep = Unpooled.copiedBuffer("ok".getBytes());
                message.ctx.writeAndFlush(rep);
            }
        }
        catch (InterruptedException ie)
        {
            logger.error("get message failed: " + ie.getMessage());
        }
        catch (SQLException se)
        {
            logger.error("mysql err: " + se.getMessage());
        }
        catch (Exception e)
        {
             e.printStackTrace();
        }
        finally
        {
            if(stmt != null)
            {
                try {stmt.close();}
                catch(SQLException e) {e.printStackTrace();}   
            }
            if(conn != null)
            {
                try {conn.close();}
                catch(SQLException e) {e.printStackTrace();}
            }
        }
        */
    }
}