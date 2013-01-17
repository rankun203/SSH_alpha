package com.mindfine.ssh.register.dao.impl;

import com.mindfine.ssh.register.dao.IUserDAO;
import com.mindfine.ssh.register.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: rankun203
 * Date: 13-1-16
 * Time: 下午9:49
 */
public class IUserDAOImplHibernate implements IUserDAO {
    SessionFactory mySessionFactory;

    public void setMySessionFactory(SessionFactory mySessionFactory) {
        this.mySessionFactory = mySessionFactory;
    }

    @Override
    public void insertUser(User user) {
        Session session = mySessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();

    }
}
