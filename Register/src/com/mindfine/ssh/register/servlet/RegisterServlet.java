package com.mindfine.ssh.register.servlet;

import com.mindfine.ssh.register.dao.impl.IUserDAOImpl;
import com.mindfine.ssh.register.model.User;
import com.mindfine.ssh.register.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: rankun203
 * Date: 13-1-8
 * Time: 下午11:34
 */
public class RegisterServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        String rePass = request.getParameter("rePass");

        if (userName != null && passWord != null && rePass != null) {
            if(passWord.equals(rePass)){
                User user = new User();
                user.setUserName(userName);
                user.setPassWord(passWord);

                UserService userService = new UserService();
                try {
                    userService.setUserDAO(new IUserDAOImpl());
                    userService.register(user);
                    System.out.println("RegisterServlet reporting: " + user.getUserName() + " has been saved.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request, response);
    }

}
