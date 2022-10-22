package com.jeremy.service.impl;

import com.jeremy.bean.User;
import com.jeremy.dao.UserDAO;
import com.jeremy.dao.impl.UserDAOImpl;
import com.jeremy.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public void register(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public boolean login(User user) {
        return userDAO.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword()) != null;
    }

    @Override
    public boolean existedUsername(String username) {
        return userDAO.queryUserByUsername(username) != null;
    }
}
