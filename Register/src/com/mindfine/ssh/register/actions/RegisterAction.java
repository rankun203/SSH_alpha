package com.mindfine.ssh.register.actions;

import com.mindfine.ssh.register.dao.IUserDAO;
import com.mindfine.ssh.register.dao.impl.IUserDAOImpl;
import com.mindfine.ssh.register.model.User;
import com.mindfine.ssh.register.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created with IntelliJ IDEA.
 * User: rankun203
 * Date: 13-1-14
 * Time: 下午2:21
 */
public class RegisterAction extends ActionSupport {
    private User user;
    private String promptStr;


    public String getPromptStr() {
        return promptStr;
    }

    public void setPromptStr(String promptStr) {
        this.promptStr = promptStr;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        System.out.println("user.getUserName(): " + user.getUserName());
        this.user = user;
    }

    public String userRegister() throws Exception {
        IUserDAO userDAO = new IUserDAOImpl();
        UserService us = new UserService();
        us.setUserDAO(userDAO);
        us.register(user);

        promptStr = "哈哈，添加成功。";
        return SUCCESS;
    }

}
