package com.mindfine.ssh.register.actions;

import com.mindfine.ssh.register.model.User;
import com.mindfine.ssh.register.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created with IntelliJ IDEA.
 * User: rankun203
 * Date: 13-1-14
 * Time: 下午2:21
 */
//@Component("registerAction")
public class RegisterAction extends ActionSupport {
    private User user;
    private String promptStr;
    UserService userService;

    public UserService getUserService() {
        return userService;
    }

//    @Resource(name = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

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
        this.user = user;
    }

    public String userRegister() throws Exception {
/*
        IUserDAOImplHibernate userDAO = new IUserDAOImplHibernate();
        UserService us = new UserService();
        us.setUserDAO(userDAO);
*/
        if (userService.register(user)) {
            promptStr = "哈哈，添加成功。";
            return SUCCESS;
        }
        promptStr = "两次输入密码不一致，请重新输入。";
        return ERROR;
    }

}
