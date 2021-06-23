/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuce.httpservlet;

import com.nuce.dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import com.nuce.entity.User;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Phan
 */
public class UserDeleteHttpServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        UserDao userDao = new UserDao();
        int id = Integer.parseInt(request.getParameter("id"));
        userDao.deleteUser(id);
        response.sendRedirect(request.getContextPath() + "/");
    }

}
