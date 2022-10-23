package com.jeremy.web;

import com.jeremy.bean.User;
import com.jeremy.service.UserService;
import com.jeremy.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        System.out.println(user);
        if(userService.login(user)) request.getRequestDispatcher("/pages/user/login_success.html").forward(request,response);
        else request.getRequestDispatcher("/pages/user/login.html").forward(request,response);

    }
}
