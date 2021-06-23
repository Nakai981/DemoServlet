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
/**
 *
 * @author Phan
 */
public class UserHttpServlet extends HttpServlet{
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html"); 
        
        UserDao user = new UserDao();
        List<User> users = user.getAllUser();
        
        PrintWriter pw = response.getWriter();
        pw.print("<h1>List User</h1>");
        pw.print("<a href='/DEMO/add'>Add User</a>");
        pw.print("<table>");
        pw.print("<tr>"
                + "<th>Id</th>"
                + "<th>Fullname</th>"
                + "<th>Year</th>"
                + "<th>Sex</th>"
                + "<th>Action</th>"
                + "</tr>");
        String sex = "";
        for(User us: users){
            if (us.isSex()) sex = "Nam";
            else sex = "Nu";
            pw.print("<tr>"
                + "<td>"+us.getId()+"</td>"
                + "<td>"+us.getFullname()+"</td>"
                + "<td>"+us.getYear()+"</td>"
                + "<td>"+sex+"</td>"
                + "<td><a href='/DEMO/update?id="+us.getId()+"'>Update</a></td>"
                + "<td><a href='/DEMO/delete?id="+us.getId()+"'>Delete</a></td>"
                + "</tr>");
        }
        pw.print("</table>");
        pw.close();
    }
}
