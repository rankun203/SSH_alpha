package com.mindfine.ssh.register.model;

/**
 * Created with IntelliJ IDEA.
 * User: rankun203
 * Date: 13-1-9
 * Time: 上午1:08
 */

public class User {
    private int id;
    private String userName;
    private String passWord;
    private String rePass;

    public String getRePass() {
        return rePass;
    }

    public void setRePass(String rePass) {
        this.rePass = rePass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
