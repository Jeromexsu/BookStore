package com.jeremy.service;

import com.jeremy.bean.User;

public interface UserService {
    void register(User user);
    boolean login(User user);

    /**
     * 检查用户名是否存在
     * @param username
     * @return true表示存在（不可用）
     */
    boolean existedUsername(String username);
}
