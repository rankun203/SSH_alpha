package com.mindfine.ssh.register.DB;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created with IntelliJ IDEA.
 * User: rankun203
 * Date: 13-1-16
 * Time: 下午10:04
 */
public class MySessionFactory {
    private SessionFactory mySessionFactory;
    public MySessionFactory () {
        mySessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public SessionFactory getSessionFactory(){
        return mySessionFactory;
    }
}
