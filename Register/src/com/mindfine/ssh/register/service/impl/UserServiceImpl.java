package com.mindfine.ssh.register.service.impl;

import com.mindfine.ssh.register.dao.impl.IUserDAOImplHibernate;
import com.mindfine.ssh.register.model.User;
import com.mindfine.ssh.register.service.UserService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: rankun203
 * Date: 13-1-9
 * Time: 上午8:52
 */
//@Component("userService")
public class UserServiceImpl implements UserService {
    private IUserDAOImplHibernate userDAO;

    @Override
    @Transactional
    public boolean register(User user) {
        if (user.getPassWord().equals(user.getRePass())) {
            userDAO.insertUser(user);
            return true;
        }
        return false;
    }

//    @Resource
    public void setUserDAO(IUserDAOImplHibernate userDAO) {
        this.userDAO = userDAO;
    }

}
