package com.solphire.echart.demo.util;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class PrestoConnection {

    static Logger LOG = Logger.getLogger(PrestoConnection.class);
    static int nTimes = 3;
    static PrestoConnection connection = new PrestoConnection();
    private Connection sqlConn = null;
    static Statement statement = null;



    public static PrestoConnection getConnection() {
        return connection;

    }

    public Connection getSqlConn() {
        return sqlConn;
    }

    public void setSqlConn(Connection sqlConn) {
        this.sqlConn = sqlConn;
    }

    private PrestoConnection() {
        System.out.println("-- 开始创建presto连接 --");
        long start = System.currentTimeMillis();
//        String url = "jdbc:presto://192.168.210.16:18080/hive/test";
        String url = PropertiesKey.readValue("presto.url");
        LOG.info("url = " + url);
        try {
            Class.forName("com.facebook.presto.jdbc.PrestoDriver");
            sqlConn = DriverManager.getConnection(url, System.getProperty("user.name"), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("创建连接 used time = "
                + (System.currentTimeMillis() - start) / 1000);

    }

    public void close() {
        try {
            sqlConn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
