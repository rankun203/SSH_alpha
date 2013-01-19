package com.mindfine.ssh.register.actions;

import com.mindfine.ssh.register.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: rankun203
 * Date: 13-1-18
 * Time: 上午2:03
 */
public class RegisterActionTest {
    @Test
    public void testRegisterAction(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("WEB-INF/applicationContext.xml");
        UserService us = (UserService)ac.getBean("userService");
        System.out.println(us == null);
    }
}
