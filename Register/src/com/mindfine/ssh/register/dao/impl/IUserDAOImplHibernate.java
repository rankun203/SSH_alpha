package com.mindfine.ssh.register.dao.impl;

import com.mindfine.ssh.register.dao.IUserDAO;
import com.mindfine.ssh.register.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * Created with IntelliJ IDEA.
 * User: rankun203
 * Date: 13-1-16
 * Time: 下午9:49
 */
//@Component("userDAO")
public class IUserDAOImplHibernate implements IUserDAO {
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void insertUser(User user) {
//        hibernateTemplate.save(user);
//        HibernateTemplate hibernateTemplate;
        getSession().save(user);
    }
}
