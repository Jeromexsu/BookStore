package com.jeremy.dao;
import com.jeremy.bean.User;

public interface UserDAO {
    /**
     * 保存用户信息
     * @param user
     * @return 返回操作行数
     */
    int saveUser(User user);

    /**
     * 根据用户名查询用户信息
     * @return 返回Null表示没有这个用户
     */
    User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户，用来验证登录
     * @return 返回NULL证明用户不存在或用户名密码不匹配
     */
    User queryUserByUsernameAndPassword(String username,String password);
}
