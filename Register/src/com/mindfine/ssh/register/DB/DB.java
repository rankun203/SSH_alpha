package com.mindfine.ssh.register.DB;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created with IntelliJ IDEA.
 * User: rankun203
 * Date: 13-1-9
 * Time: 上午9:12
 */
public class DB {
    Connection connection;
    public DB() throws Exception{
        try{
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433/SSH_Alpha", "sa", "administrator");
        } catch (ClassNotFoundException e){
            System.out.println("数据库加载失败！");
            throw e;
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
