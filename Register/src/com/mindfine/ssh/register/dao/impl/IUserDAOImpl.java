package com.mindfine.ssh.register.dao.impl;

import com.mindfine.ssh.register.DB.DB;
import com.mindfine.ssh.register.dao.IUserDAO;
import com.mindfine.ssh.register.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: rankun203
 * Date: 13-1-9
 * Time: 上午9:12
 */
public class IUserDAOImpl implements IUserDAO{

    private Connection dbc;

    public IUserDAOImpl() throws Exception {
        dbc = new DB().getConnection();
    }

    @Override
    public void insertUser(User user) {
        try {
            PreparedStatement ps = dbc.prepareStatement("insert into t_user(userName, passWord) values(?, ?)");
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassWord());
            int successRow = ps.executeUpdate();
            if (successRow > 0) {
                System.out.println("用户插入成功~");
            }
        } catch (SQLException e) {
            System.out.println("用户插入失败！");
            e.printStackTrace();
        }
    }
}
