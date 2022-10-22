package com.jeremy.web;

import com.jeremy.bean.User;
import com.jeremy.service.UserService;
import com.jeremy.service.impl.UserServiceImpl;
import com.jeremy.utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get parameters of the request
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        if("abcde".equalsIgnoreCase(code)) {
            if(userService.existedUsername(username)) {
                System.out.println("username ["+username+"] exists");
                req.getRequestDispatcher("/pages/user/register.html").forward(req,resp);
            } else {
                User user = new User(null, username, password, email);
                userService.register(user);
                req.getRequestDispatcher("/pages/user/register_success.html").forward(req,resp);
            }

        } else {
            System.out.println("The code is incorrect");
            req.getRequestDispatcher("/pages/user/register.html").forward(req,resp);
        }
    }
}
