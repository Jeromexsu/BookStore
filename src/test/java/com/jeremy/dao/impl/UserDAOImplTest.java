package com.jeremy.dao.impl;

import com.jeremy.bean.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDAOImplTest {
    private UserDAOImpl userDAO = new UserDAOImpl();

    @Test
    public void saveUser() {
        int rows = userDAO.saveUser(new User(null, "Test", "Test12345", "test@qq.com"));
        System.out.println(rows);
    }

    @Test
    public void queryUserByUsername() {
        User user1 = userDAO.queryUserByUsername("Test");
        System.out.println(user1);
        User user2 = userDAO.queryUserByUsername("Fake");
        System.out.println(user2);
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        User user1 = userDAO.queryUserByUsernameAndPassword("Test","Test12345");
        System.out.println(user1);
        User user2 = userDAO.queryUserByUsernameAndPassword("Fake","Whatever");
        System.out.println(user2);
        User user3 = userDAO.queryUserByUsernameAndPassword("Test","Whatever");
        System.out.println(user3);
    }
}