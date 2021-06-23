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
public class UserUpdateHttpServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        int id = Integer.parseInt(request.getParameter("id")) ;
        PrintWriter pw = response.getWriter();
        UserDao ud = new UserDao();
        User user = ud.getUser(id);
        pw.print("<h1>Update User</h1>");
        pw.print("<form action='/DEMO/update' method='post'>\n"
                + "    <table>\n"
                + "        <tr>\n"
                + "            <td>Fullname</td>\n"
                + "            <td><input type='text' name='name' value='"+user.getFullname()+"' required /></td>\n"
                + "            <td><input type='hidden' name='id' value='"+user.getId()+"' required /></td>\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td>Year</td>\n"
                + "            <td><input type='number' name='year' value='"+user.getYear()+"' required/></td>\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td>Sex</td>\n"
                + "            <td><select name='sex'>\n"
                + "                    <option value='true'>Nam</option>\n"
                + "                    <option value='false'>Nu</option>\n"
                + "                </select>\n"
                + "            </td>\n"
                + "        </tr>\n"
                + "    </table>\n"
                + "    <button type='submit'>Save</button>\n"
                + "</form>");
        pw.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        String fullname = request.getParameter("name");
        long year = Long.parseLong(request.getParameter("year"));
        String sex_str = request.getParameter("sex");
        boolean sex = Boolean.parseBoolean(sex_str);
        UserDao userDao = new UserDao();
        User user = new User(id,fullname, year, sex);
        userDao.updateUser(user);
        response.sendRedirect(request.getContextPath() + "/");
    }
}
