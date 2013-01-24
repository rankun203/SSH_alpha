package com.mindfine.ssh.register.service;

import com.mindfine.ssh.register.model.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: rankun203
 * Date: 13-1-22
 * Time: 下午6:19
 */
public interface UserService {
    public boolean register(User user);
}
