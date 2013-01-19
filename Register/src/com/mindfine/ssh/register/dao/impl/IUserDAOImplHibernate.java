package com.mindfine.ssh.register.dao.impl;

import com.mindfine.ssh.register.dao.IUserDAO;
import com.mindfine.ssh.register.model.User;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * Created with IntelliJ IDEA.
 * User: rankun203
 * Date: 13-1-16
 * Time: 下午9:49
 */
//@Component("userDAO")
public class IUserDAOImplHibernate implements IUserDAO {
    HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void insertUser(User user) {
        hibernateTemplate.save(user);
System.out.println("Class.IUserDAOImplHibernate.insertUser() executing");
    }
}
