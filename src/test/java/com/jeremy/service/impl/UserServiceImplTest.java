package com.jeremy.service.impl;

import com.jeremy.bean.User;
import com.jeremy.dao.impl.UserDAOImpl;
import com.jeremy.service.UserService;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {
    private UserService userService = new UserServiceImpl();

    @Test
    public void register() {
    }

    @Test
    public void login() {
        User user1 = new User(null, "Test", "Test12345", null);
        User user2 = new User(null, "Fake", "Test12345", null);
        User user3 = new User(null, "Test", "Test123", null);
        if(userService.login(user1)) System.out.println("login success!"); else System.out.println("failed!");
        if(userService.login(user2)) System.out.println("login success!"); else System.out.println("failed!");
        if(userService.login(user3)) System.out.println("login success!"); else System.out.println("failed!");

    }

    @Test
    public void existedUsername() {
        System.out.println(userService.existedUsername("jeremy"));
    }

    @Test
    public void test() {
        User user = new User(null, "Jeremy", "123456", "111@qq.com");
        userService.register(user);
    }
}