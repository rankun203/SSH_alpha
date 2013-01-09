package com.mindfine.ssh.register.service;

import com.mindfine.ssh.register.dao.impl.IUserDAOImpl;
import com.mindfine.ssh.register.model.User;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: rankun203
 * Date: 13-1-9
 * Time: 上午9:51
 */
public class UserServiceTest {
    @Test
    public void testRegister() throws Exception {
        User user = new User();
        user.setUserName("testUser1");
        user.setPassWord("testUser2");
        UserService us = new UserService();
        us.setUserDAO(new IUserDAOImpl());
        us.register(user);
    }
}
