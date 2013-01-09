package com.mindfine.ssh.register.DB;

import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created with IntelliJ IDEA.
 * User: rankun203
 * Date: 13-1-9
 * Time: 上午9:17
 */
public class DBTest {
    @Test
    public void dbTest() throws Exception {
        PreparedStatement ps = new DB().getConnection().prepareStatement("select * from t_user");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.println(rs.getInt(1) + ":" + rs.getString(2) + "-" + rs.getString(3));
        }
    }
}
