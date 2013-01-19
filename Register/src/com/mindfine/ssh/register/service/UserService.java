package com.mindfine.ssh.register.service;

import com.mindfine.ssh.register.dao.impl.IUserDAOImplHibernate;
import com.mindfine.ssh.register.model.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: rankun203
 * Date: 13-1-9
 * Time: 上午8:52
 */
//@Component("userService")
public class UserService {
    private IUserDAOImplHibernate userDAO;

    public void register(User user){
        userDAO.insertUser(user);
        System.out.println("注册了一个用户");
    }

//    @Resource
    @Transactional
    public void setUserDAO(IUserDAOImplHibernate userDAO) {
        this.userDAO = userDAO;
    }

}
