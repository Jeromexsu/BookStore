package com.jeremy.dao.impl;

import com.jeremy.bean.User;
import com.jeremy.dao.UserDAO;

public class UserDAOImpl extends BaseDAO implements UserDAO {
    @Override
    public int saveUser(User user) {
        String sql = "insert into user(username,password,email) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public User queryUserByUsername(String username) {
        String sql = "select id,username,password,email from user where username=?";
        return query(User.class,sql,username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username,String password) {
        String sql = "select id,username,password,email from user where username=? and password=?";
        return query(User.class,sql,username,password);
    }
}
