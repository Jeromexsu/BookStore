package com.jeremy.web;

import com.jeremy.bean.User;
import com.jeremy.service.UserService;
import com.jeremy.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends BaseServlet{
    private UserService userService = new UserServiceImpl();
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        System.out.println(user);
        if (userService.login(user))
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        else {
            //save error message into request map
            request.setAttribute("errMsg", "用户名或密码错误");
            //return to login.jsp
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }
    }

    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get parameters of the request
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        if("abcde".equalsIgnoreCase(code)) {
            if(userService.existedUsername(username)) {
                req.setAttribute("errMsg","用户名已存在");
                req.getRequestDispatcher("/pages/user/register.jsp").forward(req,resp);
            } else {
                User user = new User(null, username, password, email);
                userService.register(user);
                req.getRequestDispatcher("/pages/user/register_success.jsp").forward(req,resp);
            }

        } else {
            req.setAttribute("errMsg","验证码错误");
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req,resp);
        }
    }
}
